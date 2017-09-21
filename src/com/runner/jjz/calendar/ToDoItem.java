package com.runner.jjz.calendar;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import android.util.Log;

/**
 * 待办事项对象
 * 
 */
public class ToDoItem implements Serializable {

	private static final long serialVersionUID = 3199251197683853468L;
	private long _id;
	private Date createTime; // 创建时间(日期及时间)
	private Date time; // 待办事项时间
	private String alertTime; // 提醒时间,将多个提醒时间中间用逗号分隔开来

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

	// 在最后添加一个提醒时间
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
