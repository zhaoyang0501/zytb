package com.hd.zytb.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.hd.zytb.entity.User;
public interface UserRepository extends PagingAndSortingRepository<User, Long>,JpaSpecificationExecutor<User>{
	  public List<User> findByNameAndPassword(String userName,String password);
	  public List<User> findByName(String userName);
}

