package com.runner.jjz;

import java.text.SimpleDateFormat;
import java.util.Locale;

import com.runner.jjz.dboperate.BillDataOperate;
import com.runner.jjz.entities.Bill;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.app.Activity;
import android.content.Intent;

public class ExpendActivity extends Activity {

	private RadioGroup rg1;
	private RadioGroup rg2;
	private Boolean changeedGroup = false;
	private static final String TAG = "expend";
	private String date= "";
	private float money = 0.0f;
	private String remark ="";
	private int t=0;               //t表示消费类型，0（饮食），1（购物），2（娱乐）....默认为饮食（0）
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.expend);
		//通过使用RadioGruop.OnCheckedChangeListener来处理不同组RadioGroup的互斥逻辑
		rg1 = (RadioGroup) findViewById(R.id.g1);  
		rg1.setOnCheckedChangeListener(new MyRadioGroupOnCheckedChangedListener());   
		rg2 = (RadioGroup) findViewById(R.id.g2);   
		rg2.setOnCheckedChangeListener(new MyRadioGroupOnCheckedChangedListener());   

		/*
		 * 获取点击事件，并进行跳转
		 */
		//添加饮食，t值为0
		RadioButton food = (RadioButton) findViewById(R.id.food);
		food.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				turn0();
			}
			private int turn0() {
				// TODO Auto-generated method stub
				return t=0;
			}
			
		});
		//选择购物，使t值为1
		RadioButton shop = (RadioButton) findViewById(R.id.shop);
		shop.setOnClickListener(new OnClickListener(){

			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				turn1();
			}
			private int turn1() {
				// TODO Auto-generated method stub
				return t=1;
			}
		});
		//添加娱乐，t值为2
		RadioButton entertainment = (RadioButton) findViewById(R.id.entertainment);
		entertainment.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				turn2();
			}
			private int turn2() {
				// TODO Auto-generated method stub
				return t=2;	
			}
		});
		//添加通讯消费，t值为3
		RadioButton communication = (RadioButton) findViewById(R.id.communication);
		communication.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				turn3();
			}
			private int turn3() {
				// TODO Auto-generated method stub
				return t=3;	
			}
		});
		//添加学习消费，t值为4
		RadioButton study = (RadioButton) findViewById(R.id.study);
		study.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				turn4();
			}
			private int turn4() {
				// TODO Auto-generated method stub
				return t=4;	
			}
		});
		//添加出行消费，t值为5
		RadioButton travle = (RadioButton) findViewById(R.id.travle);
		travle.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				turn5();
			}
			private int turn5() {
				// TODO Auto-generated method stub
				return t=5;	
			}
		});
		//添加医疗消费，t值为6
		RadioButton medical = (RadioButton) findViewById(R.id.medical);
		medical.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View v) {
			// TODO Auto-generated method stub
				turn6();
			}
			private int turn6() {
		    // TODO Auto-generated method stub
			    return t=6;	
			}
		});
		//添加其他消费，t值为7
		RadioButton others = (RadioButton) findViewById(R.id.others);
		others.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View v) {
			// TODO Auto-generated method stub
				turn7();
			}
			private int turn7() {
		    // TODO Auto-generated method stub
			    return t=7;	
			}
		});
		SimpleDateFormat today = new SimpleDateFormat("yyyy-MM-dd",Locale.CHINA);
		date = today.format(new java.util.Date());
		//确认添加
		Button confirm = (Button) findViewById(R.id.expend_confirm);
		confirm.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				confirm(date,money,remark,t);
				money = 0.0f;
				remark = "";
			}

			private void confirm(String date,float money, String remark, int t) {
				// TODO Auto-generated method stub
				BillDataOperate operate = new BillDataOperate(getBaseContext());
				Bill bill = operate.getSmallData(date);
				switch(t)
				{
				case(0): money=bill.getFood();remark=bill.getFremark();break;
				case(1): money=bill.getShop();remark=bill.getSremark();break;
				case(2): money=bill.getEntertainment();remark=bill.getEremark();break;
				case(3): money=bill.getCommunication();remark=bill.getCremark();break;
				case(4): money=bill.getStudy();remark=bill.getStremark();break;
				case(5): money=bill.getTravle();remark=bill.getTremark();break;
				case(6): money=bill.getMedicial();remark=bill.getMremark();break;
				case(7): money=bill.getOthers();remark=bill.getOremark();break;
				}
				EditText Emoney = (EditText) findViewById(R.id.MoneyOfExpend);
				money += Float.parseFloat(Emoney.getText().toString());
				Log.i(TAG,remark);
				EditText Eremark = (EditText) findViewById(R.id.RemarkOfExpend);
				remark = remark+"$" + Eremark.getText().toString()+ "**" + Emoney.getText().toString();
				Log.i(TAG, remark);
				
				operate.update(date, money, remark, t);
				Intent intent = new Intent(ExpendActivity.this,MainActivity.class);
				startActivity(intent);
				finish();
			}
			
		});
		
		//取消添加
		Button cancel = (Button) findViewById(R.id.expend_cancel);
		cancel.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				cancel();
			}
			
			private void cancel() {
				// TODO Auto-generated method stub
				Intent intent = new Intent(ExpendActivity.this,MainActivity.class);
				startActivity(intent);
				finish();
			}
		});
	}
	
	public class MyRadioGroupOnCheckedChangedListener implements OnCheckedChangeListener {

		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			// TODO Auto-generated method stub
			if (!changeedGroup)
			{
				changeedGroup = true;   
			    if (group == rg1)
			    {   
			    	 rg2.clearCheck();   
			    } 
			    else if (group == rg2) 
			    {   
			    	rg1.clearCheck();   
			    }
			    changeedGroup = false;  
		    }
	   }
	}
}

