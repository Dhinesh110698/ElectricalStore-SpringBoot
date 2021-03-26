package com.mindgate.eelectricalstore.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class Product {
	
	private String productName;
	private int quantity;
	private double price;
//	private byte[] image;
//	private Date date_created;
//	private Date last_updated;
	private String categoryId;
	private String categoryName;
	private int dealerId;
	private String dealerName;
	
	

}
