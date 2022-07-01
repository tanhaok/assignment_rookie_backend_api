package com.assignment.backend.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 20)
    private TypeRole role;
    

    /**
     * 
     */
    public Role() {
    }

    /**
     * @param id
     * @param role
     */
    public Role(int id, TypeRole role) {
        this.id = id;
        this.role = role;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the role
     */
    public TypeRole getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(TypeRole role) {
        this.role = role;
    }

}
