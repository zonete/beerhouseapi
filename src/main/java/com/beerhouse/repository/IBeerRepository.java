package com.beerhouse.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.beerhouse.entity.BeerEntity;

@Repository
public interface IBeerRepository extends CrudRepository<BeerEntity, Integer> {

}
