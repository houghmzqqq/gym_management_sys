package com.xyz.gym_management_sys.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.xyz.gym_management_sys.dao.FieldDao;
import com.xyz.gym_management_sys.po.DividePage;
import com.xyz.gym_management_sys.po.Equipment;
import com.xyz.gym_management_sys.po.Field;

@Repository
public class FieldDaoImpl implements FieldDao {

	@Resource
	private HibernateTemplate hibernateTemplate;
	@Resource
	private DividePage dividePage;
	
	private List<Field> fields;
	
	public void addField(Field field) {
		// TODO Auto-generated method stub
		
		hibernateTemplate.save(field);
	}

	public void deleteField(Field field) {
		// TODO Auto-generated method stub
		
		hibernateTemplate.delete(field);
	}

	public void updateField(Field field) {
		// TODO Auto-generated method stub
		
		hibernateTemplate.update(field);
	}

	public Field getFieldById(int fieldId) {
		// TODO Auto-generated method stub
		
		return hibernateTemplate.get(Field.class, fieldId);
	}

	public List<Field> getFieldsByEquTypeId(int fieldTypeId) {
		// TODO Auto-generated method stub
		
		String hql = "from Field fi where fi.fieldType.fieldTypeId=?";
		return (List<Field>) hibernateTemplate.find(hql,fieldTypeId);
	}

	public List<Field> getAllField() {
		// TODO Auto-generated method stub
		
		String hql = "from Field";
		return (List<Field>) hibernateTemplate.find(hql);
	}

	public DividePage getPageField(int thisPage, int rowOfEachPage) {
		// TODO Auto-generated method stub
		
		String hql = "select count(*) from Field equ";
		int pageCount = Integer.parseInt(String.valueOf((Long) hibernateTemplate.find(hql).listIterator().next()));
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Field.class);
		fields = (List<Field>) hibernateTemplate.findByCriteria(detachedCriteria,(thisPage-1)*rowOfEachPage,rowOfEachPage);
		
		
		if((pageCount%5) != 0)
		{
			dividePage.setLastPage((pageCount/5)+1);
		}
		else
		{
			dividePage.setLastPage((pageCount/5));
		}
		if(thisPage >= dividePage.getLastPage())
		{
			dividePage.setNextPage(thisPage);
		}
		else
		{
			dividePage.setNextPage(thisPage + 1);
		}
		dividePage.setPrePage(thisPage - 1);
		dividePage.setPageCount(pageCount);
		dividePage.setThisPage(thisPage);
		dividePage.setFields(fields);
		return dividePage;
	}

	public void mergeField(Field field) {
		// TODO Auto-generated method stub
		
		hibernateTemplate.merge(field);
	}

	public DividePage getPageFieldByFieldType(int thisPage, int rowOfEachPage, int fieldTypeId) {
		// TODO Auto-generated method stub
		
		String hql = "from Field fie where fie.fieldType.fieldTypeId=" + fieldTypeId;
		Query query = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(hql);
		query.setFirstResult((thisPage-1)*rowOfEachPage);
		query.setMaxResults(rowOfEachPage);
		fields = query.list();
		
		hql = "select count(*) from Field fie where fie.fieldType.fieldTypeId=?";
		int pageCount = Integer.parseInt(String.valueOf((Long) hibernateTemplate.find(hql,fieldTypeId).listIterator().next()));
		
		if((pageCount%5) != 0)
		{
			dividePage.setLastPage((pageCount/5)+1);
		}
		else
		{
			dividePage.setLastPage((pageCount/5));
		}
		if(thisPage >= dividePage.getLastPage())
		{
			dividePage.setNextPage(thisPage);
		}
		else
		{
			dividePage.setNextPage(thisPage + 1);
		}
		dividePage.setPrePage(thisPage - 1);
		dividePage.setPageCount(pageCount);
		dividePage.setThisPage(thisPage);
		dividePage.setFields(fields);
		
		return dividePage;
	}

}
