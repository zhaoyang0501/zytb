package com.hd.zytb.repository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.hd.zytb.entity.Category;
public interface CategoryRepository extends PagingAndSortingRepository<Category, Long>,JpaSpecificationExecutor<Category>{
    
}

