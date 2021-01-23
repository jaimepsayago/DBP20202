package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity(name = "Post")
public class Post implements AbstractEntity {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
 
    private String title;
 
    public Post() {
		super();
		
	}

	@OneToMany(
			fetch = FetchType.EAGER, //carga datos de tablas relacionadas
            mappedBy = "post",
            cascade = CascadeType.ALL,
            orphanRemoval = true
        )
        private List<PostComment> comments = new ArrayList<>();
     
        //Constructors, getters and setters removed for brevity
     
        public void addComment(PostComment comment) {
            comments.add(comment);
         
            comment.setPost(this);
        }
     
        public void removeComment(PostComment comment) {
            comments.remove(comment);
            comment.setPost(null);
        }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public List<PostComment> getComments() {
			return comments;
		}

		public void setComments(List<PostComment> comments) {
			this.comments = comments;
		}
        
        
    }
	