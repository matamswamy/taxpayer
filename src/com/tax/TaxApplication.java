package com.tax;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.tax.controller.TaxController;
import com.tax.service.dto.TaxDTO;
import com.tax.utils.DateUtils;

public class TaxApplication {

	private static TaxController taxController;
	static {
		taxController = new TaxController();
	}

	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		Integer option = 0;
		do {
			System.out.println("chosse one option");
			System.out.println("0  for yourexit");
			System.out.println("1 insertTax");
			System.out.println("2 getAllTaxs");
			option = sn.nextInt();
			switch (option) {
			case 1:
				saveTax();
				break;
			case 2:
				getAllTaxes();
				break;

			default:
				System.out.println("chose one option");
				break;
			case 0:
				System.out.println("your details are not inserted");
			}

		} while (option != 0);

	}

	public static void saveTax() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Entre FirstName");
			String firstName = br.readLine();
			System.out.println("Entre lastName");
			String lastName = br.readLine();
			System.out.println("Entre emailId");
			String emailId = br.readLine();
			System.out.println("Entre pendingAmount");
			String pendingAmount = br.readLine();
			System.out.println("Entre paidAmount");
			String paidAmount = br.readLine();
			System.out.println("Entre dueTIme");
			String dueTime = br.readLine();
			
			Date udate = DateUtils.convertStringToDate(dueTime);
			TaxDTO taxdto = new TaxDTO();
			taxdto.setFirstName(firstName);
			taxdto.setLastName(lastName);
			taxdto.setEmailId(emailId);
			taxdto.setPendingAmount(pendingAmount);
			taxdto.setPaidAmount(paidAmount);
			taxdto.setDueTime(udate);
			Integer taxId = taxController.insertTax(taxdto);
			if(taxId != null && taxId>0) {
				System.out.println("user details are scusses full inserted");
			}else {
				System.out.println("your details are not inserted");
			}
			
		} catch (Exception e) {

		}
	}

	public static void getAllTaxes() {

		try {
			List<TaxDTO> taxs = taxController.getAllTaxs();
			if (taxs != null && !taxs.isEmpty()) {
				for (TaxDTO tax : taxs) {
					System.out.println("____________________");
					System.out.println("your details");
					System.out.println("customer firstName is:" + tax.getFirstName());
					System.out.println("customer lastName is:" + tax.getLastName());
					System.out.println("customer emailId is:" + tax.getEmailId());
					System.out.println("customer pendingAmount is:" + tax.getPendingAmount());
					System.out.println("customer paidAmount is:" + tax.getPaidAmount());
					System.out.println("cusomer dueTime is:" + tax.getDueTime());
					System.out.println("Due Date after converstion " + DateUtils.convertDateToString(tax.getDueTime()));
				}
			} else {
				System.out.println("details are not avalable");
			}

		} catch (Exception e) {
			
		}
	}

}
