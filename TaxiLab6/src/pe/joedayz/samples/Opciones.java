package pe.joedayz.samples;




import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;




public class Opciones extends Activity implements OnClickListener {
	//private static final String TAG = "Sudoku";
	   
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
	      /*case R.id.nosotrosButton:
		         Intent j = new Intent(this, InicioSesion.class);
		         startActivity(j);
		         break;*/
	      
	      case R.id.solicitarTaxiButton:
		         i = new Intent(this, SolicitarTaxi.class);
		         startActivity(i);
		         break;
	      case R.id.seguimientoReservasButton:
		         i = new Intent(this, SeguimientoReservas.class);
		         startActivity(i);
		         break;   
	      case R.id.rankingTaxisButton:
		         i = new Intent(this, RankingTaxi.class);
		         startActivity(i);
		         break;
	      case R.id.cerrarSesionButton:
	    	  	i = new Intent(this, StartActivity.class);
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
	   
	   /*@Override
	   public boolean onCreateOptionsMenu(Opciones menu) {
	      super.onCreateOptionsMenu(menu);
	      MenuInflater inflater = getMenuInflater();
	      inflater.inflate(R.menu.menu, menu);
	      return true;
	   }*/

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