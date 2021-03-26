package com.mindgate.eelectricalstore.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mindgate.eelectricalstore.exception.ValidaterException;
import com.mindgate.eelectricalstore.model.City;
import com.mindgate.eelectricalstore.model.Dealer;
import com.mindgate.eelectricalstore.model.Product;
import com.mindgate.eelectricalstore.model.ProductLogin;
import com.mindgate.eelectricalstore.model.State;
import com.mindgate.eelectricalstore.repository.EelectricalRepository;
@Service
public class EelectricalServiceImpl implements EelectricalService{

	@Autowired
	private EelectricalRepository eelectricalRepository;
	
	@Override
	public Dealer addDealer(Dealer dealers) {
		
		System.out.print("enter the add dealer service");
		
		return eelectricalRepository.addDealer(dealers);
	}

	@Override
	public List<City> getCityByState(String stateName) {
		
		return eelectricalRepository.getCityByState(stateName);
	}

	@Override
	public List<Dealer> showDealerByCity(String stateName, String cityName) {
	
		return eelectricalRepository.showDealerByCity(stateName, cityName);
	}

	@Override
	public Product addProduct(Product product) {
		
		return eelectricalRepository.addProduct(product);
	}

	@Override
	public List<State> displayState() {
		// TODO Auto-generated method stub
		
		return eelectricalRepository.displayState();
	}

	@Override
	public List<Product> displayProduct() {
		// TODO Auto-generated method stub
		return eelectricalRepository.displayProduct();
	}

	@Override
	public ResponseEntity<Object> productLogin(String dealerName, String phoneNumber) throws ValidaterException  {
		// TODO Auto-generated method stub
		return eelectricalRepository.productLogin(dealerName, phoneNumber);
	}

	
}
