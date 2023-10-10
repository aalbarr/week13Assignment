package pet.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pet.store.controller.model.PetStoreData;
import pet.store.dao.PetStoreDao;

@Service
public class PetStoreService {
	
	@Autowired
	private PetStoreDao petStoreDao;

	public PetStoreData savePetStore(PetStoreData petStoreData) {
		findOrCreatePetStore(petStoreId);
	
		return petStoreData;
	}

	
}
