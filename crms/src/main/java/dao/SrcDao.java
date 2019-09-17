package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import entity.Src;


@Repository
public interface SrcDao {
	
	@Select("select * from c_src ${txt} ${lim}")
	public List<Src> getAll(@Param("txt")String where, @Param("lim")String limit);
	
	@Insert("insert into c_src(name) values(#{name})")
	public int insert(Src w);

	@Delete("delete from c_src where id=#{id}")
	public int delete(int id);

	@Select("select * from c_src where id=#{id}")
	public Src getById(int id);

	@Update("update c_src set name = #{name} where id =#{id}")
	public int update(Src w);

	@Select("select count(1) from c_src ${txt}")
	public int selectCount(@Param("txt")String where);
}
