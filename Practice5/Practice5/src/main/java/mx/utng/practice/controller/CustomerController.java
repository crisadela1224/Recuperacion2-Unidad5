package mx.utng.practice.controller;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import mx.utng.practice.model.Contact;
import mx.utng.practice.model.Customer;
import mx.utng.practice.repository.CustomerRepository;


@Named
@ViewScoped
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	private Customer customer= new Customer();
	private List<Customer> customers;
	
	private boolean editMode = false;

	private Contact contact = new Contact();
	@PostConstruct
	public void init(){
		setCustomers(customerRepository.findAll());
	}
	
	public void save(){
		customerRepository.save(customer);
		if(!editMode){
			getCustomers().add(customer);
		}
		customer= new Customer();
		setEditMode(false);
	}
	public void delete(Customer customer){
		customerRepository.delete(customer);
		customers.remove(customer);
	}
	public void update(Customer customer){
		setCustomer(customer);
		setEditMode(true);
	}
	public void cancel(){
		customer= new Customer();
		setEditMode(false);
	}

	
	public void addContact(){
		contact.setCustomer(customer);
		customer.getContacts().add(contact);
	    contact = new Contact();
	}
	public void removeContact(Contact contact){
		customer.getContacts().remove(contact);
	}
	public Customer getCustomer(){
		return customer;
	}
	
	public List<Customer> getCustomers(){
		return customers;
	}
	public void setCustomers(List<Customer> customers){
		this.customers= customers;
	}
	public boolean isEditMode(){
		return editMode;
	}
	public void setCustomer(Customer customer){
		this.customer=customer;
	}
	public void setEditMode(boolean editMode){
		this.editMode=editMode;
	}

	public CustomerRepository getCustomerRepository() {
		return customerRepository;
	}

	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}


}
