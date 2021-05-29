package com.techApiBank.repository;
  
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository; 
import com.techApiBank.entities.TypeRole;	
 
 
@Repository
public interface TypeRoleRepository extends JpaRepository<TypeRole, Long> {	
  
	 
} 
