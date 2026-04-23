package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Customer;

public class CustomerSearchDBAccess {
	
	private static final String URL = "jdbc:mysql://localhost:65534/KIDDA_LA";
	private static final String USER = "user1";
	private static final String PASS = "pass1";
	
	// DB接続
	private Connection createConnection() throws Exception {
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		
		return con;
	}
	
	// DB切断
	private void closeConnection(Connection con) throws Exception {
		if (con != null) {
			con.close();
		}
	}
	
	// 顧客情報検索（検索条件：電話番号と完全一致）
	public ArrayList<Customer> searchCustomerByTel(String tel) throws Exception{
		ArrayList<Customer> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = """
				SELECT CUSTID, CUSTNAME, KANA, ADDRESS
				FROM CUSTOMER
				WHERE TEL = ?
				""";
		
		try {
			con = createConnection();
			
			ps = con.prepareStatement(sql);
			ps.setString(1, tel);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Customer customer = new Customer(
					rs.getInt("CUSTID"),
					rs.getString("CUSTNAME"),
					rs.getString("KANA"),
					tel,
					rs.getString("ADDRESS")
				);
				
				list.add(customer);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
			
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				closeConnection(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	// 顧客情報検索（検索条件：カナを含む）
	public ArrayList<Customer> searchCustomerByKana(String kana) throws Exception{
		ArrayList<Customer> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = """
				SELECT CUSTID, CUSTNAME, KANA, TEL, ADDRESS
				FROM CUSTOMER
				WHERE KANA LIKE ?
				""";
		
		try {
			con = createConnection();
			
			ps = con.prepareStatement(sql);
			ps.setString(1, "%" + kana + "%");
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Customer customer = new Customer(
					rs.getInt("CUSTID"),
					rs.getString("CUSTNAME"),
					rs.getString("KANA"),
					rs.getString("TEL"),
					rs.getString("ADDRESS")
				);
				
				list.add(customer);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
			
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				closeConnection(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return list;
		
	}
	
	// 顧客情報検索（検索条件：電話番号と完全一致 かつ カナを含む）
	public ArrayList<Customer> searchCustomer(String tel, String kana) throws Exception{
		ArrayList<Customer> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = """
				SELECT CUSTID, CUSTNAME, KANA, TEL, ADDRESS
				FROM CUSTOMER
				WHERE TEL = ? AND KANA LIKE ?
				""";
		
		try {
			con = createConnection();
			
			ps = con.prepareStatement(sql);
			ps.setString(1, tel);
			ps.setString(2, "%" + kana + "%");
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Customer customer = new Customer(
					rs.getInt("CUSTID"),
					rs.getString("CUSTNAME"),
					rs.getString("KANA"),
					tel,
					rs.getString("ADDRESS")
				);
				
				list.add(customer);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
			
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				closeConnection(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return list;
		
	}
	
	
}