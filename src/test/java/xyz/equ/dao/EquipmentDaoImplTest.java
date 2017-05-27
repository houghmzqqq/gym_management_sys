package xyz.equ.dao;

import javax.persistence.JoinColumn;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.xyz.gym_management_sys.dao.EquTypeDao;
import com.xyz.gym_management_sys.dao.EquipmentDao;
import com.xyz.gym_management_sys.dao.impl.EquipmentDaoImpl;
import com.xyz.gym_management_sys.po.EquType;
import com.xyz.gym_management_sys.po.Equipment;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:applicationContext.xml"})
public class EquipmentDaoImplTest 
{
	@Resource
	private EquipmentDao equipmentDao;
	@Resource
	private EquTypeDao equTypeDao;
	
	@Test
	@Transactional
	@Rollback(false)
	public void testAll()
	{
//		testAdd();
		testDel();
//		testUpdate();
		test04();
//		test05();
	}
	
	public void testAdd()
	{
		Equipment equipment;
		for(int i=0;i<10;i++)
		{
			equipment = new Equipment("双鱼"+i+"星乒乓球", 100, 33, 23, 0, 43, 24, 4, 5, 6, equTypeDao.getEquTypeById(1));
			equipmentDao.addEquipment(equipment);
		}
	}
	
	public void testDel()
	{
		Equipment equipment = equipmentDao.getEquipmentById(2);
		equipmentDao.deleteEquipment(equipment);
	}
	
	public void testUpdate()
	{
		Equipment equipment = new Equipment("红双喜5星乒乓球", 111, 23, 6, 34, 2, 23, 41, 1, 61, equTypeDao.getEquTypeById(1));
		equipment.setEquId(8);
		equipmentDao.updateEquipment(equipment);
	}
	
	public void test04()
	{
		List<Equipment> equipments = equipmentDao.getEquipmentsByEquType(equTypeDao.getEquTypeById(1));
		
		for(Equipment equipment : equipments)
		{
			System.out.println("allEquipment----"+equipment);
		}
	}
	
	public void test05()
	{
		List<Equipment> equipments = equipmentDao.getPageEquipment(3, 5);
		for(Equipment equipment : equipments)
		{
			System.out.println("pageEquipment---"+equipment.getEquId());
		}
	}
}
