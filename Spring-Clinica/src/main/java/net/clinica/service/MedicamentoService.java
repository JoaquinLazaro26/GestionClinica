package net.clinica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.clinica.dao.MedicamentoRepository;
import net.clinica.entity.Medicamento;

//Clase Crud de Medicamento
@Service
public class MedicamentoService{
	@Autowired
	private MedicamentoRepository repo;
	public void adicionar(Medicamento s) {
		repo.save(s);
	}
	public void actualizar(Medicamento s) {
		repo.save(s);
	}
	public void Eliminar(Integer codigo) {
		repo.deleteById(codigo);;
	}
	public Medicamento buscarPorId(Integer cod) {
		return repo.findById(cod).orElse(null);
	}
	public List<Medicamento> listarTodosMedicamentos(){
		return repo.findAll();
	}
}
