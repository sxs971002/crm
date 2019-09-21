package entity;

public class Revisit {

	private int id;
	private int clientid;
	private String date;
	
	private int linkstatu;
	private int clientstatu;
	private int purposestatu;
	private int assessstatu;
	private int execstatu;
	private int statu;
	
	
	private String askinfo;
	private String followinfo; 
	private String probleminfo;
	private String comments;

	public static String[] linkstatus= {"秒挂","未接通","有交流","有深入交流"};
	public static String[] clientstatus= {"排斥","推脱","有后续","较好"};
	public static String[] purposestatus= {"N","C","B","A","Y"};
	public static String[] assessstatus= {"截止","无果","有预约"};
	public static String[] execstatus= {"正常","转出","完成"};
	public static String[] status= {"正常","隐藏"};
	 
	private String clientname;//外键
	
	public String getClientname() {
		return clientname;
	}
	
	public String getLinkstatuname() {
		return linkstatus[linkstatu];
	}
	public String getClientstatuname() {
		return clientstatus[clientstatu];
	}
	public String getPurposestatuname() {
		return purposestatus[purposestatu];
	}
	public String getAssessstatuname() {
		return assessstatus[assessstatu];
	}
	public String getExecstatuname() {
		return execstatus[execstatu];
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

	public int getClientid() {
		return clientid;
	}

	public void setClientid(int clientid) {
		this.clientid = clientid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAskinfo() {
		return askinfo;
	}

	public void setAskinfo(String askinfo) {
		this.askinfo = askinfo;
	}

	public String getFollowinfo() {
		return followinfo;
	}

	public void setFollowinfo(String followinfo) {
		this.followinfo = followinfo;
	}

	public String getProbleminfo() {
		return probleminfo;
	}

	public void setProbleminfo(String probleminfo) {
		this.probleminfo = probleminfo;
	}

	public int getLinkstatu() {
		return linkstatu;
	}

	public void setLinkstatu(int linkstatu) {
		this.linkstatu = linkstatu;
	}

	public int getClientstatu() {
		return clientstatu;
	}

	public void setClientstatu(int clientstatu) {
		this.clientstatu = clientstatu;
	}

	public int getPurposestatu() {
		return purposestatu;
	}

	public void setPurposestatu(int purposestatu) {
		this.purposestatu = purposestatu;
	}

	public int getAssessstatu() {
		return assessstatu;
	}

	public void setAssessstatu(int assessstatu) {
		this.assessstatu = assessstatu;
	}

	public int getExecstatu() {
		return execstatu;
	}

	public void setExecstatu(int execstatu) {
		this.execstatu = execstatu;
	}

	public int getStatu() {
		return statu;
	}

	public void setStatu(int statu) {
		this.statu = statu;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
}
