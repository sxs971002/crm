package service;

import java.util.List;

import entity.Client;

public interface ClientService {

	public List<Client> getAll(String where,String limit);
	public List<Client> selectAll();
	public int delete(int id);
	public int insert(Client c);
	public Client getById(int id);
	public int update(Client c);
	public int selectCount(String where);
}
