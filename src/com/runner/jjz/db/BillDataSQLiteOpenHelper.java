package com.runner.jjz.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * @author runner
 * 数据库帮助类，用于创建和管理数据库。
 */
public class BillDataSQLiteOpenHelper extends SQLiteOpenHelper {

	/**
	 * 数据库的构造函数
	 * @param context
	 * @param name    数据库名称
	 * @param factory 游标工程
	 * @param version 数据库版本号（最小为1）
	 */
	public BillDataSQLiteOpenHelper(Context context) {
		super(context, "jjz.db", null, 1);
		// TODO Auto-generated constructor stub
	}


	/**
	 * 数据库第一次创建时回调该方法
	 * 初始化一些表
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		
		//操作数据库
		String sql = "create table bill(id int primary key ,date String,food float,fremark varchar(60),shop float, " +
				"sremark varchar(60),entertainment float,eremark varchar(60),communication float,cremark varchar(60)," +
				"study float,stremark varchar(60),travle float,tremark varchar(60),medicial float,mremark varchar(60)," +
				"others float,oremark varchar(60),rental float)";
		db.execSQL(sql);
	}

	/**
	 * 数据库的版本号更新时回调此方法
	 * 更新数据库的内容（添加表，删除表，修改表）
	 */
	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}
