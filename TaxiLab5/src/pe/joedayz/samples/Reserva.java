package pe.joedayz.samples;

public class Reserva {
	
	int _id;
	String _usuario;
	int _idDistritoOrigen;
	String _direccionOrigen;
	int _idDistritoDestino;
	String _direccionDestino;	
	String _emailAlterno;
	String _observaciones;
	String _fechaReserva;
	String _horaReserva;
	int _estadoReserva;
	int _idTaxiReserva;
	//int _dept;
	
	public Reserva(String Usuario,int IdDistritoOrigen,String DireccionOrigen,
			int IdDistritoDestino,String DireccionDestino,String EmailAlterno,
			String Observaciones, String FechaReserva, String HoraReserva, 
			int EstadoReserva, int idTaxiReserva)
	{
		this._usuario=Usuario;
		this._idDistritoOrigen=IdDistritoOrigen;
		this._direccionOrigen=DireccionOrigen;
		this._idDistritoDestino=IdDistritoDestino;
		this._direccionDestino=DireccionDestino;
		this._emailAlterno=EmailAlterno;
		this._observaciones=Observaciones;
		this._fechaReserva=FechaReserva;
		this._horaReserva=HoraReserva;
		this._estadoReserva=EstadoReserva;
		this._idTaxiReserva=idTaxiReserva;
	}
	
	public Reserva(String Usuario,int IdDistritoOrigen,String DireccionOrigen,
			int IdDistritoDestino,String DireccionDestino,String EmailAlterno)
	{
		this._usuario=Usuario;
		this._idDistritoOrigen=IdDistritoOrigen;
		this._direccionOrigen=DireccionOrigen;
		this._idDistritoDestino=IdDistritoDestino;
		this._direccionDestino=DireccionDestino;
		this._emailAlterno=EmailAlterno;
	}
	
	public Reserva(String Usuario,int IdDistritoOrigen,String DireccionOrigen,
			int IdDistritoDestino,String DireccionDestino)
	{
		this._usuario=Usuario;
		this._idDistritoOrigen=IdDistritoOrigen;
		this._direccionOrigen=DireccionOrigen;
		this._idDistritoDestino=IdDistritoDestino;
		this._direccionDestino=DireccionDestino;		
	}
	
	public int getID()
	{
		return this._id;
	}
	public void SetID(int ID)
	{
		this._id=ID;
	}
	
	public String getUsuario()
	{
		return this._usuario;
	}
	
	public void setUsuario(String Usuario)
	{
		this._usuario=Usuario;
	}
	
	public int getIdDistritoOrigen()
	{
		return this._idDistritoOrigen;
	}
	
	public void setIdDistritoOrigen(int IdDistritoOrigen)
	{
		this._idDistritoOrigen=IdDistritoOrigen;
	}
	
	public String getDireccionOrigen()
	{
		return this._direccionOrigen;
	}
	
	public void setDireccionOrigen(String DireccionOrigen)
	{
		this._direccionOrigen=DireccionOrigen;
	}
	
	public int getIdDistritoDestino()
	{
		return this._idDistritoDestino;
	}
	
	public void setIdDistritoDestino(int IdDistritoDestino)
	{
		this._idDistritoDestino=IdDistritoDestino;
	}
	
	public String getDireccionDestino()
	{
		return this._direccionDestino;
	}
	
	public void setDireccionDestino(String DireccionDestino)
	{
		this._direccionDestino=DireccionDestino;
	}
	
	public String getEmailAlterno()
	{
		return this._emailAlterno;
	}
	
	public void setEmail(String EmailAlterno)
	{
		this._emailAlterno=EmailAlterno;
	}
	
	public String getObservaciones()
	{
		return this._observaciones;
	}
	
	public void setObservaciones(String Observaciones)
	{
		this._observaciones=Observaciones;
	}
	
	public String getFechaReserva()
	{
		return this._fechaReserva;
	}
	
	public void setFechaReserva(String FechaReserva)
	{
		this._fechaReserva=FechaReserva;
	}
	
	public String getHoraReserva()
	{
		return this._horaReserva;
	}
	
	public void setHoraReserva(String HoraReserva)
	{
		this._horaReserva=HoraReserva;
	}
	
	public int getEstadoReserva()
	{
		return this._estadoReserva;
	}
	public void SetEstadoReserva(int EstadoReserva)
	{
		this._estadoReserva=EstadoReserva;
	}
	
	public int getIdTaxiReserva()
	{
		return this._idTaxiReserva;
	}
	public void SetIdTaxiReserva(int idTaxiReserva)
	{
		this._idTaxiReserva=idTaxiReserva;
	}
	
	/*public void setDept(int Dept)
	{
		this._dept=Dept;
	}
	
	public String getDeptUsuario(Context con, int Dept)
	{
		return new DatabaseHelper(con).GetDept(Dept);
	}
	public int getDept()
	{
		return this._dept;
	}*/
}
