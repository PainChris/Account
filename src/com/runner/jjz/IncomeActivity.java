package com.runner.jjz;

import java.text.SimpleDateFormat;
import java.util.Locale;

import com.runner.jjz.dboperate.BillDataOperate;
import com.runner.jjz.entities.Bill;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class IncomeActivity extends Activity {

	private String date;
	private float rental;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.income);
		
		SimpleDateFormat today = new SimpleDateFormat("yyyy-MM-dd",Locale.CHINA);
		date = today.format(new java.util.Date());
		/*
		 * 获取点击事件，并进行跳转
		 */
		//确认添加
		Button confirm = (Button) findViewById(R.id.income_confirm);
		confirm.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				confirm(rental);
			}

			private void confirm(float rental) {
				// TODO Auto-generated method stub
				BillDataOperate operate = new BillDataOperate(getBaseContext());
				Bill bill = operate.getSmallData(date);
				rental = bill.getRental();
				EditText Emoney = (EditText) findViewById(R.id.editText1);
				rental += Float.parseFloat(Emoney.getText().toString());
				
				operate.putMoney(rental, date);
				Intent intent = new Intent(IncomeActivity.this,MainActivity.class);
				startActivity(intent);
				finish();
			}
			
		});
		//取消添加
		Button cancel = (Button) findViewById(R.id.income_cancel);
		cancel.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				cancel();
			}
			
		});
	}

	protected void cancel() {
		// TODO Auto-generated method stub
		Intent intent = new Intent(IncomeActivity.this,MainActivity.class);
		startActivity(intent);
		finish();
	}
}
