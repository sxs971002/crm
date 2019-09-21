package entity;

public class User {

	private int id;
	private String name;
	private String pass;
	private String tel;
	private int sex;
	private int statu;
	private int power;
	private int groupid;
	public static String[] sexs= {"男","女"};
	public static String[] status= {"正常","禁用"};
	public static String[] powers= {"管理员","组长","组员"};
	private String groupname;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User (String tel, String pass) {
		this.tel = tel;
		this.pass = pass;
	}
	public String getGroupname() {
		return groupname;
	}
	public String getPowername() {
		return powers[power];
	}
	public String getStatuname() {
		return status[statu];
	}
	public String getSexname() {
		return sexs[sex];
	}
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
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getStatu() {
		return statu;
	}
	public void setStatu(int statu) {
		this.statu = statu;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public int getGroupid() {
		return groupid;
	}
	public void setGroupid(int groupid) {
		this.groupid = groupid;
	}
	
}
