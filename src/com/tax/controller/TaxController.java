package com.tax.controller;

import java.util.List;

import com.tax.service.TaxService;
import com.tax.service.dto.TaxDTO;
import com.tax.service.impl.TaxServiceImpl;

public class TaxController {

	private TaxService taxService;

	public TaxController() {
		this.taxService = new TaxServiceImpl();
	}

	public Integer insertTax(TaxDTO taxDTO) {
		if (taxDTO != null) {
			return taxService.saveTax(taxDTO);
		}
		return null;
	}

	public List<TaxDTO> getAllTaxs() {
		return taxService.loadAllTaxs();
	}

}
