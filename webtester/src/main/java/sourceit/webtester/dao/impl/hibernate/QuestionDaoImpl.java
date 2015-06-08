package sourceit.webtester.dao.impl.hibernate;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import sourceit.webtester.dao.QuestionDao;
import sourceit.webtester.entities.Question;

public class QuestionDaoImpl implements QuestionDao {
	protected final Logger LOGGER = Logger.getLogger(getClass());
	protected final SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
	
	@Override
	public void save(Question q) {
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.save(q);
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
	public void update(Question q) {
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.update(q);
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
	public void delete(Question q) {
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.delete(q);
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
	public void remove(Question q) {
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.delete(q);
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
	public Question findById(long id) {
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		Question res = null;
		try {
			tx = s.beginTransaction();
			res = (Question) s.load(Question.class, id);
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
	public List<Question> findAll() {
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		List<Question> res = null;
		try {
			tx = s.beginTransaction();
			res = s.createQuery("from Question").list();
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
	
}
