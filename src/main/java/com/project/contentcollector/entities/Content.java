package com.project.contentcollector.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "content")
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "content_id_sequence" )
    private Long id;

    @NotNull(message = "name must have a value")
    private String name;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
                fetch=FetchType.LAZY)
    private Category category;

    @NotNull(message = "link must have a value")
    private String link;

    public Content() {
    }

    public Content(String name, Category category, String link) {
        this.name = name;
        this.category = category;
        this.link = link;
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
