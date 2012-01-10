package org.upc.socrates.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "hora")
public class Hora {
	@Element
	private String hora;
	@Element
	private String curso;
	@Element
	private String aula;
	@Element
	private String seccion;
	@Element
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

	public String getCurso() {
		return curso;
	}

	public String getAula() {
		return aula;
	}

	public String getSeccion() {
		return seccion;
	}

	public String getLocal() {
		return local;
	}
}
