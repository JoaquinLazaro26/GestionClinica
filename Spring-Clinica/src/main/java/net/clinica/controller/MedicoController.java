package net.clinica.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.clinica.entity.Especialidad;
import net.clinica.entity.Medico;
import net.clinica.service.EspecialidadService;
import net.clinica.service.MedicoService;

@Controller
@RequestMapping("/medico")
public class MedicoController {
	@Autowired
	MedicoService medserv;
	@Autowired
	EspecialidadService espserv;
	
	
	@RequestMapping("/lista")
	public String index(Model x) {
		x.addAttribute("medicos", medserv.listarMedicos());
		x.addAttribute("especialidades", espserv.listarTodasEspecialidades());
		return "medico";
	}
	@RequestMapping("/buscar")
	@ResponseBody
	public Medico buscarMedicoPorId(@RequestParam("codigo") Integer cod) {
		return medserv.buscarPorId(cod);
	}
	@RequestMapping("/eliminar")
	public String eliminarPorId(@RequestParam("codigo") Integer cod, RedirectAttributes redirect) {
		medserv.eliminarPorId(cod);
		redirect.addFlashAttribute("MENSAJE", "Médico registrado");
		return "redirect:/medico/lista";
	}
	@RequestMapping("registrar")
	public String registrarMedico(
			@RequestParam("codigo") Integer cod,
			@RequestParam("nombre") String nom,
			@RequestParam("apellidos") String ape,
			@RequestParam("sueldo") double sue,
			@RequestParam("fechaNac") String fec,
			@RequestParam("sexo") String sex,
			@RequestParam("estado")String est,
			@RequestParam("especialidad") int codespe,
			RedirectAttributes redirect
			) {
		try {
			Medico m = new Medico();
			m.setCodigo(cod);
			m.setNombre(nom);
			m.setApellidos(ape);
			m.setSueldo(sue);
			m.setFechaNac(LocalDate.parse(fec));
			m.setSexo(sex);
			m.setEstado(est);
			
			Especialidad e = new Especialidad();
			e.setCodigo(codespe);
			
			m.setEspecialidad(e);
			
			medserv.agregaActualizar(m);
			if(cod==0) {
				redirect.addFlashAttribute("MENSAJE", "Medico registrado");
			}else {
				m.setCodigo(0);
				redirect.addFlashAttribute("MENSAJE", "Medico Actualizado");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return "redirect:/medico/lista";
	}
	
}
