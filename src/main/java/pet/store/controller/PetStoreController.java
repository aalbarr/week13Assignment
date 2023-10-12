package pet.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pet.store.controller.model.PetStoreData;
import pet.store.service.PetStoreService;

       //this annotation is a REST controller and expects and returns json
       //default response code is 200 if you dont specify differentl
       //also tells spring to map http requests to class methods
@RestController
       //tells spring  that URI for every http request is mapped to a method
       //in this controller class must start with "/pet_store
@RequestMapping("/pet_store")
       //lombok annotation that creates a SLF4J logger 
       //adds logger as an instance variable named log(used l
@Slf4j
public class PetStoreController {

	@Autowired
	private PetStoreService petStoreService;

	@PostMapping("/ps")
	@ResponseStatus(code = HttpStatus.CREATED)
	public PetStoreData insertPetStoreData(@RequestBody PetStoreData petStoreData) {
		log.info("Creating Pet Store {}", petStoreData);
		return petStoreService.savePetStore(petStoreData);
	}
	
	@PutMapping("/ps/{petStoreId}")
	public PetStoreData updatePetStoreData(@PathVariable Long petStoreId,
			@RequestBody PetStoreData petStoreData) {
		petStoreData.setPetStoreId(petStoreId);
		log.info("Changing Pet Store Id {}", petStoreData);
		return petStoreService.savePetStore(petStoreData);
		
	}
}
