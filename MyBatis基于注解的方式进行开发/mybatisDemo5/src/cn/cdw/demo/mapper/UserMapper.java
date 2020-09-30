package cn.cdw.demo.mapper;

import cn.cdw.demo.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author DW-CHEN
 * MyBatis基于注解查询
 */
public interface UserMapper {

    @Select("select * from user")
    public List<User> findAll();

    @Select("select * from user where id=#{id}")
    public User findById(Integer id);

    @Insert("insert into user values(null,#{name},#{age})")
    public Integer add(User user);

    @Update("update user set name = #{name},age = #{age} where id = #{id}")
    public Integer update(User user);

    @Delete("delete from user where id = #{id}")
    public Integer delete(Integer id);
}
