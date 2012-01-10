package org.upc.socrates.horario;

import org.upc.R;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class HorarioTabActivity extends TabActivity {
	private TabHost tabHost;

	/** Called when the activity is first created. */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.horario);

		tabHost = getTabHost();
		TabHost.TabSpec spec;
		Intent intent;

		// Tab lunes.
		intent = new Intent().setClass(this, HorarioListActivity.class);
		intent.putExtra("tab", 0);
		spec = tabHost.newTabSpec("lunes").setIndicator("Lun").setContent(intent);
		tabHost.addTab(spec);

		// Tab martes.
		intent = new Intent().setClass(this, HorarioListActivity.class);
		intent.putExtra("tab", 1);
		spec = tabHost.newTabSpec("martes").setIndicator("Mar").setContent(intent);
		tabHost.addTab(spec);

		// Tab miercoles.
		intent = new Intent().setClass(this, HorarioListActivity.class);
		intent.putExtra("tab", 2);
		spec = tabHost.newTabSpec("miercoles").setIndicator("Mie").setContent(intent);
		tabHost.addTab(spec);

		// Tab jueves.
		intent = new Intent().setClass(this, HorarioListActivity.class);
		intent.putExtra("tab", 3);
		spec = tabHost.newTabSpec("jueves").setIndicator("Jue").setContent(intent);
		tabHost.addTab(spec);

		// Tab viernes.
		intent = new Intent().setClass(this, HorarioListActivity.class);
		intent.putExtra("tab", 4);
		spec = tabHost.newTabSpec("viernes").setIndicator("Vie").setContent(intent);
		tabHost.addTab(spec);

		// Tab sabado.
		intent = new Intent().setClass(this, HorarioListActivity.class);
		intent.putExtra("tab", 5);
		spec = tabHost.newTabSpec("sabado").setIndicator("Sab").setContent(intent);
		tabHost.addTab(spec);

		tabHost.setCurrentTab(0);
	}
}
