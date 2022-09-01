package com.servlet.study.web.domain.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Types;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.servlet.study.web.domain.db.DBConnectionMgr;

public class UserRespository {
	
	private DBConnectionMgr pool;
	
	public UserRespository() {
		pool = DBConnectionMgr.getInstance();
	}
	
	public List<Map<String, Object>> getUserList() {
		String sql = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		
		try {
			con = pool.getConnection();
			sql = "SELECT\r\n"
					+ "	um.user_code,\r\n"
					+ "	um.user_id,\r\n"
					+ "	um.user_password,\r\n"
					+ "	um.user_name,\r\n"
					+ " um.user_email,\r\n"
					+ "	ud.user_phone,\r\n"
					+ "	ud.user_address\r\n"
					+ "FROM\r\n"
					+ "	user_mst um\r\n"
					+ "	LEFT OUTER JOIN user_dtl ud ON(ud.user_code = um.user_code);";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rsmd = rs.getMetaData();
			
			while(rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				
				for(int i = 0; i < rsmd.getColumnCount(); i++) {
					int index = i + 1;
					Object value = null;
					
					if(rsmd.getColumnType(index) == Types.INTEGER) {
						value = rs.getInt(index);
					}else if(rsmd.getColumnType(index) == Types.VARCHAR) {
						value = rs.getString(index);
					}else if(rsmd.getColumnType(index) == Types.TIMESTAMP) {
						value = rs.getTimestamp(index).toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
					}
					
					map.put(rsmd.getColumnName(index), value);
					
				}
				
				list.add(map);
			}
			
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			
			System.out.println(gson.toJson(list));
			
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		
		return list;
	}

}
