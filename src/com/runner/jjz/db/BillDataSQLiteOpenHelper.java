package com.runner.jjz.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * @author runner
 * ���ݿ�����࣬���ڴ����͹������ݿ⡣
 */
public class BillDataSQLiteOpenHelper extends SQLiteOpenHelper {

	/**
	 * ���ݿ�Ĺ��캯��
	 * @param context
	 * @param name    ���ݿ�����
	 * @param factory �α깤��
	 * @param version ���ݿ�汾�ţ���СΪ1��
	 */
	public BillDataSQLiteOpenHelper(Context context) {
		super(context, "jjz.db", null, 1);
		// TODO Auto-generated constructor stub
	}


	/**
	 * ���ݿ��һ�δ���ʱ�ص��÷���
	 * ��ʼ��һЩ��
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		
		//�������ݿ�
		String sql = "create table bill(id int primary key ,date String,food float,fremark varchar(60),shop float, " +
				"sremark varchar(60),entertainment float,eremark varchar(60),communication float,cremark varchar(60)," +
				"study float,stremark varchar(60),travle float,tremark varchar(60),medicial float,mremark varchar(60)," +
				"others float,oremark varchar(60),rental float)";
		db.execSQL(sql);
	}

	/**
	 * ���ݿ�İ汾�Ÿ���ʱ�ص��˷���
	 * �������ݿ�����ݣ���ӱ�ɾ�����޸ı�
	 */
	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}
