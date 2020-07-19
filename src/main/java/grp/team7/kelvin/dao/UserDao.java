package grp.team7.kelvin.dao;

import grp.team7.kelvin.entity.User;
import grp.team7.kelvin.entity.Dish;
import grp.team7.kelvin.entity.Shop;
import java.util.List;

/**
* UserDao
*/
public interface UserDao {
    public User findById(Integer id);
    public User findByAccount(String userAccount);
    public int addUser(User user);
    public int deleteUser(Integer id);
    public int updateUser(User user);
    public List<User> findAll();
    public List<Dish> findDishCollectById(Integer id);
    public List<Shop> findShopCollectById(Integer id);
    public User findUserByAcAndPa(String userAccount, String userPasswordsha256);
}
