package org.upc.socrates.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "hora")
public class Hora {
	private String hora;
	private String curso;
	private String aula;
	private String seccion;
	private String local;

	public Hora() {
	}

	public Hora(String hora, String curso, String aula, String seccion, String local) {
		this.hora = hora;
		this.curso = curso;
		this.aula = aula;
		this.seccion = seccion;
		this.local = local;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getAula() {
		return aula;
	}

	public void setAula(String aula) {
		this.aula = aula;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}
}
