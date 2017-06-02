package xyz.field.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.xyz.gym_management_sys.po.FieldOrder;
import com.xyz.gym_management_sys.service.FieldOrderService;
import com.xyz.gym_management_sys.vo.FieldOrderItemVO;
import com.xyz.gym_management_sys.vo.FieldOrderVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:applicationContext.xml"})
public class FieldOrderServiceTest 
{
	@Resource
	private FieldOrderService fieldOrderService;
	
	private FieldOrderVO fieldOrderVO;
	private FieldOrderItemVO fieldOrderItemVO;
	
	@Test
	@Transactional
	@Rollback(false)
	public void testAll()
	{
		for(int i=0;i<5;i++)
		{
//			test01();
		}
//		test02();
		test03();
		test04();
	}
	
	public void test01()
	{
		fieldOrderVO = new FieldOrderVO(1, "user1", new Timestamp(3600), 0, 25, 0);
		fieldOrderItemVO = new FieldOrderItemVO(0, 2, "乒乓球1号桌", false, 0, new Timestamp(3600), new Timestamp(3600), 4, 0);
		FieldOrderItemVO fieldOrderItemVO2 = new FieldOrderItemVO(0, 3, "乒乓球2号桌", false, 0, new Timestamp(3600), new Timestamp(3600), 4, 0);
		FieldOrderItemVO fieldOrderItemVO3 = new FieldOrderItemVO(0, 4, "乒乓球3号桌", false, 0, new Timestamp(3600), new Timestamp(3600), 4, 0);
		List<FieldOrderItemVO> fieldOrderItemVOs = new ArrayList<FieldOrderItemVO>();
		fieldOrderItemVOs.add(fieldOrderItemVO);
		fieldOrderItemVOs.add(fieldOrderItemVO2);
		fieldOrderItemVOs.add(fieldOrderItemVO3);
		
//		fieldOrderService.addFieldOrder(fieldOrderVO, fieldOrderItemVOs);
	}
	
	public void test02()
	{
		fieldOrderService.removeFieldOrder(5);
	}
	
	public void test03()
	{
		FieldOrderVO fieldOrderVO2 = new FieldOrderVO();
		fieldOrderVO2.setFieldOrderId(1);
		fieldOrderVO2.setFieldOrderStatement(3);
		fieldOrderService.updateFieldOrder(fieldOrderVO2);
	}
	
	public void test04()
	{
		fieldOrderVO = fieldOrderService.findFieldOrderById(3);
		System.out.println("findById--------"+fieldOrderVO);
		List<FieldOrderVO> fieldOrders = fieldOrderService.findAllFieldOrder();
		
		for(FieldOrderVO fieldOrder : fieldOrders)
		{
			System.out.println("findAll---------"+fieldOrder);
		}
	}
}
