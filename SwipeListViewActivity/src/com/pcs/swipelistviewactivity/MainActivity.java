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
		
		/***
		 *
		 * ArrayList<String> data = new ArrayList<String>();
		data.add(getResources().getString(R.string.heading_dismissable_list_view));
		data.add(object)

		 */
		
		listView = (ListView)findViewById(R.id.list_view);
		
		String[] data = getResources().getStringArray(R.array.name);
		
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,data);
		
		listView.setAdapter(adapter);

	}
	
	public void getSwipeItem(boolean isRight, int position) {
		
		if(isRight)
		{
			
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
