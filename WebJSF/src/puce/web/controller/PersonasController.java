package puce.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import puce.web.model.Persona;
import puce.web.util.MemoryStore;

@Named
@RequestScoped
public class PersonasController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//inyeccion de dependencia o la conexion a nuestra capa de datos
	// memory store
	@Inject
	private MemoryStore ms;
	
	//metodo para listar las personas
	public List<Persona> getPersonas(){
		return ms.getPersonas();
	}
	
	

}
