import NET.webserviceX.www.GlobalWeatherLocator;
import NET.webserviceX.www.GlobalWeatherSoap;
import NET.webserviceX.www.GlobalWeatherSoapProxy;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.ServiceException;

/**
 * Servlet implementation class WeatherWebServiceClient
 */
@WebServlet("/WeatherWebServiceClient")
public class WeatherWebServiceClient extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public WeatherWebServiceClient() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String country = request.getParameter("country");
		
		GlobalWeatherLocator locator = new GlobalWeatherLocator();
		GlobalWeatherSoap soap = null;
		try {
			soap = locator.getGlobalWeatherSoap();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String result = soap.getCitiesByCountry(country);
		
		PrintWriter out = response.getWriter();
		out.println(result);
		out.close();
	}

}
