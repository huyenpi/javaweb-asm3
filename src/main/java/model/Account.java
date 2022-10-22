package model;

public class Account {
	private String usr, pwd;
	private int role;
	private String email="", address, phone;
	private int check;

	public Account() {
	}

	public Account(String usr, String pwd, int role, String email, String address, String phone, int check) {
		this.usr = usr;
		this.pwd = pwd;
		this.role = role;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.check = check;
	}

	public String getUsr() {
		return usr;
	}

	public void setUsr(String usr) {
		this.usr = usr;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getCheck() {
		return check;
	}

	public void setCheck(int check) {
		this.check = check;
	}

}
