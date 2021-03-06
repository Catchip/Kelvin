package grp.team7.kelvin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grp.team7.kelvin.service.ShopService;
import grp.team7.kelvin.entity.*;
import grp.team7.kelvin.dao.*;

import java.util.Date;
import java.util.List;

@Service
public class ShopServiceImp implements ShopService {

    @Autowired
    private DishDao dishdao;

    @Autowired
    private OrderDao orderdao;

    @Autowired
    private ShopDao shopDao;

    @Autowired
    private DishDao dishDao;

    @Override
    public List<Dish> getDishes(Integer shopId) {
        return dishdao.findAllWithShop(shopId);
    }

    @Override
    public List<Order> getOrders(Integer shopId) {
        return orderdao.findByShop(shopId);
    }

    @Override
    public int addDish(Dish dish) {
        dish.setStatus(false);
        return dishdao.addDish(dish);
    }

    @Override
    public int updateDishInfo(Dish dish) {
        return dishdao.updateDish(dish);
    }

    @Override
    public int deleteDish(Integer dishId) {
        return dishdao.deleteDish(dishId);
    }

    @Override
    public int putOnDish(Integer dishId) {
        Dish dish = new Dish();
        dish.setDishId(dishId);
        Boolean x = true;
        dish.setStatus(x);
        return dishdao.updateDish(dish);
    }

    @Override
    public int pullDownDish(Integer dishId) {
        Dish dish = new Dish();
        dish.setDishId(dishId);
        Boolean x = false;
        dish.setStatus(x);
        return dishdao.updateDish(dish);
    }

    @Override
    public int updateInfo(Shop shop) {
        Date date = new Date();
        shop.setShopUpdatetime(date);
        return shopDao.updateShop(shop);
    }

    @Override
    public int deleteAllDish(Integer shopId) {
        return dishDao.deleteWithShop(shopId);
    }

    @Override
    public Shop getInfo(Integer shopId) {
        return shopDao.findById(shopId);
    }

    @Override
    public List<Shop> search(Shop shop) {
        return shopDao.find(shop);
    }

    @Override
    public List<Dish> searchDish(Dish dish) {
        return dishDao.find(dish);
    }
}
