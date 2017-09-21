package com.runner.jjz.slidingmenu;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;


public class SlidingMenu extends HorizontalScrollView 
{
	private int mScreenWidth;            //屏幕宽度
	
	private int mMenuRightPadding = 50;
	
	private int mMenuWidth;              //菜单宽度
	private int mHalfMenuWidth; 
	
	private boolean once; 
	
	private boolean isOpen;

	public SlidingMenu(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		//获取屏幕宽度
		WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		mScreenWidth = wm.getDefaultDisplay().getWidth();
	}
	
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) 
	{
		if (!once) 
		{
			// 返回指定位置的视图。
			LinearLayout wrapper = (LinearLayout) getChildAt(0); 
			ViewGroup menu = (ViewGroup) wrapper.getChildAt(0);
			ViewGroup content = (ViewGroup) wrapper.getChildAt(1); 
			//需要留出来的边界 ，将dp转化为px
			mMenuRightPadding = (int) TypedValue.applyDimension( 
					TypedValue.COMPLEX_UNIT_DIP, mMenuRightPadding, content.getResources().getDisplayMetrics()); 
			//菜单宽度
			mMenuWidth = mScreenWidth - mMenuRightPadding; 
			//一半菜单宽度
			mHalfMenuWidth = mMenuWidth / 2; 
			//重新加载宽度
			menu.getLayoutParams().width = mMenuWidth;  
			content.getLayoutParams().width = mScreenWidth;
			once = true;
		}
		super.onMeasure(widthMeasureSpec, heightMeasureSpec); 
		
	}
	
	protected void onLayout(boolean changed, int l, int t, int r, int b) 
	{
		super.onLayout(changed, l, t, r, b); 
		if (changed) 
		{
			//将菜单隐藏
			this.scrollTo(mMenuWidth, 0); 
			once = true;  
		}
		
	}
	
	public boolean onTouchEvent(MotionEvent event)
	{
		int action = event.getAction();  
		switch (action) 
		{case MotionEvent.ACTION_UP:
			int scrollX = getScrollX(); 
			if (scrollX > mHalfMenuWidth) 
			{
				this.smoothScrollTo(mMenuWidth, 0); 
				isOpen = false;
			}
			else
			{
				this.smoothScrollTo(0, 0); 
				isOpen = true;
			}
			return true;
		}
		return super.onTouchEvent(event); 
	}
	
	public boolean isOpen()
	{
		return isOpen;
	}
	
	public void openMenu()
	{
		if(isOpen)
			return;
		this.smoothScrollTo(0, 0);
		isOpen = true;
	}
	
	public void closeMenu()
	{
		if(isOpen)
		{
			this.smoothScrollTo(mMenuWidth, 0);
			isOpen = false;
		}
	}
	
	public void toggle()
	{
		if(isOpen)
		{
			closeMenu();
		}
		else
		{
			openMenu();
		}
	}
}