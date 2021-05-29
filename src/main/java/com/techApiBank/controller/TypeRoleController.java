package com.techApiBank.controller;
 
import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;   
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.techApiBank.entities.TypeRole;
import com.techApiBank.entities.ResourceNotFoundException;
import com.techApiBank.service.TypeRoleServiceImp;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
  

@CrossOrigin(origins="*")  // http://localhost:3000/
@RestController
@RequestMapping("/api/v1/roles")   
public class TypeRoleController {
	
	@Autowired
	private TypeRoleServiceImp TypeRoleService; 
	  

	//Obtener todos los roles
	@ApiOperation(value="Feth all Roles", notes="Operacion Get", tags="listar", response= Iterable.class)
	@ApiResponses( value = {
			@ApiResponse(code = 200, message = "SUCCESS", response= TypeRole.class, responseContainer = "List" ),
			@ApiResponse(code = 400, message = "NOT FOUND")
	})
	@GetMapping
	public List<TypeRole> getAllRoles(){ 
		List<TypeRole> roles = TypeRoleService.findAllTypeRole();
		return roles;
	}
	
	//Obtener rol  por Id
	@ApiOperation(value="Feth Roles by Id", notes="Operacion Get", tags="listar",  response= TypeRole.class)
	@GetMapping("/{id}")
	public TypeRole getRoleById(@PathVariable(value = "id") Long id)
	throws ResourceNotFoundException {
		TypeRole role = TypeRoleService.findTypeRolById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Role not found for this id :: " + id));
		if(role != null) {
			return role; 
		}
		return null; 
	}
	 
	//Crear un nuevo rol
	@ApiOperation(value="Create new Role", notes="Operacion Post", tags="listar", response= TypeRole.class)
	@PostMapping
	public ResponseEntity<TypeRole> createClient(@RequestBody TypeRole newRole)
	throws ResourceNotFoundException {   
		if(TypeRoleService.findTypeRolById(newRole.getId_type_role()).isPresent()) {
			throw new ResourceNotFoundException("Rol ya creado :: " + newRole.getRolType());  
		} 
		return ResponseEntity.status(HttpStatus.CREATED).body(TypeRoleService.saveTypeRole(newRole));
	}
	 
	
	//Editar rol por Id
	@ApiOperation(value="Edit Role by Id", notes="Operacion Put", tags="listar", response= TypeRole.class)
	@PutMapping("/{id}")
	public ResponseEntity<TypeRole> updateClient(@RequestBody TypeRole roleDetails, @PathVariable(value = "id") Long roleId)
	throws ResourceNotFoundException {
		TypeRole editRole = TypeRoleService.findTypeRolById(roleId)
         .orElseThrow(() -> new ResourceNotFoundException("Client not found for this id :: " + roleId)); 
		editRole.setRolType(roleDetails.getRolType());
     final TypeRole updatedRole = TypeRoleService.saveTypeRole(editRole);
     return ResponseEntity.ok(updatedRole);  
	}
	
	//Eliminar rol por Id
	@ApiOperation(value="Delete role by Id", notes="Operacion Delete", tags="listar",  response= TypeRole.class)
	@DeleteMapping("/{id}")
	public ResponseEntity<?>  deleteByRole(@RequestBody TypeRole deleteRole) 
	throws ResourceNotFoundException {
		if(TypeRoleService.deleteTypeRole(deleteRole.getId_type_role())!=null) {
			throw new ResponseStatusException(HttpStatus.ACCEPTED,"Borrado");
		}
		else {
			throw new ResourceNotFoundException("Client not found id"); 
		}
		 
	}
	
}

