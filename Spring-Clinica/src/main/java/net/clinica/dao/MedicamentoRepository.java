package net.clinica.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.clinica.entity.Medicamento;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Integer> {
	//Método para retornar todos los medicamentos donde su stock sea mayor a un parámetro
	//Modelo relacional SQL Select * from tb_medicamento WHERE sto_med>?
	@Query("select x from Medicamento x where x.stock >?1")
	public List<Medicamento> listarMedicamentosPorStock(int stock);
}
