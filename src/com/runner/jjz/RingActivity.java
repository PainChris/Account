package com.runner.jjz;

import java.text.SimpleDateFormat;

import com.runner.jjz.dboperate.BillDataOperate;
import com.runner.jjz.entities.Bill;
import com.runner.jjz.view.RingView;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class RingActivity extends Activity {

	private int width;
	private int height;
	private Bill bill;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.ring);
		//获取屏幕宽度和高度
		WindowManager wm = (WindowManager)getSystemService(Context.WINDOW_SERVICE);
		width = wm.getDefaultDisplay().getWidth();
		height = wm.getDefaultDisplay().getHeight();
		//获取当前日期的消费数据
		SimpleDateFormat today = new SimpleDateFormat("yyyy-MM-dd");
        String date = today.format(new java.util.Date());
        BillDataOperate operate = new BillDataOperate(getBaseContext());
        bill = operate.getSmallData(date);
        //设置属性，绘制环状图
        init(bill);
        
        //判断有无数据，若有则为显示button
        //饮食
        Button food = (Button) findViewById(R.id.food);
        //没有数据不显示且不占用布局
        if(bill.getFood()==0.0f)
        {
        	//判断有无数据，若有则为显示button
        	food.setVisibility(Button.GONE);
        }
        float p = bill.getFood()/bill.getSumcost()*100;
        
        CharSequence foodt ="餐饮:"+bill.getFood()+"¥"+"                                                                   "+p+"%";
		food.setText(foodt);
		
		//监听点击事件，进行跳转
		food.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				showFood();
			}
			private void showFood() {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.putExtra("TYPE", "0");
				intent.setClass(RingActivity.this,GetDetailActivity.class);
				startActivity(intent);
				finish();
			}
		});
		
		//购物
		Button shop = (Button) findViewById(R.id.shop);
        //没有数据不显示且不占用布局
        if(bill.getShop()==0.0f)
        {
        	shop.setVisibility(Button.GONE);
        }
        p = bill.getShop()/bill.getSumcost()*100;
        
        CharSequence shopt ="购物:"+bill.getShop()+"¥"+"                                                                   "+p+"%";
		shop.setText(shopt);
		
		//监听点击事件，进行跳转
		shop.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				showShop();
			}
			private void showShop() {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.putExtra("TYPE", "1");
				intent.setClass(RingActivity.this,GetDetailActivity.class);
				startActivity(intent);
				finish();
			}
		});
				
				
		//娱乐
		Button entertainment = (Button) findViewById(R.id.entertainment);
        //没有数据不显示且不占用布局
        if(bill.getEntertainment()==0.0f)
        {
        	entertainment.setVisibility(Button.GONE);
        }
        p = bill.getEntertainment()/bill.getSumcost()*100;
        
        CharSequence entertainmentt ="娱乐:"+bill.getEntertainment()+"¥"+"                                                                   "+p+"%";
        entertainment.setText(entertainmentt);
		
        
        //监听点击事件，进行跳转
        entertainment.setOnClickListener(new OnClickListener(){

      	  @Override
      	  public void onClick(View arg0) {
      		  // TODO Auto-generated method stub
      		  showEntertainment();
      	  }
      	  private void showEntertainment() {
      		  // TODO Auto-generated method stub
      		  Intent intent = new Intent();
      		  intent.putExtra("TYPE", "2");
      		  intent.setClass(RingActivity.this,GetDetailActivity.class);
      		  startActivity(intent);
      		  finish();
      	  }
        });
      		
		//通讯
		Button communication = (Button) findViewById(R.id.communication);
        //没有数据不显示且不占用布局
        if(bill.getCommunication()==0.0f)
        {
        	communication.setVisibility(Button.GONE);
        }
        p = bill.getCommunication()/bill.getSumcost()*100;
        
        CharSequence communicationt ="通讯:"+bill.getCommunication()+"¥"+"                                                                   "+p+"%";
        communication.setText(communicationt);
		
        //监听点击事件，进行跳转
        communication.setOnClickListener(new OnClickListener(){

      	  @Override
      	  public void onClick(View arg0) {
      		  // TODO Auto-generated method stub
      		  showCommunication();
      	  }
      	  private void showCommunication() {
      		  // TODO Auto-generated method stub
      		  Intent intent = new Intent();
      		  intent.putExtra("TYPE", "3");
      		  intent.setClass(RingActivity.this,GetDetailActivity.class);
      		  startActivity(intent);
      		  finish();
      	  }
        });
        
		//学习
		Button study = (Button) findViewById(R.id.study);
        //没有数据不显示且不占用布局
        if(bill.getStudy()==0.0f)
        {
        	study.setVisibility(Button.GONE);
        }
        p = bill.getStudy()/bill.getSumcost()*100;
        
        CharSequence studyt ="学习:"+bill.getStudy()+"¥"+"                                                                   "+p+"%";
		study.setText(studyt);
		
		//监听点击事件，进行跳转
        study.setOnClickListener(new OnClickListener(){

      	  @Override
      	  public void onClick(View arg0) {
      		  // TODO Auto-generated method stub
      		  showStudy();
      	  }
      	  private void showStudy() {
      		  // TODO Auto-generated method stub
      		  Intent intent = new Intent();
      		  intent.putExtra("TYPE", "4");
      		  intent.setClass(RingActivity.this,GetDetailActivity.class);
      		  startActivity(intent);
      		  finish();
      	  }
        });
        
        
		//出行
		Button travle = (Button) findViewById(R.id.travle);
        //没有数据不显示且不占用布局
        if(bill.getTravle()==0.0f)
        {
        	travle.setVisibility(Button.GONE);
        }
        p = bill.getTravle()/bill.getSumcost()*100;
        
        CharSequence travlet ="出行:"+bill.getTravle()+"¥"+"                                                                   "+p+"%";
        travle.setText(travlet);
        
        //监听点击事件，进行跳转
        travle.setOnClickListener(new OnClickListener(){

      	  @Override
      	  public void onClick(View arg0) {
      		  // TODO Auto-generated method stub
      		  showTravle();
      	  }
      	  private void showTravle() {
      		  // TODO Auto-generated method stub
      		  Intent intent = new Intent();
      		  intent.putExtra("TYPE", "5");
      		  intent.setClass(RingActivity.this,GetDetailActivity.class);
      		  startActivity(intent);
      		  finish();
      	  }
        });
        
        //医疗
        Button medicial = (Button) findViewById(R.id.medicial);
        //没有数据不显示且不占用布局
        if(bill.getMedicial()==0.0f)
        {
        	medicial.setVisibility(Button.GONE);
        }
        p = bill.getMedicial()/bill.getSumcost()*100;
        
        CharSequence medicialt ="医疗:"+bill.getMedicial()+"¥"+"                                                                   "+p+"%";
        medicial.setText(medicialt);
        
        //监听点击事件，进行跳转
        medicial.setOnClickListener(new OnClickListener(){

      	  @Override
      	  public void onClick(View arg0) {
      		  // TODO Auto-generated method stub
      		  showMedicial();
      	  }
      	  private void showMedicial() {
      		  // TODO Auto-generated method stub
      		  Intent intent = new Intent();
      		  intent.putExtra("TYPE", "6");
      		  intent.setClass(RingActivity.this,GetDetailActivity.class);
      		  startActivity(intent);
      		  finish();
      	  }
        });
        
        //其他
        Button others = (Button) findViewById(R.id.others);
        //没有数据不显示且不占用布局
        if(bill.getOthers()==0.0f)
        {
        	others.setVisibility(Button.GONE);
        }
        p = bill.getOthers()/bill.getSumcost()*100;
        
        CharSequence otherst ="其他:"+bill.getOthers()+"¥"+"                                                                   "+p+"%";
        others.setText(otherst);
        
        //监听点击事件，进行跳转
        others.setOnClickListener(new OnClickListener(){

      	  @Override
      	  public void onClick(View arg0) {
      		  // TODO Auto-generated method stub
      		  showOthers();
      	  }
      	  private void showOthers() {
      		  // TODO Auto-generated method stub
      		  Intent intent = new Intent();
      		  intent.putExtra("TYPE", "7");
      		  intent.setClass(RingActivity.this,GetDetailActivity.class);
      		  startActivity(intent);
      		  finish();
      	  }
        });
        
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
        		  intent.setClass(RingActivity.this,MainActivity.class);
        		  startActivity(intent);
        		  finish();
        	  }
          });
	}
	
	//绘制环状图
	private void init(Bill bill) {
		// TODO Auto-generated method stub
		LinearLayout layout=(LinearLayout) findViewById(R.id.root);  
        final RingView view = new RingView(this);
        view.setMinimumHeight(height);  
        view.setMinimumWidth(width);
        view.setBill(bill);
       //通知view组件重绘      
        view.invalidate();
        layout.addView(view);
	}
	
	
}
