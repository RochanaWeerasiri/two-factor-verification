package com.example.demo.Repository;

import com.example.demo.Entity.TemporaryUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TemporaryUserRepository extends JpaRepository<TemporaryUsers,Integer> {


    @Modifying
    @Query("UPDATE TemporaryUsers t SET t.code = :code,t.expire_time=:expire_time WHERE t.user_id = :user_id")
    void update2FA(@Param("user_id") Integer user_id, @Param("code") String code, @Param("expire_time") Long expire_time);

   /* @Query("select t.code from TemporaryUsers t WHERE t.user_id = :user_id")
    int verify(@Param("user_id") Integer user_id);*/

    /*@Modifying
    @Query("DELETE FROM TemporaryUsers t WHERE t.user_id = :user_id")
    void delete(@Param("code") String code );*/

}
