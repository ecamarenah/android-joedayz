package org.upc.socrates;




import org.upc.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	public static Theme theme;

	
	private Button entrarButton;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		theme = new Theme(getResources().getInteger(R.integer.theme));
		theme.onActivityCreateSetTheme(this);
		setContentView(R.layout.main);

		entrarButton = (Button) findViewById(R.id.entrarButton);
		entrarButton.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				Intent intent = new Intent(MainActivity.this, AplicacionesListActivity.class);
				startActivity(intent);
			}
		});
	}
}