/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.hememe.controllers;

import ch.hearc.hememe.entities.Posts;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author sylvain.renaud
 */
@Named(value = "searchBean")
@SessionScoped
public class SearchBean implements Serializable {

    @EJB
    private ch.hearc.hememe.facades.PostsFacade ejbFacade;
    private List<Posts> items;
    private String pattern;

    /**
     * Creates a new instance of SearchBean
     */
    public SearchBean() {
    }

    public List<Posts> getItems() {
        return items;
    }

    public void setItems(List<Posts> items) {
        this.items = items;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String search() {
        items = ejbFacade.searchByTitle(pattern);
        return "/ListSearch";
    }

}
