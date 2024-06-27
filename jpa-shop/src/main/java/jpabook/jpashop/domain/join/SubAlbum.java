package jpabook.jpashop.domain.join;

import javax.persistence.Entity;

@Entity
public class SubAlbum extends SuperItem {
    private String artist;
}
