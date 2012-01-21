package com.mycompany;

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
	
	void InsertDistritos(SQLiteDatabase db) {
		ContentValues cv = new ContentValues();
		cv.put(colDistritoID, 1);
		cv.put(colDistritoName, "Ate");
		db.insert(distritoTable, colDistritoID, cv);
		cv.put(colDistritoID, 2);
		cv.put(colDistritoName, "Barranco");
		db.insert(distritoTable, colDistritoID, cv);
		cv.put(colDistritoID, 3);
		cv.put(colDistritoName, "Bre–a");
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
		cv.put(colDistritoName, "Jesœs Mar’a");
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
		cv.put(colDistritoName, "Villa Mar’a del Triunfo");
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


	int getValidaUsuario(String usuario, String clave) {
		SQLiteDatabase db = this.getWritableDatabase();
		
		Cursor cur = db.rawQuery("Select * from " + userTable + " where "
				+ colUsuario + "='" + usuario + "' and " + colClave + "='"
				+ clave + "'", null);
		int x = cur.getCount();
		cur.close();
		return x;
	}

	int getUserCount() {
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cur = db.rawQuery("Select * from " + userTable, null);
		int x = cur.getCount();
		cur.close();
		return x;
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
}
