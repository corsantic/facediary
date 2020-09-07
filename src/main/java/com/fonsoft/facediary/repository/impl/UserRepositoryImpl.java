package com.fonsoft.facediary.repository.impl;


import com.fonsoft.facediary.model.User;
import com.fonsoft.facediary.model.UserParameter;
import com.fonsoft.facediary.repository.UserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Repository
//@Transactional
public class UserRepositoryImpl implements UserRepository {


    /*
        SessionFactory sessionFactory = new AnnotationConfiguration();

        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(User.class);


        public default User findUserByName(String userName){

            User specifiedUser = (User) criteria.add(Restrictions.eq("userName", userName))
                    .uniqueResult();

            return specifiedUser;
    */
    private final SessionFactory sessionFactory;
    @Autowired
    public UserRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User authenticate(UserParameter userParameter) {

//        String sql = "SELECT * FROM user WHERE userName =";
//
//        session.createQuery(sql,  )


        try {
            Session session = this.sessionFactory.openSession();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery cr = cb.createQuery(User.class);
            Root<User> root = cr.from(User.class);
            Predicate[] predicates = new Predicate[2];
            predicates[0] = cb.equal(root.get("userName"), userParameter.getUserName());
            predicates[1] = cb.equal(root.get("userPassword"), userParameter.getUserPassword());
            cr.select(root).where(predicates);
            Query<User> query = session.createQuery(cr);
            User result = query.getSingleResult();
            session.close();
            return result;
        } catch (Exception e) {

            System.out.println(e);
            throw e;

        }


    }
}
