package Database.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Database.Connection.ConnectionFactory;
import Database.Models.User;

public class UserDAO {
	//comandos DML CRUD
	private final Connection connection;
	public UserDAO() {
		ConnectionFactory connection = new ConnectionFactory();
		this.connection = connection.conectar();
	}
	
	//insert
	public void insert(User user) throws SQLException {
		String sql = "INSERT INTO USUARIOS(NAME, EMAIL, SENHA, DATAREGISTRO) VALUES(?, ?, ?, ?)";
		
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(2, user.getName());
		stmt.setString(3, user.getEmail());
		stmt.setString(4, user.getPassword());
		stmt.setDate(5, user.getRegisterDate());
		
		stmt.execute();
		stmt.close();
	}
	
	//delete
	public void delete(Long id) {
		String sql = "DELETE FROM USUARIOS WHERE ID=?";
		try {
		    PreparedStatement stmt = connection.prepareStatement(sql);
		    stmt.setLong(1, id);

		    stmt.execute();
		    stmt.close();
		} catch (SQLException e) {
		    e.printStackTrace();
		}
    	}
	
	//update
	public void update(User user) {
		String sql = "UPDATE USUARIOS SET NAME=?, EMAIL=?, SENHA=? WHERE ID=?";

		try {	
		    PreparedStatement stmt = connection.prepareStatement(sql);

		    stmt.setString(1, user.getName());
		    stmt.setString(2, user.getEmail());
		    stmt.setString(3, user.getPassword());
		    stmt.setLong(4, user.getId());

		    stmt.execute();
		    stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// selectALL
	public List<User> selectAll() throws SQLException {
		List<User> users = new ArrayList<User>();
		String sql = "SELECT * FROM USUARIOS";
		PreparedStatement stmt = connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			User user = new User();
			user.setId(rs.getLong("ID"));
			user.setName(rs.getString("NAME"));
			user.setEmail(rs.getString("EMAIL"));
			user.setPassword(rs.getString("SENHA"));
			user.setRegisterDate(rs.getDate("DATAREGISTRO"));

			users.add(user);
		}
		rs.close();
		stmt.close();
		return users;
	}
	
	// selectById
	public User selectById(Long id) throws SQLException {
		User user = null;
		String sql = "SELECT * FROM USUARIOS WHERE ID=?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setLong(1, id);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			user = new User();
			user.setId(rs.getLong("ID"));
			user.setName(rs.getString("NAME"));
			user.setEmail(rs.getString("EMAIL"));
			user.setPassword(rs.getString("SENHA"));
			user.setRegisterDate(rs.getDate("DATAREGISTRO"));
		}

		rs.close();
		stmt.close();
		return user;
	}
}
