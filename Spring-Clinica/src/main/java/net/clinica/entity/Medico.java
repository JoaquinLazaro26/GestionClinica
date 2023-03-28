package net.clinica.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_medico")
public class Medico {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "cod_med")
private Integer codigo;
@Column(name = "nom_med")
private String nombre;
@Column(name = "ape_med")
private String apellidos;
@Column(name = "num_hijos")
private int hijos;
@Column(name = "sue_med")
private double sueldo;
@Column(name = "fec_nac")
private LocalDate fechaNac;
@Column(name = "sexo_med")
private String sexo;
@Column(name = "est_civ_med")
private String estado;
@Column(name = "cod_espe")
private int codigoespe;

@ManyToOne
@JoinColumn(name = "cod_espe")
private Especialidad especialidad;

public Integer getCodigo() {
	return codigo;
}

public void setCodigo(Integer codigo) {
	this.codigo = codigo;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getApellidos() {
	return apellidos;
}

public void setApellidos(String apellidos) {
	this.apellidos = apellidos;
}

public int getHijos() {
	return hijos;
}

public void setHijos(int hijos) {
	this.hijos = hijos;
}

public double getSueldo() {
	return sueldo;
}

public void setSueldo(double sueldo) {
	this.sueldo = sueldo;
}

public LocalDate getFechaNac() {
	return fechaNac;
}

public void setFechaNac(LocalDate fechaNac) {
	this.fechaNac = fechaNac;
}

public String getSexo() {
	return sexo;
}

public void setSexo(String sexo) {
	this.sexo = sexo;
}

public String getEstado() {
	return estado;
}

public void setEstado(String estado) {
	this.estado = estado;
}

public int getCodigoespe() {
	return codigoespe;
}

public void setCodigoespe(int codigoespe) {
	this.codigoespe = codigoespe;
}

public Especialidad getEspecialidad() {
	return especialidad;
}

public void setEspecialidad(Especialidad especialidad) {
	this.especialidad = especialidad;
}



}
