package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sun.org.apache.regexp.internal.recompile;

import entity.Department;
import entity.Employee;
import entity.Job;

public class EmployeeDAO extends FactoryDataBase{
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	/**
	 * 添加员工任职信息功能
	 * @param emp
	 */
	public void addEmp(Employee emp) {
		String sql = "insert into employee (eid,ename,eemail,etel,eworkdate,esalary,jid,did) values(?,?,?,?,?,?,?,?)";
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setInt(1,emp.getEid());
			pstmt.setString(2,emp.getEname());
			pstmt.setString(3,emp.getEemail());
			pstmt.setInt(4,emp.getEtel());
			pstmt.setString(5,emp.getEworkdate());
			pstmt.setInt(6,emp.getEsalary() );
			pstmt.setInt(7,emp.getJid());
			pstmt.setInt(8,emp.getDid());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(null, pstmt, null);
		}
	}
	/**
	 * 查询任职信息方法
	 * @return
	 */
	public ArrayList queryEmp() {
		String sql = "select * from employee,job,department where employee.jid=job.jid and employee.did=department.did";
		ArrayList list = new ArrayList();
		try {
			pstmt = getConn().prepareStatement(sql);
			rs = pstmt.executeQuery();
			//处理结果集：把结果集中的数据导入到list集合中
			while(rs.next()) {
				int eid = rs.getInt("eid");
				String ename = rs.getString("ename");
				int etel = rs.getInt("etel");
				String eemail = rs.getString("eemail");
				String eworkdate = rs.getString("eworkdate");
				int esalary = rs.getInt("esalary");
				int jid = rs.getInt("jid");
				String jname=rs.getString("jname");
				int did = rs.getInt("did");
				String dname=rs.getString("dname");
				Employee emp= new Employee(eid, ename, etel, eemail, eworkdate, esalary, jid, jname, did, dname);
				list.add(emp);
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
	 * 根据eid查询某一任职信息功能
	 * @param did
	 * @return
	 */
	public Employee queryByidEmp(int eid) {
		String sql = "select * from employee where eid = ?";
		Employee emp = null;
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setInt(1, eid);
			rs = pstmt.executeQuery();
			//处理结果集：把结果集中的数据导入到list集合中
			if(rs.next()) {
				String ename = rs.getString("ename");
				int etel = rs.getInt("etel");
				String eemail = rs.getString("eemail");
				String eworkdate = rs.getString("eworkdate");
				int esalary=rs.getInt("esalary");
				int jid=rs.getInt("jid");
				int did=rs.getInt("did");
				emp=new Employee();
				emp.setEid(eid);
				emp.setEname(ename);
				emp.setEemail(eemail);
				emp.setEsalary(esalary);
				emp.setEtel(etel);
				emp.setEworkdate(eworkdate);
				emp.setDid(did);
				emp.setJid(jid);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(null, pstmt, null);
		}
		return emp;
	}
	
	/**
	 * 更新任职信息
	 * @param eid
	 * @param ename
	 * @param etel
	 * @param eemail
	 * @param eworkdate
	 * @param esalary
	 * @param jid
	 * @param jname
	 * @param did
	 * @param dname
	 */
	public void updateEmp(int eid,String ename,int etel, String eemail,String eworkdate,int esalary,int jid,int did) {
		String sql = "update employee set ename = ?,etel = ?,eemail=?,eworkdate=?,esalary=?,jid=?,did=? where eid = ?";
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setString(1, ename);
			pstmt.setInt(2,etel );
			pstmt.setString(3, eemail);
			pstmt.setString(4, eworkdate);
			pstmt.setInt(5,esalary );
			pstmt.setInt(6,jid );
			pstmt.setInt(7,did );
			pstmt.setInt(8,eid);
			pstmt.executeUpdate();	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(null, pstmt, null);
		}
	}
	/**
	 * 删除任职信息功能
	 * @param eid
	 */
	public void delEmp(int eid) {
		String sql = "delete from employee where eid = ?";
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setInt(1,eid );
			pstmt.executeUpdate();	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(null, pstmt, null);
		}
	}
	
}
