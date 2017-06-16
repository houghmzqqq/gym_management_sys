package xyz.field.service;

import java.util.List;

import javax.annotation.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.xyz.gym_management_sys.po.FieldType;
import com.xyz.gym_management_sys.service.FieldTypeService;
import com.xyz.gym_management_sys.vo.FieldTypeVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:applicationContext.xml"})
public class FieldTypeServiceTest 
{
	@Resource
	private FieldTypeService fieldTypeService;
	
	private FieldTypeVO fieldTypeVO;
	
	@Test
	@Transactional
	@Rollback(false)
	public void testAll()
	{
		test01();
		test02();
		test03();
		test04();
	}
	
	public void test01()
	{
//		for(int i=0;i<20;i++)
//		{
//			fieldTypeVO = new FieldTypeVO("乒乓球场"+i+"号桌");
//			fieldTypeService.addFieldType(fieldTypeVO);			
//		}
		fieldTypeVO = new FieldTypeVO("乒乓球场"+19+"号桌");
		fieldTypeService.addFieldType(fieldTypeVO);		
	}
	
	public void test02()
	{
		fieldTypeService.removeFieldType(19);
	}
	
	public void test03()
	{
		FieldTypeVO fieldTypeVO2 = new FieldTypeVO("羽毛球场2号场");
		fieldTypeVO2.setFieldTypeId(4);
		fieldTypeService.updateFieldType(fieldTypeVO2);
	}
	
	public void test04()
	{
		fieldTypeVO = fieldTypeService.findFieldTypeById(2);
		System.out.println("findById--------"+fieldTypeVO.getFieldTypeName());
		List<FieldTypeVO> fieldTypeVOs = fieldTypeService.findAllFieldType();
		for(FieldTypeVO fieldTypeVO : fieldTypeVOs)
		{
			System.out.println("findByAll-------"+fieldTypeVO.getFieldTypeName());
		}
	}
}
