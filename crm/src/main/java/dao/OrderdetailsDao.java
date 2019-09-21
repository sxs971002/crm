package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import entity.Orderdetails;


@Repository
public interface OrderdetailsDao {
	
	@Select("select c_orderdetails.*, c_product.name productname from c_orderdetails inner join c_product on c_orderdetails.productid = c_product.id ${txt} ${lim}")
	public List<Orderdetails> getAll(@Param("txt")String where, @Param("lim")String limit);
	
	@Insert("insert into c_orderdetails(orderid,productid,amount,price,disc,comments) values(#{orderid},#{productid},#{amount},#{price},#{disc},#{comments})")
	public int insert(Orderdetails o);

	@Delete("delete from c_orderdetails where id=#{id}")
	public int delete(int id);

	@Select("select * from c_orderdetails where id=#{id}")
	public Orderdetails getById(int id);

	@Update("update c_orderdetails set orderid = #{orderid},productid = #{productid},amount = #{amount},price = #{price},disc = #{disc},comments = #{comments} where id =#{id}")
	public int update(Orderdetails o);

	@Select("select count(1) from c_orderdetails inner join c_product on c_orderdetails.productid = c_product.id ${txt}")
	public int selectCount(@Param("txt")String where);
}
