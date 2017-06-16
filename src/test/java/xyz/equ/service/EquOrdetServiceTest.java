package xyz.equ.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.config.VelocityConfigurerBeanDefinitionParser;

import com.xyz.gym_management_sys.dao.EquOrderDao;
import com.xyz.gym_management_sys.po.EquOrder;
import com.xyz.gym_management_sys.service.EquOrderService;
import com.xyz.gym_management_sys.vo.EquOrderVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:applicationContext.xml"})
public class EquOrdetServiceTest 
{
	@Resource
	private EquOrderService equOrderService;
	@Resource
	private EquOrderDao equOrderDao;
	
	private EquOrderVO equOrderVO;
	
	@Test
	@Transactional
	@Rollback(false)
	public void testAll()
	{
		for(int i=0;i<20;i++)
		{
		test01();
		}
//		test02();
//		test03();
//		test04();
		test05();
	}
	
	public void test01()
	{
		Timestamp t1 = new Timestamp(2017, 5, 25, 10, 35, 0, 0);
		equOrderVO = new EquOrderVO(1, "张三", t1, t1, t1, 5, 0, 14, 235, 23);
		List<Integer> equIds = new ArrayList<Integer>();
		equIds.add(3);
		equIds.add(5);
		equIds.add(9);
		List<Integer> equCounts = new ArrayList<Integer>();
		equCounts.add(4);
		equCounts.add(5);
		equCounts.add(9);
		
//		equOrderService.addEquOrder(equOrderVO, equIds, equCounts);
	}
	
	public void test02()
	{
		equOrderService.removeEquOrder(4);
	}
	
	public void test03()
	{
		Timestamp t1 = new Timestamp(2017, 5, 25, 10, 35, 0, 0);
		equOrderVO = new EquOrderVO(1, "李四", t1, t1, t1, 7, 9, 14, 235, 23);
		equOrderVO.setEquOrderId(5);
		equOrderService.updateEquOrder(equOrderVO);
	}
	
	public void test04()
	{
		equOrderVO = equOrderService.findEquOrderById(2);
		System.out.println("findById--------"+equOrderVO);
		List<EquOrderVO> equOrderVOs = equOrderService.findEquOrderByUserId(1);
		for(EquOrderVO equOrderVO : equOrderVOs)
		{
			System.out.println("findByUserId----"+equOrderVO);
		}
	}
	
	public void test05()
	{
//		List<EquOrderVO> equOrderVOs = equOrderService.dividePageOfEquOrder(3, 5);
//		for(EquOrderVO equOrderVO : equOrderVOs)
//		{
//			System.out.println(equOrderVO);
//		}
	}
}
