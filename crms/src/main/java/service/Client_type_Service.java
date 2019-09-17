package service;

import java.util.List;

import entity.Client_type;

public interface Client_type_Service {

	public List<Client_type> getAll(String where,String limit);
	public int delete(int id);
	public int insert(Client_type c);
	public Client_type selectById(int id);
	public int update(Client_type c);
	public int selectCount(String where);
}
