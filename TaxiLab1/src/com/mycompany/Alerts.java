package com.mycompany;

import android.app.AlertDialog;
import android.content.Context;

public class Alerts {

	public static void ShowErrorInicioSesion(Context con) {
		AlertDialog.Builder builder = new AlertDialog.Builder(con);
		builder.setTitle("Inicio de Sesion");
		builder.setIcon(android.R.drawable.ic_dialog_info);
		
		DialogListener listner = new DialogListener();
		builder.setMessage("Inicio de Sesion fallido");
		builder.setPositiveButton("ok", listner);

		AlertDialog diag = builder.create();
		diag.show();
	}
	
	public static void ShowUserAddedAlert(Context con)
	{
		AlertDialog.Builder builder=new AlertDialog.Builder(con);
		builder.setTitle("Registro de Datos");
		builder.setIcon(android.R.drawable.ic_dialog_info);
		DialogListener listner=new DialogListener();
		builder.setMessage("Registro realizado con exito");
		builder.setPositiveButton("ok", listner);
		
		AlertDialog diag=builder.create();
		diag.show();
	}	
}
