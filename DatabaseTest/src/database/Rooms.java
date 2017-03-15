package database;
   // creates new room in zs_roo1 table
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Rooms {
	private Connection con;

	public Rooms(Connection con) {
		this.con = con;

	}

	public void create(String userName, String costumerName, String location,
			String roomSize, String roomPrice, String contact)
			throws SQLException {

		System.out.println("inside Rooms.create");

		String sql = "  INSERT  INTO zs_roo1 (roo_id,userName , costumerName , location,roomSize,roomPrice,contact) values (Rid.nextval,?,?,?,?,?,?)";
		
		PreparedStatement stmt = con.prepareStatement(sql);

		stmt.setString(1, userName);
		stmt.setString(2, costumerName);
		stmt.setString(3, location);
		stmt.setString(4, roomSize);
		stmt.setString(5, roomPrice);
		stmt.setString(6, location);
		stmt.executeUpdate();
		stmt.close();

	}
	
}
