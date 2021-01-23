package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Post;

@Stateless
public class PostServiceEjb extends AbstractPersistence<Post, Long> implements PostService{

	//implementar el JPA
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	public PostServiceEjb() {
		super(Post.class);
		
	}


	
	


	
	

}
