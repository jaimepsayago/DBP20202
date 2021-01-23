package model;

import javax.persistence.*;


@Entity(name = "PostComment")
public class PostComment implements AbstractEntity  {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
 
    private String review;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

    public PostComment() {
		super();
		
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	@ManyToOne(fetch = FetchType.EAGER)
    private Post post;
 
    //Constructors, getters and setters removed for brevity
 
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PostComment )) return false;
        return id != null && id.equals(((PostComment) o).getId());
    }
 
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}