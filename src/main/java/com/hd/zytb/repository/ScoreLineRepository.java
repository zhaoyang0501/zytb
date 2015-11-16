package com.hd.zytb.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.hd.zytb.entity.Area;
import com.hd.zytb.entity.ScoreLine;
public interface ScoreLineRepository extends PagingAndSortingRepository<ScoreLine, Long>,JpaSpecificationExecutor<ScoreLine>{
	public List<ScoreLine> findByAreaAndYear(Area area,String year);
}

