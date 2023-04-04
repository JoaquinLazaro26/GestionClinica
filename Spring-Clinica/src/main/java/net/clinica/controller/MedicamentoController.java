package net.clinica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.clinica.service.MedicamentoService;

@Controller
//Ruta o Url, para acceder a la clase "Controlador" desde la vista
@RequestMapping("/medicamento")
public class MedicamentoController {
	@Autowired
	private MedicamentoService servicioMedicamento;
	
	@RequestMapping("/lista")
	public String index(Model model) {
		//Crear un atributo
		model.addAttribute("medicamentos",servicioMedicamento.listarTodosMedicamentos());
		return "medicamento";
	}
	
	
	
	//Asignación de branches ("/medicamento/registrar")
	@RequestMapping("/registrar")
	public String registrar() {
		return "";
	}
}
