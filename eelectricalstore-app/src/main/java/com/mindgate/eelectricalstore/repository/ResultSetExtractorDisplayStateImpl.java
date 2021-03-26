package com.mindgate.eelectricalstore.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.mindgate.eelectricalstore.model.StateResponse;

public class ResultSetExtractorDisplayStateImpl implements ResultSetExtractor<Object> {

	@Override
	public List<StateResponse> extractData(ResultSet rs) throws SQLException, DataAccessException {
		// TODO Auto-generated method stub
		
		 List<StateResponse> list=new ArrayList<StateResponse>();
		 while(rs.next())
		 {
		 StateResponse state=new StateResponse();
		 state.setStateName(rs.getString(1));
		 list.add(state);
		 }
		return list;
	}

}
