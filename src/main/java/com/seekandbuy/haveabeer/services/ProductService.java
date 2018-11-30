package com.seekandbuy.haveabeer.services;

import com.seekandbuy.haveabeer.match.SearchBeer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.seekandbuy.haveabeer.domain.Beer;
import com.seekandbuy.haveabeer.domain.BeerUser;
import com.seekandbuy.haveabeer.dao.ProductDao;
import com.seekandbuy.haveabeer.dao.UserDao;
import com.seekandbuy.haveabeer.exceptions.ProductNotFoundException;

@Service
public class ProductService extends GenericService<Beer>
{	
	@Autowired
	private ProductDao promotionDao;
	
	SearchBeer searchBeer = new SearchBeer();
	
	public List<Beer> listItemByUserCharacteristic(BeerUser user, List<Beer> allBeers){

		return searchBeer.ListAllProductsByUser(user, allBeers);
	}
	
	@Override
	public List<Beer> listItem()
	{
		return promotionDao.findAll();  
	}
	
	@Override
	public Optional<Beer> findItem(Long id)
	{
		Optional<Beer> promotion = promotionDao.findById(id);
		
		if(promotion == null)
		{
			throw new ProductNotFoundException("Promotion can not be found");
		}
		
		return promotion;
	}
	
	@Override
	public Beer createItem(Beer promotion) 
	{
		promotion.setId(null); //Garantir que criaremos uma instância nova e não atualizaremos nenhuma	
		promotion.getBeerCharacteristic().setId(null);
		return promotionDao.save(promotion);	
	}
	
	@Override
	public void deleteItem(Long id) 
	{
		try 
		{
			promotionDao.deleteById(id);
		}
		catch(EmptyResultDataAccessException e)
		{
			throw new ProductNotFoundException("Promotion can not be found");
		}
	}
	
	@Override
	public void updateItem(Beer promotion)
	{
		verifyExistence(promotion);
		promotionDao.save(promotion);
	}
	
	//Semântica melhor, só verifica existência 
	@Override
	public void verifyExistence(Beer promotion)
	{
		findItem(promotion.getId());
	}
	
	public List<Beer> getPromotionByUserId(Long id) 
	{
		return promotionDao.getPromotionByUserId(id);
	}
	
}
