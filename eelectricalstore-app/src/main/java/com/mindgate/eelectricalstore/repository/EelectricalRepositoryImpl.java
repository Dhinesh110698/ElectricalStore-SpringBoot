package com.mindgate.eelectricalstore.repository;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mindgate.eelectricalstore.exception.ValidaterException;
import com.mindgate.eelectricalstore.model.City;
import com.mindgate.eelectricalstore.model.Dealer;
import com.mindgate.eelectricalstore.model.Product;
import com.mindgate.eelectricalstore.model.ProductLogin;
import com.mindgate.eelectricalstore.model.Result;
import com.mindgate.eelectricalstore.model.State;

@Repository
public class EelectricalRepositoryImpl implements EelectricalRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Dealer addDealer(Dealer dealers) {

		// Get The State Id using MysqlDataBaseQuery
		System.out.println("enter the add dealer repository page stateid enter");
		String getStateId = MysqlDataBaseQuery.getDealerStateId(dealers);
		System.out.println("enter the add dealer repository page stateid fetch");
		String stateId = jdbcTemplate.query(getStateId, new ResultSetExtractorGetStateIdImpl());

		// Get The City Id using MysqlDataBaseQuery
		System.out.println("enter the add dealer repository page cityid enter");
		String getCityId = MysqlDataBaseQuery.getDealerCityId(dealers);
		System.out.println("enter the add dealer repository page cityid fetch");
		String cityId = jdbcTemplate.query(getCityId, new ResultSetExtractorGetCityIdImpl());

		// Store The Dealer Name, Address, PhoneNumber in Dealer Table
		System.out.println("enter the add dealer repository page insertquery enter");
		String insertQuery = MysqlDataBaseQuery.insertDealersQuery(dealers, stateId, cityId);
		System.out.println("enter the add dealer repository page insertquery inserted");
		int row = jdbcTemplate.update(insertQuery);
		System.out.println(row);
		if (row >= 1)
			return dealers;
		else
			return null;
	}

	@Override
	public List<City> getCityByState(String stateName) {

		String getCityName = MysqlDataBaseQuery.getCityByStateQuery(stateName);
		return (List<City>) jdbcTemplate.query(getCityName, new ResultSetExtractorGetCityByStateImpl());

	}

	@Override
	public List<Dealer> showDealerByCity(String stateName, String cityName) {

		String showDealers = MysqlDataBaseQuery.showDealerByCityQuery(stateName, cityName);

		return (List<Dealer>) jdbcTemplate.query(showDealers, new ResultSetExtractorShowDealersByCityImpl());
	}

	@Override
	public Product addProduct(Product product) {

		String categoryId = "select category_id from product_category where category_name='" + product.getCategoryName()
				+ "'";
		String dealerId = " select dealer_id from dealer where dealer_name='" + product.getDealerName() + "'";

		categoryId = jdbcTemplate.query(categoryId, new ResultSetExtractorCategoryIdImpl());
		dealerId = jdbcTemplate.query(dealerId, new ResultSetExtractorDealerIdImpl());
		// int id=Integer.parseInt(dealerId) ;
		String addProductQuery = MysqlDataBaseQuery.addProduct(product, categoryId, dealerId);

		jdbcTemplate.update(addProductQuery);

		return product;
	}

	@Override
	public List<State> displayState() {
		// TODO Auto-generated method stub

		String stateQuery = "select state_name from state";

		return (List<State>) jdbcTemplate.query(stateQuery, new ResultSetExtractorDisplayStateImpl());
	}

	@Override
	public List<Product> displayProduct() {
		// TODO Auto-generated method stub
		String productQuery = "select category_name from product_category";

		return (List<Product>) jdbcTemplate.query(productQuery, new ResultSetExtractorDisplayProductImpl());
	}

	@Override
	public ResponseEntity<Object> productLogin(String dealerName, String phoneNumber) throws ValidaterException  {
		// TODO Auto-generated method stub
		
		String loginQuery="select dealer_id from dealer where dealer_name='"+dealerName+"'and phone_number='"+phoneNumber+"'";
		Result result = new Result();
		try {
			String id=jdbcTemplate.query(loginQuery, new ResultSetExtractorProductLoginImpl());
			System.out.print(id);
			if(!id.equals(null))
				result.setMessage("Success");
		return ResponseEntity.accepted().body(result);
		}	
		catch(InvalidResultSetAccessException e)		
		{
			throw new ValidaterException("Failure");
		}catch(DataAccessException e)		
		{
			throw new ValidaterException("Failure");
		}
		

		
	}
}
