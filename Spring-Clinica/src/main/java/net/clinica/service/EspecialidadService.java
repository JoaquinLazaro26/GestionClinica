package net.clinica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.clinica.dao.EspecialidadRepository;
import net.clinica.entity.Especialidad;

@Service
public class EspecialidadService {
	@Autowired
	private EspecialidadRepository repo;
	public List<Especialidad> listarTodasEspecialidades(){
		return repo.findAll();
	}
}
