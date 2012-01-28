package pe.joedayz.samples;


import android.content.Context;
import android.database.Cursor;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;

public class Utilities {
static public void ManageDistritoSpinner(Context context,Spinner view)
{
	DatabaseHelper dbHelper=new DatabaseHelper(context);
	Cursor c=dbHelper.getAllDistritos();
	//context.startManagingCursor(c);
	
	
	
	//SimpleCursorAdapter ca=new SimpleCursorAdapter(this,android.R.layout.simple_spinner_item, c, new String [] {DatabaseHelper.colDistritoName}, new int []{android.R.id.text1});
	SimpleCursorAdapter ca=new SimpleCursorAdapter(context,R.layout.distritospinnerrow, c, new String [] {DatabaseHelper.colDistritoName,"_id"}, new int []{R.id.txtDistritoName});
	view.setAdapter(ca);
	
}
}
