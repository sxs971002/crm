package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import entity.Product;
@Repository
public interface ProductDao {
	
	@Select("select * from c_product ${txt} ${lim}")
	public List<Product> getAll(@Param("txt")String where, @Param("lim")String limit);
	
	@Insert("insert into c_product(name,price,info) values(#{name},#{price},#{info})")
	public int insert(Product u);

	@Delete("delete from c_product where id=#{id}")
	public int delete(int id);

	@Select("select * from c_product where id=#{id}")
	public Product getById(int id);

	@Update("update c_product set name = #{name},price = #{price},info=#{info} where id =#{id}")
	public int update(Product u);

	@Select("select count(1) from c_product ${txt}")
	public int selectCount(@Param("txt")String where);
	
}
