package com.mycompany;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Nosotros extends Activity {

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nosotros);
		
	}

	
	public void btnRegresar_Click(View view) {
		Intent i = new Intent(this, StartActivity.class);
		startActivity(i);
	}
	
	
}
