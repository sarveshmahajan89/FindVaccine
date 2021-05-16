package com.github.ssoni.repository;

import com.github.ssoni.entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public interface UserDetailRepo extends JpaRepository<UserDetail, String>
{

    @Query("select distinct(u.pin) from UserDetail u where u.messageSent = false")
    public List<String> findDistPin();

    @Query("select u from UserDetail u where u.pin= :pincode and u.age < :age and u.messageSent = false")
    List<UserDetail> findByPinAndAgeLess(@Param("pincode") String pincode,@Param("age") int age);

    @Query("select u from UserDetail u where u.pin= :pincode and u.age > :age and u.messageSent = false")
    List<UserDetail> findByPinAndAgeMore(@Param("pincode") String pincode,@Param("age") int age);
    @Transactional
    @Modifying
    @Query("Update UserDetail u set u.messageSent = true where u.pin= :pincode and u.age > 44 and u.messageSent = false")
    void updateUsersAlreadyNotified45(@Param("pincode") String pincode);

    @Transactional
    @Modifying
    @Query("Update UserDetail u set u.messageSent = true where u.pin= :pincode and u.age <45 and u.messageSent = false")
    void updateUsersAlreadyNotified18(@Param("pincode") String pincode);
}