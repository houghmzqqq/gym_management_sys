package xyz.equ.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.BlockingDeque;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.xyz.gym_management_sys.dao.EquOrderDao;
import com.xyz.gym_management_sys.po.EquOrder;
import com.xyz.gym_management_sys.po.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:applicationContext.xml"})
public class EquOrderDaoImplTest 
{
	@Resource
	private EquOrderDao equOrderDao;
	
	@Test
	@Transactional
	@Rollback(false)
	public void testAll()
	{
//		testAdd();
		testDel();
		testFind();
		test04();
	}
	
	public void testAdd()
	{
		EquOrder equOrder;
		Timestamp t1;
		for(int i=0;i<5;i++)
		{
			t1 = new Timestamp(2017, 5, 25, 10, 35, 0, 0);
			User user = new User();
			user.setUserId(1);
			equOrder = new EquOrder(t1, t1, t1, i, 3, 10, 20, 30, user);
			equOrderDao.addEquOrder(equOrder);
		}
	}
	
	public void testDel()
	{
//		equOrderDao.deleteEquOrder(5);
		System.out.println("delete success,delete equOrderId(5)");
	}
	
	public void testFind()
	{
		System.out.println("byEquOrderId----"+equOrderDao.getEquOrderById(3));
	}
	
	public void test04()
	{
//		List<EquOrder> equOrders = equOrderDao.getEquOrderByUserId(1);
//		for(EquOrder equOrder : equOrders)
//		{
//			System.out.println("byUserId----"+equOrder);
//		}
	}
}
