package com.example.miniprojectver2;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class DeleteActivity extends Activity implements OnClickListener {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.delete);
		Button deleteButton = (Button) findViewById(R.id.delete_btn);
		deleteButton.setOnClickListener(this);
		//EditText deleteEditText = (EditText)findViewById(R.id.et_idDelete);
	}

	@Override
	public void onClick(View v) {
		ContentResolver resolver = getContentResolver();
		resolver.delete(StudentDetailsProvider.CONTENT_URI,((EditText) findViewById(R.id.et_idDelete)).getText().toString(), null);
		Intent returnIntent = getIntent();
		Bundle resultBundle = new Bundle();
		resultBundle.putString("message", "Row is deleted");
		returnIntent.putExtras(resultBundle);
		setResult(Activity.RESULT_OK, returnIntent);
		finish();

	}
}
