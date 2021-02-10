package com.project.contentcollector.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "content")
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_sequence" )
    private Long id;

    @NotNull(message = "name must have a value")
    private String name;

    private String category;

    @NotNull(message = "link must have a value")
    private String link;

    public Content() {
    }

    public Content(String name, String category, String link) {
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
