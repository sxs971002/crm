package dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import entity.Department;

@Repository
public interface DepartmentDao {
	
	@Select("select * from crm_department")
	public List<Department> getAll();
}
