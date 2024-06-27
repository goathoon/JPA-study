package jpabook.jpashop.domain.eachtable;

import javax.persistence.Entity;

@Entity
public class AbstractBook extends AbstractTable {
    private String author;
    private String isbn;
}
