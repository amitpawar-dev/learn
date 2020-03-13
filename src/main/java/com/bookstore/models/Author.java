package com.bookstore.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "author")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer authorid;

    @NotNull
    private String name;

    @NotNull
    private String address;

}
