package com.techApiBank.entities;
  
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn; 
import javax.persistence.ManyToOne;
import javax.persistence.Table; 

//import com.techApiBank.entities.TypeDocument;
//import com.techApiBank.entities.TypeRole;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="T_CLIENTS", schema="DEMO_TEAM")
@ApiModel(description="Clients Model")
public class Client {

    @Id 
    @Column(name="ID_CLIENT")
    @ApiModelProperty(notes="ID_CLIENT on the Bank", name="id_client", required=true, value="25")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private String  id_client;

    @Column(name="DOCUMENT")
    @ApiModelProperty(notes="DOCUMENT on the Bank", name="document", required=true, value="123456789")
    private String document;
 
    @ManyToOne 
    @JoinColumn(name = "ID_TYPE_DOCUMENT", nullable = false)
    @ApiModelProperty(notes="ID_TYPE_DOCUMENT on the Bank", name="id_type_document", required=true, value="1")
    private TypeDocument id_type_document;
 
    @Column(name="NAME")
    @ApiModelProperty(notes="NAME on the Bank", name="name", required=true, value="Jonh")
    private String name;	

    @Column(name="LASTNAME")
    @ApiModelProperty(notes="LASTNAME on the Bank", name="lastName", required=true, value="Due")
    private String lastName;	 
    
    @Column(name="MAIL")
    @ApiModelProperty(notes="MAIL on the Bank", name="mail", required=true, value="jonhDue@example.com")
    private String mail;
  
    @Column(name="DIRECTION")
    @ApiModelProperty(notes="DIRECTION on the Bank", name="direction", required=true, value="Cll 23 #32-34 Norte")
    private String direction;
  
    @Column(name="PHONE")
    @ApiModelProperty(notes="PHONE on the Bank", name="phone", required=true, value="2035622") 
    private String phone;
  
    @Column(name="PASSWORD")
    @ApiModelProperty(notes="PASSWORD on the Bank", name="password", required=true, value="Password*") 
    private String password;
   
     
    @ManyToOne 
    @JoinColumn(name = "ID_TYPE_ROLE", nullable = false)
    @ApiModelProperty(notes="ID_TYPE_ROLE on the Bank", name="id_type_role", required=true, value="2") 
    private TypeRole id_type_role;
    
    
    public Client() {
		super();
	}
    
	public String getId_client() {
		return id_client;
	}

	public void setId_client(String id_client) {
		this.id_client = id_client;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public TypeDocument getId_type_document() {
		return id_type_document;
	}

	public void setId_type_document(TypeDocument id_type_document) {
		this.id_type_document = id_type_document;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public TypeRole getId_type_role() {
		return id_type_role;
	}

	public void setId_type_role(TypeRole id_type_role) {
		this.id_type_role = id_type_role;
	}
     
}

