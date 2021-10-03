package com.example.web.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Table(name = "author")
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class Author implements Serializable {
    private static final long serialVersionUID = -3279299093769296709L;

    @Id
    @GeneratedValue
    private Integer id;
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "authorList")
    private List<Book> bookList = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}