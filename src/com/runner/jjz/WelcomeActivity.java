package com.runner.jjz;

import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.app.Activity;
import android.content.Intent;

public class WelcomeActivity extends Activity {
	private final long SPLASH_LENGTH = 2000;    
	Handler handler = new Handler();  
    public void onCreate(Bundle savedInstanceState) {  
    	super.onCreate(savedInstanceState);  
    	requestWindowFeature(Window.FEATURE_NO_TITLE);
	    setContentView(R.layout.welcome);  
	    handler.postDelayed(new Runnable() {  //ʹ��handler��postDelayedʵ����ʱ��ת  
	    	public void run() {    
	        Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);    
	        startActivity(intent);    
	        finish();       
	        }    
	    }, SPLASH_LENGTH);//2�����ת��Ӧ��������MainActivity  
	}  
}

