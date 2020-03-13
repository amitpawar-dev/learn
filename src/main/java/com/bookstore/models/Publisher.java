package com.bookstore.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

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
//@ToString
/*@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "publisherid")*/
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer publisherid;

    @Column (name="name")
    @NotNull
    private String name;

    @Column(name="address")
    @NotNull
    private String address;
    @NonNull

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "publisher",cascade = CascadeType.ALL)
    private List <Book> bookList = new ArrayList <Book>();

    public void addBook(Book book) {
        this.bookList.add(book);
    }

}
