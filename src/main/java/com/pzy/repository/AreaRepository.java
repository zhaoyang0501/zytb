package com.pzy.repository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.pzy.entity.Area;
public interface AreaRepository extends PagingAndSortingRepository<Area, Long>,JpaSpecificationExecutor<Area>{
}

