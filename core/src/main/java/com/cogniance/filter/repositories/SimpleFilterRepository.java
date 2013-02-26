package com.cogniance.filter.repositories;

import com.cogniance.filter.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * User: DOOM
 * Date: 21.02.13
 * Time: 19:16
 */
@Repository
public interface SimpleFilterRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {



}
