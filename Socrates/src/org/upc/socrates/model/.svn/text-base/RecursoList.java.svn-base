package org.upc.socrates.model;

import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "recursos")
public class RecursoList {
	@ElementList(inline = true)
	private List<Recurso> recursos;

	public RecursoList() {
	}

	public RecursoList(List<Recurso> recursos) {
		this.recursos = recursos;
	}

	public List<Recurso> getRecursos() {
		return recursos;
	}

	public void setRecursos(List<Recurso> recursos) {
		this.recursos = recursos;
	}
}
