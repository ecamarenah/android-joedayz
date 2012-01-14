package com.mycompany;

import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TimeMain extends Activity implements OnClickListener {
	
	Button btn;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);
        updateTime();
    }

	private void updateTime() {
		btn.setText(new Date().toString());
		
	}

	@Override
	public void onClick(View v) {
		updateTime();
		
	}
}