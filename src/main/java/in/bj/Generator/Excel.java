package in.bj.Generator;

import java.io.File;
import java.io.FileOutputStream;import java.io.OutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.bj.Entity.Citizen;
import in.bj.Repository.CitizenRepo;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class Excel {

	@Autowired
	private CitizenRepo citizenRepo;
	
	public void generate(HttpServletResponse response, List<Citizen> records, File f) throws Exception {
		Workbook workbook=new HSSFWorkbook();
		 Sheet sheet=workbook.createSheet("plans-data");
		 Row headerRow=sheet.createRow(0);
		 
		 headerRow.createCell(0).setCellValue("ID");
		 headerRow.createCell(1).setCellValue("Name");
		 headerRow.createCell(2).setCellValue("plan Name");
		 headerRow.createCell(3).setCellValue("plan Status");
		 headerRow.createCell(4).setCellValue("plan Start Date");
		 headerRow.createCell(5).setCellValue("plan End Date");
		 headerRow.createCell(6).setCellValue("Benefit Amount");
		 
		 List<Citizen> records1=citizenRepo.findAll();
		 
		 int dataRowIndex =1;
		 for(Citizen plan:records1 ) {
		  Row dataRow= sheet.createRow(1);
		      dataRow.createCell(0).setCellValue(plan.getCitizenId());
		      dataRow.createCell(1).setCellValue(plan.getCitizenName());
		      dataRow.createCell(2).setCellValue(plan.getPlan_Name());
		      dataRow.createCell(3).setCellValue(plan.getPlan_Status());
		      dataRow.createCell(4).setCellValue(plan.getPlan_StartDate());
		      dataRow.createCell(5).setCellValue(plan.getPlan_EndDate());
		      if(null !=plan.getBenefit_Amount()) {
		      dataRow.createCell(6).setCellValue(plan.getBenefit_Amount());
		      }
		      else {
		    	  dataRow.createCell(6).setCellValue("N/A");
		      }
		      dataRowIndex ++;
		 }
		 FileOutputStream fos =new FileOutputStream(new File("plans.xls"));
		 workbook.write(fos);
		 fos.close();
		 
		 ServletOutputStream outputstream= response.getOutputStream();		 
		 workbook.write(outputstream);
		 workbook.close();
		 
	
	}
}
