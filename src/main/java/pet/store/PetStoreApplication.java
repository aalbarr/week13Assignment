package pet.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//starts component scan in pet park package, looks for spring type of things
@SpringBootApplication
public class PetStoreApplication {
	public static void main(String[] args) {
		SpringApplication.run(PetStoreApplication.class, args);
	}

}
