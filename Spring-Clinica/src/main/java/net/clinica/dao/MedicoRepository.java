package net.clinica.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.clinica.entity.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Integer>{

}
