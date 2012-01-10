package org.upc.socrates.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "cursos")
public class CursoList {
	private List<Curso> cursos;

	public CursoList() {
	}

	public CursoList(List<Curso> cursos) {
		this.cursos = cursos;
	}

	@XmlElement(name = "curso")
	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
}
