package com.example1.demo.dao;

import com.example1.demo.domain.User;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
public class UserDao
{
    private EntityManager entityManager;

    @PersistenceContext public void setEntityManager(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    public User saveUser(User user)
    {
        entityManager.persist(user);
        return user;
    }

    public User findByName(String username){
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.select(root).where(builder.equal(root.get("username"), username));
        List<User> userList = entityManager.createQuery(query).getResultList();
        return userList.isEmpty() ? null : userList.get(0);

    }

    public User findByEmail(String email){
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.select(root)
                .where(builder.equal(root.get("email"), email));
        List<User> userList = entityManager.createQuery(query)
                .getResultList();
        return userList.isEmpty() ? null : userList.get(0);

    }
}
