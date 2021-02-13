package com.pucese.blog.resources;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import com.pucese.blog.entities.Posts;
import com.pucese.blog.repositories.PostRepository;



@RequestScoped
@Path("posts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PostResource {

    @Inject//conexion con la capa de datos
    PostRepository postRepository;

    @GET//metodo para mostrar todos
    public Response getAllPosts() {
        return Response.ok().entity(postRepository.getAllPosts()).build();
    }

    @GET
    @Path("{id}")
    public Response getPostById(@PathParam("id") Long id) {
        return Response.ok().entity(postRepository.findById(id)).build();
    }

    @POST
    public Response create(Posts post, @Context UriInfo uriInfo) {
        Posts postId = postRepository.create(post);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Long.toString(postId.getId()));
        return Response.created(builder.build()).build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, Posts post) {
        Posts updatePost = postRepository.findById(id);

        updatePost.setTitle(post.getTitle());
        updatePost.setBody(post.getBody());
        updatePost.setAuthor(post.getAuthor());

        return Response.ok().entity(post).build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        Posts post = postRepository.findById(id);
        postRepository.delete(post);
        return Response.noContent().build();
    }
}