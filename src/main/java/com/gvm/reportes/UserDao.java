package com.gvm.reportes;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void create(User user){
        entityManager.persist(user);
    }

    public void delete(User user){
        if(entityManager.contains(user)){
            entityManager.remove(user);
        }
        else{
            entityManager.remove(entityManager.merge(user));
        }
    }

    public void update(User user){
        entityManager.merge(user);
    }

    public User getById(int id){
        return entityManager.find(User.class,1);
    }

    @SuppressWarnings("unchecked")
    public List<User> getAll(){
        return entityManager.createQuery("select u from user u").getResultList();
    }
}
