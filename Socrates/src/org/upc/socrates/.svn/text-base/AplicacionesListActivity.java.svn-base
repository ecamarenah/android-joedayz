package org.upc.socrates;

import static org.upc.socrates.MainActivity.theme;

import org.upc.R;
import org.upc.socrates.horario.HorarioTabActivity;
import org.upc.socrates.nota.BusqCursosActivity;
import org.upc.socrates.reserva.AreasListActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AplicacionesListActivity extends ListActivity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		theme.onActivityCreateSetTheme(this);

		setListAdapter(ArrayAdapter.createFromResource(this, R.array.aplicaciones, R.layout.list_item));
	}

	@Override
	protected void onListItemClick(ListView parent, View view, int position, long id) {
		super.onListItemClick(parent, view, position, id);

		Intent intent = null;

		switch (position) {
		case 0:
			intent = new Intent(AplicacionesListActivity.this, HorarioTabActivity.class);
			break;
		case 1:
			intent = new Intent(AplicacionesListActivity.this, BusqCursosActivity.class);
			break;
		case 2:
			intent = new Intent(AplicacionesListActivity.this, AreasListActivity.class);
			break;
		}

		startActivity(intent);
	}
}
