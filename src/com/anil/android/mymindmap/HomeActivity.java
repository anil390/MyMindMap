package com.anil.android.mymindmap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class HomeActivity extends Activity {
	
	
	private String currentShape = "Rectangle";
	private String currentSize = "small";
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}
	
	
	 @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	        // Take appropriate action for each action item click
	        switch (item.getItemId()) {
	
	        case R.id.action_tools:
	        	Intent in = new  Intent(getApplicationContext(),ToolsActivity.class);
	        	startActivityForResult(in, 0);
	           
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	        }
	    }
	
	 @Override
	 protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	     if (resultCode == RESULT_OK) {
	         if (data.hasExtra("shape") && (data.hasExtra("size"))) {
	        	 currentShape = data.getExtras().getString("shape");
	        	 currentSize = data.getExtras().getString("size");
	             Toast.makeText(getApplicationContext(), data.getExtras().getString("shape"),
	                 Toast.LENGTH_SHORT).show();
	         }
	     }
	 }
	

}
