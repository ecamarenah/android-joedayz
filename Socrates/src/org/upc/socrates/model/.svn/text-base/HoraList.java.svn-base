package org.upc.socrates.model;

import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "horas")
public class HoraList {
	@ElementList(inline = true)
	private List<Hora> horas;

	public HoraList() {
	}

	public HoraList(List<Hora> horas) {
		this.horas = horas;
	}

	public List<Hora> getHoras() {
		return horas;
	}

	public void setHoras(List<Hora> horas) {
		this.horas = horas;
	}
}
