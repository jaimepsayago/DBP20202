package puce.web.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import puce.web.model.Persona;
import puce.web.util.MemoryStore;

@Named
@RequestScoped

public class PersonaController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private MemoryStore ms;
	
	private String identificacion;
	private String nombre;
	private String apellido;
	private int anioNacimiento=0;
	
	private String ciudad;
	private String direccion;
	private String telefono;
	
	private List<String> anios; //genera un listado de los a�os
	
	public List<String> getAnios() {
		return anios;
	}
	public void setAnios(List<String> anios) {
		this.anios = anios;
	}
	
	Persona nuevaPersona;
	
	@PostConstruct
	public void inicializar()
	{
		
		anios = new ArrayList<>(); 
			Calendar actual = GregorianCalendar.getInstance();
			int anioActual = actual.get(Calendar.YEAR);
			int anioInicial = anioActual - 80;
			int anioFinal = anioActual -10;
			for (int anio= anioFinal; anio>=anioInicial; anio--)
			{
				anios.add(String.valueOf(anio));
			}
					
	}
	
	
	public PersonaController() {
		if (nuevaPersona == null) {
			nuevaPersona = new Persona();
		}
	}
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getAnioNacimiento() {
		return anioNacimiento;
	}
	public void setAnioNacimiento(int anioNacimiento) {
		this.anioNacimiento = anioNacimiento;
	}
	
	
	
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	//metodo para guardar la informacion
	public String registrar(){
		Persona nuevaPersona = new Persona();
		nuevaPersona.setIdentificacion(identificacion);
		nuevaPersona.setNombre(nombre);
		nuevaPersona.setApellido(apellido);;
		nuevaPersona.setEdad(calcularEdad());
		nuevaPersona.setCiudad(ciudad);
		nuevaPersona.setDireccion(direccion);
		nuevaPersona.setTelefono(telefono);
		
		ms.addPersona(nuevaPersona);
		return "registrado";
	}
	
	//calcular los a�os
	private int calcularEdad() {
		Calendar hoy = GregorianCalendar.getInstance();
		int a = anioNacimiento;
		System.out.println(a);
		return hoy.get(Calendar.YEAR) - anioNacimiento;
	}
	
	
	
	
}
