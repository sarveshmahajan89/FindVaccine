package com.github.ssoni.repository;

import com.github.ssoni.entity.CommonData;
import com.github.ssoni.entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public interface CommonDataRepo extends JpaRepository<CommonData, String>
{

    @Transactional
    @Modifying
    @Query("Update CommonData c set  c.totalvalue = :total , c.registeredVal= :reg where c.data=1")
    void updateCommonData(@Param("total") int total,@Param("reg")  int reg);

}