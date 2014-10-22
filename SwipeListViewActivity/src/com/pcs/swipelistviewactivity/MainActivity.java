package com.pcs.swipelistviewactivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends SwipeListViewActivity{

	private ListView listView;
	private ArrayAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);

		listView = (ListView)findViewById(R.id.list_view);

		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
				new String[] {"Item1","Item2","Item3","Item4","Item5"} );
		
		listView.setAdapter(adapter);

	}
	
	public ListView geListView()
	{
		return listView;
		
	}
	
	public void getSwipeItem(boolean isRight, int position) {
	Toast.makeText(this,"Swipe to " + (isRight ? "right" : "left") + " direction", Toast.LENGTH_SHORT).show();
	}
	
	public void onItemClickListener(ListAdapter adapter,int position)
	{
		Toast.makeText(this, "Single tap on item position " + position,
				Toast.LENGTH_SHORT).show();
	}
}
