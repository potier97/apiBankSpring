package com.techApiBank.service;


import java.util.List;
import java.util.Optional;
 

import com.techApiBank.entities.Client; 

//La clase de servicio contiene todos los métodos que manejan la lógica empresarial de la aplicación.
//Navegue hasta el paquete de servicios y cree una nueva clase Java llamada UserService. En aras de la brevedad, 
//solo crearé un servicio para agregar un nuevo usuario y recuperar todos los usuarios.

public interface ClientService {

	public List<Client> findAllClient();
	   
	public Optional<Client> findClientById(String Id);
	
	public Client saveClient(Client newClient);
	
	public String deleteById(String id);
  
	public Client updateClient(Client client);
	  
}
