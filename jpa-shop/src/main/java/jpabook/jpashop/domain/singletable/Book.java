package jpabook.jpashop.domain.singletable;

import javax.persistence.Entity;

@Entity
public class Book extends SingleItem {
    private String author;
    private String isbn;
}
