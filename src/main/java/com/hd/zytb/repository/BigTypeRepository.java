package com.hd.zytb.repository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.hd.zytb.entity.BigType;
import com.hd.zytb.entity.Category;
public interface BigTypeRepository extends PagingAndSortingRepository<BigType, Long>,JpaSpecificationExecutor<BigType>{
    
}

