
package com.example.ts;

import java.util.ArrayList;
import java.util.List;
 
import android.R.string;
import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.TextView.BufferType;
 
public class Sec extends Activity {

 
 EditText metTextHint;
  ListView mlvTextMatches;
Button mbtSpeak;
 private static final int REQUESTCODE_VOICE = 0;
	
	Button show;
 Button cancel;
	private ArrayList al;
	private ArrayList<String> matches;
 @Override
 public void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.sec);
  metTextHint = (EditText) findViewById(R.id.editText1);
 mbtSpeak = (Button) findViewById(R.id.button1);
  Button bt=(Button)findViewById(R.id.button2);
  bt.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String wr=metTextHint.getText().toString();
		Intent it=new Intent(Sec.this,Meaning.class);
		it.putExtra("wr", wr);
		startActivity(it);
	}
});
  
  
  mbtSpeak.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		startVoiceRecognitionActivity();
		PackageManager pm = getPackageManager();
		List<ResolveInfo> activities = pm.queryIntentActivities(new Intent(
				RecognizerIntent.ACTION_RECOGNIZE_SPEECH), 0);
	
	}
});
 }
 @Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		if (requestCode == 10 && resultCode == 20) {
			ArrayList al2 = data.getStringArrayListExtra("ARRAYLIST");
			this.al = al2;
		} 
		// Handle the results from the voice recognition activity.

		if (requestCode == REQUESTCODE_VOICE && resultCode == RESULT_OK) {
			// Populate the wordsList with the String values the recognition
			// engine thought it heard
			matches = data
					.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
			
			if (matches != null) {
				metTextHint.setText(matches.get(0), BufferType.EDITABLE);
				//actv.setText(matches.get(0), BufferType.EDITABLE);
			}
		}
	}
	protected void startVoiceRecognitionActivity() {
		// TODO Auto-generated method stub
		Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
		intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
				RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
		intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
				"Voice recognition Demo...");
		startActivityForResult(intent, REQUESTCODE_VOICE);
	}
 
 }
 

 

