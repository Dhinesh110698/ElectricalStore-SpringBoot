package com.mindgate.eelectricalstore.repository;

import java.sql.SQLException;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.mindgate.eelectricalstore.exception.ValidaterException;
import com.mindgate.eelectricalstore.model.City;
import com.mindgate.eelectricalstore.model.Dealer;
import com.mindgate.eelectricalstore.model.Product;
import com.mindgate.eelectricalstore.model.ProductLogin;
import com.mindgate.eelectricalstore.model.State;

public interface EelectricalRepository {
	
	public Dealer addDealer(Dealer dealers);
	public List<City> getCityByState(String stateName);
	public List<Dealer> showDealerByCity(String stateName,String cityName);
	public Product addProduct(Product product);
	public List<State> displayState();
	public List<Product> displayProduct();
	public ResponseEntity<Object> productLogin(String dealerName,String phoneNumber) throws ValidaterException;


}
