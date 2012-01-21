package com.mycompany;

import android.app.Activity;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Spannable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AddUser extends Activity {

	EditText txtName;
	EditText txtApePat;
	EditText txtApeMat;
	EditText txtCelular;
	EditText txtEmail;
	EditText txtUsuario;
	EditText txtClave;
	TextView txtEmps;
	DatabaseHelper dbHelper;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.adduser);
		txtName = (EditText) findViewById(R.id.txtName);
		txtApePat = (EditText) findViewById(R.id.txtApePat);
		txtApeMat = (EditText) findViewById(R.id.txtApeMat);
		txtCelular = (EditText) findViewById(R.id.txtCelular);
		txtEmail = (EditText) findViewById(R.id.txtEmail);
		txtUsuario = (EditText) findViewById(R.id.txtUsuario);
		txtClave = (EditText) findViewById(R.id.txtClave);
		txtEmps = (TextView) findViewById(R.id.txtEmps);
	}
	
	
	@Override
	public void onStart() {
		try {
			super.onStart();
			dbHelper = new DatabaseHelper(this);
			txtEmps.setText(txtEmps.getText()
					+ String.valueOf(dbHelper.getUserCount()));

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
	
	
	public void btnRegresar_Click(View view) {
		Intent i = new Intent(this, InicioSesion.class);
		startActivity(i);
	}

	public void btnAddUser_Click(View view) {
		boolean ok = true;
		try {
			Spannable spn = txtCelular.getText();
			String name = txtName.getText().toString();
			String apepat = txtApePat.getText().toString();
			String apemat = txtApeMat.getText().toString();
			int celular = Integer.valueOf(spn.toString());
			String email = txtEmail.getText().toString();
			String usuario = txtUsuario.getText().toString();
			String clave = txtClave.getText().toString();
			
			User emp=new User(name,apepat,apemat,celular,email,usuario,clave);
			
			dbHelper.AddUser(emp);

		} catch (Exception ex) {
			ok = false;
			CatchError(ex.toString());
		} finally {
			if (ok) {
				Alerts.ShowUserAddedAlert(this);
			}
		}
	}
	

	
	
	
}
