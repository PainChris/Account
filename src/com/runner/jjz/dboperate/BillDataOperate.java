package com.runner.jjz.dboperate;

import java.util.ArrayList;
import java.util.List;


import com.runner.jjz.db.BillDataSQLiteOpenHelper;
import com.runner.jjz.entities.Bill;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class BillDataOperate {
	
	private BillDataSQLiteOpenHelper mOpenHelper;//���ݿ�İ�����

	public BillDataOperate(Context context){
		
		mOpenHelper = new BillDataSQLiteOpenHelper(context);
	 }
	/**
	 * ��ӵ�bill��һ������
	 * @param bill
	 */
	public void insert(Bill bill){
		
		SQLiteDatabase db = mOpenHelper.getWritableDatabase();
		
		if(db.isOpen()){   //������ݿ�򿪣�ִ����ӵĲ���
			
			//ִ����ӵ����ݿ�Ĳ���
			db.execSQL("insert into bill(id,date,food,fremark,shop,sremark,entertainment,eremark,communication," +
					"cremark,study,stremark,travle,tremark,medicial,mremark,others,oremark,rental)" +
					" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",new Object[]{bill.getId(),bill.getDate(),bill.getFood(),bill.getFremark(),
					bill.getShop(),bill.getSremark(),bill.getEntertainment(),bill.getEremark(),bill.getCommunication(),bill.getCremark(),
					bill.getStudy(),bill.getStremark(),bill.getTravle(),bill.getTremark(),bill.getMedicial(),bill.getMremark(),bill.getOthers(),
					bill.getOremark(),bill.getRental()});
			
			db.close();//���ݿ�ر�
		}
	}
	
	public void delete(String date){
    	SQLiteDatabase db = mOpenHelper.getWritableDatabase();
    	if(db.isOpen()){
    		
    		db.execSQL("delete from bill where date = ?", new String[]{date});
    		
    		db.close();
    	}
    }
	
	public void update(String date,float money,String remark,int t){
	
		String type="food";
		String typeremark="fremark";
		switch(t)
		{
		case(0):type="food";typeremark="fremark";break;
		case(1):type="shop";typeremark="sremark";break;
		case(2):type="entertainment";typeremark="eremark";break;
		case(3):type="communication";typeremark="cremark";break;
		case(4):type="study";typeremark="stremark";break;
		case(5):type="travle";typeremark="tremark";break;
		case(6):type="medicial";typeremark="mremark";break;
		case(7):type="others";typeremark="oremark";break;
		}
		SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        if(db.isOpen()){
    		
    		db.execSQL("update bill set "+ type +"=?,"+ typeremark +"=? where date=?",new Object[]{money,remark,date});
    		
    		db.close();
    	}
	}
	
	public Bill getSmallData(String date)
	{
		SQLiteDatabase db = mOpenHelper.getWritableDatabase();
    	if(db.isOpen()){
    		
    		Cursor cursor = db.rawQuery("select * from bill where date = ?", new String[]{date});
    		if(cursor!=null && cursor.getCount()>0)
    		{
    			int id;
    			float food;           //�������ѽ��
    			String fremark;         //������Ϣ��ע
    			float shop;           //�������ѽ��
    			String sremark;         //������Ϣ��ע
    			float entertainment;  //�������ѽ��
    			String eremark;         //������Ϣ��ע
    			float communication;  //ͨѶ���ѽ��
    			String cremark;         //ͨѶ��Ϣ��ע
    			float study;          //ѧϰ���ѽ��
    			String stremark;        //ѧϰ��Ϣ��ע
    			float travle;         //�������ѽ��
    			String tremark;         //������Ϣ��ע
    			float medicial;       //ҽ�����ѽ��
    			String mremark;         //ҽ����Ϣ��ע
    			float others;         //�������ѽ��
    			String oremark;         //������Ϣ��ע
    			float rental;
    			while(cursor.moveToNext()){
    				id = cursor.getInt(0);
    				date = cursor.getString(1);
    				food = cursor.getFloat(2);
    				fremark = cursor.getString(3);
    				shop = cursor.getFloat(4);
    				sremark = cursor.getString(5);
    				entertainment = cursor.getFloat(6);
    				eremark = cursor.getString(7);
    				communication = cursor.getFloat(8);
    				cremark = cursor.getString(9);
    				study = cursor.getFloat(10);
    				stremark = cursor.getString(11);
    				travle = cursor.getFloat(12);
    				tremark = cursor.getString(13);
    				medicial = cursor.getFloat(14);
    				mremark = cursor.getString(15);
    				others = cursor.getFloat(16);
    				oremark = cursor.getString(17);
    				rental = cursor.getFloat(18);
    				
    				return new Bill(id,date,food,fremark,shop,sremark,entertainment,eremark,communication,
    						cremark,study,stremark,travle,tremark,medicial, mremark,others,oremark,rental);
    			}
    			db.close();
    		}
    		db.close();
    	}
    	return null;
	}
	
	public Bill getBigData(int startid,int endid)
	{
		SQLiteDatabase db = mOpenHelper.getWritableDatabase();
    	if(db.isOpen()){
    		
    		Cursor cursor = db.rawQuery("select * from bill where id >= ? and id <= ?", new String[]{startid+"",endid+""});
    		
    		if(cursor!=null && cursor.getCount()>0 )
    		{
    			float food = 0.0f;           //�������ѽ��
    			//String fremark;         //������Ϣ��ע
    			float shop = 0.0f;           //�������ѽ��
    			//String sremark;         //������Ϣ��ע
    			float entertainment =0.0f;  //�������ѽ��
    			//String eremark;         //������Ϣ��ע
    			float communication = 0.0f;  //ͨѶ���ѽ��
    			//String cremark;         //ͨѶ��Ϣ��ע
    			float study = 0.0f;          //ѧϰ���ѽ��
    			//String stremark;        //ѧϰ��Ϣ��ע
    			float travle =  0.0f;         //�������ѽ��
    			//String tremark;         //������Ϣ��ע
    			float medicial = 0.0f;       //ҽ�����ѽ��
    			//String mremark;         //ҽ����Ϣ��ע
    			float others = 0.0f;         //�������ѽ��
    			//String oremark;         //������Ϣ��ע
    			while(cursor.moveToNext()){

    				food += cursor.getFloat(2);
    				
    				String f=food+"";
                    Log.i(f, "vdbd");
                    
    				shop += cursor.getFloat(4);
    				
    				entertainment += cursor.getFloat(6);
    				
    				communication += cursor.getFloat(8);
    				
    				study += cursor.getFloat(10);
    				
    				travle += cursor.getFloat(12);
    				
    				medicial += cursor.getFloat(14);
    				
    				others += cursor.getFloat(16);
    				
    			}
    			return new Bill(food,shop,entertainment,communication,study,travle,medicial,others);
    		}
    		db.close();
    	}
    	return null;
	}
	
	public Bill getIdandRental()
	{
		SQLiteDatabase db = mOpenHelper.getWritableDatabase();
    	if(db.isOpen()){
    		
    		Cursor cursor = db.rawQuery("select * from bill",null);
    		if(cursor!=null && cursor.getCount()>0)
    		{
    			int id;
    			float rental;
    			if(cursor.moveToLast()){
    				id = cursor.getInt(0);
    				rental = cursor.getFloat(18);
    				return new Bill(id,rental);
    			}
    			db.close();
    		}
    		db.close();
    	}
    	return null;
	}

	public void putMoney(float rental,String date)
	{
		SQLiteDatabase db = mOpenHelper.getWritableDatabase();
    	if(db.isOpen()){
    		db.execSQL("update bill set rental=? where date=?",new Object[]{rental,date});
    		db.close();
    	}
    	db.close();
    }
}