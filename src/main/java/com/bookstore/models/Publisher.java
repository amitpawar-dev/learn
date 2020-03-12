package com.bookstore.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Table (name="publisher")

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int publisherid;

    @Column (name="name")
    @NotNull
    private String name;

    @Column(name="address")
    @NotNull
    private String address;
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "publisher",cascade = CascadeType.ALL)
    private List <Book> bookList = new ArrayList<Book>();

    public void addBook(Book book) {
        this.bookList.add(book);
    }

}
