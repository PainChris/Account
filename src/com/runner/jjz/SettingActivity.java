package com.runner.jjz;

import java.text.SimpleDateFormat;

import com.runner.jjz.dboperate.BillDataOperate;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.app.Activity;
import android.content.Intent;


public class SettingActivity extends Activity {

	protected static final String tag = "HHHHH";
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.setting);
		Button confirm = (Button) findViewById(R.id.set);
		confirm.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
		        confirm();
			}
			private void confirm()
		    {
				//��ȡ�����������ֵ
				EditText et =(EditText) findViewById(R.id.Money);
		        String Money = et.getText().toString();
		        float rental = Float.parseFloat(Money);
		        //��ȡ��ǰ�������ֵ��Ϊ����ֵ�������ֵ
		        SimpleDateFormat today = new SimpleDateFormat("yyyy-MM-dd");
				String date = today.format(new java.util.Date());
		    	BillDataOperate operate = new BillDataOperate(getBaseContext());
		    	rental+=operate.getIdandRental().getRental();
		    	//Log.i("hhhhhh",operate.getRental(date)+"");
		    	operate.putMoney(rental,date);
		    	//������ϣ�����������
		    	Intent intent = new Intent(SettingActivity.this,MainActivity.class);
				startActivity(intent);
				finish();
		    }
		});
		
		Button cancel = (Button) findViewById(R.id.not_set);
		cancel.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
		        cancel();
			}
			private void cancel()
			{
				Intent intent = new Intent(SettingActivity.this,MainActivity.class);
				startActivity(intent);
				finish();
			}
		});
		
	}
}
