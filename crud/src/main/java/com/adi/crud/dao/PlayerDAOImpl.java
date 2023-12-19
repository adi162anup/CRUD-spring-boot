package com.adi.crud.dao;

import com.adi.crud.entity.Player;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlayerDAOImpl implements PlayerDAO{

    private EntityManager entityManager;

    @Autowired
    public PlayerDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void save(Player thePlayer) {
        entityManager.persist(thePlayer);
    }

    @Override
    public Player findByID(Integer id) {
        return entityManager.find(Player.class,id);
    }

    @Override
    public List<Player> findAll() {
        TypedQuery<Player> theQuery = entityManager.createQuery("FROM Player ORDER BY firstName",Player.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Player> findByAge(Integer theAge) {
        TypedQuery<Player> theQuery = entityManager.createQuery("FROM Player WHERE age=:theData",Player.class);
        theQuery.setParameter("theData",theAge);
        return theQuery.getResultList();
    }
}
