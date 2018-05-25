package com.stackroute.maverick.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.stackroute.maverick.domain.AdaptiveUser;

public interface AdaptiveUserRepository extends Neo4jRepository<AdaptiveUser, Long>{

}
