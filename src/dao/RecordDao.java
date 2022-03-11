package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.*;

public class RecordDao {
	public boolean addRecord(Record record) throws Exception {
		Connection connection = Database.getConnection();
		String sqlString="insert into record values(?,?,?)";
		String sqString2="update student set total=total+1,attendance=attendance+? where student_id=?";
		PreparedStatement pStatement=connection.prepareStatement(sqlString);
		PreparedStatement pStatement2=connection.prepareStatement(sqString2);
		int x = "attend".equals(record.getAttend()) ? 1:0;
		Student student=new Student(record.getId());
		StudentDao studentDao=new StudentDao();
		if(!studentDao.search(student).equals(null)) {
		try {
			pStatement.setString(1,record.getId());
			pStatement.setDate(2, record.getDate());
			pStatement.setString(3, record.getAttend());
			if(pStatement.executeUpdate()>0) {
				pStatement2.setInt(1, x);
				pStatement2.setString(2, record.getId());
				pStatement2.executeUpdate();
				connection.commit();
				return true;
			}
			return false;
		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}
		
		}
		return false;
	}
	public List<Record> listRecord(Record record) {
		Connection connection = Database.getConnection();
		List<Record> list=new ArrayList<Record>();
		PreparedStatement pStatement;
		try {
			if ("".equals(record.getId())&record.getDate()==null) {
				pStatement=connection.prepareStatement("select * from record");
			}
			else {
				if ("".equals(record.getId())) {
					pStatement=connection.prepareStatement("select * from record where class_date=?");
					pStatement.setDate(1, record.getDate());
				}
				else if (record.getDate()==null) {
					pStatement=connection.prepareStatement("select * from record where student_id=?");
					pStatement.setString(1, record.getId());
				}
				else {
					pStatement=connection.prepareStatement("select * from record where(student_id=? and class_date=?)");
					pStatement.setString(1,record.getId());
					pStatement.setDate(2, record.getDate());
				}
			}
			ResultSet rs=pStatement.executeQuery();
			while (rs.next()) {
				Record record1 = new Record(rs.getString("student_id"), rs.getDate("class_date"),rs.getString("attend"));
				list.add(record1);
			}
			
			connection.close();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public void clear() throws Exception {
		Connection connection=Database.getConnection();
		String sqlString="delete from record";
		PreparedStatement pStatement=connection.prepareStatement(sqlString);
		pStatement.executeUpdate();
		connection.commit();
	}
	public boolean updateRecord(Record record) throws Exception{
		

		Connection connection = Database.getConnection();
		String sqlString="update record set attend=? where student_id=? and class_date=?";
		try {
			PreparedStatement pStatement=connection.prepareStatement(sqlString);
			pStatement.setString(1, record.getAttend());
			pStatement.setString(2, record.getId());
			pStatement.setDate(3, record.getDate());
			if(pStatement.executeUpdate()>0) {
				connection.commit();
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		finally {
			connection.close();
		}
		return false;
	}
	public List<countByDate> countByDates() {
		Connection connection = Database.getConnection();
		List<countByDate>countList=new ArrayList<countByDate>();
		String sqString = "select class_date,count(*) as count from record where attend='1' group by class_date ";
		try {
			PreparedStatement sPreparedStatement=connection.prepareStatement(sqString);
			ResultSet rs = sPreparedStatement.executeQuery();
			while (rs.next()) {
				countByDate couRecord = new countByDate(rs.getInt("count"), rs.getDate("class_date"));
				countList.add(couRecord);
			}
			return countList;
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return null;
		
	}
	public class countByDate{
		public int count;
		public Date date;
		public countByDate(int count, Date date) {
			super();
			this.count = count;
			this.date = date;
		}
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		
		
	}
}
