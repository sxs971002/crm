package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import entity.Customer_level;

@Repository
public interface Customer_level_Dao {
	
	@Select("select crm_customer_level.* from crm_customer_level ${txt} ${lim}")
	public List<Customer_level> getAll(@Param("txt")String where, @Param("lim")String limit);
	
	@Select("select * from crm_customer_level")
	public List<Customer_level> selectAll();
	
	@Insert("insert into crm_customer_level(levelname) values(#{levelname})")
	public int insert(Customer_level cl);

	@Delete("delete from crm_customer_level where id=#{id}")
	public int delete(int id);

	@Select("select * from crm_customer_level where id=#{id}")
	public Customer_level getById(int id);

	@Update("update crm_user set levelname = #{levelname}")
	public int update(Customer_level cl);

	@Select("select count(1) from crm_customer_level ${txt}")
	public int selectCount(@Param("txt")String where);
	
}
