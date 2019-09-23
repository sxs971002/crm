package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import entity.User;
@Repository
public interface UserDao {
	
	@Select("select * from c_user where tel=#{tel} and pass=#{pass}")
	public User login(User u);
	
	@Select("select c_user.*,c_workgroup.name groupname from c_user inner join c_workgroup on c_user.groupid = c_workgroup.id ${txt} ${lim}")
	public List<User> getAll(@Param("txt")String where, @Param("lim")String limit);
	
	@Insert("insert into c_user(name,pass,tel,sex,statu,power,groupid) values(#{name},#{pass},#{tel},#{sex},#{statu},#{power},#{groupid})")
	public int insert(User u);

	@Delete("delete from c_user where id=#{id}")
	public int delete(int id);

	@Select("select * from c_user where id=#{id}")
	public User getById(Integer id);

	@Update("update c_user set name = #{name},pass = #{pass},tel=#{tel},sex = #{sex},statu = #{statu},power = #{power},groupid = #{groupid} where id =#{id}")
	public int update(User u);

	@Select("select count(1) from c_user inner join c_workgroup on c_user.groupid = c_workgroup.id ${txt}")
	public int selectCount(@Param("txt")String where);

	@Select("select * from c_user where tel=#{tel}")
	public User selectByTel(String tel);
	
}
