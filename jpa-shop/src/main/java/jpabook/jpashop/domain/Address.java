package jpabook.jpashop.domain;

import javax.persistence.Embeddable;
import java.util.Objects;

/**
 * 값 타입 클래스
 * 값 타입은 '불변'해야 하므로, setter를 사용하지 말자. (private)
 * 값타입을 공유하는 객체들에 원치 않는 변경이 있을 수 있기 때문이다.
 */

@Embeddable
public class Address {
     private String city;
     private String street;
     private String zipcode;

    public String getCity() {
        return city;
    }

    private void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    private void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    private void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    // equals 메서드 호출시, getter를 호출해야 proxy 객체여도 적용이 가능하다 (proxy객체가 상속받으니)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(getCity(), address.getCity()) && Objects.equals(getStreet(), address.getStreet()) && Objects.equals(getZipcode(), address.getZipcode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity(), getStreet(), getZipcode());
    }
}
