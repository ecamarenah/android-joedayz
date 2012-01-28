package pe.joedayz.samples;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class Alerts {
public static void ShowEmpAddedAlert(Context con)
{
	AlertDialog.Builder builder=new AlertDialog.Builder(con);
	builder.setTitle("Registro de Datos");
	builder.setIcon(android.R.drawable.ic_dialog_info);
	DialogListner listner=new DialogListner();
	builder.setMessage("Registro realizado con exito");
	builder.setPositiveButton("ok", listner);
	
	AlertDialog diag=builder.create();
	diag.show();
}

public static void ShowSugAddedAlert(Context con)
{
	AlertDialog.Builder builder=new AlertDialog.Builder(con);
	builder.setTitle("Sugerencias");
	builder.setIcon(android.R.drawable.ic_dialog_info);
	DialogListner listner=new DialogListner();
	builder.setMessage("Envio de sugerencias realizado");
	builder.setPositiveButton("ok", listner);
	
	AlertDialog diag=builder.create();
	diag.show();
}

public static void ShowRegistrarTaxiAlert(Context con)
{
	AlertDialog.Builder builder=new AlertDialog.Builder(con);
	builder.setTitle("Registro de Proveedor de Taxi");
	builder.setIcon(android.R.drawable.ic_dialog_info);
	DialogListner listner=new DialogListner();
	builder.setMessage("Se eligio al proveedor de taxi con exito");
	builder.setPositiveButton("ok", listner);
	
	/*builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
		public void onClick(DialogInterface dialog, int id) {
		// Action for 'Yes' Button
		}
	});*/

	AlertDialog diag=builder.create();
	diag.show();
}

public static void ShowRegistrarReserva(Context con)
{
	AlertDialog.Builder builder=new AlertDialog.Builder(con);
	builder.setTitle("Registro de Reserva");
	builder.setIcon(android.R.drawable.ic_dialog_info);
	DialogListner listner=new DialogListner();
	builder.setMessage("Reserva realizada con exito");
	builder.setPositiveButton("ok", listner);
	
	AlertDialog diag=builder.create();
	diag.show();
}

public static void ShowInicio(Context con)
{
	AlertDialog.Builder builder=new AlertDialog.Builder(con);
	builder.setTitle("Inicio con Exito");
	builder.setIcon(android.R.drawable.ic_dialog_info);
	DialogListner listner=new DialogListner();
	builder.setMessage("Inicio con exito");
	builder.setPositiveButton("ok", listner);
	
	AlertDialog diag=builder.create();
	diag.show();
}

public static void ShowErrorInicioSesion(Context con)
{
	AlertDialog.Builder builder=new AlertDialog.Builder(con);
	builder.setTitle("Inicio de Sesion");
	builder.setIcon(android.R.drawable.ic_dialog_info);
	DialogListner listner=new DialogListner();
	builder.setMessage("Inicio de Sesion fallido");
	builder.setPositiveButton("ok", listner);
	
	AlertDialog diag=builder.create();
	diag.show();
}

public static void ShowCompletarCampos(Context con)
{
	AlertDialog.Builder builder=new AlertDialog.Builder(con);
	builder.setTitle("Advertencia");
	builder.setIcon(android.R.drawable.ic_dialog_info);
	DialogListner listner=new DialogListner();
	builder.setMessage("Debe completar todos los campos");
	builder.setPositiveButton("ok", listner);
	
	AlertDialog diag=builder.create();
	diag.show();
}

public static AlertDialog ShowEditDialog(final Context con,final User emp)
{
	AlertDialog.Builder b=new AlertDialog.Builder(con);
	b.setTitle("User Details");
	LayoutInflater li=LayoutInflater.from(con);
	View v=li.inflate(R.layout.editdialog, null);
	
	b.setIcon(android.R.drawable.ic_input_get);
	
	b.setView(v);
	final TextView txtName=(TextView)v.findViewById(R.id.txtDelName);
	final TextView txtApePat=(TextView)v.findViewById(R.id.txtDelApePat);
	final TextView txtApeMat=(TextView)v.findViewById(R.id.txtDelApeMat);
	final TextView txtCelular=(TextView)v.findViewById(R.id.txtDelCelular);
	final TextView txtEmail=(TextView)v.findViewById(R.id.txtDelEmail);
	/*final Spinner spin=(Spinner)v.findViewById(R.id.spinDiagDept);
	Utilities.ManageDeptSpinner(con, spin);
	for(int i=0;i<spin.getCount();i++)
	{
		long id=spin.getItemIdAtPosition(i);
		if(id==emp.getDept())
		{
			spin.setSelection(i, true);
			break;
		}
	}*/
	
	
	txtName.setText(emp.getName());
	txtApePat.setText(emp.getApePat());
	txtApeMat.setText(emp.getApeMat());
	txtCelular.setText(String.valueOf(emp.getCelular()));
	txtEmail.setText(emp.getEmail());
	
	b.setPositiveButton("Modify", new OnClickListener() {
		
		
		public void onClick(DialogInterface dialog, int which) {
			// TODO Auto-generated method stub
			emp.setName(txtName.getText().toString());
			emp.setApePat(txtApePat.getText().toString());
			emp.setApeMat(txtApeMat.getText().toString());
			emp.setCelular(Integer.valueOf(txtCelular.getText().toString()));
			emp.setEmail(txtEmail.getText().toString());
			//emp.setDept((int)spin.getItemIdAtPosition(spin.getSelectedItemPosition()));
			
			try
			{
			DatabaseHelper db=new DatabaseHelper(con);
			db.UpdateEmp(emp);
			
			}
			catch(Exception ex)
			{
				CatchError(con, ex.toString());
			}
		}
	});
	
	b.setNeutralButton("Delete", new OnClickListener() {
		
		
		public void onClick(DialogInterface dialog, int which) {
			// TODO Auto-generated method stub
			DatabaseHelper db=new DatabaseHelper(con);
			db.DeleteEmp(emp);
		}
	});
	b.setNegativeButton("Cancel", null);
	
	return b.create();
	//diag.show();
	
}

static public void CatchError(Context con, String Exception)
{
	Dialog diag=new Dialog(con);
	diag.setTitle("Error");
	TextView txt=new TextView(con);
	txt.setText(Exception);
	diag.setContentView(txt);
	diag.show();
}


}


