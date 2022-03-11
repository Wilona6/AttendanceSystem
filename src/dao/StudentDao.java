package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.*;
public class StudentDao {
	public boolean val_student(Student student)throws Exception {
		Connection connection=Database.getConnection();
		String sqlString="select * from student where(student_id=? and student_password=?)";
		try {
			PreparedStatement pStatement=connection.prepareStatement(sqlString);
			pStatement.setString(1, student.getId());
			pStatement.setString(2,student.getPwd());
			ResultSet rs= pStatement.executeQuery();
			if(rs.next()){
				return true;
			}
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			connection.close();
		}
	}
	public Student search(Student student) throws SQLException {
		
		Connection connection=Database.getConnection();
		PreparedStatement preparedStatement;
		if(student.getId().equals("")) {
			preparedStatement = connection.prepareStatement("select * from student");
		}
		else {
			preparedStatement=connection.prepareStatement("select * from student where student_id=?");
			preparedStatement.setString(1,student.getId());
		}
		try {
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()) {
				Student student2 = new Student(rs.getString("student_id"), rs.getString("student_password"), 
						rs.getInt("attendance"), rs.getInt("total"));
				return student2;
			}
			return null;
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return null;
	}
	public boolean addStu(Student student) throws Exception{
		Connection connection=Database.getConnection();
		String sqlString="insert into student(student_id,student_password) values(?,?)";
		try {
			PreparedStatement sPreparedStatement=connection.prepareStatement(sqlString);
			sPreparedStatement.setString(1,student.getId());
			sPreparedStatement.setString(2, student.getPwd());
			if(sPreparedStatement.executeUpdate()>0) {
				connection.commit();
				return true;
			}
		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}
		finally {
			connection.close();
		}
		return false;
	}
}
