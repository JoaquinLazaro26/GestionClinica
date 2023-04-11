package net.clinica.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.clinica.entity.Especialidad;
import net.clinica.entity.Medico;
import net.clinica.service.EspecialidadService;
import net.clinica.service.MedicoService;

@Controller
@RequestMapping("/medico")
public class MedicoController {
	@Autowired
	private MedicoService servicioMedico;
	@Autowired
	private EspecialidadService servicioEspecialidad;
	
	 @RequestMapping("/lista")
	 public String index(Model x) {
		 x.addAttribute("medicos",servicioMedico.listarMedicos());
		 x.addAttribute("especialidades", servicioEspecialidad.listarTodasEspecialidades());
		 return "medico";
	 }
	 @RequestMapping("/registrar")
	 public String registrar(@RequestParam("nombre") String nombre,
			 @RequestParam("apellidos") String apellidos,
			 @RequestParam("sueldo") double sueldo,
			 @RequestParam("fechaNac") String fecha,
			 @RequestParam("sexo") String sexo,
			 @RequestParam("estado") String estado,
			 RedirectAttributes redirect
			 ) {
		 try {
			 Medico s = new Medico();
				s.setNombre("Joaquin");
				s.setApellidos("Lazaro");
				s.setSueldo(1500);
				s.setFechaNac(LocalDate.parse("2001-05-26"));
				s.setSexo("Masculino");
				s.setEstado("Casado");
				servicioMedico.agregaActualizar(s);
				
				redirect.addFlashAttribute("MENSAJE","Medico Registrado");
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return "";
	 }
}
