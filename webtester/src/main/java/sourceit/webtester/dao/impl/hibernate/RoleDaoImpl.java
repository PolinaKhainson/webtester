package sourceit.webtester.dao.impl.hibernate;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import sourceit.webtester.dao.RoleDao;
import sourceit.webtester.entities.Role;

public class RoleDaoImpl implements RoleDao {
	protected final Logger LOGGER = Logger.getLogger(getClass());
	protected final SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
	
	@Override
	public void save(Role r) {
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.save(r);
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
	public void update(Role r) {
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.update(r);
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
	public void delete(Role r) {
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.delete(r);
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
	public void remove(Role r) {
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.delete(r);
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
	public Role findById(long id) {
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		Role res = null;
		try {
			tx = s.beginTransaction();
			res = (Role) s.load(Role.class, id);
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
	public List<Role> findAll() {
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		List<Role> res = null;
		try {
			tx = s.beginTransaction();
			res = s.createQuery("from Role").list();
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
