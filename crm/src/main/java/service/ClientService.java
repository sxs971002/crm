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
	//以下为业务
	public List<Client> getNoappoint(String where, String lim);
	public List<Client> getMyunexecuted(String where, String lim);
	public int remove(Client u);
	public Client getAllById(int clientid);
	public List<Client> getMyexecuted(String where, String lim);
	public int updates(String clientid, String userids, String usernames);
}