package com.example.springrest.repository;

import com.example.springrest.entities.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public long insertUser(User user)
    {
        this.entityManager.persist(user);
        return user.getId();
    }

    @Transactional
    public User getUser(long uid)
    {
        return entityManager.find(User.class, uid);
    }

    @Transactional
    public List<User> getUsers()
    {
        return entityManager.createQuery("SELECT u from User u").getResultList();
    }

}
