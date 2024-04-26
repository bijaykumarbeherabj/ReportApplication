package in.bj.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Citizen_Info")
public class Citizen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int citizenId;
private String citizenName;
private String citizenGender;
private String plan_Name;
private String plan_Status;
private LocalDate Plan_StartDate;
private LocalDate Plan_EndDate;
private String benefit_Amount;
private String denial_Reason;
private LocalDate terminated_Date;
private String termination_Reason;
public int getCitizenId() {
	return citizenId;
}
public void setCitizenId(int citizenId) {
	citizenId = citizenId;
}
public String getCitizenName() {
	return citizenName;
}
public void setCitizenName(String citizenName) {
	citizenName = citizenName;
}
public String getCitizenGender() {
	return citizenGender;
}
public void setCitizenGender(String citizenGender) {
	citizenGender = citizenGender;
}
public String getPlan_Name() {
	return plan_Name;
}
public void setPlan_Name(String plan_Name) {
	plan_Name = plan_Name;
}
public String getPlan_Status() {
	return plan_Status;
}
public void setPlan_Status(String plan_Status) {
	plan_Status = plan_Status;
}
public LocalDate getPlan_StartDate() {
	return Plan_StartDate;
}
public void setPlan_StartDate(LocalDate date) {
	Plan_StartDate = date;
}
public LocalDate getPlan_EndDate() {
	return Plan_EndDate;
}
public void setPlan_EndDate(LocalDate localDate) {
	Plan_EndDate = localDate;
}
public String getBenefit_Amount() {
	return benefit_Amount;
}
public void setBenefit_Amount(String benefit_Amount) {
	benefit_Amount = benefit_Amount;
}
public String getDenial_Reason() {
	return denial_Reason;
}
public void setDenial_Reason(String denial_Reason) {
	denial_Reason = denial_Reason;
}
public LocalDate getTerminated_Date() {
	return terminated_Date;
}
public void setTerminated_Date(LocalDate localDate) {
	terminated_Date = localDate;
}
public String getTermination_Reason() {
	return termination_Reason;
}
public void setTermination_Reason(String termination_Reason) {
	termination_Reason = termination_Reason;
}
public Citizen(int citizenId, String citizenName, String citizenGender, String plan_Name, String plan_Status,
		LocalDate plan_StartDate, LocalDate plan_EndDate, String benefit_Amount, String denial_Reason, LocalDate terminated_Date,
		String termination_Reason) {
	super();
	citizenId = citizenId;
	citizenName = citizenName;
	citizenGender = citizenGender;
	plan_Name = plan_Name;
	plan_Status = plan_Status;
	Plan_StartDate = plan_StartDate;
	Plan_EndDate = plan_EndDate;
	benefit_Amount = benefit_Amount;
	denial_Reason = denial_Reason;
	terminated_Date = terminated_Date;
	termination_Reason = termination_Reason;
}
public Citizen() {
	super();
	// TODO Auto-generated constructor stub
}


}
