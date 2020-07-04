package com.roche.rest_demo_jaxrs;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class PersonRepository {

	Connection con = null;
	
	public PersonRepository() {
		
		String url = "jdbc:mysql://localhost:3306/prueba?serverTimezone=UTC";
		String username = "root";
		String password = "pass";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
	}
	
	public List<Person> getPersons(){
		
		List<Person> persons = new ArrayList<>();
		String sql = "select * from person";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				Person person = new Person();
				person.setId(rs.getInt(1));
				person.setName(rs.getString(2));
				person.setAge(rs.getInt(3));
				
				persons.add(person);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return persons;
	}
	
	public Person getPerson(int id) {

		String sql = "select * from person where id="+id;
		Person person = new Person();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				person.setId(rs.getInt(1));
				person.setName(rs.getString(2));
				person.setAge(rs.getInt(3));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return person;
	}
	
	public void create(Person person) {
		String sql = "insert into person values (?,?,?)";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, person.getId());
			st.setString(2, person.getName());
			st.setInt(3, person.getAge());
			st.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	public void update(Person person) {
		String sql = "update person set name=?, age=? where id=?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, person.getName());
			st.setInt(2, person.getAge());
			st.setInt(3, person.getId());
			
			st.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void delete(int id) {
		String sql = "delete from person where id=?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			
			st.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
