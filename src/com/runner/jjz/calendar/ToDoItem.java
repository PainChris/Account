package com.runner.jjz.calendar;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import android.util.Log;

/**
 * �����������
 * 
 */
public class ToDoItem implements Serializable {

	private static final long serialVersionUID = 3199251197683853468L;
	private long _id;
	private Date createTime; // ����ʱ��(���ڼ�ʱ��)
	private Date time; // ��������ʱ��
	private String alertTime; // ����ʱ��,���������ʱ���м��ö��ŷָ�����

	public ToDoItem(String task) {
		this( new Date(java.lang.System.currentTimeMillis()));
	}

	public ToDoItem( Date createTime) {
		super();
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
		return "(" + sdf.format(createTime) + ")" ;
	}



	public Date getCreateDate() {
		return createTime;
	}

	public void setCreateDate(Date createTime) {
		this.createTime = createTime;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public void setTime(int year, int month, int day) {
		Calendar c = Calendar.getInstance();
		if (time != null)
			c.setTime(time);
		c.set(year, month, day);
		time = c.getTime();
	}

	public String getAlertTime() {
		return alertTime;
	}

	public void setAlertTime(String alertTime) {
			this.alertTime = alertTime;
	}

	// ��������һ������ʱ��
	public void addAlertTime(Date date) {
		if (alertTime == null)
			alertTime = String.valueOf(date.getTime());
		else
			alertTime = alertTime + "," + String.valueOf(date.getTime());

		Log.i("Hwd", alertTime);
	}

	public long get_id() {
		return _id;
	}

	public void set_id(long _id) {
		this._id = _id;
	}
}
