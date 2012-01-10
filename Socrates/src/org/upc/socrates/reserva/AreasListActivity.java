package org.upc.socrates.reserva;

import static org.upc.socrates.MainActivity.theme;

import org.upc.R;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AreasListActivity extends ListActivity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		theme.onActivityCreateSetTheme(this);

		setListAdapter(ArrayAdapter.createFromResource(this, R.array.areas, R.layout.list_item));
	}

	@Override
	protected void onListItemClick(ListView parent, View view, int position, long id) {
		super.onListItemClick(parent, view, position, id);

		Intent intent = null;

		switch (position) {
		case 0:
			intent = new Intent(AreasListActivity.this, BusqCentroInfoActivity.class);
			break;
		}

		startActivity(intent);
	}
}
