package com.sideagroup.accademy.model;

import jakarta.persistence.*;

@Entity
@Table(name = "title_principals")
public class TitlePrincipals {

    @EmbeddedId
    private TitlePrincipalsKey id;

    @ManyToOne
    @MapsId("nameBasicsId")
    private NameBasics nameBasics;

    @ManyToOne
    @MapsId("titleBasicsId")
    private TitleBasics titleBasics;

    @Column(length = 1000)
    private String category;

    @Column(length = 1000)
    private String characters;

    public TitlePrincipalsKey getId() {
        return id;
    }

    public void setId(TitlePrincipalsKey id) {
        this.id = id;
    }

    public NameBasics getNameBasics() {
        return nameBasics;
    }

    public void setNameBasics(NameBasics nameBasics) {
        this.nameBasics = nameBasics;
    }

    public TitleBasics getTitleBasics() {
        return titleBasics;
    }

    public void setTitleBasics(TitleBasics titleBasics) {
        this.titleBasics = titleBasics;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCharacters() {
        return characters;
    }

    public void setCharacters(String characters) {
        this.characters = characters;
    }
}
