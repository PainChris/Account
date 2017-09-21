package com.runner.jjz;

import java.text.SimpleDateFormat;

import com.runner.jjz.dboperate.BillDataOperate;
import com.runner.jjz.entities.Bill;

import android.os.Bundle;
import android.util.Log;
import android.view.Window;

import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;

public class GetDetailActivity extends Activity {

	private String remark;
	private int part;
	private String[] money;
	private String[] detailremark;
	private String typename;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.get_detail);
		Intent intent = getIntent();
		int type = Integer.parseInt(intent.getStringExtra("TYPE"));
		SimpleDateFormat today = new SimpleDateFormat("yyyy-MM-dd");
		String date = today.format(new java.util.Date());
		BillDataOperate operate = new BillDataOperate(getBaseContext());
		Bill bill = operate.getSmallData(date);
		
		switch(type)
		{
		case(0): remark=bill.getFremark();typename="����";break;
		case(1): remark=bill.getSremark();typename="����";break;
		case(2): remark=bill.getEremark();typename="����";break;
		case(3): remark=bill.getCremark();typename="ͨѶ";break;
		case(4): remark=bill.getStremark();typename="ѧϰ";break;
		case(5): remark=bill.getTremark();typename="����";break;
		case(6): remark=bill.getMremark();typename="ҽ��";break;
		case(7): remark=bill.getOremark();typename="����";break;
		}
		//��������
		String split[] = remark.split("[$]");
		part = split.length;
		Log.i("ttttttttt", part+"");
	
		detailremark = new String[part-1];
		money = new String[part];
		for(int i=1;i<part;i++)
		{
			detailremark[i-1] = split[i].split("[*][*]")[0];
			money[i-1] = split[i].split("[*][*]")[1];
		}
		
        //��textview��ֵ
        TextView typetv = (TextView) findViewById(R.id.type);
        typetv.setText(typename);
        
        //��ʾ��ϸ
        int i=1;
        if(i<part)
        {
        	TextView detail1 = (TextView) findViewById(R.id.detail1);
            if(money[0]!=" "){
            	detail1.setText(money[0]+"            "+detailremark[0]);
            }
            else
            {
            	detail1.setVisibility(TextView.GONE);
            }
            i++;
        }
    
        if(i<part)
        {
        	TextView detail2 = (TextView) findViewById(R.id.detail2);
            if(money[1]!=" "){
            	detail2.setText(money[1]+"            "+detailremark[1]);
            }
            else
            {
            	detail2.setVisibility(TextView.GONE);
            }
            i++;
        }
        
        if(i<part)
        {
        	TextView detail3 = (TextView) findViewById(R.id.detail3);
            if(money[2]!=" "){
            	detail3.setText(money[2]+"            "+detailremark[2]);
            }
            else
            {
            	detail3.setVisibility(TextView.GONE);
            }
            i++;
        }
        
	}
	
	

}
