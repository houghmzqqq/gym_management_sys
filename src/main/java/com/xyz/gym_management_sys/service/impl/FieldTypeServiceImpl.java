package com.xyz.gym_management_sys.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import com.xyz.gym_management_sys.dao.FieldDao;
import com.xyz.gym_management_sys.dao.FieldTypeDao;
import com.xyz.gym_management_sys.po.Field;
import com.xyz.gym_management_sys.po.FieldType;
import com.xyz.gym_management_sys.service.FieldTypeService;
import com.xyz.gym_management_sys.vo.FieldTypeVO;

@Service
public class FieldTypeServiceImpl implements FieldTypeService {

	@Resource
	private FieldTypeDao fieldTypeDao;
	@Resource
	private FieldDao fieldDao;
	@Resource
	private DozerBeanMapper mapper;
	
	private FieldType fieldType;
	private List<FieldType> fieldTypes;
	private FieldTypeVO fieldTypeVO;
	private List<FieldTypeVO> fieldTypeVOs;
	
	public void addFieldType(FieldTypeVO fieldTypeVO) {
		// TODO Auto-generated method stub

		fieldType = mapper.map(fieldTypeVO, FieldType.class);
		fieldTypeDao.addFieldType(fieldType);
	}

	public void removeFieldType(int fieldTypeId) {
		// TODO Auto-generated method stub

		fieldType = fieldTypeDao.getFieldTypeById(fieldTypeId);
		//将所有与该场地类型关联的场地的fieldType属性设置为null
		List<Field> fields = fieldDao.getFieldsByEquTypeId(fieldTypeId);
		for(Field field : fields)
		{
			field.setFieldType(null);
			fieldDao.mergeField(field);
		}
		
		fieldTypeDao.deleteFieldType(fieldType);
	}

	public void updateFieldType(FieldTypeVO fieldTypeVO) {
		// TODO Auto-generated method stub

		fieldType = mapper.map(fieldTypeVO, FieldType.class);
		fieldTypeDao.updateFieldType(fieldType);
	}

	public FieldTypeVO findFieldTypeById(int fieldTypeId) {
		// TODO Auto-generated method stub
		
		fieldType = fieldTypeDao.getFieldTypeById(fieldTypeId);
		fieldTypeVO = mapper.map(fieldType, FieldTypeVO.class);
		return fieldTypeVO;
	}

	public List<FieldTypeVO> findAllFieldType() {
		// TODO Auto-generated method stub
		
		fieldTypeVOs = new ArrayList<FieldTypeVO>();
		fieldTypes = fieldTypeDao.getAllFieldType();
		for(FieldType fieldType : fieldTypes)
		{
			fieldTypeVO = mapper.map(fieldType, FieldTypeVO.class);
			fieldTypeVOs.add(fieldTypeVO);
		}
		return fieldTypeVOs;
	}

}
