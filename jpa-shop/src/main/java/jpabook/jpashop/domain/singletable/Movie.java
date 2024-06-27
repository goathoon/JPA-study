package jpabook.jpashop.domain.singletable;

import javax.persistence.Entity;

@Entity
public class Movie extends SingleItem{
    private String director;
    private String actor;
}
