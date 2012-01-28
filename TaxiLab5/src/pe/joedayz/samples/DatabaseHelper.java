package pe.joedayz.samples;




import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

	static final String dbName = "TaxiBD";
	static final String userTable = "Users";
	static final String colID = "UserID";
	static final String colName = "UserName";
	static final String colApePat = "ApePat";
	static final String colApeMat = "ApeMat";
	static final String colCelular = "Celular";
	static final String colEmail = "Email";
	static final String colUsuario = "Usuario";
	static final String colClave = "Clave";
	static final String colDistrito = "Distrito";

	static final String distritoTable = "Distrito";
	static final String colDistritoID = "DistritoID";
	static final String colDistritoName = "DistritoName";

	static final String reservaTable = "Reserva";
	static final String colReservaID = "ReservaID";
	static final String colReservaUserID = "ReservaUserID";
	static final String colDistritoOrigen = "DistritoOrigen";
	static final String colDireccionOrigen = "DireccionOrigen";
	static final String colDistritoDestino = "DistritoDestino";
	static final String colDireccionDestino = "DireccionDestino";
	static final String colEmailAlterno = "EmailAlterno";
	static final String colObservaciones = "Observaciones";
	static final String colFechaReserva = "FechaReserva";
	static final String colHoraReserva = "HoraReserva";
	static final String colEstadoReserva = "EstadoReserva";
	static final String colReservaTaxiID = "ReservaTaxiID";

	static final String taxiTable = "Taxi";
	static final String colTaxiID = "TaxiID";
	static final String colTaxiName = "TaxiName";
	static final String colTaxiTelefono = "TaxiTelefono";

	static final String sugerenciaTable = "Sugerencia";
	static final String colSugerenciaID = "SugerenciaID";
	static final String colSugerenciaEmail = "SugerenciaEmail";
	static final String colSugerenciaDesc = "SugerenciaDesc";

	static final String viewEmps = "ViewEmps";

	public DatabaseHelper(Context context) {
		super(context, dbName, null, 33);

	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		db.execSQL("CREATE TABLE " + sugerenciaTable + " (" + colSugerenciaID
				+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + colSugerenciaEmail
				+ " TEXT, " + colSugerenciaDesc + " TEXT)");

		db.execSQL("CREATE TABLE " + distritoTable + " (" + colDistritoID
				+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + colDistritoName
				+ " TEXT)");

		db.execSQL("CREATE TABLE " + userTable + " (" + colID
				+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + colName + " TEXT, "
				+ colApePat + " TEXT, " + colApeMat + " TEXT, " + colCelular
				+ " INTEGER, " + colEmail + " TEXT, " + colUsuario + " TEXT, "
				+ colClave + " TEXT)");

		db.execSQL("CREATE TABLE " + taxiTable + " (" + colTaxiID
				+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + colTaxiName
				+ " TEXT, " + colTaxiTelefono + " TEXT)");

		db.execSQL("CREATE TABLE " + reservaTable + " (" + colReservaID
				+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + colReservaUserID
				+ " TEXT, " + colDistritoOrigen + " INTEGER NOT NULL, "
				+ colDireccionOrigen + " TEXT, " + colDistritoDestino
				+ " INTEGER NOT NULL, " + colDireccionDestino + " TEXT, "
				+ colEmailAlterno + " TEXT, " + colObservaciones + " TEXT, "
				+ colFechaReserva + " TEXT, " + colHoraReserva + " TEXT, "
				+ colEstadoReserva + " INTEGER NOT NULL, " + colReservaTaxiID
				+ " INTEGER, FOREIGN KEY (" + colDistritoOrigen
				+ ") REFERENCES " + distritoTable + " (" + colDistritoID
				+ "), FOREIGN KEY (" + colDistritoDestino + ") REFERENCES "
				+ distritoTable + " (" + colDistritoID + "), FOREIGN KEY ("
				+ colReservaUserID + ") REFERENCES " + userTable + " ("
				+ colUsuario + "));");

		InsertDistritos(db);
		InsertTaxis(db);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

		db.execSQL("DROP TABLE IF EXISTS " + userTable);
		db.execSQL("DROP TABLE IF EXISTS " + distritoTable);
		db.execSQL("DROP TABLE IF EXISTS " + taxiTable);
		db.execSQL("DROP TABLE IF EXISTS " + reservaTable);

		db.execSQL("DROP TRIGGER IF EXISTS distrito_id_trigger");
		db.execSQL("DROP TRIGGER IF EXISTS distrito_id_trigger22");
		db.execSQL("DROP TRIGGER IF EXISTS fk_empdistrito_distritoid");
		db.execSQL("DROP VIEW IF EXISTS " + viewEmps);
		onCreate(db);
	}

	void crearBD() {
		SQLiteDatabase db = this.getWritableDatabase();

		db.execSQL("DROP TABLE IF EXISTS " + sugerenciaTable);
		db.execSQL("DROP TABLE IF EXISTS " + userTable);
		db.execSQL("DROP TABLE IF EXISTS " + distritoTable);
		db.execSQL("DROP TABLE IF EXISTS " + taxiTable);
		db.execSQL("DROP TABLE IF EXISTS " + reservaTable);

		db.execSQL("CREATE TABLE " + sugerenciaTable + " (" + colSugerenciaID
				+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + colSugerenciaEmail
				+ " TEXT, " + colSugerenciaDesc + " TEXT)");

		db.execSQL("CREATE TABLE " + distritoTable + " (" + colDistritoID
				+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + colDistritoName
				+ " TEXT)");

		db.execSQL("CREATE TABLE " + userTable + " (" + colID
				+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + colName + " TEXT, "
				+ colApePat + " TEXT, " + colApeMat + " TEXT, " + colCelular
				+ " INTEGER, " + colEmail + " TEXT, " + colUsuario + " TEXT, "
				+ colClave + " TEXT)");

		db.execSQL("CREATE TABLE " + taxiTable + " (" + colTaxiID
				+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + colTaxiName
				+ " TEXT, " + colTaxiTelefono + " TEXT)");

		db.execSQL("CREATE TABLE " + reservaTable + " (" + colReservaID
				+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + colReservaUserID
				+ " TEXT, " + colDistritoOrigen + " INTEGER NOT NULL, "
				+ colDireccionOrigen + " TEXT, " + colDistritoDestino
				+ " INTEGER NOT NULL, " + colDireccionDestino + " TEXT, "
				+ colEmailAlterno + " TEXT, " + colObservaciones + " TEXT, "
				+ colFechaReserva + " TEXT, " + colHoraReserva + " TEXT, "
				+ colEstadoReserva + " INTEGER NOT NULL, " + colReservaTaxiID
				+ " INTEGER, FOREIGN KEY (" + colDistritoOrigen
				+ ") REFERENCES " + distritoTable + " (" + colDistritoID
				+ "), FOREIGN KEY (" + colDistritoDestino + ") REFERENCES "
				+ distritoTable + " (" + colDistritoID + "), FOREIGN KEY ("
				+ colReservaUserID + ") REFERENCES " + userTable + " ("
				+ colUsuario + "));");

		InsertDistritos(db);
		InsertTaxis(db);
	}

	 void AddUser(User emp)
	{	 		 
		 SQLiteDatabase db= this.getWritableDatabase();
		 
		 ContentValues cv=new ContentValues();
		
		cv.put(colName, emp.getName());
		cv.put(colApePat, emp.getApePat());
		cv.put(colApeMat, emp.getApeMat());
		cv.put(colCelular, emp.getCelular());
		cv.put(colEmail, emp.getEmail());
		cv.put(colUsuario, emp.getUsuario());
		cv.put(colClave, emp.getClave());
		
		db.insert(userTable, colName, cv);
		db.close();	
		
	}	
	 
	 public int UpdateUser(User emp)
	 {
		 SQLiteDatabase db=this.getWritableDatabase();
		 ContentValues cv=new ContentValues();
		 cv.put(colName, emp.getName());
		 cv.put(colApePat, emp.getApePat());
		 cv.put(colApeMat, emp.getApeMat());
		 cv.put(colCelular, emp.getCelular());
		 cv.put(colEmail, emp.getEmail());
		 cv.put(colUsuario, emp.getUsuario());
		 cv.put(colClave, emp.getClave());
		
		 return db.update(userTable, cv, colID+"=?", new String []{String.valueOf(emp.getID())});
		 
	 }	 
	 
	 public void DeleteUser(User emp)
	 {
		 SQLiteDatabase db=this.getWritableDatabase();
		 db.delete(userTable,colID+"=?", new String [] {String.valueOf(emp.getID())});
		 db.close();	
		
	 }	 
	 
	int getUserCount() {
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cur = db.rawQuery("Select * from " + userTable, null);
		int x = cur.getCount();
		cur.close();
		return x;
	}

	int getReservaCount() {
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cur = db.rawQuery("Select * from " + reservaTable, null);
		int x = cur.getCount();
		cur.close();
		return x;
	}

	public int GetReservaID() {
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor c = db.rawQuery("SELECT max(" + colReservaID + ") as _id FROM "
				+ reservaTable, null);
		c.moveToFirst();
		return c.getInt(c.getColumnIndex("_id"));
	}

	public String getTelefonoTaxi(int ID) {
		SQLiteDatabase db = this.getReadableDatabase();

		String[] params = new String[] { String.valueOf(ID) };
		Cursor c = db.rawQuery("SELECT " + colTaxiTelefono + " FROM "
				+ taxiTable + " WHERE " + colTaxiID + "=?", params);
		c.moveToFirst();
		int index = c.getColumnIndex(colTaxiTelefono);
		return c.getString(index);
	}

	int getValidaUsuario(String usuario, String clave) {
		SQLiteDatabase db = this.getWritableDatabase();
		InsertDistritos(db);
		Cursor cur = db.rawQuery("Select * from " + userTable + " where "
				+ colUsuario + "='" + usuario + "' and " + colClave + "='"
				+ clave + "'", null);
		int x = cur.getCount();
		cur.close();
		return x;
	}

	Cursor updReservaTaxiID(int idReserva, int idTaxi) {
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cur = db.rawQuery("UPDATE " + reservaTable + " SET "
				+ colReservaTaxiID + "=" + idTaxi + " WHERE " + colReservaID
				+ "=" + idReserva, null);

		return cur;
	}

	Cursor getAllUsers() {
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cur = db.rawQuery("Select " + colID + " as _id , " + colName
				+ ", " + colApePat + ", " + colApeMat + " from " + userTable,
				new String[] {});
		return cur;

	}

	Cursor getAllDistritos() {
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cur = db.rawQuery("SELECT " + colDistritoID + " as _id, "
				+ colDistritoName + " from " + distritoTable, new String[] {});

		return cur;
	}

	Cursor getAllTaxis() {
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cur = db.rawQuery("SELECT " + colTaxiID + " as _id, "
				+ colTaxiName + ", " + colTaxiTelefono + " from " + taxiTable
				+ " order by " + colTaxiName, new String[] {});

		return cur;
	}

	Cursor getAllTaxistas() {

		SQLiteDatabase db = this.getReadableDatabase();
		String sSql = "SELECT " + colTaxiID + " as _id, " + colTaxiName
				+ " from " + taxiTable;
		sSql += " order by 1 desc ";
		Cursor cur = db.rawQuery(sSql, new String[] {});

		return cur;
	}

	void InsertDistritos(SQLiteDatabase db) {
		ContentValues cv = new ContentValues();
		cv.put(colDistritoID, 1);
		cv.put(colDistritoName, "Ate");
		db.insert(distritoTable, colDistritoID, cv);
		cv.put(colDistritoID, 2);
		cv.put(colDistritoName, "Barranco");
		db.insert(distritoTable, colDistritoID, cv);
		cv.put(colDistritoID, 3);
		cv.put(colDistritoName, "Breña");
		db.insert(distritoTable, colDistritoID, cv);
		cv.put(colDistritoID, 4);
		cv.put(colDistritoName, "Cercado de Lima");
		db.insert(distritoTable, colDistritoID, cv);
		cv.put(colDistritoID, 5);
		cv.put(colDistritoName, "Chorrillos");
		db.insert(distritoTable, colDistritoID, cv);
		cv.put(colDistritoID, 6);
		cv.put(colDistritoName, "Comas");
		db.insert(distritoTable, colDistritoID, cv);
		cv.put(colDistritoID, 7);
		cv.put(colDistritoName, "El Agustino");
		db.insert(distritoTable, colDistritoID, cv);
		cv.put(colDistritoID, 8);
		cv.put(colDistritoName, "Independencia");
		db.insert(distritoTable, colDistritoID, cv);
		cv.put(colDistritoID, 9);
		cv.put(colDistritoName, "Jesús María");
		db.insert(distritoTable, colDistritoID, cv);
		cv.put(colDistritoID, 10);
		cv.put(colDistritoName, "La Molina");
		db.insert(distritoTable, colDistritoID, cv);
		cv.put(colDistritoID, 11);
		cv.put(colDistritoName, "La Victoria");
		db.insert(distritoTable, colDistritoID, cv);
		cv.put(colDistritoID, 12);
		cv.put(colDistritoName, "Lince");
		db.insert(distritoTable, colDistritoID, cv);
		cv.put(colDistritoID, 13);
		cv.put(colDistritoName, "Los Olivos");
		db.insert(distritoTable, colDistritoID, cv);
		cv.put(colDistritoID, 14);
		cv.put(colDistritoName, "Magdalena del Mar");
		db.insert(distritoTable, colDistritoID, cv);
		cv.put(colDistritoID, 15);
		cv.put(colDistritoName, "Miraflores");
		db.insert(distritoTable, colDistritoID, cv);
		cv.put(colDistritoID, 16);
		cv.put(colDistritoName, "Pueblo Libre");
		db.insert(distritoTable, colDistritoID, cv);
		cv.put(colDistritoID, 17);
		cv.put(colDistritoName, "Puente Piedra");
		db.insert(distritoTable, colDistritoID, cv);
		cv.put(colDistritoID, 18);
		cv.put(colDistritoName, "Rimac");
		db.insert(distritoTable, colDistritoID, cv);
		cv.put(colDistritoID, 19);
		cv.put(colDistritoName, "San Borja");
		db.insert(distritoTable, colDistritoID, cv);
		cv.put(colDistritoID, 20);
		cv.put(colDistritoName, "San Isidro");
		db.insert(distritoTable, colDistritoID, cv);
		cv.put(colDistritoID, 21);
		cv.put(colDistritoName, "San Juan de Lurigancho");
		db.insert(distritoTable, colDistritoID, cv);
		cv.put(colDistritoID, 22);
		cv.put(colDistritoName, "San Juan de Miraflores");
		db.insert(distritoTable, colDistritoID, cv);
		cv.put(colDistritoID, 23);
		cv.put(colDistritoName, "San Luis");
		db.insert(distritoTable, colDistritoID, cv);
		cv.put(colDistritoID, 24);
		cv.put(colDistritoName, "San Martin de Porres");
		db.insert(distritoTable, colDistritoID, cv);
		cv.put(colDistritoID, 25);
		cv.put(colDistritoName, "San Miguel");
		db.insert(distritoTable, colDistritoID, cv);
		cv.put(colDistritoID, 26);
		cv.put(colDistritoName, "Santa Anita");
		db.insert(distritoTable, colDistritoID, cv);
		cv.put(colDistritoID, 27);
		cv.put(colDistritoName, "Santa Rosa");
		db.insert(distritoTable, colDistritoID, cv);
		cv.put(colDistritoID, 28);
		cv.put(colDistritoName, "Santiago de Surco");
		db.insert(distritoTable, colDistritoID, cv);
		cv.put(colDistritoID, 29);
		cv.put(colDistritoName, "Surquillo");
		db.insert(distritoTable, colDistritoID, cv);
		cv.put(colDistritoID, 30);
		cv.put(colDistritoName, "Villa El Savador");
		db.insert(distritoTable, colDistritoID, cv);
		cv.put(colDistritoID, 31);
		cv.put(colDistritoName, "Villa María del Triunfo");
		db.insert(distritoTable, colDistritoID, cv);

	}

	void InsertTaxis(SQLiteDatabase db) {
		ContentValues cv = new ContentValues();
		cv.put(colTaxiID, 1);
		cv.put(colTaxiName, "Lima Remisse");
		cv.put(colTaxiTelefono, "999656639");
		db.insert(taxiTable, colTaxiID, cv);
		cv.put(colTaxiID, 2);
		cv.put(colTaxiName, "Taxi Seguro");
		cv.put(colTaxiTelefono, "4152525");
		db.insert(taxiTable, colTaxiID, cv);
		cv.put(colTaxiID, 3);
		cv.put(colTaxiName, "Taxi Llamenos");
		cv.put(colTaxiTelefono, "4441900");
		db.insert(taxiTable, colTaxiID, cv);
		cv.put(colTaxiID, 4);
		cv.put(colTaxiName, "Royal Class");
		cv.put(colTaxiTelefono, "980597367");
		db.insert(taxiTable, colTaxiID, cv);
		cv.put(colTaxiID, 5);
		cv.put(colTaxiName, "Taxi Andes Seguro");
		cv.put(colTaxiTelefono, "2718167");
		db.insert(taxiTable, colTaxiID, cv);
	}

	public String GetDistrito(int ID) {
		SQLiteDatabase db = this.getReadableDatabase();

		String[] params = new String[] { String.valueOf(ID) };
		Cursor c = db.rawQuery("SELECT " + colDistritoName + " FROM"
				+ distritoTable + " WHERE " + colDistritoID + "=?", params);
		c.moveToFirst();
		int index = c.getColumnIndex(colDistritoName);
		return c.getString(index);
	}

	public Cursor getEmpByDistrito(String Distrito) {
		SQLiteDatabase db = this.getReadableDatabase();
		String[] columns = new String[] { "_id", colName, colDistritoName };
		Cursor c = db.query(viewEmps, columns, colDistritoName + "=?",
				new String[] { Distrito }, null, null, null);
		return c;
	}

	public int GetDistritoID(String Distrito) {
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor c = db.query(distritoTable, new String[] {
				colDistritoID + " as _id", colDistritoName }, colDistritoName
				+ "=?", new String[] { Distrito }, null, null, null);

		c.moveToFirst();
		return c.getInt(c.getColumnIndex("_id"));

	}

	Cursor getReservas() {

		SQLiteDatabase db = this.getReadableDatabase();

		String sSql = "select r.ReservaID, r.ReservaUserID, d1.DistritoName, r.DireccionOrigen, d2.DistritoName, r.DireccionDestino, r.EmailAlterno, r.Observaciones, ";
		sSql += " r.FechaReserva, r.HoraReserva, r.EstadoReserva from Reserva r inner join Distrito d1 on r.DistritoOrigen = d1.DistritoID ";
		sSql += " inner join Distrito d2 on r.DistritoDestino = d2.DistritoID";
		sSql += " order by 1 desc ";

		Cursor cur = db.rawQuery(sSql, new String[] {});

		return cur;

	}
	
	//add reserva
	
	 void AddReserva(Reserva res)
		{	 		 
			 SQLiteDatabase db= this.getWritableDatabase();
			 	
			 ContentValues cv=new ContentValues();
			
			cv.put(colReservaUserID, res.getUsuario());
			cv.put(colDistritoOrigen, res.getIdDistritoOrigen());
			cv.put(colDireccionOrigen, res.getDireccionOrigen());
			cv.put(colDistritoDestino, res.getIdDistritoDestino());
			cv.put(colDireccionDestino, res.getDireccionDestino());
			cv.put(colEmailAlterno, res.getEmailAlterno());
			cv.put(colObservaciones, res.getObservaciones());
			cv.put(colFechaReserva, res.getFechaReserva());
			cv.put(colHoraReserva, res.getHoraReserva());
			cv.put(colEstadoReserva, res.getEstadoReserva());
			//cv.put(colDistrito, emp.getDistrito());
			//cv.put(colDistrito,2);
			
			db.insert(reservaTable, colReservaUserID, cv);
			db.close();			
		}

}
