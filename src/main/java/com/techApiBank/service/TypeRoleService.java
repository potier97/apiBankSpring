package com.techApiBank.service;
 
 
import java.util.List;
import java.util.Optional;

import com.techApiBank.entities.TypeRole;

//La clase de servicio contiene todos los métodos que manejan la lógica empresarial de la aplicación.
//Navegue hasta el paquete de servicios y cree una nueva clase Java llamada UserService. En aras de la brevedad, 
//solo crearé un servicio para agregar un nuevo usuario y recuperar todos los usuarios.

public interface TypeRoleService {
	
	public List<TypeRole> findAllTypeRole();
 
	public Optional<TypeRole> findTypeRolById(Long id);
	  
	public TypeRole saveTypeRole(TypeRole newRole); 
	
	public String deleteTypeRole(Long id);
	
	public TypeRole updateTypeRole(TypeRole role);
	 
}
