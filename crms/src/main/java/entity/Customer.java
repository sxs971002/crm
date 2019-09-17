package entity;

public class Customer {

	private int id;
	private String cusname;
	private int cussex;
	private String custel;
	private String cusaddress;
	private int cuslevelid;
	public static String[] sexs= {"男","女"};
	private String cuslevelname;
	
	public String getCussexname() {
		return sexs[cussex];
	}
	public String getCuslevelname() {
		return cuslevelname;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCusname() {
		return cusname;
	}
	public void setCusname(String cusname) {
		this.cusname = cusname;
	}
	public int getCussex() {
		return cussex;
	}
	public void setCussex(int cussex) {
		this.cussex = cussex;
	}
	public String getCustel() {
		return custel;
	}
	public void setCustel(String custel) {
		this.custel = custel;
	}
	public String getCusaddress() {
		return cusaddress;
	}
	public void setCusaddress(String cusaddress) {
		this.cusaddress = cusaddress;
	}
	public int getCuslevelid() {
		return cuslevelid;
	}
	public void setCuslevelid(int cuslevelid) {
		this.cuslevelid = cuslevelid;
	}
	
}
