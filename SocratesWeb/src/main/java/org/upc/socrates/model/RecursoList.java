package org.upc.socrates.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "recursos")
public class RecursoList {
	private List<Recurso> recursos;

	public RecursoList() {
	}

	public RecursoList(List<Recurso> recursos) {
		this.recursos = recursos;
	}

	@XmlElement(name = "recurso")
	public List<Recurso> getRecursos() {
		return recursos;
	}

	public void setRecursos(List<Recurso> recursos) {
		this.recursos = recursos;
	}
}
