package net.clinica;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import net.clinica.entity.Medicamento;
import net.clinica.entity.Medico;
import net.clinica.entity.TipoMedicamento;
import net.clinica.service.MedicamentoService;
import net.clinica.service.MedicoService;

@SpringBootTest
class SpringClinicaApplicationTests {
	@Autowired
	private MedicoService servicio;

	@Test
	void contextLoads() {
		Medico s = new Medico();
		s.setNombre("Joaquin");
		s.setApellidos("Lazaro");
		s.setSueldo(1500);
		s.setFechaNac(LocalDate.parse("2001-05-26"));
		s.setSexo("Masculino");
		s.setEstado("Casado");
		servicio.agregaActualizar(s);
	}

}
