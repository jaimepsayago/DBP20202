package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Persona;



/**
 * implementamos las operaciones de la interface personaSerivce. (capa de negocio)
 * @author JSH
 *
 */

@Stateless
public class PersonaServiceEJB extends AbstractPersistence<Persona, Long> implements PersonaService {
	
	 //implementar JPA
	 @PersistenceContext
	 private EntityManager em;
	 
	 @Override
		protected EntityManager getEntityManager() {
			return em;
		}
	 
	 public PersonaServiceEJB() {
		 super(Persona.class);
	 }

}
