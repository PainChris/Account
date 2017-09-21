package com.runner.jjz.view;

import com.runner.jjz.entities.Bill;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ScrollView;
import android.widget.TextView;



public class RingView extends TextView {

	//�ؼ���
	private int width;
	//�ؼ���
	private int height;
	//������ɫ
	private final static int RingColor = Color.parseColor("#0A0A0A"); 
	//����
	private Paint paint;
	//�Ƿ��һ��
	private boolean init = false;
		
	//�������ĵ�x��
	private float content_X; 
	//�������ĵ�y��
	private float content_Y;  
	//����뾶
	private float bigRadius;
	//���ڰ뾶
	private float smallRadius;  
		
		
	//�ļ���ʾ���ı�
	private String text;  
	private static final int TEXTSIZE = 25;
	
	private Bill bill;
	public RingView(Context context){
		super(context);
	}
	
	public RingView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
	
	public RingView(Context context, AttributeSet attrs, int defStyle) {  
	    super(context, attrs, defStyle);  
    }  
	
	
	
	private int[] Colors = new int[]{Color.parseColor("#FFD952"), Color.parseColor("#FE8A02"), Color.parseColor("#98CDE1"),
			Color.parseColor("#FA7FB6"), Color.parseColor("#F46363"), Color.parseColor("#6BD768"), Color.parseColor("#8B948B") ,Color.parseColor("#CD9D0C")};//��������ͼ��ɫ
	
	private float[] startAngle = new float[8];//�����ʼ����{0.0f,30.0f,70.0f,120.0f,180.0f,250.0f,330.0f};
	private float[] sweepAngle = new float[8];//�����������νǶ�{30.0f,40.0f,50.0f,60.0f,70.0f,80.0f,30.0f};
	
	private float[] bd = new float[8];//{3.0f,4.0f,5.0f,6.0f,7.0f,8.0f,3.0f};
	
	@Override  
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {  
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);  
		if(!init) {  
			initPaint();  
		}  
	}
	
	private void initPaint() {
		// TODO Auto-generated method stub
		setPadding(0, 0, 0, 0);  
		paint = new Paint();  
		paint.setStyle(Style.FILL);  
		paint.setAntiAlias(true);  
		paint.setColor(RingColor);//ring����ɫ  
		width = getMeasuredWidth();  
		height = getMeasuredHeight();  
		bigRadius = ((float) width / 3);  
		smallRadius = (float) width / 4;  
		content_X = (float) width / 2 ;  
		content_Y = (float) height / 2;  
		init = true;  
	}  
	
	 @Override  
	 protected void onDraw(Canvas canvas) {  
		 initPaint();
		 super.onDraw(canvas);  
	     paint.setColor(RingColor);//ring����ɫ  
	     Path path = new Path();  
         path.reset();  
	     /*��Բ*/  
	     path.addCircle(content_X, content_Y, bigRadius , Path.Direction.CCW);  
	     path.close();  
	     canvas.drawPath(path, paint);  
         path.reset(); 
         
	     paint.setColor(Color.WHITE);  
	     path.addCircle(content_X, content_Y, smallRadius, Path.Direction.CCW);  
	     path.close();  
	     canvas.drawPath(path, paint);  
	     getSectorClip(canvas);  
	     path.reset();  
	     paint.setColor(Color.WHITE);  
	     path.addCircle(content_X, content_Y, smallRadius, Path.Direction.CCW);  
	     path.close();  
	     canvas.drawPath(path, paint);  
	     if (text!=null) {  
	    	 paint.setColor(Color.GREEN);  
	         paint.setFakeBoldText(true);  
             paint.setTextSize(TEXTSIZE);  
	         canvas.drawText(text,width/4,height/2, paint);  
	     }  
	 }
    /*
     * ����һ�����βü���
     * @param canves //����
     * @param startAngle
     */
	private void getSectorClip(Canvas canvas) {
		// TODO Auto-generated method stub
		setStartAndSweep();
		for(int i=0;i<8;i++)
		{
			Path path = new Path();  
			// �����ǻ��һ�������εļ�����  
			path.moveTo(content_X, content_Y); // Բ��
			
			paint.setColor(Colors[i]);//���ȵ���ɫ  
			
		    //��������βü���
			int j=i+1;
	        if(i==7){
	        	j=0;
	        }
	        path.lineTo(  
					(float) (content_X + bigRadius * Math.cos(startAngle[i] * Math.PI / 180)), // ��ʼ��Ƕ���Բ�϶�Ӧ�ĺ�����  
		  
			        (float) (content_Y + bigRadius * Math.sin(startAngle[i] * Math.PI / 180))); // ��ʼ��Ƕ���Բ�϶�Ӧ�������� 
			path.lineTo(  
			        (float) (content_X + bigRadius * Math.cos(startAngle[j] * Math.PI / 180)), // �յ�Ƕ���Բ�϶�Ӧ�ĺ�����  
			        
			        (float) (content_Y + bigRadius * Math.sin(startAngle[j] * Math.PI / 180))); // �յ��Ƕ���Բ�϶�Ӧ��������
			
			//����һ�������Σ�����Բ  
			RectF rectF = new RectF(content_X - bigRadius, content_Y - bigRadius, content_X + bigRadius,  
					content_Y + bigRadius);
			//�����ǻ�û��μ������ķ���  
			path.addArc(rectF, startAngle[i], sweepAngle[i]);
			path.close();
			canvas.drawPath(path,paint);
			
		}
		
	}
	
	private void setStartAndSweep(){
		
		Bill bill = getBill();
		//SimpleDateFormat today = new SimpleDateFormat("yyyy-MM-dd");
		//String date = today.format(new java.util.Date());
		//BillDataOperate operate = new BillDataOperate(getContext());
		//Bill billdata = operate.getData(date);
		
		float data=bill.getSumcost();
		float tempdata=0.0f;
		startAngle[0]=0.0f;
		bd[0] = bill.getFood();
		bd[1] = bill.getShop();
		bd[2] = bill.getEntertainment();
		bd[3] = bill.getCommunication();
		bd[4] = bill.getStudy();
		bd[5] = bill.getTravle();
		bd[6] = bill.getMedicial();
		bd[7] = bill.getOthers();
	
		for(int i=0;i<8;i++)
		{
			sweepAngle[i] =(float)(bd[i]/data*360.0);
			tempdata+=sweepAngle[i];
			if(i<7){
				startAngle[i+1] = tempdata;
			}
		}
	}  
	
    public void setText(String text){  
    	this.text = text;  
    	}

	public void setBill(Bill bill) {
		// TODO Auto-generated method stub
		this.bill = bill;
	}
	
	public Bill getBill()
	{
		return bill;
	}
}