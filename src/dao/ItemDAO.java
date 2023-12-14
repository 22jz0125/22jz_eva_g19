package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.Item;

public class ItemDAO {
	public List<Item> get() {
		List<Item> list = new ArrayList<>();
		
		DBManager manager = DBManager.getInstance();
		try(Connection cn = manager.getConnection()) {
			String sql = "SELECT * FROM items";
			PreparedStatement stmt = cn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			System.out.println(rs);
			
			// データをリストに格納
			while(rs.next()) {
				System.out.println(rs2model(rs) + " rs2model");
				Item item = rs2model(rs);
				list.add(item);
				
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	public Item find(int id) {
		Item item = null;
		DBManager manager = DBManager.getInstance();
		try(Connection cn = manager.getConnection()) {
			// プレースホルダで変数部分を定義
			String sql = "SELECT * FROM items WHERE id = ?";
			PreparedStatement stmt = cn.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			// データをリストに格納
			if (rs.next()) {
				item = rs2model(rs);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return  item;
	}
	
	/**
	 * ResultSetの行データをモデルの形に変換するメソッド
	 * @param rs 変換前のデータ
	 * @return 変換後のデータ
	 */
	private Item rs2model(ResultSet rs) throws SQLException {
		/* 中略。rsの値を取得し、それぞれの変数に代入 */
		int id = rs.getInt("id");
//		String title = rs.getString("title");
//		String synopsisShort = rs.getString("synopsis_short");
//		String synopsisLong = rs.getString("synopsis_long");
//		boolean pcNg = rs.getBoolean("pc_ng");
		

		String name = rs.getString("name");
		int price = rs.getInt("price");
		String description = rs.getString("description");
		String imageURL = rs.getString("imageURL");
		String material = rs.getString("material");
		int weight = rs.getInt("weight");
		int isdeleted = rs.getInt("is_deleted");
		Timestamp created_at = rs.getTimestamp("created_at");
		Timestamp updated_at = rs.getTimestamp("updated_at");

		return new Item(id, name, price, description, imageURL, material, weight, isdeleted, created_at, updated_at);
	}


}
