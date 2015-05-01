package org.herb.SimpleJPA;

import javax.annotation.PostConstruct;

import org.herb.SimpleJPA.domain.Customer;
import org.herb.SimpleJPA.domain.Player;
import org.herb.SimpleJPA.persistence.CustomerRepository;
import org.herb.SimpleJPA.persistence.PlayerRepository;
import org.herb.SimpleJPA.util.DataLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App implements CommandLineRunner 
{
	private final static Logger logger = LoggerFactory.getLogger(App.class);
	
	@Autowired
	CustomerRepository repository;
	
	@Autowired
	DataLoader dataLoader;
	
	@Autowired
	PlayerRepository playerRepository;
	
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class);
    }
    
    @Override
    public void run(String... strings) throws Exception {
        // save a couple of customers
        repository.save(new Customer("Jack", "Bauer"));
        repository.save(new Customer("Chloe", "O'Brian"));
        repository.save(new Customer("Kim", "Bauer"));
        repository.save(new Customer("David", "Palmer"));
        repository.save(new Customer("Michelle", "Dessler"));

        // fetch all customers
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Customer customer : repository.findAll()) {
            System.out.println(customer);
        }
        System.out.println();

        // fetch an individual customer by ID
        Customer customer = repository.findOne(1L);
        System.out.println("Customer found with findOne(1L):");
        System.out.println("--------------------------------");
        System.out.println(customer);
        System.out.println();

        // fetch customers by last name
        System.out.println("Customer found with findByLastName('Bauer'):");
        System.out.println("--------------------------------------------");
        for (Customer bauer : repository.findByLastName("Bauer")) {
            System.out.println(bauer);
		}
	}
    
    @PostConstruct
    void listPlayers() {
    	for (Player player : playerRepository.findAll()) {
    		logger.info(player.toString());
    	}
    }
}
