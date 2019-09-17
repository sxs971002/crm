package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import entity.Workgroup;


@Repository
public interface WorkgroupDao {
	
	@Select("select * from c_workgroup ${txt} ${lim}")
	public List<Workgroup> getAll(@Param("txt")String where, @Param("lim")String limit);
	
	@Insert("insert into c_workgroup(name) values(#{name})")
	public int insert(Workgroup w);

	@Delete("delete from c_workgroup where id=#{id}")
	public int delete(int id);

	@Select("select * from c_workgroup where id=#{id}")
	public Workgroup getById(int id);

	@Update("update c_workgroup set name = #{name} where id =#{id}")
	public int update(Workgroup w);

	@Select("select count(1) from c_workgroup ${txt}")
	public int selectCount(@Param("txt")String where);
}
