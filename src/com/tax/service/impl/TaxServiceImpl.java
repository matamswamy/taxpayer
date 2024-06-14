package com.tax.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.tax.dao.TaxDAO;
import com.tax.dao.impl.TaxDAOImpl;
import com.tax.exception.MyCustomeException;
import com.tax.modal.dao.TaxTl;
import com.tax.service.TaxService;
import com.tax.service.dto.TaxDTO;
import com.tax.utils.FactoryUtils;

public class TaxServiceImpl implements TaxService {
	private TaxDAO taxDAO;

	public TaxServiceImpl() {
		this.taxDAO = new TaxDAOImpl();
	}

	@Override
	public Integer saveTax(TaxDTO taxDTO) {
		Integer userId = 0;
		try {
		if (taxDTO != null) {
			TaxTl taxTl = FactoryUtils.convertTaxDTOToTaxTl(taxDTO);
			if (taxTl != null) {
				userId = taxDAO.insertTax(taxTl);

			}
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return userId;
	}

	@Override
	public List<TaxDTO> loadAllTaxs() {
		List<TaxDTO> taxs = new ArrayList<>();
		try {
			List<TaxTl> tax = taxDAO.getAllTaxs();
			if (tax != null && !tax.isEmpty()) {
				ListIterator<TaxTl> li = tax.listIterator();
				while (li.hasNext()) {
					TaxTl taxTl = li.next();
					TaxDTO taxDTO = FactoryUtils.convertTaxTlToTaxDTO(taxTl);
					taxs.add(taxDTO);
				}

			}
		} catch (Exception e) {
			throw new MyCustomeException("Exception occured while getting user details in TaxServiceImpl " + e.getMessage());
		}
		return taxs;
	}

}
