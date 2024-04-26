package in.bj.Search;


public class Search {
	private String PlanName;
	private String planStatus;
	private String Gender;
	private String StartDate;
	private String EndDate;
	public String getPlanName() {
		return PlanName;
	}
	public void setPlanName(String planName) {
		PlanName = planName;
	}
	public String getPlanStatus() {
		return planStatus;
	}
	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getStartDate() {
		return StartDate;
	}
	public void setStartDate(String startDate) {
		StartDate = (String) startDate;
	}
	public String getEndDate() {
		return EndDate;
	}
	public void setEndDate(String endDate) {
		EndDate = endDate;
	}
	public Search(String planName, String planStatus, String gender, String startDate, String endDate) {
		super();
		PlanName = planName;
		planStatus = planStatus;
		Gender = gender;
		StartDate = startDate;
		EndDate = endDate;
	}
	public Search() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
