package com.survey.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "survey_table")
public class Survey_table {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "id_mail")
    private String id_mail;

    @Column(name = "id_category")
    private long id_category;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "publish_date")
    private String publish_date;

    @Column(name = "ending_date")
    private String ending_date;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_category", nullable = false, insertable = false, updatable = false)
    private Category category;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_mail", nullable = false, insertable = false, updatable = false)
    private User user;

    //private boolean done = false;

    public Survey_table(){ }

    public Survey_table(String id_mail, String name, String description, String publish_date, String ending_date, Category category) {
        this.id_mail = id_mail;
        this.name = name;
        this.description = description;
        this.publish_date = publish_date;
        this.ending_date = ending_date;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public String getId_mail() {
        return id_mail;
    }

    public long getId_category() {
        return id_category;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPublish_date() {
        return publish_date;
    }

    public String getEnding_date() {
        return ending_date;
    }

    public Category getCategory() {
        return category;
    }

    public void setId_mail(String id_mail) {
        this.id_mail = id_mail;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPublish_date(String publish_date) {
        this.publish_date = publish_date;
    }

    public void setEnding_date(String ending_date) {
        this.ending_date = ending_date;
    }

    public void setCategory(Category category) {
        this.category = category;
    }




}
