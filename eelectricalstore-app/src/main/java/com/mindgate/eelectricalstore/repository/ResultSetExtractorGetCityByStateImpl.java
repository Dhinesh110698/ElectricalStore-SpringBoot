package com.mindgate.eelectricalstore.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.mindgate.eelectricalstore.model.City;
import com.mindgate.eelectricalstore.model.CityResponse;

public class ResultSetExtractorGetCityByStateImpl implements ResultSetExtractor<Object> {

	@Override
	public List<CityResponse> extractData(ResultSet rs) throws SQLException, DataAccessException {
		// TODO Auto-generated method stub
		
		
		List<CityResponse> cityList=new ArrayList();
		
		while(rs.next())
		{
			CityResponse city=new CityResponse();
			//city.setCityId(rs.getString(1));
			city.setCityName(rs.getString(2));
			cityList.add(city);
			
			
		}
		
		
		
		return cityList;
	}

}
