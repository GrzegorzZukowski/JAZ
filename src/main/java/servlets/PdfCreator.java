/*package servlets;


import java.io.FileOutputStream;
import java.io.IOException;

import java.io.OutputStream;
import org.xhtmlrenderer.pdf.ITextRenderer;
import com.itextpdf.text.DocumentException;


public class PdfCreator {
	 public static void createPDF() throws IOException, DocumentException, com.lowagie.text.DocumentException {
	        String HTMLpageUrl = "http://localhost:8080/hello"; // URL strony renderowanej .
	        String PDFdoc = "RaportKredytowy"; //Wyjœciowy plik PDF
	        OutputStream os = new FileOutputStream(PDFdoc);
	        ITextRenderer renderer = new ITextRenderer();
	        renderer.setDocument(HTMLpageUrl);
	        renderer.layout();
	        renderer.createPDF(os);
	        os.close();
	   }

}*/
