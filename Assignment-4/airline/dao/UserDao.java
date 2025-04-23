package com.airline.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.airline.entity.User;
import com.airline.util.JdbcUtils;



public class UserDao 
{
	private String query;
	public void save(User user) {
		query = "insert into user(user_name, user_email, user_password) values(?,?,?);";
		try(
				Connection con =JdbcUtils.getDbConnection();
				PreparedStatement pstm =  con.prepareStatement(query);
				){
					pstm.setString(1, user.getName());
					pstm.setString(2, user.getEmail());
					pstm.setString(3, user.getPassword());
					
					int count = pstm.executeUpdate();
					if(count > 0) {
						System.out.println(count +"Row inserted...");
//						status = true;
					}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
}
	
	public List<User> findAll(){
		List<User> users = new ArrayList<User>();
		query = "select * from user;";
		try(
				Connection con =JdbcUtils.getDbConnection();
				Statement stm = con.createStatement();
				){
					ResultSet rs = stm.executeQuery(query);
					while(rs.next()) {
						users.add(new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
					}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return users;
	}
	
	public User searchUserByEmailAndPassword(String email, String password) {
		User foundUser = null;
		query = "select * from user where user_email = ? and user_password = ?";
		try(
				Connection con =JdbcUtils.getDbConnection();
				PreparedStatement pstm =  con.prepareStatement(query);
				){
			pstm.setString(1, email);
			pstm.setString(2, password);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				foundUser = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return foundUser;
	}
}
