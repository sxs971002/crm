package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import entity.Customer;

@Repository
public interface CustomerDao {
	
	@Select("select crm_customer.*,crm_customer_level.levelname cuslevelname from crm_customer inner join crm_customer_level on crm_customer.cuslevelid = crm_customer_level.id ${txt} ${lim}")
	public List<Customer> getAll(@Param("txt")String where, @Param("lim")String limit);
	
	@Select("select * from crm_customer")
	public List<Customer> selectAll();
	
	@Insert("insert into crm_customer(cusname,custel,cussex,cusaddress,cuslevelid) values(#{cusname},#{custel},#{cussex},#{cusaddress},#{cuslevelid})")
	public int insert(Customer c);

	@Delete("delete from crm_customer where id=#{id}")
	public int delete(int id);

	@Select("select * from crm_customer where id=#{id}")
	public Customer getById(int id);

	@Update("update crm_customer set cusname = #{cusname},custel = #{custel},cussex=#{cussex},cusaddress = #{cusaddress},cuslevelid = #{cuslevelid} where id =#{id}")
	public int update(Customer u);

	@Select("select count(1) from crm_customer inner join crm_customer_level on crm_customer.cuslevelid = crm_customer_level.id ${txt}")
	public int selectCount(@Param("txt")String where);
	
}
