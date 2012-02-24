package com.mycompany;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class Inicio extends Activity {
	
	
	
	private static final String HTML_ROOT = "file:///android_asset/www/";
	private static final String VIEW_INTRO = "index.html";

	private Handler handler;
	

	private WebView webView;
	
	
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
		webView = new WebView(this);
		setContentView(webView);

		webView.getSettings().setJavaScriptEnabled(true);
		webView.getSettings().setDomStorageEnabled(true);
		webView.getSettings().setGeolocationEnabled(true);
		webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
		webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
		webView.clearHistory();
		webView.clearCache(true);
		webView.clearFormData();

		final Context myApp = this;


		handler = new Handler();
		webView.addJavascriptInterface(this, "lectorSupport");
		loadPage(VIEW_INTRO);
	}

	public void loadPage(String page)
	{
		final String url = HTML_ROOT + page;
		loadURL(url);
	}

	private void loadURL(final String url)
	{
		handler.post(new Runnable()
		{
			@Override
			public void run()
			{
				webView.loadUrl(url);
			}
		});
	}
}