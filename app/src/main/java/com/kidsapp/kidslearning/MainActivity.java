package com.kidsapp.kidslearning;

import android.app.Activity;
import android.content.ClipData;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity  
{
	Button drag;
	LinearLayout drop;
	ImageView text,img1, img2,imag3;
	TextView sucess;
	int total , failure = 0;
	public static int istch = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		drag = (Button)findViewById(R.id.one);
		drop = (LinearLayout)findViewById(R.id.bottomlinear);
		text = (ImageView)findViewById(R.id.Total);
		sucess = (TextView)findViewById(R.id.Sucess);
		img1= (ImageView)findViewById(R.id.img_friend1);
		imag3 = (ImageView)findViewById(R.id.drop1);
		img2	= (ImageView)findViewById(R.id.img_friend2);
		drop.setOnDragListener(new View.OnDragListener() {
			@Override
			public boolean onDrag(View v, DragEvent event) {
				// TODO Auto-generated method stub
				final int action = event.getAction();
				switch(action) {
				case DragEvent.ACTION_DRAG_STARTED:
					break;
				case DragEvent.ACTION_DRAG_EXITED:
					break;
				case DragEvent.ACTION_DRAG_ENTERED:
					break;
				case DragEvent.ACTION_DROP:{
					failure = failure+1;
					return(true);
				}
				case DragEvent.ACTION_DRAG_ENDED:{
					total = total +1;
					int suc = total - failure;
					sucess.setVisibility(View.GONE);
					if(istch==1)
					{
						img1.setVisibility(View.GONE);
						imag3.setVisibility(View.VISIBLE);
						istch =0;
					}
					else if (istch==2)
					{
						img2.setVisibility(View.GONE);
						text.setVisibility(View.VISIBLE);
						istch =0;
					}

					//					sucess.setText("Sucessful Drops :"+suc);
					//					text.setText("Total Drops: "+total);
					return(true);
				}
				default:
					break;
				}
				return true;
			}});
		drag.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent arg1) {
				// TODO Auto-generated method stub
				ClipData data = ClipData.newPlainText("", "");
				View.DragShadowBuilder shadow = new View.DragShadowBuilder(drag);
				v.startDrag(data, shadow, null, 0);
				return false;
			}
		});
		img1.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent arg1) {
				// TODO Auto-generated method stub
				istch=1;
				ClipData data = ClipData.newPlainText("", "");
				View.DragShadowBuilder shadow = new View.DragShadowBuilder(img1);
				v.startDrag(data, shadow, null, 0);
				return false;
			}
		});
		img2.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent arg1) {
				// TODO Auto-generated method stub
				istch=2;
				ClipData data = ClipData.newPlainText("", "");
				View.DragShadowBuilder shadow = new View.DragShadowBuilder(img2);
				v.startDrag(data, shadow, null, 0);
				return false;
			}
		});
	}


}
