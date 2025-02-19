package com.study.shop.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "notice")
public class Notice {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private Date date;

    @Override
    public String toString() {
        return "Notice{" +
                "id=" + this.id +
                ", title='" + this.title + '\'' +
                ", date=" + this.date +
                '}';
    }
}
