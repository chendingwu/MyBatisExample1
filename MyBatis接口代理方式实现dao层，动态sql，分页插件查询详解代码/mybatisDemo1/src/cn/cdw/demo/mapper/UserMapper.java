package cn.cdw.demo.mapper;

import cn.cdw.demo.pojo.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DW-CHEN
 * MyBatis接口代理方式实现dao层
 */
public interface UserMapper {
    public List<User> findAllByPage();

    public User findById(Integer id);

    public User findByCondition(User user);

    public List<User> findByIds(ArrayList<Integer> ids);
}
