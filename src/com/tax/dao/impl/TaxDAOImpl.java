package com.tax.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tax.dao.TaxDAO;
import com.tax.modal.dao.TaxTl;
import com.tax.utils.TaxUtils;

public class TaxDAOImpl implements TaxDAO {

	@Override
	public Integer insertTax(TaxTl taxTl) {
		Integer userId = 0;
		PreparedStatement pst = null;
		try {
			String sql = "insert taxpayer(first_name,last_name,email_id,pending_amount,paid_amount,due_time)values(?,?,?,?,?,?)";
			pst = TaxUtils.getConnection().prepareStatement(sql);
			pst.setString(1, taxTl.getFirstName());
			pst.setString(2, taxTl.getLastName());
			pst.setString(3, taxTl.getEmailId());
			pst.setString(4, taxTl.getPendingAmount());
			pst.setString(5, taxTl.getPaidAmount());
			pst.setDate(6, taxTl.getDueTime());
			userId = pst.executeUpdate();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			TaxUtils.closeStatement(pst);
		}
		return userId;
	}

	@Override
	public List<TaxTl> getAllTaxs() {
		List<TaxTl> taxs = new ArrayList<>();
		Statement st = null;
		ResultSet rs = null;
		try {
			String sql = "select user_id,first_name,last_name,email_id,pending_amount,paid_amount,due_time from taxpayer";
			st = TaxUtils.getConnection().createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				TaxTl tax = new TaxTl();
				tax.setUserId(rs.getInt("user_id"));
				tax.setFirstName(rs.getString("first_name"));
				tax.setLastName(rs.getString("last_name"));
				tax.setEmailId(rs.getString("email_id"));
				tax.setPendingAmount(rs.getString("pending_amount"));
				tax.setPaidAmount(rs.getString("paid_amount"));
				tax.setDueTime(rs.getDate("due_time"));
				taxs.add(tax);
			}

		} catch (SQLException sql) {

		} catch (Exception e) {

		}
		return taxs;
	}

}
