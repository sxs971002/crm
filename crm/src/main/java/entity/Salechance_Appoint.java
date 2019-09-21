package entity;

import java.util.Date;

public class Salechance_Appoint {

	private int id;
	private int salechance_id;
	private int userid;
	private Date appoint_time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSalechance_id() {
		return salechance_id;
	}
	public void setSalechance_id(int salechance_id) {
		this.salechance_id = salechance_id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public Date getAppoint_time() {
		return appoint_time;
	}
	public void setAppoint_time(Date appoint_time) {
		this.appoint_time = appoint_time;
	}
	
	
}
