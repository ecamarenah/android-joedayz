package com.mycompany;

import java.io.Serializable;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5767400139974359188L;
	int _id;
	String _name;
	String _apepat;
	String _apemat;
	int _celular;
	String _email;
	String _usuario;
	String _clave;
	
	public User(String Name,String ApePat,String ApeMat,int Celular,String Email,String Usuario,String Clave)
	{
		
		this._name=Name;
		this._apepat=ApePat;
		this._apemat=ApeMat;
		this._celular=Celular;
		this._email=Email;
		this._usuario=Usuario;
		this._clave=Clave;
	}
	
	public int getID()
	{
		return this._id;
	}
	public void SetID(int ID)
	{
		this._id=ID;
	}
	
	public String getName()
	{
		return this._name;
	}
	
	public void setName(String Name)
	{
		this._name=Name;
	}
	
	public String getApePat()
	{
		return this._apepat;
	}
	
	public void setApePat(String ApePat)
	{
		this._apepat=ApePat;
	}
	
	public String getApeMat()
	{
		return this._apemat;
	}
	
	public void setApeMat(String ApeMat)
	{
		this._apemat=ApeMat;
	}
	
	public int getCelular()
	{
		return this._celular;
	}
	public void setCelular(int Celular)
	{
		this._celular=Celular;
	}
	
	public String getEmail()
	{
		return this._email;
	}
	
	public void setEmail(String Email)
	{
		this._email=Email;
	}
	
	public String getUsuario()
	{
		return this._usuario;
	}
	
	public void setUsuario(String Usuario)
	{
		this._usuario=Usuario;
	}
	
	public String getClave()
	{
		return this._clave;
	}
	
	public void setClave(String Clave)
	{
		this._clave=Clave;
	}
}
