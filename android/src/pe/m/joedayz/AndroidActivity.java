package pe.m.joedayz;

import java.util.GregorianCalendar;

import android.app.Activity;
import android.os.Bundle;
import com.phonegap.*;

public class AndroidActivity extends DroidGap {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.loadUrl("file:///android_asset/www/jquerymobile/index.html");
    }
}