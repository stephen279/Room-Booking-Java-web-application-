package beans;
//User bean for adding new account and validation.
public class User {

	private String email = "";
	private String password = "";
	private String message = "Wrong userName or Password"; // message will be
															// returned if user
															// cant not validate

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public User() {

		// default constructor needed for bean
	}

	public User(String email, String password) {

		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getpassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean validate() {
		if (password.length() < 8) {

			message = "password not long enough";
			return false;
		}

		if (password == null) {

			message = "password cant be empty";
			return false;

		}

		if (email == null) {

			message = "password cant be empty";
			return false;

		}

		if (!email.matches("\\w+@\\w+\\.\\w+")) {

			message = "invalid email address";
			return false;
		}

		return true; // if everything validate ok return true
	}

}
