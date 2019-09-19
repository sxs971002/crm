package entity;

import java.util.Date;

public class Reserve {

	private int id;
	private int revisitid;
	private int clientid;
	private String createdate = new Date().toString();
	private int userid;
	private String date;
	private int execuserid;
	private int type;
	private int statu;
	private int execstatu;
	private String result;
	
	public static String[] types = {"回访预约","上门预约"};
	public static String[] status = {"未处理","已处理"};
	public static String[] execstatus = {"正常","违约","延期","下次继续"};
	
	public String getTypename() {
		return types[type];
	}
	public String getStatuname() {
		return status[statu];
	}
	public String getExecstatuname() {
		return execstatus[execstatu];
	}
	
	private String username;//外键
	private String execusername;
	private String clientname;
	
	public String getUsername() {
		return username;
	}
	public String getExecusername() {
		return execusername;
	}
	public String getClientname() {
		return clientname;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRevisitid() {
		return revisitid;
	}
	public void setRevisitid(int revisitid) {
		this.revisitid = revisitid;
	}
	public int getClientid() {
		return clientid;
	}
	public void setClientid(int clientid) {
		this.clientid = clientid;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getExecuserid() {
		return execuserid;
	}
	public void setExecuserid(int execuserid) {
		this.execuserid = execuserid;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getStatu() {
		return statu;
	}
	public void setStatu(int statu) {
		this.statu = statu;
	}
	public int getExecstatu() {
		return execstatu;
	}
	public void setExecstatu(int execstatu) {
		this.execstatu = execstatu;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	
}
