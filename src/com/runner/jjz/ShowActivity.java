package com.runner.jjz;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.runner.jjz.R;

import com.runner.jjz.calendar.CalendarFragment;
import com.runner.jjz.calendar.ToDoItem;
import com.runner.jjz.dboperate.BillDataOperate;
import android.os.Bundle;
import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

public class ShowActivity extends Activity {

	private String tag = "date";
	private BillDataOperate operate;
	private Button dateBtn_now;
	private Button dateBtn_before;
	private ToDoItem toDoItem;
	private String before_date;
	private String now_date;
	private int startid = 0;
	private int endid = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.show);
		Date now = new Date();
		final SimpleDateFormat sfDate = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        
		
		dateBtn_before = (Button) findViewById(R.id.date_before);
		toDoItem = new ToDoItem("");
		toDoItem.set_id(-1);
		toDoItem.setCreateDate(now); // 设置ToDoItem创建时间
			
		// 新建待办事项，将界面中事件时间设置为当前时间
		dateBtn_before.setText(sfDate.format(now));
		toDoItem.setTime(now); // 设置ToDoItem事件时间
		before_date = sfDate.format(toDoItem.getTime()).toString();
		Log.i("sssss", before_date);
		//Log.i("zzzzzzzz",operate.getSmallData(before_date).getDate());
		// 处理事件日期点击事件
		dateBtn_before.setOnClickListener(new OnClickListener() {
     		@Override
     		public void onClick(View v) {
     			DialogFragment calendarFragment = new CalendarFragment(toDoItem.getTime()){
     				
     				@Override
     				public void onDateSet(DatePicker view, int year,
     					int monthOfYear, int dayOfMonth) {
     					super.onDateSet(view, year, monthOfYear, dayOfMonth);
     					toDoItem.setTime(year, monthOfYear, dayOfMonth);
     					Date date = toDoItem.getTime();
     					dateBtn_before.setText(sfDate.format(date));
     					before_date = sfDate.format(date).toString();
     					//startid = operate.getSmallData(before_date).getId();
     					Log.i("vvvvv", before_date);
     				}

     			};
     			calendarFragment.show(getFragmentManager(), "calendarPcker");
     				//Toast.makeText(getApplicationContext(),
     				//		toDoItem.getTime().toString(), Toast.LENGTH_LONG)
     				//		.show();
     		}
     	});
     	
		
     	
        dateBtn_now = (Button) findViewById(R.id.date_now);
		
		toDoItem = new ToDoItem("");
		toDoItem.set_id(-1);
		toDoItem.setCreateDate(now); // 设置ToDoItem创建时间
		
		// 新建待办事项，将界面中事件时间设置为当前时间
		dateBtn_now.setText(sfDate.format(now));
		toDoItem.setTime(now); // 设置ToDoItem事件时间
		now_date = sfDate.format(toDoItem.getTime()).toString();
		//endid = operate.getSmallData(now_date).getId();
        // 处理事件日期点击事件
     	dateBtn_now.setOnClickListener(new OnClickListener() {
     		@Override
     		public void onClick(View v) {
     			DialogFragment calendarFragment = new CalendarFragment(toDoItem.getTime()){
     				
     				@Override
     				public void onDateSet(DatePicker view, int year,
     					int monthOfYear, int dayOfMonth) {
     					super.onDateSet(view, year, monthOfYear, dayOfMonth);
     					toDoItem.setTime(year, monthOfYear, dayOfMonth);
     					Date date = toDoItem.getTime();
     					dateBtn_now.setText(sfDate.format(date));
     					now_date = sfDate.format(date).toString();
     					//endid = operate.getSmallData(now_date).getId();
     					Log.i("vvvvv", now_date);
     				}

     			};
     			calendarFragment.show(getFragmentManager(), "calendarPcker");
     				//Toast.makeText(getApplicationContext(),
     				//		toDoItem.getTime().toString(), Toast.LENGTH_LONG)
     				//		.show();
     		}
     	});
 		
     	
		//显示所查日期消费类型对应的消费明细
		operate = new BillDataOperate(getBaseContext());
		
		//饮食
		
		if(operate.getBigData(startid,endid)==null){
			CharSequence food_detail = "最近无记录";
			TextView food = (TextView) findViewById(R.id.food);
			food.setText(food_detail);
		}
		else{
			float  food_cost= (float) (operate.getBigData(startid,endid).getFood());
			if(food_cost!=0.0f)
			{
				CharSequence food_detail = "            "+"餐饮:"+"  "+food_cost+"¥";
				TextView food = (TextView) findViewById(R.id.food);
				food.setTextSize(40.0f);
				food.setText(food_detail);
			}
			//购物
			float  shop_cost= (float) (operate.getBigData(0,1).getShop());
			if(shop_cost!=0.0f)
			{
				CharSequence shop_detail = "            "+"购物:"+"  "+shop_cost+"¥";
				TextView shop = (TextView) findViewById(R.id.shop);
				shop.setTextSize(40.0f);
				shop.setText(shop_detail);
			}
			//娱乐
			float entertainment_cost= (float) (operate.getBigData(startid,endid).getEntertainment());
			if(entertainment_cost!=0.0f)
			{
				CharSequence entertainment_detail = "            "+"娱乐:"+"  "+entertainment_cost+"¥";
				TextView entertainment = (TextView) findViewById(R.id.entertainment);
				entertainment.setTextSize(40.0f);
				entertainment.setText(entertainment_detail);
			}
			//通讯
			float communication_cost= (float) (operate.getBigData(startid,endid).getCommunication());
			if(communication_cost!=0.0f)
			{
				CharSequence communication_detail = "            "+"通讯:"+"  "+communication_cost+"¥";
				TextView communication = (TextView) findViewById(R.id.communication);
				communication.setTextSize(40.0f);
				communication.setText(communication_detail);
			}
			//学习
			float study_cost= (float) (operate.getBigData(startid,endid).getStudy());
			if(study_cost!=0.0f)
			{
				CharSequence study_detail = "            "+"学习:"+"  "+study_cost+"¥";
				TextView study = (TextView) findViewById(R.id.study);
				study.setTextSize(40.0f);
				study.setText(study_detail);
			}
			//出行
			float travle_cost= (float) (operate.getBigData(startid,endid).getTravle());
			if(travle_cost!=0.0f)
			{
				CharSequence travle_detail = "            "+"出行:"+"  "+travle_cost+"¥";
				TextView travle = (TextView) findViewById(R.id.travle);
				travle.setTextSize(40.0f);
				travle.setText(travle_detail);
			}
			//医疗
			float medicial_cost= (float) (operate.getBigData(startid,endid).getMedicial());
			if(medicial_cost!=0.0f)
			{
				CharSequence medicial_detail = "            "+"医疗:"+"  "+medicial_cost+"¥";
				TextView medicial = (TextView) findViewById(R.id.medicial);
				medicial.setTextSize(40.0f);
				medicial.setText(medicial_detail);
			}
			//其他
			float others_cost= (float) (operate.getBigData(startid,endid).getOthers());
			if(others_cost!=0.0f)
			{
				CharSequence others_detail = "            "+"其他:"+"  "+others_cost+"¥";
				TextView others = (TextView) findViewById(R.id.others);
				others.setTextSize(40.0f);
				others.setText(others_detail);
			}
		}
		Button back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new OnClickListener(){

        	  @Override
        	  public void onClick(View arg0) {
        		  // TODO Auto-generated method stub
        		  back();
        	  }
        	  private void back() {
        		  // TODO Auto-generated method stub
        		  Intent intent = new Intent();
        		  intent.setClass(ShowActivity.this,MainActivity.class);
        		  startActivity(intent);
        		  finish();
        	  }
          });
	}

}
