package com.tax.utils;

import com.tax.modal.dao.TaxTl;
import com.tax.service.dto.TaxDTO;

public class FactoryUtils {
	private FactoryUtils() {

	}

	public static TaxTl convertTaxDTOToTaxTl(TaxDTO taxDTO) {
		TaxTl taxtl = null;
		if (taxDTO != null) {
			taxtl = new TaxTl();
			taxtl.setUserId(taxDTO.getUserId());
			taxtl.setFirstName(taxDTO.getFirstName());
			taxtl.setLastName(taxDTO.getLastName());
			taxtl.setEmailId(taxDTO.getEmailId());
			taxtl.setPendingAmount(taxDTO.getPendingAmount());
			taxtl.setPaidAmount(taxDTO.getPaidAmount());
			if (taxDTO.getDueTime() != null) {
				java.sql.Date sdate = new java.sql.Date(taxDTO.getDueTime().getTime());
				taxtl.setDueTime(sdate);
			}
		}

		return taxtl;
	}

	public static TaxDTO convertTaxTlToTaxDTO(TaxTl taxTl) {
		TaxDTO taxDTO = null;
		if (taxTl != null) {
			taxDTO = new TaxDTO();
			taxDTO.setUserId(taxTl.getUserId());
			taxDTO.setFirstName(taxTl.getFirstName());
			taxDTO.setLastName(taxTl.getLastName());
			taxDTO.setEmailId(taxTl.getEmailId());
			taxDTO.setPendingAmount(taxTl.getPendingAmount());
			taxDTO.setPaidAmount(taxTl.getPaidAmount());
			taxDTO.setDueTime(taxTl.getDueTime());
		}
		return taxDTO;
	}

}
