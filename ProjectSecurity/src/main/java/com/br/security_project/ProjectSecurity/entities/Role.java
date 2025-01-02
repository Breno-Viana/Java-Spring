package com.br.security_project.ProjectSecurity.entities;

import jakarta.persistence.*;


@Entity
@Table(name="roles_tb")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;


    public enum Values{
        BASIC(2L),
        ADMIN(1L);

        private final Long roleID;

        Values(Long id){
            this.roleID=id;
        }

        public Long getRoleID() {
            return roleID;
        }
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }
}
