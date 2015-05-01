/**
 * 
 */
package org.herb.SimpleJPA.util;

import javax.annotation.PostConstruct;

import org.herb.SimpleJPA.domain.Player;
import org.herb.SimpleJPA.domain.Team;
import org.herb.SimpleJPA.persistence.PlayerRepository;
import org.herb.SimpleJPA.persistence.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author herb
 *
 */
@Service
public class DataLoader {
	
	private final TeamRepository teamRepository;
	private final PlayerRepository playerRepository;
	
	@Autowired
	public DataLoader(TeamRepository teamRepository, PlayerRepository playerRepository) {
		this.teamRepository = teamRepository;
		this.playerRepository = playerRepository;		
	}
	
	@PostConstruct
	private void initDatabase() {
		Team herbTeam = new Team("Barracudas");
		teamRepository.save(herbTeam);
		
		Player p1 = new Player("Kaeley", "Chan");
		p1.setPosition("Defence");
		p1.setTeam(herbTeam);
		playerRepository.save(p1);
		
		Player p2 = new Player("Nicole", "Chan");
		p2.setPosition("Forward");
		p2.setTeam(herbTeam);
		playerRepository.save(p2);
		
		Player p3 = new Player("Daddy", "Chan");
		p3.setPosition("Goalie");
		p3.setTeam(herbTeam);
		playerRepository.save(p3);

		Player p4 = new Player("Mommy", "Chan");
		p4.setPosition("Coach");
		p4.setTeam(herbTeam);
		playerRepository.save(p4);
		
	}

}
