package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.*;
public class TeacherDao {
	public boolean valTeacher(Teacher teacher) throws Exception{
		Connection conn=Database.getConnection();
		String sqlString = "select * from teacher where(teacher_id=? and teacher_password=?)";
			PreparedStatement pstmt=conn.prepareStatement(sqlString);
			try {
				pstmt.setString(1,teacher.getName());
				pstmt.setString(2,teacher.getPwd());
				ResultSet rs=pstmt.executeQuery();
				System.out.println(pstmt);
				if(rs.next()){
					return true;
				}
					return false;
			}
			catch(SQLException e) {
				e.printStackTrace();
				return false;
			}
			finally {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
}
