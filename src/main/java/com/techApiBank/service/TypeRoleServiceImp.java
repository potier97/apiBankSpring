package com.techApiBank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techApiBank.entities.TypeRole;
import com.techApiBank.repository.TypeRoleRepository;

@Service
public class TypeRoleServiceImp {

	@Autowired
	TypeRoleRepository typeRoleRepository;

	@Transactional
	public List<TypeRole> findAllTypeRole() { 
		return typeRoleRepository.findAll();
	}

	@Transactional
	public Optional<TypeRole> findTypeRolById(Long id) { 
		Optional<TypeRole> tipoUsuario = typeRoleRepository.findById(id);
		return tipoUsuario;
	}

	@Transactional
	public TypeRole saveTypeRole(TypeRole newRole) { 
		if(newRole != null) {
			return typeRoleRepository.save(newRole);
		}
		return new TypeRole();
	}

	@Transactional
	public String deleteTypeRole(long id) { 
		if(typeRoleRepository.findById(id).isPresent()) {
			typeRoleRepository.deleteById(id);
			return "Rol eliminado correctamente";
		}
		return "Rol no existe";
	}
 
	@Transactional
	public TypeRole updateTypeRole(TypeRole role) { 
		Long num = role.getId_type_role();
		if(typeRoleRepository.findById(num).isPresent()) {
			TypeRole updateRole = new TypeRole();
			updateRole.setRolType(role.getRolType()); 
			typeRoleRepository.save(updateRole);
			return typeRoleRepository.getById(num);
		}
		return null;
	}
}