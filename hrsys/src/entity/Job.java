package entity;


public class Job {
	private int jid;
	private String jname;
	private int lowsalary;
	private int highsalary;
	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Job(int jid, String jname, int lowsalary, int highsalary) {
		super();
		this.jid = jid;
		this.jname = jname;
		this.lowsalary = lowsalary;
		this.highsalary = highsalary;
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
	public int getLowsalary() {
		return lowsalary;
	}
	public void setLowsalary(int lowsalary) {
		this.lowsalary = lowsalary;
	}
	public int getHighsalary() {
		return highsalary;
	}
	public void setHighsalary(int highsalary) {
		this.highsalary = highsalary;
	}
	
	
}
