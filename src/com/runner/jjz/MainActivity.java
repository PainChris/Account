package com.runner.jjz;

import java.text.SimpleDateFormat;

import com.runner.jjz.db.BillDataSQLiteOpenHelper;
import com.runner.jjz.dboperate.BillDataOperate;
import com.runner.jjz.entities.Bill;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;




public class MainActivity extends Activity {

	private float rental = 0.0f;
	private int id = 0;
	private String date;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
		setContentView(R.layout.activity_main);
		
		//获取当前日期
		SimpleDateFormat today = new SimpleDateFormat("yyyy-MM-dd");
		date = today.format(new java.util.Date());
		String tag="tttttttt";
		Log.i(tag, date);
		//初始化数据库操作类
		//BillDataSQLiteOpenHelper openHelper = new BillDataSQLiteOpenHelper(getBaseContext());
		//openHelper.getReadableDatabase();
		BillDataOperate operate = new BillDataOperate(getBaseContext());
		//operate.delete("2016-06-15");
		//operate.delete("2016-06-16");
		//operate.insert(new Bill(1,"2016-06-16", 4.0f, "bbbb",0.0f,"",0.0f, "",
		//		0.0f, "", 0.0f, "",0.0f, "", 0.0f, "",0.0f, "",0.0f));
		//获取当前余额
		//查询今日是否记账，如果没有则插入一条仅包含当前余额的空数据
		if(operate.getSmallData(date)==null){
			if(operate.getIdandRental()!=null)
			{
				id = operate.getIdandRental().getId()+1;
			    rental = operate.getIdandRental().getRental();
			}
			operate.insert(new Bill(id,date,rental));
		}
		//设置主界面余额显示
		if(operate.getIdandRental()!=null)
		{
		    rental = operate.getIdandRental().getRental();
		}
		float bal =rental-operate.getSmallData(date).getSumcost();
		CharSequence text = bal+"¥";
		System.out.print(text);
		TextView balance = (TextView) findViewById(R.id.balance);
		balance.setTextSize(50.0f);
		balance.setText(text);
		/*
		 * 获取点击事件，并进行相应跳转
		 */
		//添加跳转
		Button add = (Button) findViewById(R.id.add);
		add.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				add();
			}
		});
		//查询跳转
		Button inquire = (Button) findViewById(R.id.inquire);
		inquire.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				inquire();
			}
		});
		//扇形图查看
		Button rental = (Button) findViewById(R.id.rental);
		rental.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				rental();
			}
		});
		
		Button setMoney = (Button) findViewById(R.id.setMoney);
		setMoney.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				setMoney();
			}
		});
	}

	protected void setMoney() {
		// TODO Auto-generated method stub
		Intent intent = new Intent(MainActivity.this,SettingActivity.class);
		startActivity(intent);
		
	}

	protected void rental() {
		// TODO Auto-generated method stub
		Intent intent = new Intent(MainActivity.this,RingActivity.class);
		startActivity(intent);
		finish();
	}

	protected void add() {
		// TODO Auto-generated method stub
		Intent intent = new Intent(MainActivity.this,SelectSort.class);
		startActivity(intent);
		finish();
	}
	
	protected void inquire() {
		// TODO Auto-generated method stub
		Intent intent = new Intent(MainActivity.this,ShowActivity.class);
		startActivity(intent);
		finish();
	}
}
