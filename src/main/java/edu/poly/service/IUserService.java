package edu.poly.service;

import java.util.List;
import edu.poly.model.User;

public interface IUserService {
    public List<User> list();
	public void saveOrUpdate(User user);
    public void delete(String id);
    public User get(String id);
    public User checkLogin(String username, String password);
    public List<User> search(String name) ;
}
