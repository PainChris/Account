package com.runner.jjz;



import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Window;
import android.widget.TabHost;

public class SelectSort extends TabActivity {
	private Intent shouRu;
	private Intent zhiChu;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		TabHost tabHost = getTabHost();
		// ����ʹ��TabHost����
		LayoutInflater.from(this).inflate(R.layout.select_sort,
				tabHost.getTabContentView(), true);
	
//	LayoutInflater.from(this).inflate(R.layout.activity_main,
//			tabHost.getTabContentView(), true);
	//��һ�� ֧������
	zhiChu = new Intent(SelectSort.this,ExpendActivity.class);
	tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("֧��")
			.setContent(zhiChu));
	//�ڶ��� �������
	shouRu = new Intent(SelectSort.this, IncomeActivity.class);
	tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("����")
			.setContent(shouRu));
	}
}
