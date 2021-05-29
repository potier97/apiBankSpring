package com.techApiBank.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity; 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table; 

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="T_TYPE_DOCUMENTS", schema="DEMO_TEAM")
@ApiModel(description="Documents Model")
public class TypeDocument {

	@Id   
	@Column(name = "ID_TYPE_DOCUMENT", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@ApiModelProperty(notes="ID_TYPE_DOCUMENT on the Bank", name="id_type_document", required=true, value="2") 
	private Long id_type_document;
	 
	@JsonIgnore
	@OneToMany(mappedBy="id_type_document")
	@ApiModelProperty(notes="DOCUMENTTYPE on the Bank", name="documentType", required=true, value="CC") 
	private Set<Client> documentType;
 
	public Long getId_type_document() {
		return id_type_document;
	}
 
	public void setId_type_document(Long id_type_document) {
		this.id_type_document = id_type_document;
	}
 
	public Set<Client> getDocumentType() {
		return documentType;
	}
 
	public void setDocumentType(Set<Client> documentType) {
		this.documentType = documentType;
	}  
	  
	
}
 
