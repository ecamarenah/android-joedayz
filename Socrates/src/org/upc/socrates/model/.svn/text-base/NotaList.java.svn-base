package org.upc.socrates.model;

import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "notas")
public class NotaList {
	@ElementList(inline = true)
	private List<Nota> notas;

	public NotaList() {
	}

	public NotaList(List<Nota> notas) {
		this.notas = notas;
	}

	public List<Nota> getNotas() {
		return notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}
}
