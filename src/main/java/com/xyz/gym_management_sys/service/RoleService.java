package com.xyz.gym_management_sys.service;

import java.util.List;

import com.xyz.gym_management_sys.po.Role;
import com.xyz.gym_management_sys.vo.RoleVo;

/**
 * 这是处理用户角色相关的业务接口，其中定义了相关业务方法
 * @author HIPAA
 */
public interface RoleService {
	/**
	 * 更新用户角色表记录，实际为更新用户角色名称
	 * @param role
	 * @return boolean
	 */
	public boolean updateRole(RoleVo roleVo);
	
	/**
	 * 通过Role的ID查找一个用户角色记录
	 * @param role
	 * @return Role
	 */
	public RoleVo findRoleById(RoleVo roleVo);
	
	/**
	 * 查找Role记录，它可以完成以下业务:
	 * 1.通过Role的名称查找用户角色,返回List但理应不存在同名Role
	 * 2.查找所有的Role记录
	 * @param role
	 * @return List<Role>
	 */
	public List<RoleVo> findRoles(RoleVo roleVo);
}
