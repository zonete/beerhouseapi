package com.beerhouse.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beerhouse.entity.BeerEntity;
import com.beerhouse.repository.IBeerRepository;

@Service
public class BeerService {
	@Autowired
	private IBeerRepository beerRepository;
	
	public List<BeerEntity> getAll() {
		Iterable<BeerEntity> beers = beerRepository.findAll();
		List<BeerEntity> result = new ArrayList<BeerEntity>();
		beers.forEach(result::add);
		return result;
	}
	
	public BeerEntity findById(Integer id){
		return beerRepository.findOne(id);
	}
	
	public BeerEntity Insert(BeerEntity beer) throws Exception {
		Valid(beer);
		return beerRepository.save(beer);
	}
	
	public BeerEntity Update(BeerEntity beer) throws Exception {
		if(beerRepository.findOne(beer.getId())==null)
			return null;
		Valid(beer);
		return beerRepository.save(beer);
	}
	
	public void Delete(Integer id) throws Exception {
		if(beerRepository.findOne(id)==null)
			throw new Exception("Not Found");
		
		beerRepository.delete(id);
		
	}

	private void Valid(BeerEntity beer) throws Exception {
		if(beer.getName().isEmpty())
			throw new Exception("Nome é obrigatório");
	}
}
