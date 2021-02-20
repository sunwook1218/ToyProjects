package com.sun.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Quotation {

	private Timestamp date;
	private BigDecimal cq;
	private BigDecimal var;
	private BigDecimal oq;
	private BigDecimal hq;
	private BigDecimal lq;
	private BigDecimal tv;

}
