package pe.joedayz.samples;




import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;




public class StartActivity extends Activity implements OnClickListener {
	//private static final String TAG = "Sudoku";
	   
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

	   
	   /*protected void onResume() {
	      super.onResume();
	      Music.play(this, R.raw.main);
	   }

	   @Override
	   protected void onPause() {
	      super.onPause();
	      Music.stop(this);
	   }*/

	   public void onClick(View v) {
		   Intent i;
	      switch (v.getId()) {
	      //case R.id.continue_button:
	      //   startGame(Game.DIFFICULTY_CONTINUE);
	      //   break;
	         // ...
	      case R.id.nosotrosButton:
		         i = new Intent(this, Nosotros.class);
		         startActivity(i);
		         break;
	      case R.id.serviciosButton:
		         i = new Intent(this, Servicios.class);
		         startActivity(i);
		         break;
	      case R.id.tarifasButton:
		         i = new Intent(this, Tarifas.class);
		         startActivity(i);
		         break;
	      case R.id.sugerenciasButton:
		         i = new Intent(this, EnviarSugerencia.class);
		         startActivity(i);
		         break;
	      case R.id.inicioSesionButton:
	    	  	 i = new Intent(this, InicioSesion.class);
	    	  	 startActivity(i);
	    	  	 break;
	      case R.id.acercaDeButton:
		         i = new Intent(this, About.class);
		         startActivity(i);
		         break;
		      // More buttons go here (if any) ...
	     // case R.id.new_button:
	      //   openNewGameDialog();
	      //   break;
	      //case R.id.exit_button:
	      //   finish();
	      //   break;
	      }
	   }
	   
	   @Override
	   public boolean onCreateOptionsMenu(Menu menu) {
	      super.onCreateOptionsMenu(menu);
	      MenuInflater inflater = getMenuInflater();
	      inflater.inflate(R.menu.menu, menu);
	      return true;
	   }

	   /*@Override
	   public boolean onOptionsItemSelected(MenuItem item) {
	      switch (item.getItemId()) {
	      case R.id.settings:
	         startActivity(new Intent(this, Prefs.class));
	         return true;
	      // More items go here (if any) ...
	      }
	      return false;
	   }*/

	   /** Ask the user what difficulty level they want */
	   /*private void openNewGameDialog() {
	      new AlertDialog.Builder(this)
	           .setTitle(R.string.new_game_title)
	           .setItems(R.array.difficulty,
	            new DialogInterface.OnClickListener() {
	               public void onClick(DialogInterface dialoginterface,
	                     int i) {
	                  startGame(i);
	               }
	            })
	           .show();
	   }*/

	   /** Start a new game with the given difficulty level */
	   /*private void startGame(int i) {
	      Log.d(TAG, "clicked on " + i);
	      Intent intent = new Intent(this, Game.class);
	      intent.putExtra(Game.KEY_DIFFICULTY, i);
	      startActivity(intent);
	   }*/
    
}