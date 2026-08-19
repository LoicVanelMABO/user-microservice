package com.mabo.user_microservice;
import com.mabo.user_microservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@SpringBootApplication
public class UserMicroserviceApplication {

	//private final UserService userService;
	private static final Logger LOG = LoggerFactory.getLogger(UserMicroserviceApplication.class);
	@Autowired
	UserService userService;

    public static void main(String[] args) {
		SpringApplication.run(UserMicroserviceApplication.class, args);
	}

	/*@PostConstruct //qui s'execute apres le constructeur
	public void init() {
		LOG.info("Init UserMicroserviceApplication CREATION DES ROLES ET USERS");
		//Ajout de role
		/*userService.addRole(new Role(null, "ADMIN"));
		userService.addRole(new Role(null, "USER"));*/

		//Ajout les Users
		/*userService.save(new User(null, "admin1","123",true,null));
		userService.save(new User(null, "loic1","123",true,null));
		userService.save(new User(null, "mabo1","123",true,null));*/

		//Ajout role aux users
		/*userService.addRoleToUser("admin1","ADMIN");
		userService.addRoleToUser("admin1","USER");
		userService.addRoleToUser("loic1","USER");
		userService.addRoleToUser("mabo1","USER");

		LOG.info("Init UserMicroserviceApplication FIN CREATION DES ROLES ET USERS");
	}*/

	@Bean
	BCryptPasswordEncoder getBCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
