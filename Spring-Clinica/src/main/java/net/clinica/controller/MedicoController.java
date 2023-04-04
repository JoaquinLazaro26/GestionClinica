package net.clinica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.clinica.service.MedicoService;

@Controller
@RequestMapping("/medico")
public class MedicoController {
	@Autowired
	private MedicoService servicioMedico;
	 @RequestMapping("/lista")
	 public String index(Model x) {
		 x.addAttribute("medicos",servicioMedico.listarMedicos());
		 return "medico";
	 }
}
