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
@Table(name="T_TYPE_ROLES", schema="DEMO_TEAM")
@ApiModel(description="Roles Model")
public class TypeRole  {

	@Id
	@Column(name = "ID_TYPE_ROLE", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
	@ApiModelProperty(notes="ID_TYPE_ROLE on the Bank", name="id_type_role", required=true, value="2") 
	private long id_type_role;
 
	@JsonIgnore
	@OneToMany(mappedBy="id_type_role") 
	@ApiModelProperty(notes="ROLTYPE on the Bank", name="rolType", required=true, value="Admin") 
    private Set<Client> rolType;

	public long getId_type_role() {
		return id_type_role;
	}

	public void setId_type_role(long id_type_role) {
		this.id_type_role = id_type_role;
	}

	public Set<Client> getRolType() {
		return rolType;
	}

	public void setRolType(Set<Client> rolType) {
		this.rolType = rolType;
	} 
    
}
 
