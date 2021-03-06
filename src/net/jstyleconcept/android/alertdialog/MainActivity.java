package net.jstyleconcept.android.alertdialog;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	private Button button1,button2,button3;
	private int singleChoiceItemsIndex;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_mainactivity);
		button1=(Button)findViewById(R.id.button1);
		button2=(Button)findViewById(R.id.button2);
		button3=(Button)findViewById(R.id.button3);
		singleChoiceItemsIndex=0;
		button1.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View v) {
				new AlertDialog.Builder(MainActivity.this)
					.setTitle("Alert Dialog 1")
					.setMessage("This is Alert Dialog 1")
					.setNeutralButton(getResources().getString(R.string.ok),new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog,int which) {
							
						}
					}).show();
			}
		});
		button2.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View v) {
				new AlertDialog.Builder(MainActivity.this)
					.setTitle("Alert Dialog 2")
					.setItems(R.array.dialogstrarry,new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog,int which) {
							String[] itemArray=getResources().getStringArray(R.array.dialogstrarry);
							new AlertDialog.Builder(MainActivity.this)
								.setMessage(itemArray[which])
								.setNeutralButton(getResources().getString(R.string.ok),new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,int which) {
										
									}
									
								}).show();
						}	
					}).show();
			}	
		});
		button3.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View v) {

				new AlertDialog.Builder(MainActivity.this)
					.setTitle("Dialog 3")
					.setSingleChoiceItems(R.array.dialogstrarry,0,new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog,int which) {
							singleChoiceItemsIndex=which;
						}
					})
					.setPositiveButton(getResources().getString(R.string.ok),new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog,int which) {
							String[] itemArray=getResources().getStringArray(R.array.dialogstrarry);
							new AlertDialog.Builder(MainActivity.this)
								.setMessage(itemArray[singleChoiceItemsIndex])
								.setPositiveButton(getResources().getString(R.string.ok),new DialogInterface.OnClickListener() {
									
									@Override
									public void onClick(DialogInterface dialog,int which) {
										
									}
								}).show();
						}
					})
					.setNegativeButton(getResources().getString(R.string.cancel),new DialogInterface.OnClickListener() {
									
						@Override
						public void onClick(DialogInterface dialog,int which) {
							
						}
					}).show();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.layout_mainactivity,menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent intent=new Intent(MainActivity.this,SourceCodeActivity.class);
		switch(item.getOrder()) {
			case 0:
				startActivity(intent);
				break;
			case 1:
				finish();
				break;
		}
		return super.onOptionsItemSelected(item);
	}
}
