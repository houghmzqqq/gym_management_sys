package xyz.equ.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.xyz.gym_management_sys.dao.EquOrderDao;
import com.xyz.gym_management_sys.dao.EquOrderItemDao;
import com.xyz.gym_management_sys.dao.EquipmentDao;
import com.xyz.gym_management_sys.po.EquOrderItem;
import com.xyz.gym_management_sys.po.Equipment;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:applicationContext.xml"})
public class EquOrderItemDaoImplTest 
{
	
	@Resource
	private EquOrderItemDao equOrderItemDao;
	@Resource
	private EquipmentDao equipmentDao;
	@Resource
	private EquOrderDao equOrderDao;
	
	@Test
	@Transactional
	@Rollback(false)
	public void testAll()
	{
//		testAdd();
		test02();
	}
	
	public void testAdd()
	{
		EquOrderItem equOrderItem;
		
		for(int i=0;i<3;i++)
		{
			equOrderItem = new EquOrderItem(0, 3, 0, equipmentDao.getEquipmentById(3), equOrderDao.getEquOrderById(1));
			equOrderItemDao.addEquOrderItem(equOrderItem);
		}
	}
	
	public void test02()
	{
		List<EquOrderItem> equOrderItems = equOrderItemDao.getEquOrderItemByEquOrderId(1);
		for(EquOrderItem equOrderItem : equOrderItems)
		{
			System.out.println("byEquOrderId----"+equOrderItem);
		}
	}
}
