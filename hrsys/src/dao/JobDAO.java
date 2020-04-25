package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entity.Department;
import entity.Job;

public class JobDAO extends FactoryDataBase{
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	/**
	 * 查询所有职务信息功能
	 * @return
	 */
	public ArrayList queryJob() {
		String sql = "select * from job";
		ArrayList list = new ArrayList();
		try {
			pstmt = getConn().prepareStatement(sql);
			rs = pstmt.executeQuery();
			//处理结果集：把结果集中的数据导入到list集合中
			while(rs.next()) {
				int jid = rs.getInt("jid");
				String jname = rs.getString("jname");
				int lowsalary = rs.getInt("lowsalary");
				int highsalary = rs.getInt("highsalary");
				Job job = new Job(jid,jname,lowsalary,highsalary);
				list.add(job);
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
	 * 根据jid查询某一职务信息功能
	 * @param did
	 * @return
	 */
	public Job queryByidJob(int jid) {
		String sql = "select * from job where jid = ?";
		Job job = null;
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setInt(1, jid);
			rs = pstmt.executeQuery();
			//处理结果集：把结果集中的数据导入到list集合中
			if(rs.next()) {
				int id = rs.getInt("jid");
				String jname = rs.getString("jname");
				int lowsalary=rs.getInt("lowsalary");
				int highsalary=rs.getInt("highsalary");
			 job = new Job(jid,jname,lowsalary,highsalary);

			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(null, pstmt, null);
		}
		return job;
	}
	/**
	 * 修改职务信息功能
	 * @param did
	 * @param dname
	 * @param dloc
	 */
	public void updateJob(int jid,String jname,int lowsalary,int highsalary) {
		String sql = "update job set jname = ?,lowsalary = ?,highsalary = ? where jid = ?";
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setString(1, jname);
			pstmt.setInt(2,lowsalary );
			pstmt.setInt(3,highsalary);
			pstmt.setInt(4,jid);
			pstmt.executeUpdate();	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(null, pstmt, null);
		}
	}
	/**
	 * 增加职务
	 * @param jid
	 * @param jname
	 * @param lowsalary
	 * @param highsalary
	 */
	public void addDept(int jid,String jname,int lowsalary,int highsalary) {
		String sql = "insert into job (jid,jname,lowsalary,highsalary) values(?,?,?,?)";
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setInt(1,jid );
			pstmt.setString(2,jname );
			pstmt.setInt(3,lowsalary);
			pstmt.setInt(4,highsalary);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(null, pstmt, null);
		}
	}
	/**
	 * 删除职务信息功能
	 * @param jid
	 */
	public void delJob(int jid) {
		String sql = "delete from job where jid = ?";
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setInt(1,jid );
			pstmt.executeUpdate();	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(null, pstmt, null);
		}
	}
}
