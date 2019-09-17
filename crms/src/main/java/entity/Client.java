package entity;

public class Client {

	private int id;
	private String name;
	private int sex;
	private String tel;
	private String qq;
	private String email;
	private String address;
	private String infos;
	private int linkstatu;
	private int clientstatu;
	private int purposestatu;
	private int assessstatu;
	private int execstatu;
	private int statu;
	
	private int clienttypeid;
	private String userids;
	private int createuserid;
	private String createdate; 
	private int srcid;
	private int count;
	private String comments;

	public static String[] sexs= {"男","女"};
	public static String[] linkstatus= {"未指定","秒挂","未接通","有交流","有深入交流"};
	public static String[] clientstatus= {"未指定","排斥","推脱","有后续","较好"};
	public static String[] purposestatus= {"未指定","N","C","B","A","Y"};
	public static String[] assessstatus= {"未指定","截止","无果","有预约"};
	public static String[] execstatus= {"正常","转出","完成"};
	public static String[] status= {"正常","公共","资料不齐","无效"};
	 
	private String clienttypename;//外键
	private String srcname;
	private String createusername;
	
	public String getClienttypename() {
		return clienttypename;
	}
	public String getCreateusername() {
		return createusername;
	}
	public String getSrcname() {
		return srcname;
	}
	
	public String getSexname() {
		return sexs[sex];
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getInfos() {
		return infos;
	}

	public void setInfos(String infos) {
		this.infos = infos;
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

	public int getClienttypeid() {
		return clienttypeid;
	}

	public void setClienttypeid(int clienttypeid) {
		this.clienttypeid = clienttypeid;
	}

	public String getUserids() {
		return userids;
	}

	public void setUserids(String userids) {
		this.userids = userids;
	}

	public int getCreateuserid() {
		return createuserid;
	}

	public void setCreateuserid(int createuserid) {
		this.createuserid = createuserid;
	}

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	public int getSrcid() {
		return srcid;
	}

	public void setSrcid(int srcid) {
		this.srcid = srcid;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
	
}
