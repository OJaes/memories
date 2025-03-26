package com.ojg.memories_back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ojg.memories_back.common.entity.EmpathyEntity;
import com.ojg.memories_back.common.entity.pk.EmpathyPk;

@Repository
public interface EmpathyRepository extends JpaRepository<EmpathyEntity, EmpathyPk>{
        EmpathyEntity findByUserIdAndDiaryNumber(String userid, Integer diarynumber);
        List<EmpathyEntity> findByDiaryNumber(Integer diaryNumber);
}
