package xyz.field.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.xyz.gym_management_sys.service.FieldService;
import com.xyz.gym_management_sys.vo.FieldVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:applicationContext.xml"})
public class FieldServiceTest 
{
	@Resource
	private FieldService fieldService;
	
	private FieldVO fieldVO;
	
	@Test
	@Transactional
	@Rollback(false)
	public void testAll()
	{
//		test01();
//		test02();
		test03();
		test04();
	}
	
	public void test01()
	{
		for(int i=0;i<5;i++)
		{
			fieldVO = new FieldVO("乒乓球"+i+"号桌", 1, "乒乓球场", 0, 3);
			fieldService.addField(fieldVO);
		}
	}

	public void test02()
	{
		fieldService.removeField(4);
	}

	public void test03()
	{
		FieldVO fieldVO2 = new FieldVO();
		fieldVO2.setFieldId(1);
		fieldVO2.setFieldName("乒乓球12号桌");
		fieldService.updateField(fieldVO2);
	}

	public void test04()
	{
		fieldVO = fieldService.findFieldById(1);
		System.out.println("findById--------"+fieldVO);
		List<FieldVO> fieldVOs = fieldService.findFieldByFieldTypeId(1);
		for(FieldVO fieldVO : fieldVOs)
		{
			System.out.println("findByTypeId----"+fieldVO);
		}
	}
}
