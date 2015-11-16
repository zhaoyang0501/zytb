package com.hd.zytb.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.hd.zytb.entity.Plan;
import com.hd.zytb.entity.User;
public interface PlanRepository extends PagingAndSortingRepository<Plan, Long>,JpaSpecificationExecutor<Plan>{
    public List<Plan>	findByUser(User user);
}

