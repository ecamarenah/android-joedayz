package pe.joedayz.samples;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class StartActivity extends Activity implements OnClickListener {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// Set up click listeners for all the buttons
		View nosotrosButton = findViewById(R.id.nosotrosButton);
		nosotrosButton.setOnClickListener(this);
		View serviciosButton = findViewById(R.id.serviciosButton);
		serviciosButton.setOnClickListener(this);
		View tarifasButton = findViewById(R.id.tarifasButton);
		tarifasButton.setOnClickListener(this);
		View sugerenciasButton = findViewById(R.id.sugerenciasButton);
		sugerenciasButton.setOnClickListener(this);
		View inicioSesionButton = findViewById(R.id.inicioSesionButton);
		inicioSesionButton.setOnClickListener(this);
		View acercaDeButton = findViewById(R.id.acercaDeButton);
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
		case R.id.tarifasButton:

			break;
		case R.id.sugerenciasButton:

			break;
		case R.id.inicioSesionButton:
   	  	 i = new Intent(this, InicioSesion.class);
   	  	 startActivity(i);
   	  	 break;
		case R.id.acercaDeButton:
			break;
		}

	}
}