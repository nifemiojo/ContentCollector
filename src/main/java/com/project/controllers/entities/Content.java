package com.project.controllers.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "content")
public class Content {

    @Id
    @SequenceGenerator(name = "content_id_sequence", sequenceName = "content_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "content_id_sequence" )
    private Long id;

    @NotNull(message = "name must have a value")
    private String name;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH},
                fetch=FetchType.LAZY)
    private Category category;

    @NotNull(message = "link must have a value")
    private String link;

    public Content() {
    }

    public Content(String name, String link) {
        this.name = name;
        this.link = link;
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

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
