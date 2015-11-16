package com.hd.zytb.repository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.hd.zytb.entity.News;
public interface NewsRepository extends PagingAndSortingRepository<News, Long>,JpaSpecificationExecutor<News>{
}

