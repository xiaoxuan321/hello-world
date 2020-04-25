package entity;

import java.util.Date;

import sun.tools.jar.resources.jar_it;

public class Employee {
	private int eid;
	private String ename;
	private int etel;
	private String eemail;
	private String eworkdate;
	private int esalary;
	private int jid;
	private String jname;
	private int did;
	private String dname;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int eid, String ename, int etel, String eemail, String eworkdate, int esalary, int jid,
			String jname, int did, String dname) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.etel = etel;
		this.eemail = eemail;
		this.eworkdate = eworkdate;
		this.esalary = esalary;
		this.jid = jid;
		this.jname = jname;
		this.did = did;
		this.dname = dname;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getEtel() {
		return etel;
	}
	public void setEtel(int etel) {
		this.etel = etel;
	}
	public String getEemail() {
		return eemail;
	}
	public void setEemail(String eemail) {
		this.eemail = eemail;
	}
	public String getEworkdate() {
		return eworkdate;
	}
	public void setEworkdate(String eworkdate) {
		this.eworkdate = eworkdate;
	}
	public int getEsalary() {
		return esalary;
	}
	public void setEsalary(int esalary) {
		this.esalary = esalary;
	}
	public int getJid() {
		return jid;
	}
	public void setJid(int jid) {
		this.jid = jid;
	}
	public String getJname() {
		return jname;
	}
	public void setJname(String jname) {
		this.jname = jname;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	
}
