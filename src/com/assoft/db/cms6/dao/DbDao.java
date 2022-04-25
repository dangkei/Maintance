package com.assoft.db.cms6.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;






public class DbDao implements DbOperator {
	
	

	private HibernateTemplate hibernateTemplate = null;

	


	
	
	
	

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public void deleteInfo(Object instance) {
		this.getHibernateTemplate().delete(instance);

	}

	public Serializable find(Class clazz, String id) {
	
		return (Serializable)this.getHibernateTemplate().get(clazz, id);
	}

	public List findAllByHql(String hql) {
		
		return this.getHibernateTemplate().find(hql);
	}

	public List findAllByParameters(String hql, Object[] parameters) {
	
		 return this.getHibernateTemplate().find(hql, parameters);
	}

	public List findAllByParmeterMap(final String hql, final Map<String, ?> hqlMap) {
		List list =getHibernateTemplate().executeFind(new HibernateCallback() { 
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql); 
				query.setProperties(hqlMap);
				List list = query.list(); 
				return list;  
			} 
		});
	
		return list;
	}

	
	
	public Serializable findByIdAndClassName(String className, String id) {
		
		 return (Serializable)this.getHibernateTemplate().get(className, id);
	}

	public long findCountByHql(String hql) {
		List<Long> l = getHibernateTemplate().find(hql);
		long ll = l.get(0);
		return ll;
	}

	public long findCountByParameters(String hql, Object[] parameters) {
		List<Long> l = getHibernateTemplate().find(hql, parameters);
		long ll = l.get(0);
		return ll;
	}

	public long findCountByParameterMap(final String hql,final Map<String, ?> params) {
		List<Long> l=  getHibernateTemplate().executeFind(new HibernateCallback() { 
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql); 
				query.setProperties(params);
				List list = query.list(); 
				return list; 
			} 
		});
		
		long ll = l.get(0);
		return ll;
	}



	public List findPageListByParmeterMap(final String hql,final Map<String, ?> params, final int offset, final int length) {
		List list = getHibernateTemplate().executeFind(
				new HibernateCallback() { 
					public Object doInHibernate(Session session) throws HibernateException, SQLException {
						Query query = session.createQuery(hql); 
						query.setProperties(params);
						query.setFirstResult(offset); 
						query.setMaxResults(length); 
						List list = query.list(); 
						return list; 
					} 
				}
			); 
			return list; 
	}

	public Serializable saveInfo(Object instance) {
		
		return this.getHibernateTemplate().save(instance);
	}

	public void updateExecuteHql(final String hql,final Map<String, ?> hqlMap) {
		getHibernateTemplate().execute(new HibernateCallback() { 
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql); 
				query.setProperties(hqlMap);
				query.executeUpdate();
				return null; 
			} 
		});

	}

	public void updateInfo(Object instance) {
		this.getHibernateTemplate().update(instance);

	}



	
	public List findAllByTableField(String tableName, String fieldName,
			Object value,String orderBy) {
		
		 String hql=" from " +tableName+" where "+fieldName+"=?";
		 
		 if(value==null){
			 hql=" from " +tableName+" where "+fieldName+" is null ";
		 }
		 if(orderBy!=null&&!"".equals(orderBy)){
			 hql+=" "+orderBy;
		 }
		 
		   Object[] parameters={value};
		return findAllByParameters(hql, parameters);
	}




	public Serializable findByTableField(String tableName, String fieldName,
			Object value) {
		List<Serializable> list=findAllByTableField(tableName, fieldName, value,null);
		if(list.size()>0){
			return list.get(0);
		}
		
		return null;
	}

	public List findByGridRand(String hql, Object[] parameters) {
		
		return findAllByParameters(hql, parameters);
	}
	public List findByGridRand(final String hql, final Map<String, ?> hqlMap,final int size) {
		List list =getHibernateTemplate().executeFind(new HibernateCallback() { 
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql); 
				query.setMaxResults(size);
				query.setProperties(hqlMap);
				List list = query.list(); 
				return list;  
			} 
		});
	
		return list;
	}

	
	public List findAllByTableClassField(Class clazz, String fieldName,
			Object value,String orderBy) {
		String tableName=clazz.getSimpleName();
		return findAllByTableField(tableName, fieldName, value,orderBy);
	}




	public Serializable findByTableClassField(Class clazz, String fieldName,
			Object value) {
		String tableName=clazz.getSimpleName();
		return findByTableField(tableName, fieldName, value);
	}




	public Serializable findRelContent(Class clazz, String cid) {
		String fieldName="contentId";
		String value=cid;
		
		
		return findByTableClassField(clazz, fieldName, value);
	}

	public Serializable findFirstByParameters(String hql, Object[] parameter) {
		List list=findAllByParameters(hql, parameter);
		return getFirst(list);
	}

	public Serializable findFirstByParmeterMap(String hql, Map<String, ?> hqlMap) {
		List list=findAllByParmeterMap(hql, hqlMap);
		return getFirst(list);
	}
	
	private Serializable getFirst(List list){
		
		if(list.size()>0){
			Object object=list.get(0);
			if(object!=null){
				return (Serializable)object;
			}
		}
		return null;
	}

	public List findPageList(final String hql,final int offset, final int length) {
		List list = getHibernateTemplate().executeFind(
				new HibernateCallback() { 
					public Object doInHibernate(Session session) throws HibernateException, SQLException {
						Query query = session.createQuery(hql); 
						
						query.setFirstResult(offset); 
						query.setMaxResults(length); 
						List list = query.list(); 
						return list; 
					} 
				}
			); 
			return list; 
	}

}
