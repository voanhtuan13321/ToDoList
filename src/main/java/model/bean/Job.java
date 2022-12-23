package model.bean;

public class Job {
	private int id;
	private String title;
	private boolean status; // 0 - working, 1 - done

	public Job(int id, String title, boolean status) {
		super();
		this.id = id;
		this.title = title;
		this.status = status;
	}

	public Job() {
		super();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id + "-" + title;
	}
}
