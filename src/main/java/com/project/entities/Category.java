package com.project.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
public class Category implements Serializable {

    @Id
    @SequenceGenerator(name = "category_id_sequence", sequenceName = "category_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_id_sequence")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinTable(name="user_category", joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<UserAccount> userAccountList;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        if (name != null) return name;
        return null;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserAccount> getUserAccountList() {
        return userAccountList;
    }

    public void setUserAccountList(UserAccount userAccount) {
        if(userAccountList==null) {
            userAccountList = new ArrayList<>();
        }
        userAccountList.add(userAccount);
    }
}
