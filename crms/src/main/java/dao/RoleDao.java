package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import entity.Role;

@Repository
public interface RoleDao {
	
	@Select("select * from crm_role ${txt}")
	public List<Role> getAll(@Param("txt")String where);
}
