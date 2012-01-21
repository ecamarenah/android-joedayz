package pe.joedayz.samples;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;




public class Opciones extends Activity implements OnClickListener {
	
	   
	   /** Called when the activity is first created. */
	   
	   public void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.opciones);

	      // Set up click listeners for all the buttons
	      View solicitarTaxiButton = findViewById(R.id.solicitarTaxiButton);
	      solicitarTaxiButton.setOnClickListener(this);
	      View seguimientoReservasButton = findViewById(R.id.seguimientoReservasButton);
	      seguimientoReservasButton.setOnClickListener(this);
	      View rankingTaxisButton = findViewById(R.id.rankingTaxisButton);
	      rankingTaxisButton.setOnClickListener(this);
	      View cerrarSesionButton = findViewById(R.id.cerrarSesionButton);
	      cerrarSesionButton.setOnClickListener(this);
	   }

	  

	   public void onClick(View v) {
		   Intent i;
	      switch (v.getId()) {

	      case R.id.solicitarTaxiButton:

		         break;
	      case R.id.seguimientoReservasButton:

		         break;   
	      case R.id.rankingTaxisButton:

		         break;
	      case R.id.cerrarSesionButton:
	    	 i = new Intent(this, StartActivity.class);
	         startActivity(i);
	         break;	         

	      }
	   }
	   
	
}