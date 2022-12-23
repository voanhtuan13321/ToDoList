package model.bo;

import java.util.List;

import model.bean.Job;
import model.dao.JobDAO;

public class JobBO {
	
	private JobDAO jobDao = new JobDAO();

	public List<Job> getListJob() {
		// TODO Auto-generated method stub
		return jobDao.getListJob();
	}

	public void createJob(String title) {
		// TODO Auto-generated method stub
		jobDao.createJob(title);
	}

	public void deleteJob(int id) {
		// TODO Auto-generated method stub
		jobDao.deleteJob(id);
	}

	public Job getJobById(int id) {
		// TODO Auto-generated method stub
		return jobDao.getJobById(id);
	}

	public void updateJob(int id, String title) {
		// TODO Auto-generated method stub
		jobDao.updateJob(id, title);
	}

	public void doneJob(int id) {
		// TODO Auto-generated method stub
		jobDao.doneJob(id);
	}

}
