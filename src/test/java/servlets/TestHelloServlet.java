package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.mockito.Mockito;

public class TestHelloServlet extends Mockito{
	
	@Test
	public void servlet_should_not_compute_if_the_parameters_are_null() throws IOException{
		
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response= mock(HttpServletResponse.class);
		CreditCalculator calculator= new CreditCalculator();
		
		when(request.getParameter("amountOfCredit")).thenReturn(null);
		calculator.doPost(request, response);
		
		when(request.getParameter("numberOfInstalments")).thenReturn(null);
		calculator.doPost(request, response);
		
		when(request.getParameter("interest")).thenReturn(null);
		calculator.doPost(request, response);
		
		when(request.getParameter("fixedFee")).thenReturn(null);
		calculator.doPost(request, response);
		
		when(request.getParameter("typeOfInstalments")).thenReturn(null);
		calculator.doPost(request, response);
		
		verify(response).sendRedirect("/");
		
		PrintWriter writer = mock(PrintWriter.class);
		when(response.getWriter()).thenReturn(writer); 
		
	}
	public void servlet_should_not_compute_if_the_parameters_are_not_numeric() throws IOException{
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response= mock(HttpServletResponse.class);
		CreditCalculator calculator= new CreditCalculator();
		
		when(request.getParameter("amountOfCredit")).thenReturn("s");
		calculator.doPost(request, response);
		
		when(request.getParameter("numberOfInstalments")).thenReturn("s");
		calculator.doPost(request, response);
		
		when(request.getParameter("interest")).thenReturn("s");
		calculator.doPost(request, response);
		
		when(request.getParameter("fixedFee")).thenReturn("s");
		calculator.doPost(request, response);
		
	
		
		verify(response).sendRedirect("/");
		
		PrintWriter writer = mock(PrintWriter.class);
		when(response.getWriter()).thenReturn(writer); 

}
	public void servlet_should_compute_if_the_parameters_are_numeric() throws IOException{			//tu jeszcze trzeba popracowaæ
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response= mock(HttpServletResponse.class);
		CreditCalculator calculator= new CreditCalculator();
		
		when(request.getParameter("amountOfCredit")).thenReturn("30000");
		calculator.doPost(request, response);
		
		when(request.getParameter("numberOfInstalments")).thenReturn("15");
		calculator.doPost(request, response);
		
		when(request.getParameter("interest")).thenReturn("10");
		calculator.doPost(request, response);
		
		when(request.getParameter("fixedFee")).thenReturn("25");
		calculator.doPost(request, response);
		
		
		
		verify(response).sendRedirect("/");
		
		PrintWriter writer = mock(PrintWriter.class);
		when(response.getWriter()).thenReturn(writer); 

}
}