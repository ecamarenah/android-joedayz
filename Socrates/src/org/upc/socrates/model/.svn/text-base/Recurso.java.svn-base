package org.upc.socrates.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "recurso")
public class Recurso {
	@Element
	private String codigo;
	@Element
	private String descripcion;
	@Element
	private String local;
	@Element
	private String reservado;

	public Recurso() {
	}

	public Recurso(String codigo, String descripcion, String local, String reservado) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.local = local;
		this.reservado = reservado;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getReservado() {
		return reservado;
	}

	public void setReservado(String reservado) {
		this.reservado = reservado;
	}
}
