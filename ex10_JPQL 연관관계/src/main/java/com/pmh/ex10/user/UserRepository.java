package com.pmh.ex10.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    // select * from users where name='?'
    Optional<User> findByName(String name);

    @Query("select u from User u where u.name =:name")
    Optional<User> jpqlFindByName(@Param("name") String name);

    @Query(value = "select * from users u where u.name =:name", nativeQuery = true)
    Optional<User> njpqlFindByName(@Param("name") String name);

    // select * from users where name=? or email =?
    Optional<User> findByNameOrEmail(String name,String email);

    @Query("select u from User u where u.name=:name or u.email=:email")
    Optional<User> jpqlfindByNameOrEmail(@Param("name") String name,@Param("email") String email);

    // select * from uers where name like '%name%' order by id desc
    List<User> findByNameContainingOrderByIdDesc(String name);

}
