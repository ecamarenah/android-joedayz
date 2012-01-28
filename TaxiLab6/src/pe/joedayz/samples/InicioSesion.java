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
        txtUsuario=(EditText)findViewById(R.id.txtUsuario);
        txtClave=(EditText)findViewById(R.id.txtClave);   
    }
	
	@Override
	public void onStart()
	{
		try
		{
		super.onStart();
		dbHelper=new DatabaseHelper(this);
		//txtEmps.setText(txtEmps.getText()+String.valueOf(dbHelper.getUserCount()));
		
		/*Cursor c=dbHelper.getAllDepts();
		startManagingCursor(c);
		
		
		
		//SimpleCursorAdapter ca=new SimpleCursorAdapter(this,android.R.layout.simple_spinner_item, c, new String [] {DatabaseHelper.colDeptName}, new int []{android.R.id.text1});
		SimpleCursorAdapter ca=new SimpleCursorAdapter(this,R.layout.deptspinnerrow, c, new String [] {DatabaseHelper.colDeptName,"_id"}, new int []{R.id.txtDeptName});
		//ca.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinDept.setAdapter(ca);
		spinDept.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View selectedView,
					int position, long id) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});*/
		
		
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
	
	public void btnNuevoUsuario_Click(View view)
	{
		Intent i = new Intent(this, AddUser.class);
        startActivity(i);
	}
	
	public void btnIniciarSesion_Click(View view)
	{
		boolean ok=true;
		String usuario=txtUsuario.getText().toString();
		String clave=txtClave.getText().toString();
		
		
			try
			{
				if(dbHelper.getValidaUsuario(usuario,clave)==0)
				{
					ok=false;
				}			
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
					//Alerts.ShowInicio(this);
					SharedPreferences prefs=getSharedPreferences("MisPreferencias",Context.MODE_PRIVATE);   
			        SharedPreferences.Editor editor = prefs.edit(); 
			        editor.putString("usuario",usuario); 
			        editor.commit();
					Intent i = new Intent(this, Opciones.class);
			        startActivity(i);
					//txtEmps.setText("Numero de Usuarios: "+String.valueOf(dbHelper.getUserCount()));
				}else{
					Alerts.ShowErrorInicioSesion(this);
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
