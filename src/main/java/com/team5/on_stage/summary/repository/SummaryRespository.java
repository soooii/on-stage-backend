package com.team5.on_stage.summary.repository;

import com.team5.on_stage.summary.entity.Summary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SummaryRespository extends JpaRepository<Summary, Long> {
    List<Summary> findSummariesByUserId(Long userId);
    void deleteSummariesByUserId(Long userId);
}