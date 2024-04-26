package in.bj.service;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.bj.Entity.Citizen;
import in.bj.Generator.Excel;
import in.bj.Generator.GeneratorMail;
import in.bj.Generator.Pdf;
import in.bj.Repository.CitizenRepo;
import in.bj.Search.Search;
import jakarta.servlet.http.HttpServletResponse;


@Service
public class ServiceImpl implements ServiceCitizen {

	@Autowired
	private CitizenRepo citizenRepo;
	
	@Autowired
    private Excel excel;
	
	@Autowired
	private Pdf pdf;
	
	@Autowired
	private GeneratorMail emailUtils;

	
	@Override
	public List<String> getplanname() {
	
		List<String>planeNames= citizenRepo.getPlanName();
		return planeNames;
	}

	@Override
	public List<String> getplanstatus() {

    List<String>planStatus =citizenRepo.getPlanStatus();
		return  planStatus;
	}

	@Override
	public List<Citizen> search(Search sear) {
		Citizen entity=new Citizen();
		
		if(null !=sear.getPlanName()&&!"".equals(sear.getPlanName())) {
			entity.setPlan_Name(sear.getPlanName());
		}
		if(null !=sear.getPlanStatus()&&!"".equals(sear.getPlanStatus())) {
			entity.setPlan_Status(sear.getPlanStatus()); 
		}
		if(null !=sear.getGender()&&!"".equals(sear.getGender())) {
			entity.setCitizenGender(sear.getGender());
		}
		if(null !=sear.getStartDate() && !"".equals(sear.getStartDate())) {
			String startDate=sear.getStartDate();
		    DateTimeFormatter formatter =DateTimeFormatter.ofPattern("dd-MM-yyyy");
			
			LocalDate localDate =LocalDate.parse(startDate, formatter);
			entity.setPlan_StartDate(localDate);
		}
		if(null !=sear.getEndDate() && !"".equals(sear.getEndDate())) {
			String startDate=sear.getStartDate();
		    DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");
			LocalDate localDate =LocalDate.parse(startDate,formatter);
			entity.setPlan_StartDate(localDate);
		}
	
		return citizenRepo.findAll(Example.of(entity));
	}

	@Override
	public Boolean exportExcel(HttpServletResponse response) throws Exception {	
		File f=new File("plans.xls");
		List<Citizen> plans=citizenRepo.findAll();	
		excel.generate(response,plans,f);
		
		String subject="Test mail subject";
		String body ="<h1> Test mail body </h1>";
		String to="bijaybeheralb@gmail.com";
		
		
		
		emailUtils.sendEmail(subject,body,to,f);
		f.delete();
		
		return true;
		
		
	}
	@Override
	public Boolean exportpdf(HttpServletResponse response) throws Exception {	
		List<Citizen> plans=citizenRepo.findAll();
		pdf.generate(response, plans, null);
		
				return true;
		

	}

	}
