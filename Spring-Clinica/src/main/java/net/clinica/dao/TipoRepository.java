package net.clinica.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.clinica.entity.TipoMedicamento;

public interface TipoRepository extends JpaRepository<TipoMedicamento, Integer>{
	
	
}
