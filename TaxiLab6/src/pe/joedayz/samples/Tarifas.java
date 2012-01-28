
package pe.joedayz.samples;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Tarifas extends Activity {
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.tarifas);
   }
   public void btnRegresar_Click(View view)
	{
		Intent i = new Intent(this, StartActivity.class);
      startActivity(i);
	}
}
