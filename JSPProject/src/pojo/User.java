package pojo;

public class User {
	private Integer u_id;
	private String name;
	private String pass;

	public User() {

	}

	public User(Integer u_id, String name, String pass) {
		this.u_id = u_id;
		this.name = name;
		this.pass = pass;
	}

	public Integer getU_id() {
		return u_id;
	}

	public void setU_id(Integer u_id) {
		this.u_id = u_id;
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

}
