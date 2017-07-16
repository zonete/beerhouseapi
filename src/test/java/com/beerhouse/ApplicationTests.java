package com.beerhouse;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.beerhouse.Application;
import com.beerhouse.controller.BeerController;
import com.beerhouse.entity.BeerEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackageClasses = Application.class)
public class ApplicationTests {

	
	@Autowired
	private BeerController beerController;
	
	@Test
	public void contextLoads() {
		assertThat(beerController).isNotNull();
	}
	
	@Test 
	public void testBeerInsert() {
		ResponseEntity<BeerEntity> result = beerController.inserir(new BeerEntity("Cerveja Teste","Ingredients","Alcohol",(float) 2.0,"Category"));
		assertThat(result.getStatusCodeValue()).isEqualTo(HttpStatus.OK.value());
		assertThat(result.getBody().getId()).isGreaterThan(0);
	}
	@Test 
	public void testBeerDelete() {
		ResponseEntity<BeerEntity> result = beerController.inserir(new BeerEntity("CervejaTest","Ingredients","Alcohol",(float) 2.0,"Category"));
		assertThat(result.getBody().getId()).isGreaterThan(0);
		ResponseEntity<Boolean> resultDelete = beerController.delete(result.getBody().getId());
		assertThat(resultDelete.getBody()).isTrue();
		assertThat(resultDelete.getStatusCodeValue()).isEqualTo(HttpStatus.OK.value());
	}
	
	@Test 
	public void testBeerUpdate() {
		ResponseEntity<BeerEntity> result = beerController.inserir(new BeerEntity("CervejaTest","Ingredients","Alcohol",(float) 2.0,"Category"));
		assertThat(result.getBody().getId()).isGreaterThan(0);
		BeerEntity beerUpd = result.getBody();
		String oldname = beerUpd.getName();
		beerUpd.setName(oldname + "updt");
		ResponseEntity<BeerEntity> resultUpdate = beerController.update(beerUpd.getId(), beerUpd);
		assertThat(resultUpdate.getBody().getName()).isEqualTo(oldname + "updt");
		assertThat(resultUpdate.getStatusCodeValue()).isEqualTo(HttpStatus.OK.value());
	}

	@Test
	public void testBeerGetAll() {
		ResponseEntity<List<BeerEntity>> result = beerController.getAll();
		assertThat(result.getStatusCodeValue()).isEqualTo(HttpStatus.OK.value());
		assertThat(result.getBody()).isNotNull();		
	}
	
	@Test
	public void testFailInsertWithoutName() {
		ResponseEntity<BeerEntity> result = beerController.inserir(new BeerEntity(null,"Ingredients","Alcohol",(float) 2.0,"Category"));
		assertThat(result.getStatusCodeValue()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR.value());
				
	}
	

}