package com.techApiBank.service;
   
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techApiBank.entities.TypeDocument;
import com.techApiBank.repository.TypeDocumentRepository;

@Service
public class TypeDocumentServiceImp {

	@Autowired
	TypeDocumentRepository typeDocumentRepository;

	@Transactional
	public List<TypeDocument> findAllTypeDocument() { 
		return typeDocumentRepository.findAll();
	}

	@Transactional
	public Optional<TypeDocument> findTypeDocumentById(Long id) { 
		Optional<TypeDocument> tipoDoc = typeDocumentRepository.findById(id);
		return tipoDoc;
	}

	@Transactional
	public TypeDocument saveTypeDocument(TypeDocument newDoc) { 
		if(newDoc != null) {
			return typeDocumentRepository.save(newDoc);
		}
		return new TypeDocument();
	}

	@Transactional
	public String deleteTypeDocument(long id) { 
		if(typeDocumentRepository.findById(id).isPresent()) {
			typeDocumentRepository.deleteById(id);
			return "Documento eliminado correctamente";
		}
		return "Documento no existe";
	}

	@Transactional
	public TypeDocument updateTypeDocument(TypeDocument doc) { 
		long num = doc.getId_type_document();
		if(typeDocumentRepository.findById(num).isPresent()) {
			TypeDocument updateDoc = new TypeDocument();
			updateDoc.setDocumentType(doc.getDocumentType()); 
			typeDocumentRepository.save(updateDoc);
			return typeDocumentRepository.getById(num);
		}
		return null;
	}
}