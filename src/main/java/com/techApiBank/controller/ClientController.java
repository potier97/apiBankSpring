package com.techApiBank.controller;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.techApiBank.entities.Client;
import com.techApiBank.entities.ResourceNotFoundException;
import com.techApiBank.service.ClientServiceImp;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
 

//A continuación, creamos el controlador de usuario que contiene todos los puntos finales REST. 
//Navegue hasta el paquete del controlador y cree una nueva clase llamada UserController y agregue lo siguiente:

//@ApiOperation(value="/api/clients", tags= "Clients profile Controller") 
@CrossOrigin(origins="*")  // http://localhost:3000/
@RestController
@RequestMapping("/api/v1/clients")   
public class ClientController {
	
	@Autowired
	private ClientServiceImp clientService; 
	 
	@Autowired    
	private BCryptPasswordEncoder encoderPass;

	//Obtener todos los usuarios
	@ApiOperation(value="Feth all Clients", notes="Operacion Get", tags="listar", response= Iterable.class)
	@ApiResponses( value = {
			@ApiResponse(code = 200, message = "SUCCESS", response= Client.class, responseContainer = "List" ),
			@ApiResponse(code = 400, message = "NOT FOUND")
	})
	@GetMapping
	public List<Client> getAllClients(){ 
		List<Client> users = clientService.findAllClient();
		return users;
	}
	
	//Obtener cliente por Id
	@ApiOperation(value="Feth client by Id", notes="Operacion Get", tags="listar",  response= Client.class)
	@GetMapping("/{id}")
	public Client getClientById(@PathVariable(value = "id") String id)
	throws ResourceNotFoundException {
		Client client = clientService.findClientById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Client not found for this id :: " + id));
		if(client != null) {
			return client;
			//return ResponseEntity.ok().body(client); 
		}
		return null; 
	}
	 
	//Crear un nuevo cliente
	@ApiOperation(value="Create new client", notes="Operacion Post", tags="listar", response= Client.class)
	@PostMapping
	public ResponseEntity<Client> createClient(@RequestBody Client newClient)
	throws ResourceNotFoundException {   
		if(clientService.findClientById(newClient.getId_client()).isPresent()) {
			throw new ResourceNotFoundException("Usuario ya creado :: " + newClient.getId_client());  
		}
		newClient.setPassword(encoderPass.encode(newClient.getPassword()));
		return ResponseEntity.status(HttpStatus.CREATED).body(clientService.saveClient(newClient));
	}
	 
	
	//Editar cliente por Id
	@ApiOperation(value="Edit client by Id", notes="Operacion Put", tags="listar", response= Client.class)
	@PutMapping("/{id}")
	public ResponseEntity<Client> updateClient(@RequestBody Client clientDetails, @PathVariable(value = "id") String clientId)
	throws ResourceNotFoundException {
		Client client = clientService.findClientById(clientId)
         .orElseThrow(() -> new ResourceNotFoundException("Client not found for this id :: " + clientId)); 
		client.setDocument(clientDetails.getDocument());
		client.setId_type_document(clientDetails.getId_type_document());
		client.setName(clientDetails.getName());
		client.setLastName(clientDetails.getLastName());
		client.setMail(clientDetails.getMail());
		client.setDirection(clientDetails.getDirection());
		client.setPhone(clientDetails.getPhone()); 
		client.setPassword(encoderPass.encode(clientDetails.getPassword()));
     final Client updatedClient = clientService.saveClient(client);
     return ResponseEntity.ok(updatedClient);  
	}
	
	//Eliminar cliente por Id
	@ApiOperation(value="Delete client by Id", notes="Operacion Delete", tags="listar",  response= Client.class)
	@DeleteMapping("/{id}")
	public ResponseEntity<?>  deleteClient(@RequestBody Client deleteClient) 
	throws ResourceNotFoundException {
		if(clientService.deleteById(deleteClient.getId_client())!=null) {
			throw new ResponseStatusException(HttpStatus.ACCEPTED,"Borrado");
		}
		else {
			throw new ResourceNotFoundException("Client not found id"); 
		}
		
//		Client client = clientService.findClientById(clientId)
//         .orElseThrow(() -> new ResourceNotFoundException("Client not found for this id :: " + clientId)); 
//		clientService.deleteById(clientId);
//		return ResponseEntity.ok().body(client); 
	}
	
}
