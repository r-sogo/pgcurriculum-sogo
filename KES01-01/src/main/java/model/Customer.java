package model;

import java.io.Serializable;

public class Customer implements Serializable {
	
	// 顧客ID
	private int custId;
	// 顧客名
	private String custName;
	// カナ
	private String kana;
	// 電話番号
	private String tel;
	// 住所
	private String address;
	
	// コンストラクタ（引数なし）
	public Customer() {
	}
	
	// コンストラクタ（引数あり）
	public Customer(
			int custId,
			String custName,
			String kana,
			String tel,
			String address) {
		this.custId = custId;
		this.custName = custName;
		this.kana = kana;
		this.tel = tel;
		this.address = address;
	}
	
	// セッター：custId
	public void setCustId(int custId) {
		this.custId = custId;
	}
	
	// ゲッター：custId
	public int getCustId() {
		return this.custId;
	}
	
	// セッター：custName
	public void setCustName(String custName) {
		this.custName = custName;
	}
	
	// ゲッター：custName
	public String getCustName() {
		return this.custName;
	}
	
	// セッター：kana
	public void setKana(String kana) {
		this.kana = kana;
	}
	
	// ゲッター：kana
	public String getKana() {
		return this.kana;
	}
	
	// セッター：tel
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	// ゲッター：tel
	public String getTel() {
		return this.tel;
	}
	
	// セッター：address
	public void setAddress(String address) {
		this.address = address;
	}
	
	// ゲッター：address
	public String getAddress() {
		return this.address;
	}
	
}
