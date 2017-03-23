package com.school.dl.utility;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;


public class SimpleHibernateTemplate<E> {

  private static final int JDBC_BATCH_SIZE = 50;

  private SessionFactory sessionFactory;
  private String filter;

  public SimpleHibernateTemplate(SessionFactory sessionFactory, String filter) {
   this.sessionFactory = sessionFactory;
   this.filter = filter;
  }

  public SimpleHibernateTemplate(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  public Session getSession() {
    Session result = sessionFactory.getCurrentSession();
    return result;
  }

  public Criteria createCriteria(Class persistentClass) {
    return getSession().createCriteria(persistentClass);
  }

  public Query createQuery(String queryString) {
    return getSession().createQuery(queryString);
  }

  public void delete(Object object) {
    getSession().delete(object);
  }

  public void evict(Object object) {
    getSession().evict(object);
  }

  @SuppressWarnings("unchecked")
  public E get(Class entityClass, Serializable id) throws DataAccessException {
    return (E) getSession().get(entityClass, id);
  }

  @SuppressWarnings("unchecked")
  public E saveOrUpdateAndGet(final Object object) throws DataAccessException {
    getSession().saveOrUpdate(object);
    return (E) object;
  }

  public DataAccessException convertHibernateAccessException(HibernateException e) {
    HibernateExceptionTranslator translator = new HibernateExceptionTranslator();
    return translator.translateExceptionIfPossible(e);
  }

  public void update(final Object object) throws DataAccessException {
    getSession().update(object);
  }

  public void saveOrUpdate(final Object object) throws DataAccessException {
    getSession().saveOrUpdate(object);
  }

  public void flush() {
    getSession().flush();
  }

  @SuppressWarnings("unchecked")
  public E updateAndGet(final Object object) throws DataAccessException {
    getSession().update(object);
    return (E) object;
  }

  @SuppressWarnings("unchecked")
  public E saveAndGet(final Object object) throws DataAccessException {
    getSession().save(object);
    return (E) object;
  }

  public void save(final Object object) throws DataAccessException {
    getSession().save(object);
  }

  public List<E> find(final String queryString) throws DataAccessException {
    return list(getSession().createQuery(queryString));
  }

  public Object findFirstValue(final String queryString)
    throws DataAccessException {
    List result = getQuery(queryString).list();
    return result.isEmpty() ? null : result.get(0);
  }

  public Object findFirstValueByNamedParams(final String queryString, List<String> names,
    final Object... values) throws DataAccessException {
    List result = findValueByNamedParams(queryString, names, values);
    return result.isEmpty() ? null : result.get(0);
  }

  public E findFirstByNamedParams(final String queryString, final List<String> names,
    final Object... values) throws DataAccessException {
    List<E> result = findByNamedParam(queryString, names, values);
    return result.isEmpty() ? null : result.get(0);
  }

  public E findFirstByNamedParam(final String queryString, String name, final Object value)
    throws DataAccessException {
    Query queryObject = getSession().createQuery(queryString);
    applyNamedParameterToQuery(queryObject, name, value);
    List<E> result = list(queryObject);
    return result.isEmpty() ? null : result.get(0);
  }

  @SuppressWarnings("unchecked")
  private List<E> list(Query queryObject) {
    return queryObject.list();
  }

  protected void applyNamedParameterToQuery(Query queryObject, String paramName, Object value)
    throws HibernateException {
    if (value instanceof Collection) {
      queryObject.setParameterList(paramName, (Collection) value);
    } else if (value instanceof Object[]) {
      queryObject.setParameterList(paramName, (Object[]) value);
    } else {
      queryObject.setParameter(paramName, value);
    }
  }

  public List<E> findByNamedParam(final String queryString,
    final String paramName, final Object value) throws DataAccessException {
    return findByNamedParam(queryString, Arrays.asList(paramName), value);
  }

  public List<E> findByNamedParam(final String queryString, final List<String> paramNames,
    final Object... values) throws DataAccessException {
    Query queryObject = getSession().createQuery(queryString);
    if (values != null) {
      if (paramNames.size() != values.length) {
        throw new IllegalArgumentException(
          "number of parameter names does not match number of values");
      }
      for (int i = 0; i < values.length; i++) {
        applyNamedParameterToQuery(queryObject, paramNames.get(i), values[i]);
      }
    }
    return list(queryObject);
  }

  public List findValueByNamedParams(final String queryString, final List<String> paramNames,
    final Object... values) throws DataAccessException {
    return findByNamedParam(queryString, paramNames, values);
  }

  public List findValueByNamedParam(final String queryString, String paramNames,
    final Object... values) throws DataAccessException {
    return findByNamedParam(queryString, paramNames, values);
  }

  public int bulkUpdate(String queryString) throws DataAccessException {
    return getSession().createQuery(queryString).executeUpdate();
  }

  public int bulkUpdateByNamedParams(final String queryString, final List<String> names,
    final Object... values) throws DataAccessException {
    Query queryObject = getSession().createQuery(queryString);
    if (values != null) {
      for (int i = 0; i < values.length; i++) {
        applyNamedParameterToQuery(queryObject, names.get(i), values[i]);
      }
    }
    return queryObject.executeUpdate();
  }

  public int bulkUpdateByNamedParam(final String queryString, String name, final Object value)
    throws DataAccessException {
    Query queryObject = getSession().createQuery(queryString);
    applyNamedParameterToQuery(queryObject, name, value);
    return queryObject.executeUpdate();
  }

  public Query getQuery(String queryString) {
    return getSession().createQuery(queryString);
  }

  @SuppressWarnings("unchecked")
  public <T> T merge(final T entity) throws DataAccessException {
    return (T) getSession().merge(entity);
  }

  public void saveInBatches(Collection entities) {
    int i = 0;
    Session session = getSession();
    for (Object entity : entities) {
      session.saveOrUpdate(entity);
      if (i % JDBC_BATCH_SIZE == 0) {
        session.flush();
        session.clear();
      }
    }
  }

}
