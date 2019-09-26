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
	private String usernames;
	private int createuserid;
	private String createdate; 
	private int srcid;
	private int count;
	private String comments;

	public static String[] sexs= {"��","Ů"};
	public static String[] linkstatus= {"δָ��","���","δ��ͨ","�н���","�����뽻��"};
	public static String[] clientstatus= {"δָ��","�ų�","����","�к���","�Ϻ�"};
	public static String[] purposestatus= {"δָ��","N","C","B","A","Y"};
	public static String[] assessstatus= {"δָ��","��ֹ","�޹�","��ԤԼ"};
	public static String[] execstatus= {"����","ת��","���"};
	public static String[] status= {"����","����","���ϲ���","��Ч"};
	 
	
	
	private int uploadstatus=0;  // 0δ�ϴ�  1�ɹ�  2ʧ��
	public String getUploadstatusname() {
		return uploadstatus==0?"δ�ϴ�":"�ɹ�";
	}
	public int getUploadstatus() {
		return uploadstatus;
	}
	public void setUploadstatus(int uploadstatus) {
		this.uploadstatus = uploadstatus;
	}
	
	private String clienttypename;//���
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
	
	//�ֽ���
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
	public String getUsernames() {
		return usernames;
	}
	public void setUsernames(String usernames) {
		this.usernames = usernames;
	}
	
	
	
}
