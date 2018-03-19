package servlets;


import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.DocumentException;




@WebServlet("/hello")
public class CreditCalculator extends HttpServlet {


	private static final long serialVersionUID = 1L;
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
	String amountOfCredit= request.getParameter("amountOfCredit");
	if(amountOfCredit==null || amountOfCredit.equals("")||Logic.isNumeric(amountOfCredit)==false) {
		response.sendRedirect("/");
	}
	
	String numberOfInstalments= request.getParameter("numberOfInstalments");
	if(numberOfInstalments==null || numberOfInstalments.equals("")||Logic.isNumeric(numberOfInstalments)==false) {
		response.sendRedirect("/");
	}

	String interest= request.getParameter("interest");
	if(interest==null || interest.equals("")||Logic.isNumeric(interest)==false) {
		response.sendRedirect("/");
	}
	
	String fixedFee= request.getParameter("fixedFee");
	if(fixedFee==null || fixedFee.equals("")||Logic.isNumeric(fixedFee)==false) {
		response.sendRedirect("/");
	}
	
	String typeOfInstalments= request.getParameter("typeOfInstalments");
	if(typeOfInstalments==null || typeOfInstalments.equals("")) {
		response.sendRedirect("/");
	}
	
	
	
	for(int i=1;i<=Integer.parseInt(numberOfInstalments);i++) {
	response.getWriter().print("numer raty: "+i+"\t|");
	if(typeOfInstalments.equals("Malejaca")) {
		response.getWriter().print("Calkowita kwota raty:  " +Logic.calculationOfInstalmentsDescending(Float.parseFloat(amountOfCredit), Float.parseFloat(numberOfInstalments), i, Float.parseFloat(interest), Float.parseFloat(interest), Float.parseFloat(amountOfCredit), Float.parseFloat(fixedFee))+"\t\t|");  //tu wpisz odpowiednie pola 
		
	}else {
		response.getWriter().print("Calkowita kwota raty: "+Logic.calculationOfInstalmentsConstans(Float.parseFloat(amountOfCredit),Float.parseFloat(numberOfInstalments), Float.parseFloat(interest), 12 ,Float.parseFloat(interest), Float.parseFloat(amountOfCredit), Float.parseFloat(fixedFee))+"\t\t|");
	}
	response.getWriter().println("");
	}
	response.getWriter().println("-------------------------------------------------------");
	response.getWriter().print("Kwota kapiatlu: "+amountOfCredit);
	response.getWriter().print(" Odsetki: " +Logic.calculationOfInterest(Integer.parseInt(amountOfCredit), Integer.parseInt(interest),Integer.parseInt(numberOfInstalments)));
	response.getWriter().print(" koszt kredytu: "+Logic.costOfCredit(Integer.parseInt(interest), Integer.parseInt(amountOfCredit)));
	response.getWriter().print(" Oplaty stale zwiazane z obsluga kredytu: "+fixedFee );
	
	String makePdf = request.getParameter("makePdf");
	if(!(makePdf==null)) {
		try {
			PdfCreator.createPDF();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (com.lowagie.text.DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	}
}
	
	
	
	
	

	

