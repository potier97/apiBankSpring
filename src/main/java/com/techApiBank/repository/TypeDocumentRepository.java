package com.techApiBank.repository; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository; 
import com.techApiBank.entities.TypeDocument;	
 
@Repository
public interface TypeDocumentRepository extends JpaRepository<TypeDocument, Long> {	
  
	 
} 