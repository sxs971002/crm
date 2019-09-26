package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import entity.Revisit;

@Repository
public interface RevisitDao {
	
	@Select("select c_revisit.*,c_client.name clientname, c_user.name execusername from (c_revisit inner join c_client on c_revisit.clientid = c_client.id) inner join c_user on c_revisit.execuserid = c_user.id ${txt} ${lim}")
	public List<Revisit> getAll(@Param("txt")String where, @Param("lim")String limit);
	
	@Select("select * from c_revisit")
	public List<Revisit> selectAll();
	
	@Insert("insert into c_revisit(clientid,execuserid,date,linkstatu,clientstatu,purposestatu,assessstatu,execstatu,statu,askinfo,followinfo,probleminfo,comments) values(#{clientid},#{execuserid},#{date},#{linkstatu},#{clientstatu},#{purposestatu},#{assessstatu},#{execstatu},#{statu},#{askinfo},#{followinfo},#{probleminfo},#{comments})")
	public int insert(Revisit r);

	@Delete("delete from c_revisit where id=#{id}")
	public int delete(int id);

	@Select("select * from c_revisit where id=#{id}")
	public Revisit getById(int id);

	@Update("update c_revisit set clientid = #{clientid},execuserid = #{execuserid},linkstatu = #{linkstatu},clientstatu = #{clientstatu},purposestatu = #{purposestatu},assessstatu = #{assessstatu},execstatu = #{execstatu},statu = #{statu},askinfo = #{askinfo},followinfo = #{followinfo},probleminfo = #{probleminfo},comments = #{comments} where id=#{id}")
	public int update(Revisit r);

	@Select("select count(1) from (c_revisit inner join c_client on c_revisit.clientid = c_client.id) inner join c_user on c_revisit.execuserid = c_user.id ${txt}")
	public int selectCount(@Param("txt")String where);

	//以下为业务
	@Select("select c_revisit.*,c_client.name clientname from (c_revisit inner join c_client on c_revisit.clientid = c_client.id) inner join c_user on c_revisit.execuserid = c_user.id ${txt} ${lim}")
	public List<Revisit> getAllById(@Param("txt")String where, @Param("lim")String limit);
	
}
