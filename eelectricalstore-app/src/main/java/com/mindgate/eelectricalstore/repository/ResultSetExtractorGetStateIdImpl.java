package com.mindgate.eelectricalstore.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.mindgate.eelectricalstore.model.State;

public class ResultSetExtractorGetStateIdImpl implements ResultSetExtractor<String> {

	 State state=new State();
	
	String getStateId;
	
	@Override
	public String extractData(ResultSet rs) throws SQLException, DataAccessException {
		
		// Get The State Id
		
		rs.next();
		state.setStateId(rs.getString(1));
		getStateId=state.getStateId();
		
		//System.out.println("S1");
		
		return getStateId;
	}

}
