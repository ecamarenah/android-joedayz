package org.upc.socrates.reserva;

import static commons.Utilities.DATETIME_FORMAT;
import static commons.Utilities.DATE_FORMAT;
import static commons.Utilities.TIME_FORMAT;
import static commons.Utilities.dateToString;
import static commons.Utilities.stringToDate;
import static org.upc.socrates.MainActivity.theme;

import java.util.Date;

import org.upc.R;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TimePicker;

public class BusqCentroInfoActivity extends Activity {
	static final int DATE_DIALOG_ID = 0;
	static final int TIME_DIALOG_ID = 1;

	private Spinner localSpinner;
	private Spinner tipoRecursoSpinner;
	private Button fechaButton;
	private Button horaButton;
	private Button buscarButton;

	private DatePickerDialog.OnDateSetListener dateSetListener;
	private TimePickerDialog.OnTimeSetListener timeSetListener;

	/** Called when the activity is first created. */
	@SuppressWarnings("rawtypes")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		theme.onActivityCreateSetTheme(this);
		setContentView(R.layout.busq_centro_info);

		localSpinner = (Spinner) findViewById(R.id.localSpinner);
		ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.locales, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		localSpinner.setAdapter(adapter);

		tipoRecursoSpinner = (Spinner) findViewById(R.id.tipoRecursoSpinner);
		adapter = ArrayAdapter.createFromResource(this, R.array.tipoRecurso, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		tipoRecursoSpinner.setAdapter(adapter);

		Date hoy = new Date();

		fechaButton = (Button) findViewById(R.id.fechaButton);
		fechaButton.setText(dateToString(DATE_FORMAT, hoy));
		fechaButton.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				showDialog(DATE_DIALOG_ID);
			}
		});

		horaButton = (Button) findViewById(R.id.horaButton);
		horaButton.setText(dateToString(TIME_FORMAT, hoy));
		horaButton.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				showDialog(TIME_DIALOG_ID);
			}
		});

		buscarButton = (Button) findViewById(R.id.buscarButton);
		buscarButton.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				Intent intent = new Intent(BusqCentroInfoActivity.this, RecursosListActivity.class);
				startActivity(intent);
			}
		});

		dateSetListener = new DatePickerDialog.OnDateSetListener() {
			@SuppressWarnings("deprecation")
			public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
				Date date = new Date(year - 1900, monthOfYear, dayOfMonth);
				fechaButton.setText(dateToString(DATE_FORMAT, date));
			}
		};

		timeSetListener = new TimePickerDialog.OnTimeSetListener() {
			@SuppressWarnings("deprecation")
			public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
				Date date = new Date();
				date.setHours(hourOfDay);
				date.setMinutes(minute);
				horaButton.setText(dateToString(TIME_FORMAT, date));
			}

		};
	}

	@SuppressWarnings("deprecation")
	@Override
	protected Dialog onCreateDialog(int id) {
		String string;
		Date date;

		switch (id) {
		case DATE_DIALOG_ID:
			string = fechaButton.getText().toString();
			date = stringToDate(DATE_FORMAT, string);
			return new DatePickerDialog(this, dateSetListener, date.getYear() + 1900, date.getMonth(), date.getDate());
		case TIME_DIALOG_ID:
			string = dateToString(DATE_FORMAT, new Date()) + " " + horaButton.getText().toString();
			date = stringToDate(DATETIME_FORMAT, string);
			return new TimePickerDialog(this, timeSetListener, date.getHours(), date.getMinutes(), false);
		}

		return null;
	}
}
