package model;

import java.sql.Date;

public class Record {
	private String id;
	private Date date;
	private String attend;
	
	public Record(String id) {
		super();
		this.id = id;
	}
	public Record(String id, Date date, String attend) {
		super();
		this.id = id;
		this.date = date;
		this.attend = attend;
	}
	
	public Record(String id, Date date) {
		super();
		this.id = id;
		this.date = date;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getAttend() {
		return attend;
	}
	public void setAttend(String attend) {
		this.attend = attend;
	}
	
}
