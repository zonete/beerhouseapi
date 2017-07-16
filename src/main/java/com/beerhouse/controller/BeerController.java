package com.beerhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.beerhouse.entity.BeerEntity;
import com.beerhouse.service.BeerService;
import com.mysql.fabric.Response;
@CrossOrigin
@RestController
public class BeerController {
	@Autowired
	private BeerService beerService;
	
	@RequestMapping(value = "/beers", method = RequestMethod.GET)
	public ResponseEntity<List<BeerEntity>> getAll(){
        try {
        	List<BeerEntity> list = beerService.getAll();
        	return new ResponseEntity<>(list,HttpStatus.OK);
			
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value  = "beers/{id}", method = RequestMethod.GET)
	public ResponseEntity<BeerEntity> show(@PathVariable(value="id")Integer id){
        try {
        	BeerEntity result = beerService.findById(id);
        	return new ResponseEntity<>(result,HttpStatus.OK);
			
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@RequestMapping(value = "beers/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BeerEntity> inserir(@RequestBody BeerEntity beer){
        try {
        	BeerEntity result = beerService.Insert(beer);
        	return new ResponseEntity<>(result,HttpStatus.OK);
			
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "beers/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BeerEntity> update(@PathVariable(value="id") Integer id, @RequestBody BeerEntity beer){
        try {
        	beer.setId(id);
        	BeerEntity result = beerService.Update(beer);
        	return new ResponseEntity<>(result,HttpStatus.OK);
			
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value  = "beers/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> delete(@PathVariable(value="id")Integer id){
        try {
        	beerService.Delete(id);
        	return new ResponseEntity<Boolean>(true,HttpStatus.OK);
			
		}catch (Exception e) {
			return new ResponseEntity<Boolean>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
