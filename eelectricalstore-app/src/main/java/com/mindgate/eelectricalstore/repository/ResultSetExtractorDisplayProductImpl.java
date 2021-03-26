package com.mindgate.eelectricalstore.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.mindgate.eelectricalstore.model.ProductResponse;
import com.mindgate.eelectricalstore.model.StateResponse;

public class ResultSetExtractorDisplayProductImpl implements ResultSetExtractor<Object> {

	@Override
	public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
		 List<ProductResponse> list=new ArrayList<ProductResponse>();
		 while(rs.next())
		 {
			 ProductResponse product=new ProductResponse();
		 product.setCategoryName(rs.getString(1));
		 list.add(product);
		 }
		return list;
	}

}
