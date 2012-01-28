package pe.joedayz.samples;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class InicioSesion extends Activity {

	EditText txtUsuario;
	EditText txtClave;
	DatabaseHelper dbHelper;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.iniciosesion);
		txtUsuario = (EditText) findViewById(R.id.txtUsuario);
		txtClave = (EditText) findViewById(R.id.txtClave);
	}

	@Override
	public void onStart() {
		try {
			super.onStart();
			dbHelper = new DatabaseHelper(this);

		} catch (Exception ex) {
			CatchError(ex.toString());
		}
	}

	void CatchError(String Exception) {
		Dialog diag = new Dialog(this);
		diag.setTitle("Inicio de Sesion");
		TextView txt = new TextView(this);
		txt.setText(Exception);
		diag.setContentView(txt);
		diag.show();
	}

	public void btnRegresar_Click(View view) {
		Intent i = new Intent(this, StartActivity.class);
		startActivity(i);
	}

	public void btnNuevoUsuario_Click(View view) {
		Intent i = new Intent(this, AddUser.class);
		startActivity(i);
	}

	public void btnIniciarSesion_Click(View view) {
		boolean encontro = true;
		String usuario = txtUsuario.getText().toString();
		String clave = txtClave.getText().toString();

		try {
			if (dbHelper.getValidaUsuario(usuario, clave) == 0) {
				encontro = false;
			}
		} catch (Exception ex) {
			encontro = false;
			CatchError(ex.toString());
		} finally {
			if (encontro) {
				SharedPreferences prefs = getSharedPreferences(
						"MisPreferencias", Context.MODE_PRIVATE);
				SharedPreferences.Editor editor = prefs.edit();
				editor.putString("usuario", usuario);
				editor.commit();

				Intent i = new Intent(this, Opciones.class);
				startActivity(i);

			} else {
				Alerts.ShowErrorInicioSesion(this);
			}
		}

	}

}
