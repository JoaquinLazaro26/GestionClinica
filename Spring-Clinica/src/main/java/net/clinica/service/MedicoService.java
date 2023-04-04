package net.clinica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.clinica.dao.MedicoRepository;
import net.clinica.entity.Medico;
@Service
public class MedicoService {
@Autowired
private MedicoRepository repo;

public void agregaActualizar(Medico m) {
	repo.save(m);
}
public void eliminarPorId(Integer codigo) {
	repo.deleteById(codigo);
}
public Medico buscarPorId(Integer cod) {
	return repo.findById(cod).orElse(null);
}
public List<Medico> listarMedicos(){
	return repo.findAll();
}
}
