package action;

import java.util.ArrayList;

import dao.CustomerSearchDBAccess;
import model.Customer;
import model.OrderControlUtility;

public class CustomerSearchAction {
	
	// 顧客情報検索アクション
	public String[][] execute(String[] data) throws Exception{
		
		String tel = (data != null && data.length > 0 && data[0] != null) ? data[0] : "";
		String kana = (data != null && data.length > 1 && data[1] != null) ? data[1] : "";
		
		tel = tel.trim().replace("　", "");
		kana = kana.trim().replace("　", "");
		
		CustomerSearchDBAccess dao = new CustomerSearchDBAccess();
		ArrayList<Customer> list = new ArrayList<>();
		
		if (!"".equals(tel) && "".equals(kana)) {
			list = dao.searchCustomerByTel(tel);
		} else if ("".equals(tel) && !"".equals(kana)) {
			list = dao.searchCustomerByKana(kana);
		} else if (!"".equals(tel) && !"".equals(kana)) {
			list = dao.searchCustomer(tel, kana);
		}
		
		String[][] tableData;
		
		if (list.size() > 0) {
			tableData = OrderControlUtility.customerToArray(list);
			
		} else {
			tableData = new String[0][0];
		}
		
		return tableData;
		
	}

}
