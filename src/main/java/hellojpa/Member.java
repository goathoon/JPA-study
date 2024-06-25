package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Member {
    @Id
    private Long id;
    private String name;
    private Integer age;

    // Table에 EnumType처럼 지정하고 싶을 떄 사용하는 Annotation
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    // 날짜 == Temporal
    //JAVA 8 부터는 LocalDate, LocalDateTime 타입이 새로 나왔으므로 이를 사용하면 그대로 DB에 반영됨
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    @Lob
    private String description;



    // DB에 반영하지 말아줘 == (transient 직렬화랑 같은 개념)
    @Transient
    private String test;



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
}
