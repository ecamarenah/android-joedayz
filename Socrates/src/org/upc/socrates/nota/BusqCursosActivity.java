package org.upc.socrates.nota;

import static org.upc.socrates.MainActivity.theme;

import org.upc.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class BusqCursosActivity extends Activity {
	private Spinner modalidadSpinner;
	private Spinner cicloSpinner;
	private Button siguienteButton;

	/** Called when the activity is first created. */
	@SuppressWarnings("rawtypes")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		theme.onActivityCreateSetTheme(this);
		setContentView(R.layout.busq_cursos);

		modalidadSpinner = (Spinner) findViewById(R.id.modalidadSpinner);
		ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.modalidades, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		modalidadSpinner.setAdapter(adapter);
		
		cicloSpinner = (Spinner) findViewById(R.id.cicloSpinner);
		adapter = ArrayAdapter.createFromResource(this, R.array.ciclos, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		cicloSpinner.setAdapter(adapter);

		siguienteButton = (Button) findViewById(R.id.siguienteButton);
		siguienteButton.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				Intent intent = new Intent(BusqCursosActivity.this, CursosListActivity.class);
				startActivity(intent);
			}
		});
	}
}
