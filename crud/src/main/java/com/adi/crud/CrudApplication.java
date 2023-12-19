package com.adi.crud;

import com.adi.crud.dao.PlayerDAO;
import com.adi.crud.entity.Player;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(PlayerDAO playerDAO){
		return runner -> {
//			createMultiplePlayers(playerDAO);

//			readPlayer(playerDAO);

//			readAllPlayers(playerDAO);

			readPlayerByAge(playerDAO);
		};
	}

	private void readPlayerByAge(PlayerDAO playerDAO) {
		List<Player> tempPlayer = playerDAO.findByAge(25);

		for(Player myPlayer : tempPlayer){
			System.out.println(myPlayer);
		}

	}

	private void readAllPlayers(PlayerDAO playerDAO) {

		System.out.println("Retrieving all players in the database in the order of their first names");
		List<Player> tempPlayers = playerDAO.findAll();
		for(Player myPlayer : tempPlayers){
			System.out.println(myPlayer);
		}
	}

	private void readPlayer(PlayerDAO playerDAO) {
		Player tempPlayer = new Player("Stefanos","Tsitsipas",25);
		playerDAO.save(tempPlayer);

		int id = tempPlayer.getId();

		System.out.println("Retrieving player with ID: " + id);
		Player myPlayer = playerDAO.findByID(id);
		System.out.println(myPlayer);
	}

	private void createMultiplePlayers(PlayerDAO playerDAO) {
		System.out.println("Creating 5 new ATP players ...");
		Player tempPlayer1 = new Player("Novak","Djokovic",36);
		Player tempPlayer2 = new Player("Carlos","Alcaraz",20);
		Player tempPlayer3 = new Player("Danil","Medvedev",27);
		Player tempPlayer4 = new Player("Jannik","Sinner",22);
		Player tempPlayer5 = new Player("Andrey","Rublev",26);

		System.out.println("Saving the players ...");
		playerDAO.save(tempPlayer1);
		playerDAO.save(tempPlayer2);
		playerDAO.save(tempPlayer3);
		playerDAO.save(tempPlayer4);
		playerDAO.save(tempPlayer5);
	}
}
