package com.xyz.gym_management_sys.dao;

import java.util.List;

import com.xyz.gym_management_sys.po.Admin;

/**
 * 这接口中定义了Admin实体的数据库操作方法
 * @author HIPAA
 */
public interface AdminDao {
	/**
	 * 添加一个新的管理员账户记录到数据库的方法
	 * @param admin
	 */
	public void addAdmin(Admin admin);
	
	/**
	 * 更新数据库中的管理员账户信息的方法，传入的admin对象中主键对应的属性不可以为空
	 * @param admin
	 */
	public void updateAdmin(Admin admin);
	
	/**
	 * 删除一条指定的管理员账户记录，传入的admin对象中的主键对应属性不可为空
	 * @param admin
	 */
	public void deleteAdmin(Admin admin);
	
	/**
	 * 查找多条管理员账户记录，传入的admin属性中不为空的属性将作为查询条件
	 * @param admin
	 * @return List<Admin>
	 */
	public List<Admin> findAdminByNotNullProp(Admin admin); 
}
