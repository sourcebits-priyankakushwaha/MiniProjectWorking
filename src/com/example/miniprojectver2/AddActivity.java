package com.example.miniprojectver2;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends Activity implements OnClickListener {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add);
		Button button1 = (Button) findViewById(R.id.submit_btn);
		button1.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {

		ContentValues values = new ContentValues();
		values.put(StudentDetailsProvider.STUD_NAME, ((EditText) findViewById(R.id.et1)).getText().toString());
		//values.put(StudentDetailsProvider.STUD_ID, ((EditText) findViewById(R.id.et2)).getText().toString());
		
		values.put(StudentDetailsProvider.MATHS_MARKS, ((EditText) findViewById(R.id.et3)).getText().toString());
		values.put(StudentDetailsProvider.ENGLISH_MARKS, ((EditText) findViewById(R.id.et4)).getText().toString());
		values.put(StudentDetailsProvider.SCIENCE_MARKS, ((EditText) findViewById(R.id.et5)).getText().toString());
		values.put(StudentDetailsProvider.HISTORY_MARKS, ((EditText) findViewById(R.id.et6)).getText().toString());
		values.put(StudentDetailsProvider.SOCIAL_SCIENCE_MARKS, ((EditText) findViewById(R.id.et7)).getText().toString());
		
		Uri uri = getContentResolver().insert(StudentDetailsProvider.CONTENT_URI, values);
		

		Intent returnIntent = getIntent();
		Bundle resultBundle = new Bundle();
		resultBundle.putString("message", "New row is added");
		returnIntent.putExtras(resultBundle);
		setResult(Activity.RESULT_OK, returnIntent);
		finish();

	}
}
