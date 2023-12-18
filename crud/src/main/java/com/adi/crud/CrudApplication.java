package com.adi.crud;

import com.adi.crud.dao.PlayerDAO;
import com.adi.crud.entity.Player;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(PlayerDAO playerDAO){
		return runner -> {
			createMultiplePlayers(playerDAO);
		};
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
