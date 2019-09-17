package serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.DepartmentDao;
import entity.Department;
import service.DepartmentService;


@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	DepartmentDao depDao;
	public List<Department> getAll() {
		// TODO Auto-generated method stub
		return depDao.getAll();
	}
}
