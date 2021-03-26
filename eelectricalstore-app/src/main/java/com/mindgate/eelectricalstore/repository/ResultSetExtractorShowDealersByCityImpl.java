package com.mindgate.eelectricalstore.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.mindgate.eelectricalstore.model.City;
import com.mindgate.eelectricalstore.model.Dealer;

public class ResultSetExtractorShowDealersByCityImpl implements ResultSetExtractor<Object> {

	@Override
	public List<Dealer> extractData(ResultSet rs) throws SQLException, DataAccessException {
		
		List<Dealer> dealersList=new ArrayList();
		
		while(rs.next())
		{
			Dealer dealer=new Dealer();
			
			dealer.setDealerName(rs.getString(1));
			dealer.setAddress(rs.getString(2));
			dealer.setPhoneNumber(rs.getLong(3));
			
			dealersList.add(dealer);
			
		}
		
		return dealersList;
	}

}
