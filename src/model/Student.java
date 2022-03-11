package model;

public class Student {
	private String id;
	private String pwd;
	private int attend_num;
	private int total_num;
	
	public Student(String id) {
		super();
		this.id = id;
	}
	public Student(String id, String pwd) {
		super();
		this.id = id;
		this.pwd = pwd;
	}
	public Student(String id, String pwd, int attend_num, int total_num) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.attend_num = attend_num;
		this.total_num = total_num;
	}
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getAttend_num() {
		return attend_num;
	}
	public void setAttend_num(int attend_num) {
		this.attend_num = attend_num;
	}
	public int getTotal_num() {
		return total_num;
	}
	public void setTotal_num(int total_num) {
		this.total_num = total_num;
	}
	
}
