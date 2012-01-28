package pe.joedayz.samples;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
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
	//Spinner spinDept;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adduser);
        txtName=(EditText)findViewById(R.id.txtName);
        txtApePat=(EditText)findViewById(R.id.txtApePat);
        txtApeMat=(EditText)findViewById(R.id.txtApeMat);
        txtCelular=(EditText)findViewById(R.id.txtCelular);
        txtEmail=(EditText)findViewById(R.id.txtEmail);
        txtUsuario=(EditText)findViewById(R.id.txtUsuario);
        txtClave=(EditText)findViewById(R.id.txtClave);
        txtEmps=(TextView)findViewById(R.id.txtEmps);
        //spinDept=(Spinner)findViewById(R.id.spinDept);
    }
	
	@Override
	public void onStart()
	{
		try
		{
		super.onStart();
		dbHelper=new DatabaseHelper(this);
		txtEmps.setText(txtEmps.getText()+String.valueOf(dbHelper.getUserCount()));
		
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
		Intent i = new Intent(this, InicioSesion.class);
        startActivity(i);
	}
	
	public void btnAddUser_Click(View view)
	{
		boolean ok=true;
		try
		{
			Spannable spn=txtCelular.getText();
			String name=txtName.getText().toString();
			String apepat=txtApePat.getText().toString();
			String apemat=txtApeMat.getText().toString();
			int celular=Integer.valueOf(spn.toString());
			String email=txtEmail.getText().toString();
			String usuario=txtUsuario.getText().toString();
			String clave=txtClave.getText().toString();
			//int deptID=Integer.valueOf((int)spinDept.getSelectedItemId());
			User emp=new User(name,apepat,apemat,celular,email,usuario,clave);
			
			dbHelper.AddUser(emp);
			
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
				Alerts.ShowEmpAddedAlert(this);
				//txtEmps.setText("Numero de Usuarios: "+String.valueOf(dbHelper.getUserCount()));
			}
		}
	}
	
	void CatchError(String Exception)
	{
		Dialog diag=new Dialog(this);
		diag.setTitle("Registro de Datos");
		TextView txt=new TextView(this);
		txt.setText(Exception);
		diag.setContentView(txt);
		diag.show();
	}
	
	void NotifyEmpAdded()
	{
		Dialog diag=new Dialog(this);
		diag.setTitle("Registro de Datos");
		TextView txt=new TextView(this);
		txt.setText("Registro realizado con exito");
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
