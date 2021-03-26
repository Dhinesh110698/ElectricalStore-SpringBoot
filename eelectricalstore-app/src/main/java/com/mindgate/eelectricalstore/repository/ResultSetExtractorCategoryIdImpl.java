package com.mindgate.eelectricalstore.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.mindgate.eelectricalstore.model.Product;

public class ResultSetExtractorCategoryIdImpl implements ResultSetExtractor<String> {

	@Override
	public String extractData(ResultSet rs) throws SQLException, DataAccessException {
		// TODO Auto-generated method stub
		
		Product product = new Product();
		rs.next();
		product.setCategoryId(rs.getString(1));
		String categoryId=product.getCategoryId();
		
		
		return categoryId;
	}

}
