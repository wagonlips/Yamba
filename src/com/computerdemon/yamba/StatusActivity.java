package com.computerdemon.yamba;

import winterwell.jtwitter.Twitter;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class StatusActivity extends Activity implements OnClickListener {
	private static final String TAG = "StatusActivity";
	EditText editText;
	Button updateButton;
	Twitter twitter;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.status);
        
        // Find views
        editText = (EditText) findViewById(R.id.editText);
        updateButton = (Button) findViewById(R.id.buttonUpdate);
        
        updateButton.setOnClickListener(this);
        
        twitter = new Twitter("student","password");
        twitter.setAPIRootUrl("http://yamba.computerdemon.com/api");
    }
    
    /** Called when button is clicked **/
    public void onClick(View v) {
    	twitter.setStatus(editText.getText().toString());
    	Log.d(TAG,"onClicked");
    }
}