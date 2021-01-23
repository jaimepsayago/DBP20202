package controller;

import javax.inject.Inject;
import javax.inject.Named;

import dao.PostService;
import model.Post;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@Named
@RequestScoped
public class PostController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//conectarme a la capa de negocio
	@Inject
	private PostService postService;
	
	//crear objeto de tipo Post
	private Post post;
	
	
	//datamodel para casrgar la informacion de post
	DataModel<Post> lista;
	
	Long idSeleccionado; //variable para enviar parametros
	
	//constructor
	public PostController() {
		if(post == null) { //inicializar vasriables u objetos
			post = new Post();
		}
	}
	
	//guardar
	
		//editar
		
		//eliminar
		
		//listar
	//cargar los datos de la tabla post y listarlos
		public DataModel<Post> getLista() {
			lista = new ListDataModel<Post>(postService.findAll());
			return lista;
		}
		
		//generar los getters and settes
		

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	

	public void setLista(DataModel<Post> lista) {
		this.lista = lista;
	}

	public Long getIdSeleccionado() {
		return idSeleccionado;
	}

	public void setIdSeleccionado(Long idSeleccionado) {
		this.idSeleccionado = idSeleccionado;
	}
	
	
	
	
	
	
	
}
