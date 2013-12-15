package com.example.ts;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class Meaning extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_PROGRESS);
		setContentView(R.layout.mean);
		WebView wv=(WebView)findViewById(R.id.webView1);
		

		 wv.getSettings().setJavaScriptEnabled(true);


		
		String w=getIntent().getStringExtra("wr");
		Toast.makeText(getApplicationContext(), w, Toast.LENGTH_SHORT).show();
		
		wv.setWebChromeClient(new WebChromeClient());
		wv.setWebViewClient(new WebViewClient());
		
		//Uri uri=Uri.parse("www.thefreedictionary.com/dict.aspx?word="+w);
		wv.loadUrl("http://www.thefreedictionary.com/dict.aspx?word="+w);
	}
	

}
