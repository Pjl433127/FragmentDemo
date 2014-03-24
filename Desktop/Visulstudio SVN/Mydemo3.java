package com.example.gridviewdemo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity {
	private ImageView img = null;
	private GridView myGridView = null;
	private SimpleAdapter simpleadpter = null;
	private List<Map<String,Integer>>list = new ArrayList<Map<String,Integer>>();
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_main);
		this.img = (ImageView)super.findViewById(R.id.img);
		this.myGridView = (GridView)super.findViewById(R.id.myGridView);
		this.initAdapter();
		this.myGridView.setAdapter(this.simpleadpter);
		this.myGridView.setOnItemClickListener(new OnItemClickListenerImpl());
	}
	private class  OnItemClickListenerImpl implements  OnItemClickListener{

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			ImageView showImg = new ImageView(MainActivity.this);
			showImg.setScaleType(ImageView.ScaleType.CENTER);
			showImg.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
			Map<String,Integer> map= (Map<String,Integer>)MainActivity.this.simpleadpter.getItem(position);
			showImg.setImageResource(map.get("img"));
			Dialog dialog = new AlertDialog.Builder(MainActivity.this)
			.setIcon(R.drawable.pic_m)
			.setTitle("²é¿´Í¼Æ¬")
			.setView(showImg)
			.setNegativeButton("¹Ø±Õ",new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int whichButton) {
					
				}}).create();
			dialog.show();
			
		}
		
	}

	private void initAdapter(){
		Field[] fields = R.drawable.class.getDeclaredFields();
		for(int x = 0;x<fields.length;x++){
			if(fields[x].getName().startsWith("png_")){
				Map<String,Integer> map= new HashMap<String,Integer>();
				try{
					map.put("img",fields[x].getInt(R.drawable.class));
				}catch(Exception e){
					
				}
				this.list.add(map);
			}
		}
		this.simpleadpter = new SimpleAdapter(this,
				this.list,
				R.layout.grid_layout,
				new String[]{"img"},
				new int[]{R.id.img});
	}
}
