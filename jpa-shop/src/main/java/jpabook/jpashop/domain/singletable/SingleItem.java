package jpabook.jpashop.domain.singletable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SingleItem {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private int price;
}
