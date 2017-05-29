package xyz.field.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.xyz.gym_management_sys.dao.FieldDao;
import com.xyz.gym_management_sys.dao.FieldTypeDao;
import com.xyz.gym_management_sys.po.Field;
import com.xyz.gym_management_sys.po.FieldType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:applicationContext.xml"})
public class FieldDaoImplTest 
{
	@Resource
	private FieldDao fieldDao;
	@Resource
	private FieldTypeDao fieldTypeDao;
	
	@Test
	@Transactional
	@Rollback(false)
	public void testAll()
	{
//		test01();
//		test02();
//		test03();
		test04();
	}
	
	public void test01()
	{
		Field field;
		
		for(int i=0;i<5;i++)
		{
			
			field = new Field("场地"+i, 3, 10, fieldTypeDao.getFieldTypeById(2));
			fieldDao.addField(field);
		}
	}
	
	public void test02()
	{
//		fieldDao.deleteField(5);
	}
	
	public void test03()
	{
		Field field = fieldDao.getFieldById(3);
		List<Field> fields = fieldDao.getAllField();
		
		System.out.println("findById----"+field.getFieldName());
		for(Field field2 : fields)
		{
			System.out.println("getAll------"+field2.getFieldName());
		}
	}
	
	public void test04()
	{
		List<Field> fields = fieldDao.getFieldsByEquTypeId(2);
		for(Field field : fields)
		{
			System.out.println("getByTypeId----"+field.getFieldName());
		}
	}
}
