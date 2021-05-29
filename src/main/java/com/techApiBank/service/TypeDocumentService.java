package com.techApiBank.service;
 
import java.util.List;
import java.util.Optional;

import com.techApiBank.entities.TypeDocument; 

public interface TypeDocumentService {
	
	public List<TypeDocument> findAllTypeDocument();
 
	public Optional<TypeDocument> findTypeDocumentById(Long id);
	  
	public TypeDocument saveTypeDocument(TypeDocument newDocument); 
	
	public String deleteTypeDocument(Long id);
	
	public TypeDocument updateTypeDocument(TypeDocument document);
	
  
}