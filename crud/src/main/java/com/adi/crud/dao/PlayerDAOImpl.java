package com.adi.crud.dao;

import com.adi.crud.entity.Player;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
