/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smhtml.reisgids.service;

import com.smhtml.reisgids.Appuser;
import com.smhtml.reisgids.Bezienswaardigheid;
import com.smhtml.reisgids.Userfoto;
import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author fhict
 */
@Stateless
@Path("com.smhtml.reisgids.appuser")
public class AppuserFacadeREST extends AbstractFacade<Appuser> {

    @PersistenceContext(unitName = "com.smhtml_Reisgids_war_1.0PU")
    private EntityManager em;

    public AppuserFacadeREST() {
        super(Appuser.class);
    }

    
    /**
     * Creates a new user and persists it.
     * @param entity 
     */
    @POST
    @Override
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Appuser entity) {
        super.create(entity);
    }
    
    /**
     * Edits the user entity
     * @param id email as id
     * @param entity the user entity
     */
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, Appuser entity) {
        super.edit(entity);
    }

    /**
     * Removes the user
     * @param id email
     */
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

    /**
     * retrieve the user entity
     * @param id email
     * @return user entity as json
     */
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Appuser find(@PathParam("id") String id) {

        
        return super.find(id);
    }

    /**
     * get the users favorite items
     * @param id email
     * @return json array with Bezienswaardigheden
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/{id}/fav")
    public Collection<Bezienswaardigheid> findFav(@PathParam("id") String id){
        System.out.println("get favorieten");
        Appuser user = super.find(id);
        return user.getBezienswaardigheidCollection();
    }
    
    
//    @GET
//    @Produces({MediaType.APPLICATION_JSON})
//    @Path("/{id}/image")
//    public Collection<Userfoto> findImages(@PathParam("id") String id){
//        System.out.println("get images");
//        Appuser user = super.find(id);
//        return user.getUserfotoCollection();
//    }
    
//    @POST
//    @Path("/{id}/image/")
//    @Consumes({MediaType.APPLICATION_JSON})
//    public void addImage(@PathParam("id") String id, Userfoto entity){
//        System.out.println("Add image");
//        Appuser user = this.find(id);
//        user.getUserfotoCollection().add(entity);
//        super.edit(user);
//    }
    /**
     * Adds a favorite to the user
     * @param id email
     * @param entity Bezienswaardigheid.
     */
    @POST
    @Path("/{id}/fav/")
    @Consumes({MediaType.APPLICATION_JSON})
    public void addFav(@PathParam("id") String id, Bezienswaardigheid entity){
        System.out.println("Add favorieten");
        Appuser user = this.find(id);
        user.getBezienswaardigheidCollection().add(entity);
        super.edit(user);
    }
    
    
    
//    @POST
//    @Path("/{id}/fav/")
//    @Consumes({MediaType.APPLICATION_JSON})
//    public void addFav(@PathParam("id") String id, String entity){
//        System.out.println("Add favorieten");
//        System.out.println(entity + "");
//        Appuser user = this.find(id);
//
//        super.edit(user);
//    }
//    
    /**
     * Retrieve all users
     * @return json array appuser objects
     */
    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Appuser> findAll() {
        return super.findAll();
    }

//    @GET
//    @Path("{from}/{to}")
//    @Produces({MediaType.APPLICATION_JSON})
//    public List<Appuser> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
//        return super.findRange(new int[]{from, to});
//    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    
    

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
