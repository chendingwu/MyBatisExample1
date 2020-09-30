package cn.cdw.demo.mapper;

import cn.cdw.demo.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author DW-CHEN
 * 测试
 */
public class TestUserMapper {
    public static void main(String[] args) throws IOException {
        //findAll();
        //findById();
        //add();
        //update();
        delete();

    }

    public static UserMapper getUserMapper() throws IOException {//获取mapper
        InputStream resourceAsStream = Resources.getResourceAsStream("MyBatisConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        resourceAsStream.close();
        return mapper;
    }

    public static void findAll() throws IOException {//查询所有数据
        UserMapper mapper = getUserMapper();
        List<User> all = mapper.findAll();

        for (User user : all) {
            System.out.println(user);
        }
    }

    public static void findById() throws IOException {//根据id查询
        UserMapper userMapper = getUserMapper();
        User user = userMapper.findById(2);
        System.out.println(user);
    }

    public static void add() throws IOException {//添加
        UserMapper userMapper = getUserMapper();
        Integer i = userMapper.add(new User(null, "小行星", 12));
        System.out.println(i+" 添加成功");
    }

    public static void update() throws IOException {
        UserMapper userMapper = getUserMapper();
        Integer i = userMapper.update(new User(11, "修改修改", 66));
        System.out.println(i + " 修改成功");
    }

    public static void delete() throws IOException {
        UserMapper userMapper = getUserMapper();
        Integer delete = userMapper.delete(4);
        System.out.println(delete + " 删除成功");
    }
}
