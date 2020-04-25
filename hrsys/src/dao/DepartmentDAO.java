package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entity.Department;

public class DepartmentDAO extends FactoryDataBase{

	private PreparedStatement pstmt;
	private ResultSet rs;
	
	/**
	 * 添加部门信息功能
	 * @param did
	 * @param dname
	 * @param dloc
	 */
	public void addDept(int did,String dname,String dlocation) {
		String sql = "insert into department (did ,dname,dlocation) values(?,?,?)";
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setInt(1,did );
			pstmt.setString(2,dname );
			pstmt.setString(3,dlocation);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(null, pstmt, null);
		}
	}
	/**
	 * 查询部门信息方法
	 * @return
	 */
	public ArrayList queryDept() {
		String sql = "select * from department";
		ArrayList list = new ArrayList();
		try {
			pstmt = getConn().prepareStatement(sql);
			rs = pstmt.executeQuery();
			//处理结果集：把结果集中的数据导入到list集合中
			while(rs.next()) {
				int did = rs.getInt("did");
				String dname = rs.getString("dname");
				String dlocation = rs.getString("dlocation");
				Department dept = new Department(did,dname,dlocation);
				list.add(dept);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(null, pstmt, null);
		}
		return list;
	}
	
	/**
	 * 删除部门信息功能
	 * @param did
	 */
	public void delDept(int did) {
		String sql = "delete from department where did = ?";
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setInt(1,did );
			pstmt.executeUpdate();	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(null, pstmt, null);
		}
	}
	
	/**
	 * 根据did查询某一部门信息功能
	 * @param did
	 * @return
	 */
	public Department queryByidDept(int did) {
		String sql = "select * from department where did = ?";
		Department dept = null;
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setInt(1, did);
			rs = pstmt.executeQuery();
			//处理结果集：把结果集中的数据导入到list集合中
			if(rs.next()) {
				int id = rs.getInt("did");
				String dname = rs.getString("dname");
				String dloc = rs.getString("dlocation");
				dept = new Department(did,dname,dloc);

			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(null, pstmt, null);
		}
		return dept;
	}

	/**
	 * 修改部门信息功能
	 * @param did
	 * @param dname
	 * @param dloc
	 */
	public void updateDept(int did,String dname,String dloc) {
		String sql = "update department set dname = ?,dlocation = ? where did = ?";
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setString(1, dname);
			pstmt.setString(2, dloc);
			pstmt.setInt(3,did );
			pstmt.executeUpdate();	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(null, pstmt, null);
		}
	}
}
