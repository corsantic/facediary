package com.fonsoft.facediary.repository;

import com.fonsoft.facediary.model.User;
import com.fonsoft.facediary.model.UserParameter;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    /*SessionFactory sessionFactory = new AnnotationConfiguration().buildSessionFactory();

    Session session = sessionFactory.getCurrentSession();
    Criteria criteria = session.createCriteria(User.class);


    public default User findUserByName(String userName){

        User specifiedUser = (User) criteria.add(Restrictions.eq("userName", userName))
                .uniqueResult();

        return specifiedUser;
    }*/

    User authenticate(UserParameter userParameter);
}
