package com.mindgate.eelectricalstore.repository;

import com.mindgate.eelectricalstore.model.Dealer;
import com.mindgate.eelectricalstore.model.Product;

public class MysqlDataBaseQuery {
	
	
	public static String getDealerStateId(Dealer dealers)
	{
		StringBuffer getStateId= new StringBuffer();
		getStateId.append("select state_id from state");
		getStateId.append(" where state_name='"+dealers.getStateName()+"'");
		return getStateId.toString();
		
	}
	
	public static String getDealerCityId(Dealer dealers)
	{
		
		StringBuffer getCityId= new StringBuffer();
		getCityId.append("select city_id from city ");
		getCityId.append(" where city_name='"+dealers.getCityName()+"'");
		return getCityId.toString();
		
	}
	
	public static String insertDealersQuery(Dealer dealers,String stateId,String cityId)
	{
		
		StringBuffer insertQuery= new StringBuffer();
		insertQuery.append("insert into dealer(dealer_name,address,phone_number,state_id,city_id) values ('");
		insertQuery.append(dealers.getDealerName());
		insertQuery.append("','");
		insertQuery.append(dealers.getAddress());
		insertQuery.append("',");
		insertQuery.append(dealers.getPhoneNumber());
		insertQuery.append(",'");
		insertQuery.append(stateId);
		insertQuery.append("','");
		insertQuery.append(cityId);
		insertQuery.append("')");
		
		return insertQuery.toString();
		
	}
	
	public static String getCityByStateQuery(String stateName)
	{
		StringBuffer getCity= new StringBuffer();
		getCity.append("select city_id,city_name from city");
		getCity.append(" where state_id=(select state_id");
		getCity.append(" from state  where state_name='"+stateName+"')");
		
		
		
		return getCity.toString();
	}
	
	public static String showDealerByCityQuery(String stateName,String cityName)
	{

		
		StringBuffer showDealers= new StringBuffer();
		showDealers.append("select dealer_name,address,phone_number from dealer");
		showDealers.append(" where state_id=(select state_id");
		showDealers.append(" from state where state_name='"+stateName+"'");
		showDealers.append(" and city_id=(select city_id from city where city_name='"+cityName+"'))");
					
		return showDealers.toString();
		
	}
	
	public static String addProduct(Product products,String categoryId,String dealerId)
	{

	
		
		StringBuffer insertProductQuery= new StringBuffer();
		
		insertProductQuery.append("insert into product(product_name,price,quantity,category_id,dealer_id) values ('");
		insertProductQuery.append(products.getProductName());
		insertProductQuery.append("',");
		insertProductQuery.append(products.getPrice());
		insertProductQuery.append(",");
		insertProductQuery.append(products.getQuantity());
		insertProductQuery.append(",'");
		insertProductQuery.append(categoryId);
		insertProductQuery.append("',");
		insertProductQuery.append(dealerId);
		insertProductQuery.append(")");
		
		return insertProductQuery.toString();
		
	}

}
