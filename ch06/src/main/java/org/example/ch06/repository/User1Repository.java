package org.example.ch06.repository;


import org.example.ch06.entity.User1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

// Repository는 JPA에서 데이터 엑세스 객체(DAO)
@Repository
public interface User1Repository extends JpaRepository<User1, String> {
    // JpaRepository<T, ID> : 사용하는 엔티티와 해당 엔티티의 @ID 컬럼 속성 타입

    // 다양한 JPA 쿼리 메서드
    public User1 findByUserid(String userid); // SELECT * FROM User1 WHERE userid={userid}
    public List<User1> findByName(String name); // SELECT * FROM User1 WHERE name={name}
    public List<User1> findByNameNot(String name); // SELECT * FROM User1 WHERE name!={name}
    public User1 findByUseridAndName(String userid, String name); // SELECT * FROM User1 WHERE userid={userid} AND name={name}
    public List<User1> findByUseridOrName(String userid, String name); // SELECT * FROM User1 WHERE userid={userid} OR name={name}
    public List<User1> findByHp(String hp);

    public List<User1> findByAgeGreaterThan(int age); // SELECT * FROM User1 WHERE age > {age}
    public List<User1> findByAgeGreaterThanEqual(int age); // SELECT * FROM User1 WHERE age >= {age}
    public List<User1> findByAgeLessThan(int age); // SELECT * FROM User1 WHERE age < {age}
    public List<User1> findByAgeLessThanEqual(int age); // SELECT * FROM User1 WHERE age <= {age}
    public List<User1> findByAgeBetween(int low, int high); // SELECT * FROM User1 WHERE age >= {low} AND age <= {high}

    public List<User1> findByNameLike(String name); // SELECT * FROM User1 WHERE name LIKE '{name}'
    public List<User1> findByNameContains(String name); // SELECT * FROM User1 // WHERE name LIKE '%{name}%'
    public List<User1> findByNameStartingWith(String name); // SELECT * FROM User1 WHERE name LIKE '{name}%'
    public List<User1> findByNameEndsWith(String name); // SELECT * FROM User1 WHERE name LIKE '%{name}'


    public List<User1> findByOrderByName();
    public List<User1> findByOrderByAgeAsc();
    public List<User1> findByOrderByAgeDesc();
    public List<User1>  findByAgeGreaterThanOrderByAgeDesc(int age);

    public int countByUserid(String userid);
    public int countByName(String name);


    // JPQL : JPA에서 지원하는 SQL
    @Query("SELECT u FROM User1 AS u WHERE u.age < 30")
    public List<User1> selectUnderAge30();

    @Query("SELECT u FROM User1 AS u WHERE u.name = :name")
    public List<User1> selectByName(String name);

    @Query("SELECT u.userid, u.name, u.age FROM User1 AS u WHERE u.userid = :userid")
    public List<Object[]> selectByUserid(String userid);

//    @Query("SELECT p, c FROM Parent AS p " +
//                "JOIN Child AS c ON p.pid = c.parent " +
//                "WHERE p.pid = :pid"
//    )
//    public void selectParentChild(String pid);

}