package com.pucese.blog.repositories;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.pucese.blog.entities.Posts;

import java.util.List;

@Stateless
public class PostRepository {

	//persistencia
    @PersistenceContext(unitName = "myBlog_PU")
    EntityManager em;

    public List getAllPosts() {
        return em.createNamedQuery("Post.findAll", Posts.class).getResultList();
    }

    public Posts findById(Long id) {
        return em.find(Posts.class, id);
    }

    public Posts create(Posts post) {
        em.persist(post);
        return post;
    }

    public void update(Posts post) {
        em.merge(post);
    }

    public void delete(Posts post) {
        if (!em.contains(post)) {
            post = em.merge(post);
        }

        em.remove(post);
    }
}