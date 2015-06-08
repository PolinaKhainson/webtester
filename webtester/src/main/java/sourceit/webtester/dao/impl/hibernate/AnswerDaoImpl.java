package sourceit.webtester.dao.impl.hibernate;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import sourceit.webtester.dao.AnswerDao;
import sourceit.webtester.entities.Answer;


public class AnswerDaoImpl implements AnswerDao{
	protected final Logger LOGGER = Logger.getLogger(getClass());
	protected final SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
	
	@Override
	public void save(Answer a) {
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.save(a);
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
	public void update(Answer a) {
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.update(a);
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
	public void delete(Answer a) {
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.delete(a);
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
	public void remove(Answer a) {
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.delete(a);
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
	public Answer findById(long id) {
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		Answer res = null;
		try {
			tx = s.beginTransaction();
			res = (Answer) s.load(Answer.class, id);
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
	public List<Answer> findAll() {
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		List<Answer> res = null;
		try {
			tx = s.beginTransaction();
			res = s.createQuery("from Answer").list();
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
	public void persist(Answer a) {
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.persist(a);
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
