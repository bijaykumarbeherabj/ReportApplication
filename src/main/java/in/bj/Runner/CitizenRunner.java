package in.bj.Runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import in.bj.Entity.Citizen;
import in.bj.Repository.CitizenRepo;

@Component
public class CitizenRunner implements ApplicationRunner {
	
	@Autowired
	private CitizenRepo Citizenrepo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Citizenrepo.deleteAll();
		
	Citizen c1=new Citizen();
	
	c1.setCitizenName("Bijay");
	c1.setCitizenGender("male");
	c1.setPlan_Name("cash");
	c1.setPlan_Status("Activated");
	c1.setPlan_StartDate(LocalDate.now());
	c1.setPlan_EndDate(LocalDate.now().plusMonths(6));
	c1.setBenefit_Amount("5000");
	
	
Citizen c2=new Citizen();
	
	c2.setCitizenName("Akash");
	c2.setCitizenGender("male");
	c2.setPlan_Name("cash");
	c2.setPlan_Status("denied");
	c2.setDenial_Reason("Rental Income");
	
Citizen c3=new Citizen();
	
	c3.setCitizenName("Chunni");
	c3.setCitizenGender("Female");
	c3.setPlan_Name("cash");
	c3.setPlan_Status("terminated");
	c3.setPlan_StartDate(LocalDate.now().minusMonths(4));
	c3.setPlan_EndDate(LocalDate.now().plusMonths(6));
	c3.setBenefit_Amount("5000");
	c3.setTerminated_Date(LocalDate.now());
	c3.setTermination_Reason("Employed");
		
	Citizen c4=new Citizen();
	
	c4.setCitizenName("Rupesh");
	c4.setCitizenGender("male");
	c4.setPlan_Name("Food");
	c4.setPlan_Status("Activated");
	c4.setPlan_StartDate(LocalDate.now());
	c4.setPlan_EndDate(LocalDate.now().plusMonths(6));
	c4.setBenefit_Amount("6000");
	
	
Citizen c5=new Citizen();
	
	c5.setCitizenName("Halu");
	c5.setCitizenGender("male");
	c5.setPlan_Name("Food");
	c5.setPlan_Status("denied");
	c5.setDenial_Reason("propertity Income");
	
Citizen c6=new Citizen();
	
	c6.setCitizenName("Jasoda");
	c6.setCitizenGender("Female");
	c6.setPlan_Name("Food");
	c6.setPlan_Status("terminated");
	c6.setPlan_StartDate(LocalDate.now().minusMonths(4));
	c6.setPlan_EndDate(LocalDate.now().plusMonths(6));
	c6.setBenefit_Amount("7000");
	c6.setTerminated_Date(LocalDate.now());
	c6.setTermination_Reason("Employed");
	
	Citizen c7=new Citizen();
	
	c7.setCitizenName("satya");
	c7.setCitizenGender("male");
	c7.setPlan_Name("Medical");
	c7.setPlan_Status("Activated");
	c7.setPlan_StartDate(LocalDate.now());
	c7.setPlan_EndDate(LocalDate.now().plusMonths(6));
	c7.setBenefit_Amount("5000");
	
	
Citizen c8=new Citizen();
	
	c8.setCitizenName("Vicky");
	c8.setCitizenGender("male");
	c8.setPlan_Name("medical");
	c8.setPlan_Status("denied");
	c8.setDenial_Reason("Govt job");
	
Citizen c9=new Citizen();
	
	c9.setCitizenName("Priya");
	c9.setCitizenGender("Female");
	c9.setPlan_Name("medical");
	c9.setPlan_Status("terminated");
	c9.setPlan_StartDate(LocalDate.now().minusMonths(4));
	c9.setPlan_EndDate(LocalDate.now().plusMonths(6));
	c9.setBenefit_Amount("5000");
	c9.setTerminated_Date(LocalDate.now());
	c9.setTermination_Reason("govt job");
		
		
	Citizen c10=new Citizen();
	
	c10.setCitizenName("Biswajit");
	c10.setCitizenGender("male");
	c10.setPlan_Name("Employ");
	c10.setPlan_Status("Activated");
	c10.setPlan_StartDate(LocalDate.now());
	c10.setPlan_EndDate(LocalDate.now().plusMonths(6));
	c10.setBenefit_Amount("5000");
	
	
Citizen c11=new Citizen();
	
	c11.setCitizenName("dada");
	c11.setCitizenGender("male");
	c11.setPlan_Name("Employ");
	c11.setPlan_Status("denied");
	c11.setDenial_Reason("Rental Income");
	
Citizen c12=new Citizen();
	
	c12.setCitizenName("Satadi");
	c12.setCitizenGender("Female");
	c12.setPlan_Name("Employ");
	c12.setPlan_Status("terminated");
	c12.setPlan_StartDate(LocalDate.now().minusMonths(4));
	c12.setPlan_EndDate(LocalDate.now().plusMonths(6));
	c12.setBenefit_Amount("5000");
	c12.setTerminated_Date(LocalDate.now());
	c12.setTermination_Reason("govt job");
		
	
	 List list=Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12);
	 
	 Citizenrepo.saveAll(list);
	}

}
