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

	public static String[] linkstatus= {"���","δ��ͨ","�н���","�����뽻��"};
	public static String[] clientstatus= {"�ų�","����","�к���","�Ϻ�"};
	public static String[] purposestatus= {"N","C","B","A","Y"};
	public static String[] assessstatus= {"��ֹ","�޹�","��ԤԼ"};
	public static String[] execstatus= {"����","ת��","���"};
	public static String[] status= {"����","����"};
	 
	private String clientname;//���
	
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
	
	//�ֽ���
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
