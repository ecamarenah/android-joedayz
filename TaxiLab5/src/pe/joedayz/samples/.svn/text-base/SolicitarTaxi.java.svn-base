package pe.joedayz.samples;


import java.util.Calendar;






import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.AdapterView.OnItemSelectedListener;

public class SolicitarTaxi extends Activity {
	//Declarando los widgets
	EditText txtDireccionOrigen;
	EditText txtDireccionDestino;
	EditText txtEmailAlterno;
	EditText txtObservaciones;
	TextView txtEmps;
	DatabaseHelper dbHelper;
    Spinner spinDistritoOrigen;
    Spinner spinDistritoDestino;
    
    private EditText mDateDisplay;    
    private Button mPickDate;    
    private int mYear;    
    private int mMonth;    
    private int mDay;
    
    private EditText mTimeDisplay;    
    private Button mPickTime;    
    private int mHour;
    private int mMinute;
    
    static final int DATE_DIALOG_ID = 1;
    static final int TIME_DIALOG_ID = 0;
    
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.solicitartaxi);
        txtDireccionOrigen=(EditText)findViewById(R.id.txtDireccionOrigen);
        txtDireccionDestino=(EditText)findViewById(R.id.txtDireccionDestino);
        txtEmailAlterno=(EditText)findViewById(R.id.txtEmailAlterno);
        txtObservaciones=(EditText)findViewById(R.id.txtObservaciones);
        txtEmps=(TextView)findViewById(R.id.txtEmps);
        spinDistritoOrigen=(Spinner)findViewById(R.id.spinDistritoOrigen);
        spinDistritoDestino=(Spinner)findViewById(R.id.spinDistritoDestino);
        
        // capture our View elements        
        mDateDisplay = (EditText) findViewById(R.id.dateDisplay);        
        mPickDate = (Button) findViewById(R.id.pickDate);
        mTimeDisplay = (EditText) findViewById(R.id.timeDisplay);        
        mPickTime = (Button) findViewById(R.id.pickTime);       
        // add a click listener to the button        
        mPickDate.setOnClickListener(new View.OnClickListener() {            
        	public void onClick(View v) {                
        		showDialog(DATE_DIALOG_ID);            
        	}        
        }); 
        mPickTime.setOnClickListener(new View.OnClickListener() {            
        	public void onClick(View v) {                
        		showDialog(TIME_DIALOG_ID);            
        	}        
        }); 
        // get the current date        
        final Calendar c = Calendar.getInstance();        
        mYear = c.get(Calendar.YEAR);        
        mMonth = c.get(Calendar.MONTH);        
        mDay = c.get(Calendar.DAY_OF_MONTH);    
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);
        // display the current date (this method is below)        
        updateDateDisplay();
        updateTimeDisplay();    
		
	}
	
	// updates the date in the TextView    
	private void updateDateDisplay() {
		mDateDisplay.setText(            
			new StringBuilder()                    
				// Month is 0 based so add 1         
				.append(pad(mDay)).append("-")
				.append(pad(mMonth + 1)).append("-")                    
				.append(mYear));    	
	}
	
	private void updateTimeDisplay() {
		mTimeDisplay.setText(            
			new StringBuilder()                    
				// Month is 0 based so add 1         
			.append(pad(mHour)).append(":")
            .append(pad(mMinute)));	
	}
	
	private static String pad(int c) {
        if (c >= 10)
            return String.valueOf(c);
        else
            return "0" + String.valueOf(c);
    }	
	
	
	@Override
	public void onStart() {
		

		try {
			super.onStart();
			dbHelper = new DatabaseHelper(this);

			Cursor c = dbHelper.getAllDistritos();
			startManagingCursor(c);

			SimpleCursorAdapter ca = new SimpleCursorAdapter(this,
					R.layout.distritospinnerrow, c, new String[] {
							DatabaseHelper.colDistritoName, "_id" },
					new int[] { R.id.txtDistritoName });
			
			spinDistritoOrigen.setAdapter(ca);
			spinDistritoOrigen
					.setOnItemSelectedListener(new OnItemSelectedListener() {

						public void onItemSelected(AdapterView<?> parent,
								View selectedView, int position, long id) {
							// TODO Auto-generated method stub

						}

						public void onNothingSelected(AdapterView<?> arg0) {
							// TODO Auto-generated method stub

						}
					});

			spinDistritoDestino.setAdapter(ca);
			spinDistritoDestino
					.setOnItemSelectedListener(new OnItemSelectedListener() {

						public void onItemSelected(AdapterView<?> parent,
								View selectedView, int position, long id) {
							// TODO Auto-generated method stub

						}

						public void onNothingSelected(AdapterView<?> arg0) {
							// TODO Auto-generated method stub

						}
					});

			// never close cursor
		} catch (Exception ex) {
			CatchError(ex.toString());
		}
	}
	

	void CatchError(String Exception) {
		Dialog diag = new Dialog(this);
		diag.setTitle("Registro de Datos");
		TextView txt = new TextView(this);
		txt.setText(Exception);
		diag.setContentView(txt);
		diag.show();
	}

	
	//Listeners de los pickers de fecha y hora
	
	
	private DatePickerDialog.OnDateSetListener mDateSetListener =
			new DatePickerDialog.OnDateSetListener() {

		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			mYear = year;
			mMonth = monthOfYear;
			mDay = dayOfMonth;
			updateDateDisplay();
		}
	};

	private TimePickerDialog.OnTimeSetListener mTimeSetListener = 
			new TimePickerDialog.OnTimeSetListener() {

		public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
			mHour = hourOfDay;
			mMinute = minute;
			updateTimeDisplay();
		}
	};
	
	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case TIME_DIALOG_ID:
			return new TimePickerDialog(this, mTimeSetListener, mHour, mMinute,
					false);
		case DATE_DIALOG_ID:
			return new DatePickerDialog(this, mDateSetListener, mYear, mMonth,
					mDay);
		}
		return null;
	}	
	
	
	public void btnRegresar_Click(View view) {
		Intent i = new Intent(this, Opciones.class);
		startActivity(i);
	}

	
	public void btnSolicitarTaxi_Click(View view) {
		boolean ok = true;
		try {
			String direccionOrigen = txtDireccionOrigen.getText().toString();
			String direccionDestino = txtDireccionDestino.getText().toString();
			String emailAlterno = txtEmailAlterno.getText().toString();
			String observaciones = txtObservaciones.getText().toString();
			int distritoOrigenID = Integer.valueOf((int) spinDistritoOrigen
					.getSelectedItemId());
			int distritoDestinoID = Integer.valueOf((int) spinDistritoDestino
					.getSelectedItemId());
			String fechaReserva = mDateDisplay.getText().toString();
			String horaReserva = mTimeDisplay.getText().toString();

			String usuario;
			SharedPreferences prefs = getSharedPreferences("MisPreferencias",
					Context.MODE_PRIVATE);
			usuario = prefs.getString("usuario", "");

			Reserva res = new Reserva(usuario, distritoOrigenID,
					direccionOrigen, distritoDestinoID, direccionDestino,
					emailAlterno, observaciones, fechaReserva, horaReserva, 0,
					0);
			dbHelper.AddReserva(res);
		} catch (Exception ex) {
			ok = false;
			CatchError(ex.toString());
		} finally {
			if (ok) {
				
				Alerts.ShowRegistrarReserva(this);
				Intent i = new Intent(this, GridReserva.class);
				startActivity(i);
				
			}
		}
	}
	
}
