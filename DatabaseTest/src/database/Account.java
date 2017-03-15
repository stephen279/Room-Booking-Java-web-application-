package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
   //  Will return info to controller For logging in,creating and checking if account already exists.
public class Account {

	private Connection con;

	public Account(Connection con) {
		this.con = con;

	}

	public boolean login(String email, String password) throws SQLException {

		System.out.println("inside account.login");

		String sql = " SELECT count(*)as count FROM zs_cos1 WHERE EMAIL=? and password=? ";

		PreparedStatement stmt1 = con.prepareStatement(sql);

		stmt1.setString(1, email);
		stmt1.setString(2, password);

		ResultSet rs = stmt1.executeQuery();
		int count = 0;

		System.out.println("inside account.login after ResultSet rs call");

		if (rs.next()) {

			// System.out.println("<BR>Name=" + rs.getString("email") + " "
			// + rs.getString("password"));

			count = rs.getInt("count");
			// count = 1;
		}
		rs.close();

		if (count == 0) {
			System.out.println("count == 0 so returned false");

			return false;
		} else {
			System.out.println("count == 1 so returned true");
			return true;
		}

	}

	public void create(String email, String password) throws SQLException {

		System.out.println("inside account.create");

		String sql = " INSERT  INTO zs_cos1 (cos_id,EMAIL , PASSWORD) values (mid.nextval,?,?) ";

		PreparedStatement stmt = con.prepareStatement(sql);

		stmt.setString(1, email);
		stmt.setString(2, password);

		stmt.executeUpdate();
		stmt.close();

	}

	public boolean exists(String email) throws SQLException {

		System.out.println("inside Account.exists()");

		String sql = " SELECT count(*)as count FROM zs_cos1 WHERE EMAIL=? ";

		System.out.println("sql = " + sql + "");

		PreparedStatement stmt1 = con.prepareStatement(sql);

		stmt1.setString(1, email);

		ResultSet rs = stmt1.executeQuery();
		System.out.println("stml1 = " + stmt1 + "");
		int count = 0;

		System.out.println("inside account.exists after ResultSet rs call");

		if (rs.next()) {

			count = rs.getInt("count");

		}
		rs.close();

		if (count == 0) {
			System.out.println("count == 0 so returned false");

			return false;
		} else {
			System.out.println("count == 1 so returned true");
			return true;
		}

	}

	/*public boolean search(String location) throws SQLException {

		System.out.println("inside Account.search()");

		String sql = " SELECT roo_id FROM SH279_USERS WHERE location=cavan ";

		System.out.println("sql = " + sql + "");

		PreparedStatement stmt1 = con.prepareStatement(sql);

		stmt1.setString(1, location);

		ResultSet rs = stmt1.executeQuery();
		int count = 0;

		System.out.println("sql = " + sql + "");

		if (rs.next()) {

			count = rs.getInt("count");

		}
		rs.close();

		if (count == 0) {
			System.out.println("count == 0 so returned false");

			return false;
		} else {
			System.out.println("count == 1 so returned true");
			return true;
		}

	}*/

}