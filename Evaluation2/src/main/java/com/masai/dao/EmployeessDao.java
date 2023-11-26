package com.masai.dao;

import java.util.List;

import com.masai.models.ContractualEmployee;
import com.masai.models.SalariedEmployee;

public interface EmployeessDao {
	
	public String addSalariedEmployee(SalariedEmployee se);
	
	public String addContractualEmployee(ContractualEmployee ce);
	
	public List<SalariedEmployee> getSalariedEmployeesDetails();
	
	public List<ContractualEmployee> getContractualEmployeesDetails();

}
