package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.bean.Job;

public class JobDAO extends BaseDAO {

	public List<Job> getListJob() {
		// TODO get list jobs from database
		
		// connect to database
		Connection conn = this.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from job";
		List<Job> listJobs = new ArrayList<>();
		Job job = null;
		
		try {
			// execute
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			// get data
			while (rs.next()) {
				job = new Job();
				job.setId(rs.getInt(1));
				job.setTitle(rs.getString(2));
				job.setStatus(rs.getBoolean(3));
				listJobs.add(job);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeConnection(conn, pstmt, rs);
		}
		
		return listJobs;
	}

	public void createJob(String title) {
		// TODO insert job to database
		
		// connect to database
		Connection conn = this.getConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into job(title, stt) values(?, 0)";
		
		try {
			// execute
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeConnection(conn, pstmt, null);
		}
	}

	public void deleteJob(int id) {
		// TODO delete job in database
		
		// connect to database
		Connection conn = this.getConnection();
		PreparedStatement pstmt = null;
		String sql = "delete from job where id=?";
		
		try {
			// execute
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeConnection(conn, pstmt, null);
		}
		
	}

	public Job getJobById(int id) {
		// TODO get job by id from database

		// connect to database
		Connection conn = this.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from job where id=?";
		Job job = null;
		
		try {
			// execute
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			// get data
			if (rs.next()) {
				job = new Job();
				job.setId(rs.getInt(1));
				job.setTitle(rs.getString(2));
				job.setStatus(rs.getBoolean(3));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeConnection(conn, pstmt, rs);
		}
		
		return job;
	}

	public void updateJob(int id, String title) {
		// TODO update job in database
		
		// connect to database
		Connection conn = this.getConnection();
		PreparedStatement pstmt = null;
		String sql = "update job set title=? where id=?";
		
		try {
			// execute
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setInt(2, id);
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeConnection(conn, pstmt, null);
		}
	}

	public void doneJob(int id) {
		// TODO update job done
		
		// connect to database
		Connection conn = this.getConnection();
		PreparedStatement pstmt = null;
		String sql = "update job set stt=1 where id=?";
		
		try {
			// execute
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeConnection(conn, pstmt, null);
		}
	}

}
