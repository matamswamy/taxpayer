package com.tax.service;

import java.util.List;

import com.tax.service.dto.TaxDTO;

public interface TaxService {

	public Integer saveTax(TaxDTO taxDTO);

	public List<TaxDTO> loadAllTaxs();

}
