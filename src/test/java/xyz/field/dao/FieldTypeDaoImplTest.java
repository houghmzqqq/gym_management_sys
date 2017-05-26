package xyz.field.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.xyz.gym_management_sys.dao.FieldTypeDao;
import com.xyz.gym_management_sys.po.Field;
import com.xyz.gym_management_sys.po.FieldType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:applicationContext.xml"})
public class FieldTypeDaoImplTest 
{
	@Resource
	private FieldTypeDao fieldTypeDao;
	
	@Test
	@Transactional
	@Rollback(false)
	public void testAll()
	{
		test01();
		test02();
		test03();
	}
	
	public void test01()
	{
		FieldType fieldType;
		
		for(int i=0;i<5;i++)
		{
			fieldType = new FieldType("场地类型"+i);
			fieldTypeDao.addFieldType(fieldType);
		}
	}
	
	public void test02()
	{
		fieldTypeDao.deleteFieldType(5);
	}
	
	public void test03()
	{
		FieldType fieldType = fieldTypeDao.getFieldTypeById(3);
		List<FieldType> fieldTypes = fieldTypeDao.getAllFieldType();
		
		System.out.println("findById----"+fieldType.getFieldTypeName());
		for(FieldType fieldType2 : fieldTypes)
		{
			System.out.println("getAll------"+fieldType2.getFieldTypeName());
		}
	}
}
