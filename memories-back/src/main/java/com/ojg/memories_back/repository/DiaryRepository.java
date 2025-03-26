package com.ojg.memories_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ojg.memories_back.common.entity.DiaryEntity;
import java.util.List;


@Repository
public interface DiaryRepository extends JpaRepository<DiaryEntity, Integer>{
    List<DiaryEntity> findByUserIdOrderByWriteDateDesc(String userId);
    DiaryEntity findByDiaryNumber(Integer diaryNumber);
}
