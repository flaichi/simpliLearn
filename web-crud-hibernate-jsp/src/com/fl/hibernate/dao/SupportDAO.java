package com.fl.hibernate.dao;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fl.hibernate.model.Support;

import com.fl.hibernate.util.*;


import java.util.List;



public class SupportDAO {
	   
	public void insertSupport(Support user) {
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

		public boolean deleteSupport(int id) {
				Transaction tr = null;
				try (Session session = HibernateUtil.getSessionFactory().openSession()) {
						// start a transaction
						tr = session.beginTransaction();
						// delete the object
						Support user = session.get(Support.class,id);
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

		public boolean updateSupport(Support user){
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
		public List<Support> selectAllUser() {
			Transaction tr = null;
			List <Support> listSupport = null;
			try (Session session = HibernateUtil.getSessionFactory().openSession()) {

				// start a transaction
				tr = session.beginTransaction();
				// get the object
				listSupport = session.createQuery("from Support").getResultList();
				// commit transaction
				tr.commit();
			} catch (Exception e) {
				if (tr != null) {
					tr.rollback();
					System.out.println("Exception caught ..."+ e.getMessage());					
				}
				e.printStackTrace();
			}
			return listSupport;
		}

		public Support selectUser(int id) {
					Transaction tr = null;
					Support user = null;
					try (Session session = HibernateUtil.getSessionFactory().openSession()) {
						// start a transaction
						tr = session.beginTransaction();
						// get  the object
						user = session.get(Support.class,id);
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
