package sourceit.webtester.dao.impl.hibernate;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import sourceit.webtester.dao.TestDao;
import sourceit.webtester.entities.Test;

public class TestDaoImpl implements TestDao {
	protected final Logger LOGGER = Logger.getLogger(getClass());
	protected final SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
	
	@Override
	public void save(Test t) {
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.save(t);
			tx.commit();			
		} catch (RuntimeException e) {
			if(tx != null) {
				try {
					tx.rollback();
				} catch (Exception e1) {
					LOGGER.error("Rollback failed: "+e.getMessage(), e);
				}
			}
			throw e;
		} finally {
			if(s != null) {
				try {
					s.flush();
					s.close();
				} catch (HibernateException e) {
					LOGGER.error("close session failed: "+e.getMessage(), e);
				}
			}
		}		
	}

	@Override
	public void update(Test t) {
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.update(t);
			tx.commit();			
		} catch (RuntimeException e) {
			if(tx != null) {
				try {
					tx.rollback();
				} catch (Exception e1) {
					LOGGER.error("Rollback failed: "+e.getMessage(), e);
				}
			}
			throw e;
		} finally {
			if(s != null) {
				try {
					s.flush();
					s.close();
				} catch (HibernateException e) {
					LOGGER.error("close session failed: "+e.getMessage(), e);
				}
			}
		}
		
	}

	@Override
	public void delete(Test t) {
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.delete(t);
			tx.commit();			
		} catch (RuntimeException e) {
			if(tx != null) {
				try {
					tx.rollback();
				} catch (Exception e1) {
					LOGGER.error("Rollback failed: "+e.getMessage(), e);
				}
			}
			throw e;
		} finally {
			if(s != null) {
				try {
					s.flush();
					s.close();
				} catch (HibernateException e) {
					LOGGER.error("close session failed: "+e.getMessage(), e);
				}
			}
		}
		
	}

	@Override
	public void remove(Test t) {
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.delete(t);
			tx.commit();			
		} catch (RuntimeException e) {
			if(tx != null) {
				try {
					tx.rollback();
				} catch (Exception e1) {
					LOGGER.error("Rollback failed: "+e.getMessage(), e);
				}
			}
			throw e;
		} finally {
			if(s != null) {
				try {
					s.flush();
					s.close();
				} catch (HibernateException e) {
					LOGGER.error("close session failed: "+e.getMessage(), e);
				}
			}
		}
		
	}

	@Override
	public Test findById(long id) {
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		Test res = null;
		try {
			tx = s.beginTransaction();
			res = (Test)s.load(Test.class, id);
			tx.commit();			
		} catch (RuntimeException e) {
			if(tx != null) {
				try {
					tx.rollback();
				} catch (Exception e1) {
					LOGGER.error("Rollback failed: "+e.getMessage(), e);
				}
			}
			throw e;
		} finally {
			if(s != null) {
				try {
					s.flush();
					s.close();
				} catch (HibernateException e) {
					LOGGER.error("close session failed: "+e.getMessage(), e);
				}
			}
		}
		return res;
	}

	@Override
	public List<Test> findAll() {
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		List<Test> res = null;
		try {
			tx = s.beginTransaction();
			res = s.createQuery("from Test").list();
			tx.commit();			
		} catch (RuntimeException e) {
			if(tx != null) {
				try {
					tx.rollback();
				} catch (Exception e1) {
					LOGGER.error("Rollback failed: "+e.getMessage(), e);
				}
			}
			throw e;
		} finally {
			if(s != null) {
				try {
					s.flush();
					s.close();
				} catch (HibernateException e) {
					LOGGER.error("close session failed: "+e.getMessage(), e);
				}
			}
		}
		return res;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void persist(Test t) {
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.persist(t);
			tx.commit();			
		} catch (RuntimeException e) {
			if(tx != null) {
				try {
					tx.rollback();
				} catch (Exception e1) {
					LOGGER.error("Rollback failed: "+e.getMessage(), e);
				}
			}
			throw e;
		} finally {
			if(s != null) {
				try {
					s.flush();
					s.close();
				} catch (HibernateException e) {
					LOGGER.error("close session failed: "+e.getMessage(), e);
				}
			}
		}	
		
	}
	
}
