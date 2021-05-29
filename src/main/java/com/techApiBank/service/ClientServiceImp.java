package com.techApiBank.service;

import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techApiBank.entities.Client;
import com.techApiBank.repository.ClientRepository;
//import com.techApiBank.entities.ResourceNotFoundException; 

@Service
public class ClientServiceImp implements ClientService {

	@Autowired
	private ClientRepository clientRepo;
	
	@Override
	@Transactional(readOnly = true)
	public List<Client> findAllClient(){
		return clientRepo.findAll();
	}
	 
	@Override
	@Transactional(readOnly = true)
	public Optional<Client> findClientById(String Id){ 
		Optional<Client> client = clientRepo.findById(Id);
		return client;
	}
	
	@Override
	@Transactional
	public Client saveClient(Client newClient){ 
		if(newClient != null) {
			return clientRepo.save(newClient);
		}
		return new Client();
	}
	
	@Override
	@Transactional
	public String deleteById(String id){ 
		if(clientRepo.findById(id).isPresent()) {
			clientRepo.deleteById(id);
			return "Cliente borrado correctamente";
		}
		return null; //"Cliente no encontrado";
	}
	
	@Override 
	@Transactional
	public Client updateClient(Client client){

		String num = client.getId_client();   
		if(clientRepo.findById(num).isPresent()) {
			Client updateClient = new Client();
			updateClient.setId_client(client.getId_client());
			updateClient.setDocument(client.getDocument());
			updateClient.setId_type_document(client.getId_type_document());
			updateClient.setName(client.getName());
			updateClient.setLastName(client.getLastName());
			updateClient.setMail(client.getMail());
			updateClient.setDirection(client.getDirection());
			updateClient.setPhone(client.getPhone());
			updateClient.setPassword(client.getPassword()); 
			updateClient.setId_type_role(client.getId_type_role()); 
			clientRepo.save(updateClient);
			return clientRepo.getById(num); 
		}
		return null;
    }
   
}
