package com.example.miniprojectver2;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class View1Activity extends Activity implements OnClickListener {
	protected void onCreate(android.os.Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.view1);
		Button viewButton = (Button) findViewById(R.id.fetch_btn);
		viewButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		
		//sending ID to the next page
		//EditText etext = (EditText) findViewById(R.id.et_idno);
		Intent nextIntent = new Intent(this, View2Activity.class);
		nextIntent.putExtra("ID",((EditText) findViewById(R.id.et_idno)).getText().toString());//key value pair
		startActivity(nextIntent);
		
		
		//sending back the result to previous activity
		Intent returnIntent = getIntent();
		setResult(Activity.RESULT_OK, returnIntent);
		finish();

	}

}
