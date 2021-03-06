package com.neu.cloud.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.neu.cloud.model.Employee;

public class EmployeeDao extends DAO{
	
	public List<Employee> queryEmployeeByName(String lastName)
            throws Exception {
        try {
      //      begin();
        	
        	Criteria criteria = getSession().createCriteria(Employee.class).add(Restrictions.eq("lastname",lastName));
            
            
        	List<Employee> employeeList = null;
            
            try
    		{
            	employeeList =  criteria.list();
    			
    		}
    		catch(Exception ex)
    		{
    			System.out.println("Exception occured" + ex.getCause().getMessage());
    		}
    		System.out.println(employeeList.size());
            
           return employeeList;
           
        } catch (HibernateException e) {
     //       rollback();
            throw new Exception("Could not get user " + lastName, e);
        }
	}

}
