package com.sunbeam.daos;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sunbeam.pojos.User;

public class UserDaoImpl extends Dao implements UserDao {
	public UserDaoImpl() throws Exception {
	}
	public User findByEmail(String email) throws Exception {
		String sql = "SELECT * FROM users WHERE email=?";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, email);
			try(ResultSet rs = stmt.executeQuery()) {
				if(rs.next()) {
					int user_id = rs.getInt("user_id");
					String full_name = rs.getString("full_name");
					email = rs.getString("email");
					String password = rs.getString("password");
					String phone_no = rs.getString("phone_no");
					User u = new User(user_id, full_name, email, password, phone_no);
					return u;
				}
			} // rs.close();
		} // stmt.close();
		return null;
	}

	public int save(User user) throws Exception {
		String sql = "INSERT INTO users VALUES(default, ?, ?, ?, ?, now())";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, user.getFull_name());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getEmail());
			stmt.setString(4, user.getPassword());
			
			int cnt = stmt.executeUpdate();
			return cnt;
		} //stmt.close();
	}
}
	
	