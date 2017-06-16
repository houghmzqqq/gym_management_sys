package xyz.field.service;

import java.util.List;

import javax.annotation.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.xyz.gym_management_sys.service.FieldOrderItemService;
import com.xyz.gym_management_sys.vo.FieldOrderItemVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:applicationContext.xml"})
public class FieldOrderItemServiceTest 
{
	@Resource
	private FieldOrderItemService fieldOrderItemService;
	
	private FieldOrderItemVO fieldOrderItemVO;
	
	@Test
	@Transactional
	@Rollback(false)
	public void testAll()
	{
		test01();
		test02();
	}
	
	public void test01()
	{
		fieldOrderItemVO = new FieldOrderItemVO();
		fieldOrderItemVO.setFieldOrderItemId(1);
		fieldOrderItemVO.setFieldOrderId(1);
		fieldOrderItemVO.setFieldCompensation(100);
		fieldOrderItemService.updateFieldOrderItem(fieldOrderItemVO);
	}
	
	public void test02()
	{
		List<FieldOrderItemVO> fieldOrderItemVOs = fieldOrderItemService.findFieldOrderItemByFieldOrderId(2);
		for(FieldOrderItemVO fieldOrderItemVO : fieldOrderItemVOs)
		{
			System.out.println("findByOrderId----"+fieldOrderItemVO);
		}
	}
}
