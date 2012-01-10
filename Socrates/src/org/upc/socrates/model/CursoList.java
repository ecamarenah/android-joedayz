package org.upc.socrates.model;

import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "cursos")
public class CursoList {
	@ElementList(inline = true)
	private List<Curso> cursos;

	public CursoList() {
	}

	public CursoList(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
}
