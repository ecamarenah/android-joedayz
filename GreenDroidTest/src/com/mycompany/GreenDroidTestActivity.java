package com.mycompany;

import greendroid.app.GDActivity;
import greendroid.widget.ActionBarItem;
import greendroid.widget.ActionBarItem.Type;
import android.os.Bundle;
import android.widget.Toast;

public class GreenDroidTestActivity extends GDActivity {

	private final int LOCATE = 0;
	private final int REFRESH = 1;
	private final int SHARE = 2;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setActionBarContentView(R.layout.main);

		initActionBar();

	}

	@Override
	public boolean onHandleActionBarItemClick(ActionBarItem item, int position) {

		switch (item.getItemId()) {
		case LOCATE:
			Toast.makeText(getApplicationContext(),
					"Has pulsado el boton LOCATE", Toast.LENGTH_SHORT).show();
			break;

		case REFRESH:
			Toast.makeText(getApplicationContext(),
					"Has pulsado el boton REFRESH", Toast.LENGTH_SHORT).show();
			break;

		case SHARE:
			Toast.makeText(getApplicationContext(),
					"Has pulsado el boton SHARE", Toast.LENGTH_SHORT).show();
			break;

		default:
			return super.onHandleActionBarItemClick(item, position);
		}

		return true;

	}

	private void initActionBar() {
		addActionBarItem(Type.Locate, LOCATE);
		addActionBarItem(Type.Refresh, REFRESH);
		addActionBarItem(Type.Share, SHARE);

	}

}