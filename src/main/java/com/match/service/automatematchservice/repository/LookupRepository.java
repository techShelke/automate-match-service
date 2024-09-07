package com.match.service.automatematchservice.repository;

import com.match.service.automatematchservice.dao.Lookup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LookupRepository extends JpaRepository<Lookup, Integer> {
    List<Lookup> findBySys(String sys);
}
