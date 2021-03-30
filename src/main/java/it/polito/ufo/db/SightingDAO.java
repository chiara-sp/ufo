package it.polito.ufo.db;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SightingDAO {
	
	

	public List<String> readShapes(){
		
		try {
			Connection conn = DBConnect.getConnection();
			String sql="SELECT DISTINCT shape FROM sighting WHERE shape<>''ORDER BY shape ASC";
			PreparedStatement st=conn.prepareStatement(sql);
			
			ResultSet res =st.executeQuery();
			
			List<String> formeUFO= new ArrayList<String>();
			
			while(res.next()) {
				String forma=res.getString("shape");
				formeUFO.add(forma);
			}
			st.close();	
			conn.close();
			
			return formeUFO;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Database error in readshape",e);
		}
		
		
		
	}
	
	public int countByShape(String shape) {
		try {
			Connection conn = DBConnect.getConnection();
		String sql2= "Select count( *) as cnt from sighting where shape= ? ";

		
		PreparedStatement st2= conn.prepareStatement(sql2);
		st2.setString(1, shape);
		ResultSet res2= st2.executeQuery();
		res2.first();
		int count = res2.getInt("cnt");
		st2.close();
		conn.close();
		
		return count;
		}
		catch(SQLException e){
			throw new RuntimeException("Data error in countByShape",e);
		}
	}
	
	
}
