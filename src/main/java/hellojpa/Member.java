package hellojpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * nullable = false 지정시 not null 제약조건 붙임
     * unique = true시 유니크 제약조건(유니크 키 이름을 랜덤으로 지정하기때문에 잘 사용하지 않음 = 보통 클래스 @Table 어노테이션에서 사용함)
     * length = 10  = varchar(10)
     * columnDefinition = "varchar(100) default 'EMPTY'" 지정시 커럼 크기와 default값 지정가능
     * insertable,updateable = 등록,변경가능여부
     */
    @Column(name = "name", nullable = false)
    private String username;

    private Integer age;

    /** DB에는 E넘타입이 없기 떄문에 Enumerated 사용
     *  Enum 타입 사용시 주의사항!! 기본값인 ORDINAL 사용시 integer로 db에 생성되며 숫자로 enum을 관리함
     *  Enum의 순서가 바뀔시 에러가 남 0, 1, 2 ... n 순서로 저장되기때문에 EnumType.STRING 으로 사용할것
     *  ORDINAL = Enum의 순서를 DB에 저장(DEFAULT값)
     *  STRING  = Enum의 이름을 DB에 저장*/
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    /** 날짜타입 Temporal 타입 3가지 있음 데이터베이스에 맞게 타입 지정 
     *  LocalDate, LocalDateTime 사용시 생략 가능
     *  */
    private LocalDate testLocalDate; // db에 date 타입으로 생성됨
    private LocalDateTime testLocalDateTime; // db에 timestamp로 생성됨

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    /** varchar 보다 큰 타입 @Lob 어노테이션 사용 - 문자타입은 clob으로 지정됨 */
    @Lob
    private String description;

    /**
     * ** @Transient 어노테이션 사용
     * ** DB에서 사용 하지 않고 메모리에서만 사용하고 싶을때
     * ** -매핑을 하고싶지 않을때 사용함!!*/
    @Transient
    private int temp;

    public Member() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }
}