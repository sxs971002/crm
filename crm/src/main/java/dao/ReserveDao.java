package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import entity.Reserve;

@Repository
public interface ReserveDao {
	
	@Select("select c_reserve.*,c_client.name clientname,u1.name username,u2.name execusername from ((c_reserve inner join c_client on c_reserve.clientid = c_client.id) inner join c_user u1 on c_reserve.userid = u1.id) inner join c_user u2 on c_reserve.execuserid = u2.id ${txt} ${lim}")
	public List<Reserve> getAll(@Param("txt")String where, @Param("lim")String limit);
	
	@Select("select * from c_reserve")
	public List<Reserve> selectAll();
	
	@Insert("insert into c_reserve(revisitid,clientid,createdate,date,userid,execuserid,type,statu,execstatu,result) values(#{revisitid},#{clientid},#{createdate},#{date},#{userid},#{execuserid},#{type},#{statu},#{execstatu},#{result})")
	public int insert(Reserve r);

	@Delete("delete from c_reserve where id=#{id}")
	public int delete(int id);

	@Select("select * from c_reserve where id=#{id}")
	public Reserve getById(int id);

	@Update("update c_reserve set revisitid = #{revisitid},clientid = #{clientid},date = #{date},userid = #{userid},execuserid = #{execuserid},type = #{type},statu = #{statu},execstatu = #{execstatu},result = #{result} where id=#{id}")
	public int update(Reserve r);

	@Select("select count(1) from ((c_reserve inner join c_client on c_reserve.clientid = c_client.id) inner join c_user u1 on c_reserve.userid = u1.id) inner join c_user u2 on c_reserve.execuserid = u2.id ${txt}")
	public int selectCount(@Param("txt")String where);

	//以下为业务
	@Select("select c_client.name clientname,u1.name username,u2.name execusername,c_reserve.* from ((c_reserve inner join c_client on c_reserve.clientid = c_client.id) inner join c_user u1 on c_reserve.userid = u1.id) inner join c_user u2 on c_reserve.execuserid = u2.id ${txt} ${lim}")
	public List<Reserve> getMyreserved(@Param("txt")String where, @Param("lim")String limit);
	
	@Update("update c_reserve set date = #{date},type = #{type},statu = #{statu},execstatu = #{execstatu},result = #{result} where id=#{id}")
	public int updatepool(Reserve r);
	
}
