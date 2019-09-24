package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import entity.Order;

@Repository
public interface OrderDao {
	
	@Select("select c_order.*,c_client.name clientname,c_user.name createusername from (c_order inner join c_client on c_order.clientid = c_client.id) inner join c_user on c_order.createuserid = c_user.id ${txt} ${lim}")
	public List<Order> getAll(@Param("txt")String where, @Param("lim")String limit);
	
	@Select("select * from c_order")
	public List<Order> selectAll();
	
	@Insert("insert into c_order(clientid,createdate,performdate,orderdate,startdate,enddate,infos,createuserid,files,performuserids,performusernames,performweight,statu,totalprice,comments) values(#{clientid},#{createdate},#{performdate},#{orderdate},#{startdate},#{enddate},#{infos},#{createuserid},#{files},#{performuserids},#{performusernames},#{performweight},#{statu},#{totalprice},#{comments})")
	public int insert(Order o);

	@Delete("delete from c_order where id=#{id}")
	public int delete(int id);

	@Select("select * from c_order where id=#{id}")
	public Order getById(int id);

	@Update("update c_order set clientid = #{clientid},createdate = #{createdate},performdate = #{performdate},orderdate = #{orderdate},startdate = #{startdate},enddate = #{enddate},infos = #{infos},createuserid = #{createuserid},files = #{files},performuserids = #{performuserids},performusernames = #{performusernames},performweight = #{performweight},statu = #{statu},totalprice = #{totalprice},comments = #{comments} where id=#{id}")
	public int update(Order o);

	@Select("select count(1) from (c_order inner join c_client on c_order.clientid = c_client.id) inner join c_user on c_order.createuserid = c_user.id ${txt}")
	public int selectCount(@Param("txt")String where);

	@Select("select c_order.*,c_client.name clientname,c_user.name createusername from (c_order inner join c_client on c_order.clientid = c_client.id) inner join c_user on c_order.createuserid = c_user.id where clientid=#{clientid}")
	public Order getByClientId(int clientid);
	
}
