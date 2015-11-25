package com.example.miniprojectver2;

import android.app.Activity;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Update2Activity extends Activity implements OnClickListener {

	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.update2);
		Button update2Button = (Button) findViewById(R.id.update2_btn);
		update2Button.setOnClickListener(this);
	}

	public void onClick(View v) {
		ContentValues values = new ContentValues();
		values.put(StudentDetailsProvider.STUD_NAME, ((EditText) findViewById(R.id.et1)).getText().toString());
		// values.put(StudentDetailsProvider.STUD_ID, ((EditText)
		// findViewById(R.id.et2)).getText().toString());

		values.put(StudentDetailsProvider.MATHS_MARKS, ((EditText) findViewById(R.id.et3)).getText().toString());
		values.put(StudentDetailsProvider.ENGLISH_MARKS, ((EditText) findViewById(R.id.et4)).getText().toString());
		values.put(StudentDetailsProvider.SCIENCE_MARKS, ((EditText) findViewById(R.id.et5)).getText().toString());
		values.put(StudentDetailsProvider.HISTORY_MARKS, ((EditText) findViewById(R.id.et6)).getText().toString());
		values.put(StudentDetailsProvider.SOCIAL_SCIENCE_MARKS,
				((EditText) findViewById(R.id.et7)).getText().toString());

		int uri = getContentResolver().update(StudentDetailsProvider.CONTENT_URI, values, null, null);
		Toast.makeText(this, "student table is updated", Toast.LENGTH_SHORT).show();

	}

}
