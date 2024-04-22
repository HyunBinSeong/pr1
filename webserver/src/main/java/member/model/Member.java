package member.model;

import java.util.Date;

public class Member {

	private String id;
	private String password;
	private String name;
	private String juminfirst;
	private String juminsecond;
	private String phone1;
	private String phone2;
	private String phone3;
	private String adress;
	private String email;
	private int point;
	private int 내계좌;
	private Date regDate;

	public Member(String id, String password, String name, String juminfirst, String juminsecond, String phone1,
			String phone2, String phone3, String adress, String email, int point, int 내계좌, Date regDate) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.juminfirst = juminfirst;
		this.juminsecond = juminsecond;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.phone3 = phone3;
		this.adress = adress;
		this.email = email;
		this.point = point;
		this.내계좌 = 내계좌;
		this.regDate = regDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJuminfirst() {
		return juminfirst;
	}

	public void setJuminfirst(String juminfirst) {
		this.juminfirst = juminfirst;
	}

	public String getJuminsecond() {
		return juminsecond;
	}

	public void setJuminsecond(String juminsecond) {
		this.juminsecond = juminsecond;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getPhone3() {
		return phone3;
	}

	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int get내계좌() {
		return 내계좌;
	}

	public void set내계좌(int 내계좌) {
		this.내계좌 = 내계좌;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

}