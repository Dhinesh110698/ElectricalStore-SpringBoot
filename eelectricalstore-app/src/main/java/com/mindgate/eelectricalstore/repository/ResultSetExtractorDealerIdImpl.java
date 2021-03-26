package com.mindgate.eelectricalstore.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.mindgate.eelectricalstore.model.Product;

public class ResultSetExtractorDealerIdImpl implements ResultSetExtractor<String> {

	@Override
	public String extractData(ResultSet rs) throws SQLException, DataAccessException {
		// TODO Auto-generated method stub
		
		
	Product product = new Product();
		rs.next();
		product.setDealerId(rs.getInt(1));
		int dealerId=product.getDealerId();
		String dealerId1=String.valueOf(dealerId);
		
		
		
		return dealerId1;
	}

}
