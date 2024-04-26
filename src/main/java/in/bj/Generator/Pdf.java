package in.bj.Generator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.bj.Entity.Citizen;
import in.bj.Repository.CitizenRepo;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class Pdf {


	private CitizenRepo citizenRepo;
	
	public void generate (HttpServletResponse response,List<Citizen>plans,File f) throws Exception, IOException {
		
	Document document =new Document(PageSize.A4);
	
	PdfWriter.getInstance(document,response.getOutputStream());
	PdfWriter.getInstance(document,new FileOutputStream(f));
	
	
	document.open();
	Paragraph p =new Paragraph("citizen plans info");
	document.add(p);
	Font fontTitle =FontFactory.getFont(FontFactory.TIMES_ROMAN);
	fontTitle.setSize(20);
	 PdfPTable table = new PdfPTable(6);
	
	 table.addCell("Id");
	 table.addCell("citizen Name");
	 table.addCell("plan Name");
	 table.addCell("plan Status");
	 table.addCell("Start Date");
	 table.addCell("End Date");
	 
	 
	List<Citizen> plans1= citizenRepo.findAll();
	
	for(Citizen plan1 :plans1) {
		table.addCell(String.valueOf(plan1.getCitizenId()));
		table.addCell(plan1.getCitizenName());
		table.addCell(plan1.getPlan_Name());
		table.addCell(plan1.getPlan_Status());
		table.addCell(plan1.getPlan_StartDate()+"");
		table.addCell(plan1.getPlan_EndDate()+"");
		
	}
	 
	 document.add(table);
	document.close();
	
	}
}
