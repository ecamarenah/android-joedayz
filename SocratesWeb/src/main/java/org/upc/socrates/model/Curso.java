package org.upc.socrates.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "curso")
public class Curso {
	private String codigo;
	private String nombre;
	private String nota;

	public Curso() {
	}

	public Curso(String codigo, String nombre, String nota) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.nota = nota;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}
}
