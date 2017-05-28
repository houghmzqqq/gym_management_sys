package xyz.equ.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.xyz.gym_management_sys.service.EquTypeService;
import com.xyz.gym_management_sys.vo.EquTypeVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:applicationContext.xml"})
public class EquTypeServiceTest 
{
	
	@Resource
	private EquTypeService equTypeService;
	
	private EquTypeVO equTypeVO;
	
	@Test
	@Transactional
	@Rollback(false)
	public void testAll()
	{
//		test01();
//		test02();
//		test03();
		test04();
	}
	
	public void test01()
	{
		equTypeVO = new EquTypeVO();
		equTypeVO.setEquTypeName("排球");
		equTypeService.addEquType(equTypeVO);
	}
	
	public void test02()
	{
		equTypeService.removeEquType(6);
	}
	
	public void test03()
	{
		equTypeVO = new EquTypeVO();
		equTypeVO.setEquTypeId(5);
		equTypeVO.setEquTypeName("杠铃");
		equTypeService.updateEquType(equTypeVO);
	}
	
	public void test04()
	{
		equTypeVO = equTypeService.findById(3);
		System.out.println("findById--------"+equTypeVO.getEquTypeName());
		List<EquTypeVO> equTypeVOs = equTypeService.findAllEquType();
		for(EquTypeVO equTypeVO : equTypeVOs)
		{
			System.out.println("findByAll-------"+equTypeVO.getEquTypeName());
		}
	}
}
