package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class UserDAO extends FactoryDataBase{
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	/**
	 *用户登录
	 * @param username
	 * @param password
	 * @param level
	 * @return
	 */
	public boolean login(String username,String password,int level) {
		String sql = "select * from user where username = ? and password = ? and level = ?";
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setString(1,username );
			pstmt.setString(2,password );
			pstmt.setInt(3, level);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(rs, pstmt, null);
		}
		return false;
	}
	
}
