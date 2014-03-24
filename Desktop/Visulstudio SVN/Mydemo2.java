package com.example.dialogdemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	private Button mybut = null;
	private TextView mych = null;
	private String fruitData[] = new String[]{"Apple","Banana","Watermelon"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        this.mybut = (Button)super.findViewById(R.id.mybut);
        this.mych = (TextView)super.findViewById(R.id.mych);
        this.mybut.setOnClickListener((android.view.View.OnClickListener)new OnClickListenerImpl());
    }
    private class OnClickListenerImpl implements OnClickListener{

		public void onClick(View v) {
			// TODO Auto-generated method stub
			Dialog dialog = new AlertDialog.Builder(MainActivity.this)
    		.setIcon(R.drawable.pic_m)
    		.setTitle("请选择你喜欢吃的水果：")
    		.setNegativeButton("Cancel", 
    				new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog,
								int whichButton) {
						}})
					.setItems(fruitData,
							new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,
								int which){
							MainActivity.this.mych.setText("你选择的水果是："
									+fruitData[which]);
						}
					}).create();
    		dialog.show();
					}
		}
    }
    		
    		
    			
  
   


  
