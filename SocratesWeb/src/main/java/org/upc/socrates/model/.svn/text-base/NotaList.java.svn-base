package org.upc.socrates.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "notas")
public class NotaList {
	private List<Nota> notas;

	public NotaList() {
	}

	public NotaList(List<Nota> notas) {
		this.notas = notas;
	}

	@XmlElement(name = "nota")
	public List<Nota> getNotas() {
		return notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}
}
