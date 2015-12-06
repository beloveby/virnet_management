package virnet.management.dao;

import java.io.Serializable;
import java.util.List;

import virnet.management.entity.StuClass;

public class StuClassDAO extends BaseDAO{
	 public void add(StuClass obj) {
        super.add(obj);
    }

   
    public void delete(StuClass obj) {
        super.delete(obj);
    }

	public void deleteById(Serializable id) {
        super.deleteById(StuClass.class, id);
    }

   
    public void update(StuClass obj) {
    	super.update(obj);
    }

   
    public Object get(Serializable id) {
    	Object o = super.get(StuClass.class, id);
		return o;
    }

   
	public Object getByNProperty(String... strs) {
    	Object o = super.getByNProperty(StuClass.class, strs);
		return o;
    }

	public Object getUniqueByProperty(String pName, Object pValue) {
    	Object o = super.getUniqueByProperty(StuClass.class, pName, pValue);
		return o;
    }

   
    public Object getUniqueByHql(String hql) {
    	Object o = super.getUniqueByHql(hql);
    	return o;
    }

	public Object getUniqueBySql(String sql) {
    		Object o = super.getUniqueBySql(sql, StuClass.class);
    	return o;
    }

    // ////////////////////查询单个完毕////////////////

   
    @SuppressWarnings({ "rawtypes" })
	public List getList() {
    	List list = super.getList(StuClass.class);
    	return list;
    }

   
    @SuppressWarnings({ "rawtypes" })
	public List getListByProperty(String pName,
            Object pValue) {
    	List list = super.getListByProperty(StuClass.class, pName, pValue);
    	return list;	    	
    }

   
    @SuppressWarnings({ "rawtypes" })
	public List getListByProperty(String pName, Object pValue, String condition) {
    	List list = super.getListByProperty(StuClass.class, pName, pValue, condition);
    	return list;
    }

   
    @SuppressWarnings({ "rawtypes" })
	public List getListByNProperty(String... strs) {
    	List list = super.getListByNProperty(StuClass.class, strs);
    	return list;
    }

   
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public List getListByHql(String hql) {
    	List list = super.getListByHql(hql);
    	return list;
    }

   
    @SuppressWarnings("rawtypes")
	public List getListBySql(String sql) {
    	List list = super.getListBySql(sql, StuClass.class);
    	return list;
    }

   
	@SuppressWarnings("rawtypes")
	public void getListByPage(PageUtil pageUtil) {
        super.getListByPage(StuClass.class, pageUtil);
    }

	@SuppressWarnings("rawtypes")
	public void getListByPage(String hql, PageUtil pageUtil) {
		super.getListByPage(hql, pageUtil);
    }
}

