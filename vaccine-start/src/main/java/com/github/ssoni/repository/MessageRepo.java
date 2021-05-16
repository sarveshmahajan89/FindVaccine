package com.github.ssoni.repository;

import com.github.ssoni.entity.CommonData;
import com.github.ssoni.entity.MessageLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Repository
public interface MessageRepo extends JpaRepository<MessageLog, String>
{

}