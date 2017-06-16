package xyz.equ.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.xyz.gym_management_sys.dao.EquTypeDao;
import com.xyz.gym_management_sys.po.EquType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:applicationContext.xml"})
public class EquTypeDaoImplTest
{
	@Resource
	EquTypeDao equTypeDao;

	
	public void test01()
	{
		EquType equType;

		equType = new EquType("肉球");
		equTypeDao.addEquType(equType);
		
	}
	
	public void test02()
	{
//		equTypeDao.deleteEquType(11);
	}
	
	public void test03()
	{
		System.out.println(equTypeDao.getEquTypeById(3));
	}
	
	public void test04()
	{
		List<EquType> equTypes = equTypeDao.getAllEquType();
		for(EquType equType : equTypes)
		{
			System.out.println(equType);
		}
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void testAll()
	{
//		test01();
//		test02();
		test04();
	}
}
