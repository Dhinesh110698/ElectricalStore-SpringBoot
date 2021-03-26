package com.mindgate.eelectricalstore.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.mindgate.eelectricalstore.model.City;

public class ResultSetExtractorGetCityIdImpl implements ResultSetExtractor<String> {

	City city=new City();
	
	String getCityId;
	
	@Override
	public String extractData(ResultSet rs) throws SQLException, DataAccessException {
		
		// Get the City Id
		
		rs.next();
		city.setCityId(rs.getString(1));
		getCityId=city.getCityId();
		
		//System.out.println("C1");
		
		return getCityId;
		
		
	}

}
