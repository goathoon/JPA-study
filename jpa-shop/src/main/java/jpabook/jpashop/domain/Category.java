package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.*;

@Entity
public class Category {
    @Id @GeneratedValue
    private Long id;
    private String name;

    // self로 만들어진 Category table들 ---- start
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "PARENT_ID")
    private Category parent;
    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();
    // self로 만들어진 Category table들 ---- end


    @ManyToMany
    @JoinTable(name = "CATEGORY_ITEM", joinColumns = @JoinColumn(name = "CATEGORY_ID"),
    inverseJoinColumns = @JoinColumn(name = "ITEM_ID"))
    private List<Item> items = new ArrayList<>();

}
