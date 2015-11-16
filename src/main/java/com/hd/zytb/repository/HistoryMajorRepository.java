package com.hd.zytb.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.hd.zytb.entity.HistoryMajor;
import com.hd.zytb.entity.School;
public interface HistoryMajorRepository extends PagingAndSortingRepository<HistoryMajor, Long>,JpaSpecificationExecutor<HistoryMajor>{
    public List<HistoryMajor>	findByType(Integer type);
    public List<HistoryMajor>	findBySchool(School school);
    public List<HistoryMajor>	findBySchoolAndTypeAndYear(School school,Integer type,String year);
    
}

