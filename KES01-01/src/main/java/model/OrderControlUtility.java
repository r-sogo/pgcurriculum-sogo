package model;

import java.util.ArrayList;

public class OrderControlUtility {
	
	// 検索結果表示用データ変換
	public static String[][] customerToArray(ArrayList<Customer> list){
		int size = list.size();
		String[][] tableData = new String[size][4];
		
		for (int i = 0; i < size; i++) {
			Customer customer = list.get(i);
			
			tableData[i][0] = String.valueOf(customer.getCustId());
			tableData[i][1] = customer.getCustName();
			tableData[i][2] = customer.getKana();
			tableData[i][3] = customer.getAddress();
			
		}
		
		return tableData;
	}
	
	/*
	 // 商品情報表示用データ変換（未実装）
	 public static String[][] itemToArray(ArrayList<Item> list){
	 }
	 */
	
	/*
	 // 注文明細情報表示用データ変換（未実装）
	 public static String[][] orderToArray(ArrayList<OrderDetailList> orderDetailList){
	 }
	 */
	
	/*
	 // 現在日付生成処理（未実装）
	 public static String getDate(){
	 }
	 */
	
}
