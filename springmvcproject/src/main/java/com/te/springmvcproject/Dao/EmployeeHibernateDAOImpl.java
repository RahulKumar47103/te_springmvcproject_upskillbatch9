package com.te.springmvcproject.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.te.springmvcproject.beans.EmployeeBean;
import com.te.springmvcproject.customexceptions.EmployeeExp;

@Repository
public class EmployeeHibernateDAOImpl implements EmployeeDAO {

	@PersistenceUnit
	EntityManagerFactory factory;
	
	@Override
	public EmployeeBean authenticate(int id, String password) {
		EntityManager entityManager=factory.createEntityManager();
		try {
			EmployeeBean bean = entityManager.find(EmployeeBean.class, id);
			if(bean!=null) {
				if(bean.getPassword().equals(password)) {
					System.out.println("succesfull login");
					return bean;
				}
				else {
					System.out.println("invalid password");
					return null;
				}
			
			}else {
				System.out.println("invalid credentials");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new EmployeeExp("user not found");
		}finally {
			try {
				if(factory!=null) {
					factory.close();
				}
				if(entityManager!=null) {
					entityManager.close();
				}
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
		}
		return null;	
	}

	@Override
	public EmployeeBean getEmployee(int id) {
		EntityManager entityManager=factory.createEntityManager();
		try {
			EmployeeBean bean = entityManager.find(EmployeeBean.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean getDelete(int id) {

		return false;
	}

	@Override
	public List<EmployeeBean> getAllEmp() {

		return null;
	}

	
	
	
	
	@Override
	public boolean addEmp(EmployeeBean bean) {
		EntityManager entityManager=factory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		try {
			entityTransaction.begin();
			entityManager.persist(bean);
			entityTransaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}

	@Override
	public boolean getUpdate(EmployeeBean bean) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		EmployeeBean info=manager.find(EmployeeBean.class, bean);
		try {
			boolean isUpdated=false;
			if(bean.getName()!=null && bean.getName()!="") {
			info.setName(bean.getName());
			}
			if(bean.getPassword()!=null && bean.getPassword()!="") {
				info.setPassword(bean.getPassword());
			}
		} catch (Exception e) {
			
		}
		return false;
	}

	

}
