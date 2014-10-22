package com.pcs.swipelistviewactivity;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends SwipeListViewActivity{

	private ListView listView;
	private ArrayAdapter<String> adapter;
	private LayoutInflater layoutInflater;
	private AlertDialog.Builder builder;
	private AlertDialog alertDialog;
	private TextView deleteList_yes;
	private TextView deleteList_no;
	private ArrayList<String> data;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);
		
		
	String[] data = getResources().getStringArray(R.array.name);
	

		 
		
		listView = (ListView)findViewById(R.id.list_view);
		
		
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,data);
		
		listView.setAdapter(adapter);

	}
	
	public void getSwipeItem(boolean isRight,  final int position) {
		
		if(isRight)
		{
			layoutInflater = LayoutInflater.from(MainActivity.this);
			View dialogView = layoutInflater.inflate(R.layout.delete_list_item, null);
			deleteList_yes = (TextView)dialogView.findViewById(R.id.deleteList_yes);
			deleteList_no = (TextView)dialogView.findViewById(R.id.deleteList_No);
			
			builder.setView(dialogView);
			
			deleteList_yes.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					data.remove(position);
					alertDialog.dismiss();
				}
				
			});
			alertDialog = builder.create();
			alertDialog.show();
		}
		else
			
		Toast.makeText(this,"Swipe to " + (isRight ? "right" : "left") + " direction", Toast.LENGTH_SHORT).show();
	}
	
	public void onItemClickListener(ListAdapter adapter,int position)
	{
		Toast.makeText(this, "Single tap on item position " + position,
				Toast.LENGTH_SHORT).show();
	}

	@Override
	public ListView getListView() {
		// TODO Auto-generated method stub
		return listView;
	}
}
