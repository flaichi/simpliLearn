package com.fl.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fl.hibernate.model.Sale;
import com.fl.hibernate.util.*;


import java.util.List;



//import org.hibernate.SessionFactory;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.cfg.Configuration;


public class SaleDAO {
	
	
   public void insertUser(Sale user) {
	 Transaction tr = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
				// start a transaction
			tr = session.beginTransaction();
			session.save(user);
			tr.commit();
		} catch (Exception e) {
				if (tr != null) {
					tr.rollback();
					System.out.println("Exception caught ..."+ e.getMessage());
				}
				e.printStackTrace();
		}
	}

	public boolean deleteUser(int id) {
			Transaction tr = null;
			try (Session session = HibernateUtil.getSessionFactory().openSession()) {
					// start a transaction
					tr = session.beginTransaction();
					// delete the object
					Sale user = session.get(Sale.class,id);
					if(user!= null) {
						session.delete(user);
						System.out.println( "user is deleted");
					}
					// commit transaction
					tr.commit();
					return true;
			} catch (Exception e) {
					if (tr != null) {
						tr.rollback();
					}
					e.printStackTrace();
			}
			return false;
		}

	public boolean updateUser(Sale user){
		Transaction tr = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
					// start a transaction
					tr = session.beginTransaction();
					// update the object
					session.update(user);
					// commit transaction
					tr.commit();
				} catch (Exception e) {
					if (tr != null) {
					   tr.rollback();
					   System.out.println("Exception caught ..."+ e.getMessage());
					}
					e.printStackTrace();
				}
				return true;
			}		

	@SuppressWarnings("unchecked")
	public List<Sale> selectAllUser() {
		Transaction tr = null;
		List <Sale> listSale = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			// start a transaction
			tr = session.beginTransaction();
			// get the object
			listSale = session.createQuery("from Sale").getResultList();
			// commit transaction
			tr.commit();
		} catch (Exception e) {
			if (tr != null) {
				tr.rollback();
				System.out.println("Exception caught ..."+ e.getMessage());					
			}
			e.printStackTrace();
		}
		return listSale;
	}

	public Sale selectUser(int id) {
				Transaction tr = null;
				Sale user = null;
				try (Session session = HibernateUtil.getSessionFactory().openSession()) {
					// start a transaction
					tr = session.beginTransaction();
					// get  the object
					user = session.get(Sale.class,id);
					// commit transaction
					tr.commit();
				} catch (Exception e) {
					if (tr != null) {
					tr.rollback();
					   System.out.println("Exception caught ..."+ e.getMessage());
					}
					e.printStackTrace();
				}
				return user;
			}
}
