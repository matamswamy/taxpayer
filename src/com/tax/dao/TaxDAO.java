package com.tax.dao;

import java.util.List;

import com.tax.modal.dao.TaxTl;

public interface TaxDAO {

	public Integer insertTax(TaxTl taxTl);

	public List<TaxTl> getAllTaxs();

}
