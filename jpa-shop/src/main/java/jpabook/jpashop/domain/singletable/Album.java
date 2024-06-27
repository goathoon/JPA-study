package jpabook.jpashop.domain.singletable;

import javax.persistence.Entity;

@Entity
public class Album extends SingleItem {
    private String artist;
}
