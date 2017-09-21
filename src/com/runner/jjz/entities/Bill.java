package com.runner.jjz.entities;

public class Bill {

	private int id;                //���
	private String date;          //����
	private float food;           //�������ѽ��
	private String fremark;         //������Ϣ��ע
	private float shop;           //�������ѽ��
	private String sremark;         //������Ϣ��ע
	private float entertainment;  //�������ѽ��
	private String eremark;         //������Ϣ��ע
	private float communication;  //ͨѶ���ѽ��
	private String cremark;         //ͨѶ��Ϣ��ע
	private float study;          //ѧϰ���ѽ��
	private String stremark;        //ѧϰ��Ϣ��ע
	private float travle;         //�������ѽ��
	private String tremark;         //������Ϣ��ע
	private float medicial;       //ҽ�����ѽ��
	private String mremark;         //ҽ����Ϣ��ע
	private float others;         //�������ѽ��
	private String oremark;         //������Ϣ��ע
	private float rental;           //���
	
	/*
	 * ���������ݸ�ֵ�ͻ�ȡ
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public float getFood() {
		return food;
	}
	public void setFood(float food) {
		this.food = food;
	}
	public String getFremark() {
		return fremark;
	}
	public void setFremark(String fremark) {
		this.fremark = fremark;
	}
	public float getShop() {
		return shop;
	}
	public void setShop(float shop) {
		this.shop = shop;
	}
	public String getSremark() {
		return sremark;
	}
	public void setSremark(String sremark) {
		this.sremark = sremark;
	}
	public float getEntertainment() {
		return entertainment;
	}
	public void setEntertainment(float entertainment) {
		this.entertainment = entertainment;
	}
	public String getEremark() {
		return eremark;
	}
	public void setEremark(String eremark) {
		this.eremark = eremark;
	}
	public float getCommunication() {
		return communication;
	}
	public void setCommunication(float communication) {
		this.communication = communication;
	}
	public String getCremark() {
		return cremark;
	}
	public void setCremark(String cremark) {
		this.cremark = cremark;
	}
	public float getStudy() {
		return study;
	}
	public void setStudy(float study) {
		this.study = study;
	}
	public String getStremark() {
		return stremark;
	}
	public void setStremark(String stremark) {
		this.stremark = stremark;
	}
	public float getTravle() {
		return travle;
	}
	public void setTravle(float travle) {
		this.travle = travle;
	}
	public String getTremark() {
		return tremark;
	}
	public void setTremark(String tremark) {
		this.tremark = tremark;
	}
	public float getMedicial() {
		return medicial;
	}
	public void setMedicial(float medicial) {
		this.medicial = medicial;
	}
	public String getMremark() {
		return mremark;
	}
	public void setMremark(String mremark) {
		this.mremark = mremark;
	}
	public float getOthers() {
		return others;
	}
	public void setOthers(float others) {
		this.others = others;
	}
	public String getOremark() {
		return oremark;
	}
	public void setOremark(String oremark) {
		this.oremark = oremark;
	}
	public float getRental() {
		return rental;
	}
	public void setRental(float rental) {
		this.rental = rental;
	}
	public float getSumcost()
	{
		return food+shop+entertainment+communication+study+travle+medicial+others;
	}
	/*
	 *��ʼ��bill�� 
	 */
	
    
	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Bill(int id,String date, float food, String fremark, float shop,
			String sremark, float entertainment, String eremark,
			float communication, String cremark, float study, String stremark,
			float travle, String tremark, float medicial, String mremark,
			float others, String oremark,float rental) {
		super();
		this.id = id;
		this.date = date;
		this.food = food;
		this.fremark = fremark;
		this.shop = shop;
		this.sremark = sremark;
		this.entertainment = entertainment;
		this.eremark = eremark;
		this.communication = communication;
		this.cremark = cremark;
		this.study = study;
		this.stremark = stremark;
		this.travle = travle;
		this.tremark = tremark;
		this.medicial = medicial;
		this.mremark = mremark;
		this.others = others;
		this.oremark = oremark;
		this.rental = rental;

	}
	public Bill(int id,String date,float rental){
		this.id = id;
		this.date = date;
		this.food = 0.0f;
		this.fremark = "";
		this.shop = 0.0f;
		this.sremark = "";
		this.entertainment = 0.0f;
		this.eremark = "";
		this.communication = 0.0f;
		this.cremark = "";
		this.study = 0.0f;
		this.stremark = "";
		this.travle = 0.0f;
		this.tremark = "";
		this.medicial = 0.0f;
		this.mremark = "";
		this.others = 0.0f;
		this.oremark = "";
		this.rental = rental;
	}
	
	public Bill(float food,float shop, float entertainment,float communication, 
			float study,float travle, float medicial,float others)
	{
		this.food = food;
		this.shop = shop;
		this.entertainment = entertainment;
		this.communication = communication;
		this.study = study;
		this.travle = travle;
		this.medicial = medicial;
		this.others = others;
	}
	
	public Bill(int id,float rental)
	{
		this.id = id;
		this.rental = rental;
	}
	
	@Override
	public String toString() {
		return "Bill [id=" + id + ",date=" + date + ", food=" + food + ", fremark=" + fremark
				+ ", shop=" + shop + ", sremark=" + sremark
				+ ", entertainment=" + entertainment + ", eremark=" + eremark
				+ ", communication=" + communication + ", cremark=" + cremark
				+ ", study=" + study + ", stremark=" + stremark + ", travle="
				+ travle + ", tremark=" + tremark + ", medicial=" + medicial
				+ ", mremark=" + mremark + ", others=" + others + ", oremark="
				+ oremark + ",id=" + id + "]";
	}
	
	public String ftoString(){
		return "food="+food+"";
	}
}
