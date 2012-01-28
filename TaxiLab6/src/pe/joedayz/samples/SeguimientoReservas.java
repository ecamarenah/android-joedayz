package pe.joedayz.samples;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;



public class SeguimientoReservas extends Activity {
	DatabaseHelper dbHelper;
	
	//CheckERUtils utils;
	//CheckERData data;
	SQLiteDatabase db;
	Cursor rs;
	String sql;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.seguimiento);

        TableLayout reporte=(TableLayout)findViewById(R.id.tableLayoutCajaReport);
        reporte.removeAllViews();
        TableRow oper;
        int c=0; double tt_d=0; double tt_h=0; double tt_s=0;
        TextView nro; 
        TextView empresa; 
        TextView origen; 
        TextView destino; 
        TextView fecha;
        TextView estado;
        
        
       //data=new CheckERData(this);
        //db=data.getReadableDatabase();
       // utils=new CheckERUtils(this);
        
        dbHelper=new DatabaseHelper(this);
        Cursor cu=dbHelper.getReservas();
		startManagingCursor(cu);
        
		// SQLiteDatabase db=this.getReadableDatabase();
		 //String sSql="SELECT * from Reserva; ";
		 //sSql+=" order by 1 desc ";
		
		 //sql="select _id, grupo, strftime('%d %H:%M', fecha) as fecha, detalle, debe, haber, saldo from caja WHERE fecha >= datetime('"+(utils.getFecha("yyyy-MM")+"-01 00:00:00")+"') ORDER BY _id ASC;";
	      //rs=db.rawQuery(sSql, null);
		
				
		//if (rs.moveToNext()) {
		     //Recorremos el cursor hasta que no haya más registros
			while(cu.moveToNext()) {
		    	 c++;
/*		          String colReservaUserID 		= cu.getString(0);
		          String colDistritoOrigen 		= cu.getString(1);
		          String colDireccionOrigen 	= cu.getString(2);
		          String colDistritoDestino 	= cu.getString(3);
		          String colDireccionDestino	= cu.getString(4);
		          String colEmailAlterno 		= cu.getString(5);
		          String colObservaciones 		= cu.getString(6);
		          String colFechaReserva 		= cu.getString(7);
		          String colHoraReserva 		= cu.getString(8);
		          String colEstadoReserva 		= cu.getString(9);*/

		          
		          
		          if(c==1){
		            	oper=new TableRow(this);
		            	nro=new TextView(this);
			            	nro.setText("Nro.");
			            	nro.setTextSize(10);
			            	nro.setTextColor(Color.parseColor("#505050"));
			            	nro.setBackgroundColor(Color.parseColor("#CEEBFF"));
		        		empresa=new TextView(this);
			        		empresa.setText("Empresa");
			        		empresa.setTextSize(10);
			        		empresa.setTextColor(Color.parseColor("#505050"));
			        		empresa.setWidth(50);
			        		empresa.setBackgroundColor(Color.parseColor("#CEEBFF"));
		    			origen=new TextView(this);
			    			origen.setText("Origen");
			    			origen.setTextSize(10);
			    			origen.setTextColor(Color.parseColor("#505050"));
			    			origen.setWidth(50);
			    			origen.setBackgroundColor(Color.parseColor("#CEEBFF"));
		    			destino=new TextView(this);
			    			destino.setText("Destino");
			    			destino.setTextSize(10);
			    			destino.setTextColor(Color.parseColor("#505050"));
			    			destino.setWidth(50);
			    			destino.setBackgroundColor(Color.parseColor("#CEEBFF"));
		    			fecha=new TextView(this);
			    			fecha.setText("Fecha-hora");
			    			fecha.setTextSize(10);
			    			fecha.setTextColor(Color.parseColor("#505050"));
			    			fecha.setWidth(80);
			    			fecha.setBackgroundColor(Color.parseColor("#CEEBFF"));
		    			estado=new TextView(this);
			    			estado.setText("Estado");
			    			estado.setTextSize(10);
			    			estado.setTextColor(Color.parseColor("#505050"));
			    			estado.setWidth(50);
			    			estado.setBackgroundColor(Color.parseColor("#CEEBFF"));

		        		oper.addView(nro);
		        		oper.addView(empresa);
		        		oper.addView(origen);
		        		oper.addView(destino);
		        		oper.addView(fecha);
		        		oper.addView(estado);
		        		
		            	reporte.addView(oper);
		        	}
		        	oper=new TableRow(this);
		        	nro=new TextView(this);
		        		nro.setText(cu.getString(0));
		        		nro.setTextColor(Color.YELLOW);
		        		nro.setTextSize(9);
		        	empresa=new TextView(this);
		    			empresa.setText("");
		    			empresa.setTextSize(9);
		    			empresa.setWidth(50);
		    		origen=new TextView(this);
						origen.setText(cu.getString(2) + "\n-" + cu.getString(3));
						origen.setTextSize(9);
						origen.setWidth(50);
					destino=new TextView(this);
						destino.setText(cu.getString(4) + "-" + cu.getString(5));
						destino.setTextSize(9);
						destino.setWidth(50);
					fecha=new TextView(this);
						fecha.setText(cu.getString(8) + "-" + cu.getString(9));
						fecha.setTextSize(9);
						fecha.setWidth(50);
					estado=new TextView(this);
						estado.setText(cu.getString(10));
						estado.setTextSize(9);
						estado.setWidth(30);
		    		
						
					oper.addView(nro);
		    		oper.addView(empresa);
		    		oper.addView(origen);
		    		oper.addView(destino);
		    		oper.addView(fecha);
		    		oper.addView(estado);
		        	reporte.addView(oper);

		          
		     } 
/*		     
		     oper=new TableRow(this);
		    	fecha=new TextView(this);
		    		fecha.setText("");
				detalle=new TextView(this);
					detalle.setText(" TOTALES ");
					detalle.setTextSize(12);
				ingreso=new TextView(this);
					ingreso.setText(""+tt_d);
					ingreso.setTextSize(12);
					ingreso.setTextColor(Color.parseColor("#505050"));
					ingreso.setBackgroundColor(Color.parseColor("#3FFF7D"));
				salida=new TextView(this);
					salida.setText(""+tt_h);
					salida.setTextSize(12);
					salida.setTextColor(Color.parseColor("#505050"));
					salida.setWidth(55);
					salida.setBackgroundColor(Color.parseColor("#FFBCCB"));
				saldo=new TextView(this);
					saldo.setText(""+tt_s);
					saldo.setTextSize(12);
					saldo.setTextColor(Color.parseColor("#505050"));
					saldo.setBackgroundColor(Color.parseColor("#83EAFF"));

				oper.addView(fecha);
				oper.addView(detalle);
				oper.addView(ingreso);
				oper.addView(salida);
				oper.addView(saldo);
		    	reporte.addView(oper);*/
		//}

    	
    }
	
	
	   public void btnRegresar_Click(View view)
		{
	       
			Intent i = new Intent(this, Opciones.class);
	        startActivity(i);
		}

}
