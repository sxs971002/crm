package entity;

public class Order {

	private int id;
	private String clientid;
	private String createdate;
	private String performdate;
	private String orderdate;
	private String startdate;
	private String enddate;
	private int createuserid;
	private String infos;
	private String files;
	private String performuserids;
	private String performusernames;
	private String performweight;
	private int statu;
	private double totalprice;
	private String comments;
	
	public static String[] status= {"未审核","已审核","暂缓业绩","作废"};
	 
	private String clientname;//外键
	private String createusername;
	
	public String getClientname() {
		return clientname;
	}
	public String getCreateusername() {
		return createusername;
	}
	
	public String getStatuname() {
		return status[statu];
	}
	
	//分界线
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClientid() {
		return clientid;
	}
	public void setClientid(String clientid) {
		this.clientid = clientid;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	public String getPerformdate() {
		return performdate;
	}
	public void setPerformdate(String performdate) {
		this.performdate = performdate;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public int getCreateuserid() {
		return createuserid;
	}
	public void setCreateuserid(int createuserid) {
		this.createuserid = createuserid;
	}
	public String getInfos() {
		return infos;
	}
	public void setInfos(String infos) {
		this.infos = infos;
	}
	public String getFiles() {
		return files;
	}
	public void setFiles(String files) {
		this.files = files;
	}
	public String getPerformuserids() {
		return performuserids;
	}
	public void setPerformuserids(String performuserids) {
		this.performuserids = performuserids;
	}
	public String getPerformweight() {
		return performweight;
	}
	public void setPerformweight(String performweight) {
		this.performweight = performweight;
	}
	public int getStatu() {
		return statu;
	}
	public void setStatu(int statu) {
		this.statu = statu;
	}
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getPerformusernames() {
		return performusernames;
	}
	public void setPerformusernames(String performusernames) {
		this.performusernames = performusernames;
	}
	
	
}
