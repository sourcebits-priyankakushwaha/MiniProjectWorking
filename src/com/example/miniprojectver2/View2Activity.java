package com.example.miniprojectver2;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class View2Activity extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view2);
		TextView name = (TextView) findViewById(R.id.view2_tv1);
		TextView id = (TextView) findViewById(R.id.view2_tv3);
		TextView maths = (TextView) findViewById(R.id.view2_tv5);
		TextView english = (TextView) findViewById(R.id.view2_tv7);
		TextView science = (TextView) findViewById(R.id.view2_tv9);
		TextView history = (TextView) findViewById(R.id.view2_tv11);
		TextView social = (TextView) findViewById(R.id.view2_tv13);

		Bundle extras = getIntent().getExtras();
		String value = null;
		if (extras != null) {
			value = extras.getString("ID");
			Log.i("hi", value);
		}
		ContentResolver resolver = getContentResolver();
		Cursor cursor = resolver.query(StudentDetailsProvider.CONTENT_URI, null, value, null, null);
		if (cursor.moveToFirst()) {
			do {

				String ID = cursor.getString(cursor.getColumnIndex(StudentDetailsProvider.STUD_ID));
				String Name = cursor.getString(cursor.getColumnIndex(StudentDetailsProvider.STUD_NAME));
				String MathsMarks = cursor.getString(cursor.getColumnIndex(StudentDetailsProvider.MATHS_MARKS));
				String EnglishMarks = cursor.getString(cursor.getColumnIndex(StudentDetailsProvider.ENGLISH_MARKS));
				String ScienceMarks = cursor.getString(cursor.getColumnIndex(StudentDetailsProvider.SCIENCE_MARKS));
				String HistoryMarks = cursor.getString(cursor.getColumnIndex(StudentDetailsProvider.HISTORY_MARKS));
				String SocialScienceMarks = cursor.getString(cursor.getColumnIndex(StudentDetailsProvider.SOCIAL_SCIENCE_MARKS));
				name.setText(ID);
				id.setText(Name);
				maths.setText(MathsMarks);
				english.setText(EnglishMarks);
				science.setText(ScienceMarks);
				history.setText(HistoryMarks);
				social.setText(SocialScienceMarks);

			} while (cursor.moveToNext());
		}
	}

}
