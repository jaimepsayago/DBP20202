package puce.web.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import puce.web.model.Persona;

@Named
@SessionScoped
public class MemoryStore implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private HashMap<String, Persona> personas;
	
	@PostConstruct
	public void inicializar()
	{
		personas = new HashMap<>();
	}
	
	public void addPersona (Persona persona){
		String identificacion = persona.getIdentificacion();
		if (personas.containsKey(identificacion)){
			personas.remove(identificacion);
		}
		personas.put(identificacion, persona);
	}
	
	public List<Persona> getPersonas(){
		return new ArrayList<>(personas.values());
	}
	
	public Persona getPersona(String identificacion){
		return personas.get(identificacion);
	}
	

}
