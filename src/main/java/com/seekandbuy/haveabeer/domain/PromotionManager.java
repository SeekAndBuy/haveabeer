package com.seekandbuy.haveabeer.domain;

import java.util.List;

public class PromotionManager {
	private User user;
	
	public PromotionManager(User user) {
		this.user = user;
	}

	public void userCreatePromotion(Promotion promotion) {
		user.promotions.add(promotion);;
	}
	
	public void userDeletePromotion(Promotion promotion) {
		user.promotions.remove(promotion);
	}
	
	public List<Promotion> getUserPromotions(){
		return user.promotions;
	}

	//ESSE MÉTODO DE BUSCA É SÓ PARA USUARIO, EXISTIRA OUTRO PARA O FEED
	//DISCUTIR SE NAO É MELHOR CRIAR UMA INTERFACE PARA BUSCAR UMA PROMOCAO
	/*
	public Promotion findPromotion(short findType, String arg) {
		switch (findType) {
		case 0:
		}
	}
	
	
	private Promotion findByAddress(String arg)
	{
		return null;
	}
	
	private Promotion findByBrand(String arg)
	{
		return null;
	}
	
	private Promotion findById(String arg)
	{
		return null;
	}
	
	private Promotion findByType(String arg)
	{
		return null;
	}
	*/
	
}
