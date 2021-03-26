package com.mindgate.eelectricalstore.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.eelectricalstore.exception.ValidaterException;
import com.mindgate.eelectricalstore.model.City;
import com.mindgate.eelectricalstore.model.Dealer;
import com.mindgate.eelectricalstore.model.Product;
import com.mindgate.eelectricalstore.model.ProductLogin;
import com.mindgate.eelectricalstore.model.State;
import com.mindgate.eelectricalstore.service.EelectricalService;

@CrossOrigin("*")
@RestController
@RequestMapping("/eelectrical/app")
public class EelectricalController {
	
	@Autowired
	private EelectricalService eelectricalService;
	
	@PostMapping("/adddealers")
	public Dealer registerDealer(@RequestBody Dealer dealers)
	{
		System.out.print("enter the add dealer");
		Dealer dealer1=eelectricalService.addDealer(dealers);
		System.out.println(dealer1);
		return dealer1;
		
	}
	
	@GetMapping("/getCity/{state}")
	public List<City> getCityByState(@PathVariable("state") String stateName)
	{
		return eelectricalService.getCityByState(stateName);
		
	}
	
	@GetMapping("/showDealers")
	public List<Dealer> showDealerByCity(@RequestParam("stateName") String stateName,@RequestParam("cityName") String cityName)
	{
		return eelectricalService.showDealerByCity(stateName, cityName);
		
	}
	
	@PostMapping("/addproducts")
	public Product addProduct(@RequestBody Product products)
	{
  		return eelectricalService.addProduct(products);
		
	}
	@GetMapping
	public List<State> displayState()
	{
	return eelectricalService.displayState();
	}
	
	@GetMapping("/displayProduct")
	public List<Product> displayProduct()
	{
		return eelectricalService.displayProduct();
	}
	
	@GetMapping("/login")
	public ResponseEntity<Object> productLogin(@RequestParam("dealerName") String dealerName,@RequestParam("phoneNumber") String phoneNumber) throws ValidaterException
	{
		
		return eelectricalService.productLogin(dealerName, phoneNumber);
		
	}
	
	
	

}
