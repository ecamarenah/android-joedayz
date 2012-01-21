package com.mycompany;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class StartActivity extends Activity implements OnClickListener {

	Button nosotrosButton;
	Button serviciosButton;
	Button tarifasButton;
	Button sugerenciasButton;
	Button inicioSesionButton;
	Button acercaDeButton;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		nosotrosButton = (Button) findViewById(R.id.nosotrosButton);
		nosotrosButton.setOnClickListener(this);

		serviciosButton = (Button) findViewById(R.id.serviciosButton);
		serviciosButton.setOnClickListener(this);

		tarifasButton = (Button) findViewById(R.id.tarifasButton);
		tarifasButton.setOnClickListener(this);

		sugerenciasButton = (Button) findViewById(R.id.sugerenciasButton);
		sugerenciasButton.setOnClickListener(this);

		inicioSesionButton = (Button) findViewById(R.id.inicioSesionButton);
		inicioSesionButton.setOnClickListener(this);

		acercaDeButton = (Button) findViewById(R.id.acercaDeButton);
		acercaDeButton.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		Intent i;
		switch (v.getId()) {

		case R.id.nosotrosButton:
			i = new Intent(this, Nosotros.class);
			startActivity(i);
			break;
		case R.id.serviciosButton:

			break;

		case R.id.inicioSesionButton:
			i = new Intent(this, InicioSesion.class);
			startActivity(i);
			break;

		case R.id.sugerenciasButton:

			break;

		case R.id.tarifasButton:

			break;

		case R.id.acercaDeButton:

			break;
		}
	}
}