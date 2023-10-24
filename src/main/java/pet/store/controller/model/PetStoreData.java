package pet.store.controller.model;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;
import pet.store.entity.Customer;
import pet.store.entity.Employee;
import pet.store.entity.PetStore;

@Data
@NoArgsConstructor
public class PetStoreData {

	private Long petStoreId;
	private String petStoreName;
	private String petStoreAddress;
	private String petStoreCity;
	private String petStoreState;
	private Long petStoreZip;
	private Long petStorePhoneNumber;
	private Set<PetStoreCustomer> customers = new HashSet<>();
	private Set<PetStoreEmployee> employees = new HashSet<>();
	
	public PetStoreData(PetStore petStore) {
		petStoreId = petStore.getPetStoreId();
		petStoreName = petStore.getPetStoreName();
		petStoreAddress = petStore.getPetStoreAddress();
		petStoreCity = petStore.getPetStoreCity();
		petStoreState = petStore.getPetStoreState();
		petStoreZip = petStore.getPetStoreZip();
		petStorePhoneNumber = petStore.getPetStorePhoneNumber();
		
		for(Customer c : petStore.getCustomers()) {
			customers.add(new PetStoreCustomer(c));
		}
		
		for(Employee e : petStore.getEmployees()) {
			employees.add(new PetStoreEmployee(e));
		}
		
		
	}

	@Data
	@NoArgsConstructor
	public static class PetStoreCustomer {
		
		private Long customerId;
		private String customerFirstName;
		private String customerLastName;
		private String customerEmail;
		
		public PetStoreCustomer(Customer c) {
			customerId = c.getCustomerId();
			customerFirstName = c.getCustomerFirstName();
			customerLastName = c.getCustomerLastName();
			customerEmail = c.getCustomerEmail();
		}
	}

	@Data
	@NoArgsConstructor
	public static class PetStoreEmployee {
		private Long employeeId;
		private String employeeFirstName;
		private String employeeLastName;
		private Long employeePhone;
		private String employeeJobTitle;
		
		public PetStoreEmployee(Employee e) {
			employeeId = e.getEmployeeId();
			employeeFirstName = e.getEmployeeFirstName();
			employeeLastName = e.getEmployeeLastName();
			employeePhone = e.getEmployeePhone();
			employeeJobTitle = e.getEmployeeJobTitle();
		}
	}
}
