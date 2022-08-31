package com.servlet.study.web.domain.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Types;

import com.servlet.study.web.domain.db.DBConnectionMgr;

public class UserDBTest {
	
	public static void main(String[] args) {
		

		DBConnectionMgr pool = DBConnectionMgr.getInstance();
		
		String sql = "SELECT\r\n"
				+ "	om.order_code,\r\n"
				+ "	om.order_user,\r\n"
				+ "	um.user_id,\r\n"
				+ "	om.order_product,\r\n"
				+ "	pm.product_name,\r\n"
				+ "	pm.product_category,\r\n"
				+ "	cm.category_name,\r\n"
				+ "	pm.product_price,\r\n"
				+ "	om.order_datetime\r\n"
				+ "FROM\r\n"
				+ "	order_mst om\r\n"
				+ "LEFT OUTER JOIN user_mst um ON(um.user_code = om.order_user)\r\n"
				+ "LEFT OUTER JOIN product_mst pm ON(pm.product_code = om.order_product)\r\n"
				+ "LEFT OUTER JOIN category_mst cm ON(cm.category_code = pm.product_category);";
		
		try {
			Connection con = pool.getConnection();
			
			PreparedStatement pstmt = con.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();
			
			ResultSetMetaData metaData = rs.getMetaData();
			int colcount = metaData.getColumnCount();
			
			for(int i = 0; i < colcount; i++) {
				System.out.printf("%-50s", metaData.getColumnName(i + 1));
			}
			System.out.println();
			
			while(rs.next()) {
				for(int i = 0; i < colcount; i++) {
					int index = i + 1;
					
					int scale = metaData.getScale(index);
					int colType = metaData.getColumnType(index);
					
					if(colType == Types.NUMERIC && scale == 0) {
						System.out.printf("%-30d", rs.getInt(index));
					}else if(colType == Types.VARCHAR) {
						System.out.printf("%-30s", rs.getString(index));
					}else if(colType == Types.TIMESTAMP) {
						System.out.printf("%-30s", rs.getTimestamp(index).toString());
					}
				}
				System.out.println();
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

}
