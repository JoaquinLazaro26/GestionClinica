package net.clinica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.clinica.dao.TipoRepository;
import net.clinica.entity.TipoMedicamento;

//Clase para listar TipoMedicamentos en una lista desplegable
@Service
public class TipoService{
	 @Autowired
	private TipoRepository repo;
	public List<TipoMedicamento> listartodoTipoMedicamentos(){
		return repo.findAll();
	}
}
