package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member extends BaseEntity{
    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    private String name;
    @Embedded
    private Address address;

    /**
     * 단방향의 연관관계를 위주로 설계해야하는 것이 제일 좋다.
     * 하지만, 예시의 경우라 @OneToMany를 사용해서 양방향 연관관계를 넣은 것 뿐이다.
     * Member 객체가 반듯 Order 정보들을 알아야만 할까? 좋은 설계가 아닐지도 모른다.
     * 꼭 Order정보가 중요하면 Order객체에서 FK를통해서 Join으로 해도 될것이다.
     */

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
