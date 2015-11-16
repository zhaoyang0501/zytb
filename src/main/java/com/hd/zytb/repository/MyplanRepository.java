package com.hd.zytb.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.hd.zytb.entity.Myplan;
import com.hd.zytb.entity.User;
public interface MyplanRepository extends PagingAndSortingRepository<Myplan, Long>,JpaSpecificationExecutor<Myplan>{
	public List<Myplan> findByUser(User user);
}

