package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/factura")
public class Factura extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Factura() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		//ingreso de variables de la factura
		
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String subtotal = request.getParameter("subtotal");
		String porcentajeIva = request.getParameter("porcentajeIva");
		
		//operaciones de la factura
		double dsubtotal = Double.parseDouble(subtotal);
		int iPorcentajeIva = Integer.parseInt(porcentajeIva);
		
		double montoIva = dsubtotal * iPorcentajeIva/100;
		double total = dsubtotal+montoIva;
		
		
		//mostrar la factura 
		StringBuilder sb = new StringBuilder();
		sb.append("<html><head><title>")
		.append("Resumen de la Factura")
		.append("</title></head>")
		.append("<body><h1>FACTURA</h1>")
		.append("<p>Cliente Nombre: ").append(nombre).append("</p>")
		.append("<p>Cliente Apellido: ").append(apellido).append("</p>")
		.append("<table>")
		.append("<tr><td>Subtotal:</td><td>").append(dsubtotal).append("</td></tr>")
		.append("<tr><td>Subtotal:</td><td>").append(montoIva).append("</td></tr>")
		.append("<tr><td>Subtotal:</td><td>").append(total).append("</td></tr>")
		.append("</table></body></html>");

		//imprimir datos con formato
		out.print(sb.toString());
		out.flush();
		
		//ejemplo de github
		
		
		
	}

}
