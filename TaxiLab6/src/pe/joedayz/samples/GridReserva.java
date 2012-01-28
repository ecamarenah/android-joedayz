package pe.joedayz.samples;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.GridView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class GridReserva extends Activity {
	DatabaseHelper dbHelper;
	static public GridView grid;
	ListenToPhoneState listener;
	Spinner spinTaxi;

	// TextView txtTest;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.gridreservaview);
		grid = (GridView) findViewById(R.id.grid);
		spinTaxi = (Spinner) findViewById(R.id.spinTaxi);
		LoadGrid();
	}

	@Override
	public void onStart() {
		try {
			super.onStart();
			dbHelper = new DatabaseHelper(this);

			Cursor c = dbHelper.getAllTaxis();
			startManagingCursor(c);

			// SimpleCursorAdapter ca=new
			// SimpleCursorAdapter(this,android.R.layout.simple_spinner_item, c,
			// new String [] {DatabaseHelper.colDistritoName}, new int
			// []{android.R.id.text1});
			SimpleCursorAdapter ca = new SimpleCursorAdapter(this,
					R.layout.taxispinnerrow, c, new String[] {
							DatabaseHelper.colTaxiName, "_id" },
					new int[] { R.id.txtTaxiName });
			// ca.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			spinTaxi.setAdapter(ca);
			spinTaxi.setOnItemSelectedListener(new OnItemSelectedListener() {

				public void onItemSelected(AdapterView<?> parent,
						View selectedView, int position, long id) {
					// TODO Auto-generated method stub

				}

				public void onNothingSelected(AdapterView<?> arg0) {
					// TODO Auto-generated method stub

				}
			});

			// never close cursor
		} catch (Exception ex) {
			CatchError(ex.toString());
		}
	}

	void CatchError(String Exception) {
		Dialog diag = new Dialog(this);
		diag.setTitle("Registro de Datos");
		TextView txt = new TextView(this);
		txt.setText(Exception);
		diag.setContentView(txt);
		diag.show();
	}

	private void call(String telefono) {
		try {
			Intent callIntent = new Intent(Intent.ACTION_CALL);
			callIntent.setData(Uri.parse("tel:" + telefono));
			startActivity(callIntent);

			TelephonyManager tManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
			listener = new ListenToPhoneState();
			tManager.listen(listener, PhoneStateListener.LISTEN_CALL_STATE);
		} catch (ActivityNotFoundException activityException) {
			Log.e("telephony-example", "Call failed", activityException);
		}
	}

	private class ListenToPhoneState extends PhoneStateListener {

		public void onCallStateChanged(int state, String incomingNumber) {
			Log.i("telephony-example", "State changed: " + stateName(state));
		}

		String stateName(int state) {
			switch (state) {
			case TelephonyManager.CALL_STATE_IDLE:
				return "Idle";
			case TelephonyManager.CALL_STATE_OFFHOOK:
				return "Off hook";
			case TelephonyManager.CALL_STATE_RINGING:
				return "Ringing";
			}
			return Integer.toString(state);
		}
	}

	public void LoadGrid() {
		dbHelper = new DatabaseHelper(this);
		try {
			Cursor c = dbHelper.getAllTaxis();
			startManagingCursor(c);

			String[] from = new String[] { DatabaseHelper.colTaxiName,
					DatabaseHelper.colTaxiTelefono };
			int[] to = new int[] { R.id.colName, R.id.colTelefono };

			SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
					R.layout.gridreservarow, c, from, to);
			grid.setAdapter(adapter);
		} catch (Exception ex) {
			AlertDialog.Builder b = new AlertDialog.Builder(this);
			b.setMessage(ex.toString());
			b.show();
		}
	}

	public void btnRegistrarTaxi_Click(View view) {
		boolean ok = true;
		try {
			int idReserva = dbHelper.GetReservaID();
			int idTaxi = Integer.valueOf((int) spinTaxi.getSelectedItemId());
			dbHelper.updReservaTaxiID(idReserva, idTaxi);
		} catch (Exception ex) {
			ok = false;
			CatchError(ex.toString());
		} finally {
			if (ok) {
				// NotifyEmpAdded();
				Alerts.ShowRegistrarTaxiAlert(this);
				Intent i = new Intent(this, Opciones.class);
				startActivity(i);
				// txtEmps.setText("Numero de Reservas: "+String.valueOf(dbHelper.getReservaCount()));
			}
		}
	}

	public void btnLlamarTaxi_Click(View view) {
		boolean ok = true;
		try {
			int idTaxi = Integer.valueOf((int) spinTaxi.getSelectedItemId());
			call(dbHelper.getTelefonoTaxi(idTaxi));
		} catch (Exception ex) {
			ok = false;
			CatchError(ex.toString());
		} finally {
			if (ok) {

			}
		}
	}

}
