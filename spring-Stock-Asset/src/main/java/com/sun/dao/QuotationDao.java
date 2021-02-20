package com.sun.dao;

import java.util.List;

import com.sun.model.Quotation;

public interface QuotationDao {

	List<Quotation> getQuotationList(String code);

}
