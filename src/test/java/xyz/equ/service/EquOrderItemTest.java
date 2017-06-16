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
import org.springframework.web.portlet.bind.annotation.ResourceMapping;
import org.springframework.web.servlet.config.VelocityConfigurerBeanDefinitionParser;

import com.xyz.gym_management_sys.dao.EquOrderDao;
import com.xyz.gym_management_sys.dao.EquOrderItemDao;
import com.xyz.gym_management_sys.po.EquOrderItem;
import com.xyz.gym_management_sys.service.EquOrderItemService;
import com.xyz.gym_management_sys.vo.EquOrderItemVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:applicationContext.xml"})
public class EquOrderItemTest 
{
	@Resource
	private EquOrderItemService equOrderItemService;
	@Resource
	private EquOrderItemDao equOrderItemDao;
	@Resource
	private EquOrderDao equOrderDao;
	@Resource
	private DozerBeanMapper mapper;
	
	@Test
	@Transactional
	@Rollback(true)
	public void testAll()
	{
//		test01();
		test02();
	}
	
	public void test01()
	{
		List<EquOrderItemVO> equOrderItemVOs = equOrderItemService.findEquOrderItemByEquOrderId(1);
		for(EquOrderItemVO equOrderItemVO : equOrderItemVOs)
		{
			System.out.println(equOrderItemVO.getEquName()+":"+equOrderItemVO.getEquCount());
		}
	}
	
	public void test02()
	{
		EquOrderItem equOrderItem = new EquOrderItem(1, 5, 14, null, equOrderDao.getEquOrderById(1));
		equOrderItem.setEquOrderItemId(1);
		EquOrderItemVO equOrderItemVO = mapper.map(equOrderItem, EquOrderItemVO.class);
		
		equOrderItemService.updateEquOrderItem(equOrderItemVO);
	}
}
