package xyz.equ.service;

import java.util.List;

import javax.annotation.Resource;

import org.dozer.DozerBeanMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.xyz.gym_management_sys.dao.EquipmentDao;
import com.xyz.gym_management_sys.po.Equipment;
import com.xyz.gym_management_sys.service.EquipmentService;
import com.xyz.gym_management_sys.vo.EquipmentVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:applicationContext.xml"})
public class EquipmentServiceTest 
{
	
	@Resource
	private EquipmentService equipmentService;
	@Resource 
	private EquipmentDao equipmentDao;
	
	@Test
	@Transactional
	@Rollback(false)
	public void testAll()
	{
//		testAdd();
//		test02();
		test03();
//		test04();
	}
	
	public void testAdd()
	{
		EquipmentVO equipmentVO;
		for(int i=1;i<11;i++)
		{
			equipmentVO = new EquipmentVO("红双喜2星乒乓球"+i+10, 2, "乒乓球", 100, 33, 23, 0, 43, 24,200, 4, 5, 6);
			equipmentService.addEqu(equipmentVO);
		}
	}
	
	public void test02()
	{
		List<EquipmentVO> equipmentVOs = equipmentService.dividePageOfEqu(3, 3);
		
		for(EquipmentVO equipmentVO : equipmentVOs)
		{
			System.out.println(equipmentVO);
		}
	}
	
	public void test03()
	{
		equipmentService.removeEqu(18);
	}
	
	public void test04()
	{
		EquipmentVO equipmentVO = equipmentService.findEquById(3);
		equipmentVO.setEquBorrowCount(55);
		equipmentService.updateEqu(equipmentVO);
	}
}
