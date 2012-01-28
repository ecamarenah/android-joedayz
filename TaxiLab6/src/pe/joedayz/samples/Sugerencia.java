package pe.joedayz.samples;

//import android.content.Context;

public class Sugerencia {
	
	int _id;
	String _email;
	String _sugerencia;
	
	public Sugerencia(String Email,String Sugerencia)
	{
		
		this._email=Email;
		this._sugerencia=Sugerencia;
	}
	
	public int getID()
	{
		return this._id;
	}
	public void SetID(int ID)
	{
		this._id=ID;
	}
	
	public String getEmail()
	{
		return this._email;
	}
	
	public void setEmail(String Email)
	{
		this._email=Email;
	}
	
	public String getSugerencia()
	{
		return this._sugerencia;
	}
	
	public void setSugerencia(String Sugerencia)
	{
		this._sugerencia=Sugerencia;
	}
	
}
