package dao;

import java.util.List;

import javax.ejb.Local;

import model.Post;

@Local
public interface PostService {
	
	//crud
	
	public Post save(Post p);
	public void remove(Post p);
	public Post find(Long id);
	public List<Post> findAll();
	

}
