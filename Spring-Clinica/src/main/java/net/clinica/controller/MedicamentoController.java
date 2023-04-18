package net.clinica.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.clinica.entity.Medicamento;
import net.clinica.entity.TipoMedicamento;
import net.clinica.service.LaboratorioService;
import net.clinica.service.MedicamentoService;
import net.clinica.service.TipoService;

@Controller
//Ruta o Url, para acceder a la clase "Controlador" desde la vista
@RequestMapping("/medicamento")
public class MedicamentoController {
	@Autowired
	private MedicamentoService servicioMedicamento;
	@Autowired
	private TipoService serTipo;
	@Autowired
	private LaboratorioService serLab;
	
	@RequestMapping("/lista")
	public String index(Model model) {
		//Crear un atributo
		model.addAttribute("medicamentos",servicioMedicamento.listarTodosMedicamentos());
		model.addAttribute("laboratorios", serLab.listartodosLaboratorio());
		
		return "medicamento";
	}
	@RequestMapping("/listarPorLab")
	@ResponseBody
	public List<TipoMedicamento> listarPorLab(@RequestParam("codigo") Integer cod) {
		return serTipo.ListarPorLaboratorio(cod);
	}
	
	
	//Asignación de branches ("/medicamento/registrar") URL
	@RequestMapping("/registrar")
	public String registrar(
			@RequestParam("codigo") Integer cod,
			@RequestParam("nombre") String nom,
			@RequestParam("descripcion") String des,
			@RequestParam("stock") int sto,
			@RequestParam("precio") double pre,
			@RequestParam("fecha") String fec,
			@RequestParam("tipo") int codTipo,
			RedirectAttributes redirect
			) 
			{
		try {
			
			Medicamento m = new Medicamento();
			m.setCodigo(cod);
			m.setNombre(nom);
			m.setDescripcion(des);
			m.setPrecio(pre);
			m.setStock(sto);
			m.setFecha(LocalDate.parse(fec));
			
			TipoMedicamento tm = new TipoMedicamento();
			tm.setCodigo(codTipo);
			
			m.setTipo(tm);
			
			if(cod==0) {
				servicioMedicamento.adicionar(m);
				redirect.addFlashAttribute("MENSAJE","Medicamento Registrado");
			}else {
				m.setCodigo(0);
				servicioMedicamento.actualizar(m);
				redirect.addFlashAttribute("MENSAJE","Medicamento Actualizado");
			}
			
			
			
			
			
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error en el registro");
			e.printStackTrace();
		}
		return "redirect:/medicamento/lista";
	}
	//URL Ruta para buscar por Código
	
	@RequestMapping("/buscar")
	@ResponseBody //Genera JSON
	public Medicamento buscarMedicamentoPorCodigo(@RequestParam("codigo") Integer cod) {

		return servicioMedicamento.buscarPorId(cod);
	}
	
	//URL para eliminar por código
	
	@RequestMapping("/eliminar")
	public String eliminarMedicamentoPorCodigo(@RequestParam("codigo") Integer cod, RedirectAttributes redirect) {
		servicioMedicamento.Eliminar(cod);
		redirect.addFlashAttribute("MENSAJE","Medicamento eliminado");
		return "redirect:/medicamento/lista";
	}
	
	
}
