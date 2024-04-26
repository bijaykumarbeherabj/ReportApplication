package in.bj.service;

import java.io.FileNotFoundException;
import java.util.List;

import org.apache.catalina.filters.ExpiresFilter.XHttpServletResponse;

import in.bj.Entity.Citizen;
import in.bj.Search.Search;
import jakarta.servlet.http.HttpServletResponse;

public interface ServiceCitizen {
	
	public List <String>getplanname();
	public List<String>getplanstatus();
	public List<Citizen> search( Search search);
	Boolean exportExcel(HttpServletResponse response) throws Exception;
	Boolean exportpdf(HttpServletResponse response) throws Exception;

}
