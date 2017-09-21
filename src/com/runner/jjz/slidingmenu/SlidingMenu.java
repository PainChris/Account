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
	private int mScreenWidth;            //��Ļ���
	
	private int mMenuRightPadding = 50;
	
	private int mMenuWidth;              //�˵����
	private int mHalfMenuWidth; 
	
	private boolean once; 
	
	private boolean isOpen;

	public SlidingMenu(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		//��ȡ��Ļ���
		WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		mScreenWidth = wm.getDefaultDisplay().getWidth();
	}
	
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) 
	{
		if (!once) 
		{
			// ����ָ��λ�õ���ͼ��
			LinearLayout wrapper = (LinearLayout) getChildAt(0); 
			ViewGroup menu = (ViewGroup) wrapper.getChildAt(0);
			ViewGroup content = (ViewGroup) wrapper.getChildAt(1); 
			//��Ҫ�������ı߽� ����dpת��Ϊpx
			mMenuRightPadding = (int) TypedValue.applyDimension( 
					TypedValue.COMPLEX_UNIT_DIP, mMenuRightPadding, content.getResources().getDisplayMetrics()); 
			//�˵����
			mMenuWidth = mScreenWidth - mMenuRightPadding; 
			//һ��˵����
			mHalfMenuWidth = mMenuWidth / 2; 
			//���¼��ؿ��
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
			//���˵�����
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