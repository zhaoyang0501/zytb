package com.hd.zytb.repository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.hd.zytb.entity.Area;
public interface AreaRepository extends PagingAndSortingRepository<Area, Long>,JpaSpecificationExecutor<Area>{
}

