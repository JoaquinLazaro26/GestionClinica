package net.clinica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import net.clinica.entity.Enlace;
import net.clinica.entity.Usuario;
import net.clinica.service.UsuarioService;
@SessionAttributes({"datosUsuario","ENLACES"})
@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	private UsuarioService servicio;
	
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	@RequestMapping("/intranet")
	public String intranet(Authentication auth, Model x) {
		
		String vLogin = auth.getName();
		//Invocar al método validar sesión
		Usuario bean = servicio.validarSesion(vLogin);
		//Invocar al método enlaces del usuario
		List<Enlace> lista = servicio.retornarEnlacesUsuario(bean.getRol().getCodigo());
		//Asignar valor a los atributos de tipo sesión
		x.addAttribute("datosUsuario",bean.getApellido()+" "+bean.getNombre());
		x.addAttribute("ENLACES", lista);
		return "intranet";
	}
}
