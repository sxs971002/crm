package serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.RoleDao;
import entity.Role;
import service.RoleService;


@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleDao roleDao;
	public List<Role> getAll(String where) {
		// TODO Auto-generated method stub
		return roleDao.getAll(where);
	}
}
