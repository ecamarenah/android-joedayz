package pe.joedayz.samples;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ImageView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class RankingTaxi extends Activity {
		
	DatabaseHelper dbHelper;
    Spinner spinTaxista;
    ImageView imgTaxista;
    public static int nIdTaxista=0;

    private Integer[] Imgid = {
    		 R.raw.all, R.raw.t1, R.raw.t2, R.raw.t3
    };
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rankingtaxi);
        spinTaxista=(Spinner)findViewById(R.id.spinTaxista);            
    }	
	
	@Override
	public void onStart()
	{
		try
		{
		super.onStart();
		dbHelper=new DatabaseHelper(this);
		
		Cursor c=dbHelper.getAllTaxistas();
		startManagingCursor(c);		
		
		
		//SimpleCursorAdapter ca=new SimpleCursorAdapter(this,android.R.layout.simple_spinner_item, c, new String [] {DatabaseHelper.colDistritoName}, new int []{android.R.id.text1});
		SimpleCursorAdapter ca=new SimpleCursorAdapter(this,R.layout.taxistaspinnerrow, c, new String [] {DatabaseHelper.colTaxiName,"_id"}, new int []{R.id.txtTaxistaName});
		//ca.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinTaxista.setAdapter(ca);
		spinTaxista.setOnItemSelectedListener(new OnItemSelectedListener() {

			//@Override
			public void onItemSelected(AdapterView<?> parent, View selectedView,
					int position, long id) {
				// TODO Auto-generated method stub
				
			}

			//@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		//never close cursor
		}
		catch(Exception ex)
		{
			CatchError(ex.toString());
		}
	}
	
	public void btnRegresar_Click(View view)
	{
		Intent i = new Intent(this, Opciones.class);
        startActivity(i);
	}
	
	public void btnListarTaxi_Click(View view)
	{
		boolean ok=true;
		try
		{
			nIdTaxista = Integer.valueOf((int)spinTaxista.getSelectedItemId());
			imgTaxista = (ImageView)findViewById(R.id.imgvw01);
			
			switch (nIdTaxista) {
			case 1:imgTaxista.setImageResource(Imgid[1]);break;
			case 2:imgTaxista.setImageResource(Imgid[2]);break;
			case 3:imgTaxista.setImageResource(Imgid[3]);break;
			default:imgTaxista.setImageResource(Imgid[0]);break;
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
				//Alerts.ShowEmpAddedAlert(this);
				
				//Intent i = new Intent(this, GridReserva.class);
		        //startActivity(i);
			}
		}
	}
	
	void CatchError(String Exception)
	{
		Dialog diag=new Dialog(this);
		diag.setTitle("Ranking de Taxis");
		TextView txt=new TextView(this);
		txt.setText(Exception);
		diag.setContentView(txt);
		diag.show();
	}	
	
}
