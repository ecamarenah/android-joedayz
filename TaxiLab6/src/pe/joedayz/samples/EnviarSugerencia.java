package pe.joedayz.samples;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class EnviarSugerencia extends Activity {
	EditText txtEmail;
	EditText txtSugerencias;
	DatabaseHelper dbHelper;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sugerencias);
        txtEmail=(EditText)findViewById(R.id.txtEmail);
        txtSugerencias=(EditText)findViewById(R.id.txtSugerencias);   
    }
	
	@Override
	public void onStart()
	{
		try
		{
		super.onStart();
		dbHelper=new DatabaseHelper(this);
		//never close cursor
		}
		catch(Exception ex)
		{
			CatchError(ex.toString());
		}
	}
	
	public void btnRegresar_Click(View view)
	{
		Intent i = new Intent(this, StartActivity.class);
        startActivity(i);
	}
	
	public void btnEnviar_Click(View view)
	{
		boolean ok=true;
		try
		{
			String email=txtEmail.getText().toString();
			String sugerencia=txtSugerencias.getText().toString();
			Sugerencia sug=new Sugerencia(email,sugerencia);
			
			dbHelper.AddSugerencia(sug);
			
		}
		catch(Exception ex)
		{
			ok=false;
			CatchError(ex.toString());
		}
		finally
		{
			if(ok)
			{
				//NotifyEmpAdded();
				Alerts.ShowSugAddedAlert(this);
				//txtEmps.setText("Numero de Usuarios: "+String.valueOf(dbHelper.getUserCount()));
			}
		}
	}
	
	void CatchError(String Exception)
	{
		Dialog diag=new Dialog(this);
		diag.setTitle("Inicio de Sesion");
		TextView txt=new TextView(this);
		txt.setText(Exception);
		diag.setContentView(txt);
		diag.show();
	}
	
	void NotifyEmpAdded()
	{
		Dialog diag=new Dialog(this);
		diag.setTitle("Inicio de Sesion");
		TextView txt=new TextView(this);
		txt.setText("Inicio de Sesion exitoso");
		diag.setContentView(txt);
		diag.show();
		try {
			diag.wait(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			CatchError(e.toString());
		}
		diag.notify();
		diag.dismiss();
	}
	
}
