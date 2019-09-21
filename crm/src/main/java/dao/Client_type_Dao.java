package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import entity.Client_type;


@Repository
public interface Client_type_Dao {
	
	@Select("select * from c_client_type ${txt} ${lim}")
	public List<Client_type> getAll(@Param("txt")String where, @Param("lim")String limit);
	
	@Insert("insert into c_client_type(name) values(#{name})")
	public int insert(Client_type c);

	@Delete("delete from c_client_type where id=#{id}")
	public int delete(int id);

	@Select("select * from c_client_type where id=#{id}")
	public Client_type getById(int id);

	@Update("update c_client_type set name = #{name} where id =#{id}")
	public int update(Client_type c);

	@Select("select count(1) from c_client_type ${txt}")
	public int selectCount(@Param("txt")String where);
}
