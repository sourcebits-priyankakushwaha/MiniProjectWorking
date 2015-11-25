package com.example.miniprojectver2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private Button bAdd;
	private Button bDelete;
	private Button bUpdate;
	private Button bView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		bAdd = (Button) findViewById(R.id.btn_add);
		bDelete = (Button) findViewById(R.id.btn_delete);
		bUpdate = (Button) findViewById(R.id.btn_update);
		bView = (Button) findViewById(R.id.btn_view);

		bAdd.setOnClickListener(this);
		bDelete.setOnClickListener(this);
		bUpdate.setOnClickListener(this);
		bView.setOnClickListener(this);
	}

	public void onClick(View view) {
		if (view == bAdd) {

			Intent addIntent = new Intent(this, AddActivity.class);
			startActivityForResult(addIntent, 0);

		}

		if (view == bDelete) {
			Intent deleteIntent = new Intent(this, DeleteActivity.class);
			startActivityForResult(deleteIntent, 1);
		}
		if (view == bUpdate) {
			Intent updateIntent = new Intent(this, Update1Activity.class);
			startActivityForResult(updateIntent, 2);

		}
		if (view == bView) {
			Intent viewIntent = new Intent(this, View1Activity.class);
			startActivityForResult(viewIntent, 3);

		}

	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (requestCode == 0) {

			if (resultCode == Activity.RESULT_OK) {

				Bundle bundle = data.getExtras();
				String name = bundle.getString("message");
				Toast.makeText(MainActivity.this, name, Toast.LENGTH_LONG).show();
			}

		} else if (requestCode == 1) {
			if (resultCode == Activity.RESULT_OK) {


				Bundle bundle = data.getExtras();
				String name = bundle.getString("message");
				Toast.makeText(MainActivity.this, name, Toast.LENGTH_LONG).show();
			}

		} else if (requestCode == 2) {
			if (resultCode == Activity.RESULT_OK) {

			}

		} else if (requestCode == 3) {
			if (resultCode == Activity.RESULT_OK) {

			}

		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
