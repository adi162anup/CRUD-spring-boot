package com.adi.crud.dao;

import com.adi.crud.entity.Player;

import java.util.List;

public interface PlayerDAO {

    void save(Player thePlayer);

    Player findByID(Integer id);

    List<Player> findAll();

    List<Player> findByAge(Integer theAge);

}
