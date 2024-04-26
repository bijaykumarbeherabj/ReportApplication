package in.bj.Controller;

import java.util.List;

import org.apache.catalina.filters.ExpiresFilter.XHttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.bj.Entity.Citizen;
import in.bj.Search.Search;
import in.bj.service.ServiceCitizen;

@Controller
public class ControllerCitizen {

	@Autowired
	private ServiceCitizen serviceCitizen;
	
	@GetMapping("/pdf")
	public void pdfExport(XHttpServletResponse response) throws Exception {
		
		response.setContentType("application/pdf");
		response.addHeader("content-Disposition", "attachment;filename=plans.pdf");
		serviceCitizen.exportpdf(response);
	}
	
	@GetMapping("/excel")
	public void excelExport(XHttpServletResponse response) throws Exception {
		
		response.setContentType("application/octet-stream");
		response.addHeader("content-Disposition", "attachment;filename=plans.xls;attachment");
		serviceCitizen.exportExcel(response);
	}
	
	@PostMapping("/searchData")
	public String handleSearch( Search search,Model model) {
		
		List<Citizen>plans= serviceCitizen.search(search);
		model.addAttribute("plans", plans);
		
		model.addAttribute("search", search);  
		
		init(model);
		return "index";
	}
	@GetMapping("/")
	public String getRequest(Model model) {
		
		model.addAttribute("search",new Search());
		init(model);
		
		return "index";	
	}
	private void init(Model model) {
		model.addAttribute("names",serviceCitizen.getplanname());
		model.addAttribute("status",serviceCitizen.getplanstatus());
	}
	
}
