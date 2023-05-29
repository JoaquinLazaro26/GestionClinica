package net.clinica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.clinica.dao.UsuarioRepository;
import net.clinica.entity.Enlace;
import net.clinica.entity.Usuario;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuRepo;
	
	public Usuario validarSesion(String vLogin) {
		return usuRepo.iniciarSesion(vLogin);
	}
	public List<Enlace> retornarEnlacesUsuario(int codigo){
		return usuRepo.retornarEnlaces(codigo);
	}
}
