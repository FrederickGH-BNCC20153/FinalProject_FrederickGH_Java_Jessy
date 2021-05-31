package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import Menu.Data;
import db.ConnectDatabase;

public class MenuDAO {
	
	private Connection connection;
	
	public MenuDAO() {
		connection = ConnectDatabase.connectDataBase();
	}

	public void insert(Data data) {
		try {
			Statement stats = connection.createStatement();
			
//			String query = "Insert into data values('BC-123','"+data.getName()+"',"+data.getHarga()+","+data.getStok()+")";
			String query = String.format("Insert into data values('%s', '%s', '%d', '%d' ) ", data.getKode(), data.getName(), data.getHarga(), data.getStok());
			stats.execute(query);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//
	}
	
	public Vector<Vector<String>> getMenu(){
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		
		try {
			Statement stmt = connection.createStatement();
			
			String query = "Select * from data";
			
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				Vector<String> subdata = new Vector<String>();
				
				subdata.add(rs.getString(1));
				subdata.add(rs.getString(2));
				subdata.add(rs.getString(3));
				subdata.add(rs.getString(4));
				
				data.add(subdata);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data;
	}
	
	public void delete(String id) {
		try {
			Statement stmt = connection.createStatement();
			
			String query = "delete from data where kode = '"+id+"'";
			
			stmt.execute(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}