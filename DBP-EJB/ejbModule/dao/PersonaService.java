package dao;

import java.util.List;

import javax.ejb.Local;

import model.Persona;

/**
 * interface genera o estipula los servicios de una entidad o clases
 * @author JSH
 *
 */
@Local
public interface PersonaService {
	
	//metodos o servicios de la entidad
	//lo necesario para manipular la entidad
	//crud
	
	public Persona save(Persona p);
	public void remove(Persona p);
	public Persona find(Long id);
	public List<Persona> findAll();
	
}
