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

import com.techApiBank.entities.TypeDocument;
import com.techApiBank.entities.ResourceNotFoundException;
import com.techApiBank.service.TypeDocumentServiceImp;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
  

@CrossOrigin(origins="*")  // http://localhost:3000/
@RestController
@RequestMapping("/api/v1/documents")   
public class TypeDocumentController {
	
	@Autowired
	private TypeDocumentServiceImp TypeDocumentService; 
	  

	//Obtener todos los Documentos
	@ApiOperation(value="Feth all Documents", notes="Operacion Get", tags="listar", response= Iterable.class)
	@ApiResponses( value = {
			@ApiResponse(code = 200, message = "SUCCESS", response= TypeDocument.class, responseContainer = "List" ),
			@ApiResponse(code = 400, message = "NOT FOUND")
	})
	@GetMapping
	public List<TypeDocument> getAllRoles(){ 
		List<TypeDocument> roles = TypeDocumentService.findAllTypeDocument();
		return roles;
	}
	
	//Obtener Documentos  por Id
	@ApiOperation(value="Feth Document by Id", notes="Operacion Get", tags="listar",  response= TypeDocument.class)
	@GetMapping("/{id}")
	public TypeDocument getRoleById(@PathVariable(value = "id") Long id)
	throws ResourceNotFoundException {
		TypeDocument role = TypeDocumentService.findTypeDocumentById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Role not found for this id :: " + id));
		if(role != null) {
			return role; 
		}
		return null; 
	}
	 
	//Crear un nuevo Documentos
	@ApiOperation(value="Create new Document", notes="Operacion Post", tags="listar", response= TypeDocument.class)
	@PostMapping
	public ResponseEntity<TypeDocument> createClient(@RequestBody TypeDocument newRole)
	throws ResourceNotFoundException {   
		if(TypeDocumentService.findTypeDocumentById(newRole.getId_type_document()).isPresent()) {
			throw new ResourceNotFoundException("Rol ya creado :: " + newRole.getDocumentType());  
		} 
		return ResponseEntity.status(HttpStatus.CREATED).body(TypeDocumentService.saveTypeDocument(newRole));
	}
	 
	
	//Editar Documentos por Id
	@ApiOperation(value="Edit Document by Id", notes="Operacion Put", tags="listar", response= TypeDocument.class)
	@PutMapping("/{id}")
	public ResponseEntity<TypeDocument> updateClient(@RequestBody TypeDocument documentDetails, @PathVariable(value = "id") Long documentId)
	throws ResourceNotFoundException {
		TypeDocument editRole = TypeDocumentService.findTypeDocumentById(documentId)
         .orElseThrow(() -> new ResourceNotFoundException("Client not found for this id :: " + documentId)); 
		editRole.setDocumentType(documentDetails.getDocumentType());
     final TypeDocument updatedRole = TypeDocumentService.saveTypeDocument(editRole);
     return ResponseEntity.ok(updatedRole);  
	}
	
	//Eliminar Documentos por Id
	@ApiOperation(value="Delete Document by Id", notes="Operacion Delete", tags="listar",  response= TypeDocument.class)
	@DeleteMapping("/{id}")
	public ResponseEntity<?>  deleteByRole(@RequestBody TypeDocument deleteDocument) 
	throws ResourceNotFoundException {
		if(TypeDocumentService.deleteTypeDocument(deleteDocument.getId_type_document())!=null) {
			throw new ResponseStatusException(HttpStatus.ACCEPTED,"Borrado");
		}
		else {
			throw new ResourceNotFoundException("Client not found id"); 
		}
		 
	}
	
}