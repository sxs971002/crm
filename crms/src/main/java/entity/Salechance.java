package entity;

import java.util.Date;

public class Salechance {

	private int id;
	private String chance_form;
	private int chance_cusid;
	private int chance_statusid;
	private Date chance_createtime;
	private String cusname;
	private String statusname;
	
	
	public String getCusname() {
		return cusname;
	}
	public String getStatusname() {
		return statusname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getChance_form() {
		return chance_form;
	}
	public void setChance_form(String chance_form) {
		this.chance_form = chance_form;
	}
	public int getChance_cusid() {
		return chance_cusid;
	}
	public void setChance_cusid(int chance_cusid) {
		this.chance_cusid = chance_cusid;
	}
	public int getChance_statusid() {
		return chance_statusid;
	}
	public void setChance_statusid(int chance_statusid) {
		this.chance_statusid = chance_statusid;
	}
	public Date getChance_createtime() {
		return chance_createtime;
	}
	public void setChance_createtime(Date chance_createtime) {
		this.chance_createtime = chance_createtime;
	}
	
	
}
