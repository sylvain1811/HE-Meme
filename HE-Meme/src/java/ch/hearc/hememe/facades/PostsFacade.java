/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.hememe.facades;

import ch.hearc.hememe.entities.Posts;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sylvain.renaud
 */
@Stateless
public class PostsFacade extends AbstractFacade<Posts> {

    @PersistenceContext(unitName = "HE-MemePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PostsFacade() {
        super(Posts.class);
    }

    public List<Posts> searchByTitle(String title) {
        return (List<Posts>) em.createNamedQuery("Posts.searchByTitle").setParameter("title", "%" + title + "%").getResultList();
    }

}
