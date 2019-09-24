package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import entity.Client;

@Repository
public interface ClientDao {
	
	@Select("select c_client.*,c_client_type.name clienttypename,c_user.name createusername,c_src.name srcname from ((c_client inner join c_client_type on c_client.clienttypeid = c_client_type.id) inner join c_user on c_client.createuserid = c_user.id)inner join c_src on c_client.srcid = c_src.id ${txt} ${lim}")
	public List<Client> getAll(@Param("txt")String where, @Param("lim")String limit);
	
	@Select("select * from c_client")
	public List<Client> selectAll();
	
	@Insert("insert into c_client(name,sex,tel,qq,email,address,infos,linkstatu,clientstatu,purposestatu,assessstatu,execstatu,statu,clienttypeid,userids,usernames,createuserid,createdate,srcid,count,comments) values(#{name},#{sex},#{tel},#{qq},#{email},#{address},#{infos},#{linkstatu},#{clientstatu},#{purposestatu},#{assessstatu},#{execstatu},#{statu},#{clienttypeid},#{userids},#{usernames},#{createuserid},#{createdate},#{srcid},#{count},#{comments})")
	public int insert(Client c);

	@Delete("delete from c_client where id=#{id}")
	public int delete(int id);

	@Select("select * from c_client where id=#{id}")
	public Client getById(int id);

	@Update("update c_client set name = #{name},sex = #{sex},tel = #{tel},qq = #{qq},email = #{email},address = #{address},infos = #{infos},linkstatu = #{linkstatu},clientstatu = #{clientstatu},purposestatu = #{purposestatu},assessstatu = #{assessstatu},execstatu = #{execstatu},statu = #{statu},clienttypeid = #{clienttypeid},userids = #{userids},usernames = #{usernames},createuserid = #{createuserid},createdate = #{createdate},srcid = #{srcid},count = #{count},comments = #{comments} where id=#{id}")
	public int update(Client c);

	@Select("select count(1) from ((c_client inner join c_client_type on c_client.clienttypeid = c_client_type.id) inner join c_user on c_client.createuserid = c_user.id)inner join c_src on c_client.srcid = c_src.id ${txt}")
	public int selectCount(@Param("txt")String where);

	//以下为业务
	@Select("select c_client.*,c_client_type.name clienttypename,c_user.name createusername,c_src.name srcname from ((c_client inner join c_client_type on c_client.clienttypeid = c_client_type.id) inner join c_user on c_client.createuserid = c_user.id)inner join c_src on c_client.srcid = c_src.id ${txt} ${lim}")
	public List<Client> getNoappoint(@Param("txt")String where, @Param("lim")String limit);
	
	@Select("select c_client.*,c_client_type.name clienttypename,c_user.name createusername,c_src.name srcname from ((c_client inner join c_client_type on c_client.clienttypeid = c_client_type.id) inner join c_user on c_client.createuserid = c_user.id)inner join c_src on c_client.srcid = c_src.id ${txt} ${lim}")
	public List<Client> getMyunexecuted(@Param("txt")String where, @Param("lim")String limit);

	@Update("update c_client set userids = null,usernames = null where id = #{id}")
	public int remove(Client u);

	@Select("select c_client.*,c_client_type.name clienttypename,c_user.name createusername,c_src.name srcname from ((c_client inner join c_client_type on c_client.clienttypeid = c_client_type.id) inner join c_user on c_client.createuserid = c_user.id)inner join c_src on c_client.srcid = c_src.id where c_client.id = #{clientid}")
	public Client getAllById(int clientid);

	@Select("select c_client.*,c_client_type.name clienttypename,c_user.name createusername,c_src.name srcname from ((c_client inner join c_client_type on c_client.clienttypeid = c_client_type.id) inner join c_user on c_client.createuserid = c_user.id)inner join c_src on c_client.srcid = c_src.id ${txt} ${lim}")
	public List<Client> getMyexecuted(@Param("txt")String where, @Param("lim")String limit);

	
}
