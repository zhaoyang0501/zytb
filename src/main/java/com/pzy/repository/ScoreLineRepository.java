package com.pzy.repository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.pzy.entity.ScoreLine;
public interface ScoreLineRepository extends PagingAndSortingRepository<ScoreLine, Long>,JpaSpecificationExecutor<ScoreLine>{
}

