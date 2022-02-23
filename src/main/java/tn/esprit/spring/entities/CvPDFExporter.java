package tn.esprit.spring.entities;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class CvPDFExporter {

	
	private List<CV> listCv;
	
	//public CVPDFExporter(List<CV> listCV) {
      //   this.listCv = listCV;
        
   // }
 
    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.RED);
        cell.setPadding(3);
         
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
   
         
        cell.setPhrase(new Phrase("profileTitle", font));
        table.addCell(cell);
  
        cell.setPhrase(new Phrase("aboutMe", font));
        table.addCell(cell);
        /*   
        cell.setPhrase(new Phrase("internetSite", font));
        table.addCell(cell);
/*        /* 
        cell.setPhrase(new Phrase("drivingLesence", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("linkdIn", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("profileDescription", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("centerOfInterest", font));
        table.addCell(cell); */
        
       
       
    

       
    }
     
    private void writeTableData(PdfPTable table) {
        for (CV CV : listCv) {
         //  table.addCell(String.valueOf(CV.getId()));
          table.addCell(CV.getProfileDescription());
            table.addCell(CV.getAboutMe());
           /* table.addCell(CV.getInternetSite());*/
            /*table.addCell(CV.getDrivingLesence());*/
         /*    table.addCell(CV.getLinkdIn());*/
           /*  table.addCell(CV.getProfileDescription());*/
            /* table.addCell(CV.getCenterOfInterest());*/
           
         
        }
    }
     
    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
         
        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.orange);
         
        Paragraph p = new Paragraph("List of CVs", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
         
        document.add(p);
         
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f});
        table.setSpacingBefore(10);
        writeTableHeader(table);
        writeTableData(table);
         
        document.add(table);
         
        document.close();
         
    }
}
