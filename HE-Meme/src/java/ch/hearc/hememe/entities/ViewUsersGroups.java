/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.hememe.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sylvain.renaud
 */
@Entity
@Table(name = "view_users_groups")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ViewUsersGroups.findAll", query = "SELECT v FROM ViewUsersGroups v")
    , @NamedQuery(name = "ViewUsersGroups.findByGroupname", query = "SELECT v FROM ViewUsersGroups v WHERE v.groupname = :groupname")
    , @NamedQuery(name = "ViewUsersGroups.findByUsername", query = "SELECT v FROM ViewUsersGroups v WHERE v.username = :username")
    , @NamedQuery(name = "ViewUsersGroups.findByPassword", query = "SELECT v FROM ViewUsersGroups v WHERE v.password = :password")})
public class ViewUsersGroups implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 45)
    @Column(name = "groupname")
    private String groupname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "password")
    private String password;

    public ViewUsersGroups() {
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
