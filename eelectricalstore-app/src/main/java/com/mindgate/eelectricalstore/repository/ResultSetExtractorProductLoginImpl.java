package com.mindgate.eelectricalstore.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.mindgate.eelectricalstore.model.ProductLogin;

public class ResultSetExtractorProductLoginImpl implements ResultSetExtractor<String> {

	@Override
	public String extractData(ResultSet rs) throws SQLException, DataAccessException {
		// TODO Auto-generated method stub
		
		ProductLogin productLogin = new ProductLogin();
		rs.next();
		productLogin.setDealerId(rs.getInt(1));
		
		String id=String.valueOf(productLogin.getDealerId());
		
		return id;
	}

}
