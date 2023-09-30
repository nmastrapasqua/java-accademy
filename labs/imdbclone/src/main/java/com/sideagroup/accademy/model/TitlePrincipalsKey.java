package com.sideagroup.accademy.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class TitlePrincipalsKey {

    @Column(name = "nconst", length = 200)
    private String nameBasicsId;
    @Column(name = "tconst", length = 200)
    private String titleBasicsId;

    public String getNameBasicsId() {
        return nameBasicsId;
    }

    public void setNameBasicsId(String nameBasicsId) {
        this.nameBasicsId = nameBasicsId;
    }

    public String getTitleBasicsId() {
        return titleBasicsId;
    }

    public void setTitleBasicsId(String titleBasicsId) {
        this.titleBasicsId = titleBasicsId;
    }
}
