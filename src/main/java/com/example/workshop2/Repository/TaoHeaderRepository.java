package com.example.workshop2.Repository;

import com.example.workshop2.Entity.TaoHeaderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TaoHeaderRepository extends JpaRepository<TaoHeaderEntity, Integer> {

    List<TaoHeaderEntity> findByVdtNo(Integer vdtNo);

    List<TaoHeaderEntity> findByCreateDate(Date createDate);

    List<TaoHeaderEntity> findByVdtNoAndCreateDate(Integer vdtNo, Date createDate);
}

