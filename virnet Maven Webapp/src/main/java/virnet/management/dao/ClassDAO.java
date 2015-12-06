package virnet.management.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

import virnet.management.entity.Class;

public class ClassDAO extends BaseDAO{
	 public void add(Class obj) {
        super.add(obj);
    }

   
    public void delete(Class obj) {
        super.delete(obj);
    }

	public void deleteById(Serializable id) {
        super.deleteById(Class.class, id);
    }

   
    public void update(Class obj) {
    	super.update(obj);
    }

   
    public Object get(Serializable id) {
    	Object o = super.get(Class.class, id);
		return o;
    }

   
	public Object getByNProperty(Object... strs) {
    	Object o = super.getByNProperty(Class.class, strs);
		return o;
    }

	public Object getUniqueByProperty(String pName, Object pValue) {
    	Object o = super.getUniqueByProperty(Class.class, pName, pValue);
		return o;
    }

   
    public Object getUniqueByHql(String hql) {
    	Object o = super.getUniqueByHql(hql);
    	return o;
    }

	public Object getUniqueBySql(String sql) {
    		Object o = super.getUniqueBySql(sql, Class.class);
    	return o;
    }

    // ////////////////////查询单个完毕////////////////

   
    @SuppressWarnings({ "rawtypes" })
	public List getList() {
    	Session session = null;
    	List<Class> clist = new ArrayList<Class>();
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            String hql = "select model from " + Class.class.getName() + " as model ";
            List list = session.createQuery(hql).list();
            if(list != null){
            	for(Object c : list){
            		Class clazz = new Class(((Class) c).getClassId(), ((Class) c).getCourse(), ((Class) c).getClassName(), ((Class) c).getClassTeacherId(), ((Class) c).getPeriodarranges(), ((Class) c).getStuClasses());
            		clist.add(clazz);
            	}
            }
            return clist;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

   
    @SuppressWarnings({ "rawtypes" })
	public List getListByProperty(String pName,
            Object pValue) {
    	List list = super.getListByProperty(Class.class, pName, pValue);
    	return list;	    	
    }

   
    @SuppressWarnings({ "rawtypes" })
	public List getListByProperty(String pName, Object pValue, String condition) {
    	List list = super.getListByProperty(Class.class, pName, pValue, condition);
    	return list;
    }

   
    @SuppressWarnings({ "rawtypes" })
	public List getListByNProperty(String... strs) {
    	List list = super.getListByNProperty(Class.class, strs);
    	return list;
    }

   
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public List getListByHql(String hql) {
    	List list = super.getListByHql(hql);
    	return list;
    }

   
    @SuppressWarnings("rawtypes")
	public List getListBySql(String sql) {
    	List list = super.getListBySql(sql, Class.class);
    	return list;
    }

   
	@SuppressWarnings("rawtypes")
	public void getListByPage(PageUtil pageUtil) {
        super.getListByPage(Class.class, pageUtil);
    }

	@SuppressWarnings("rawtypes")
	public void getListByPage(String hql, PageUtil pageUtil) {
		super.getListByPage(hql, pageUtil);
    }
}

