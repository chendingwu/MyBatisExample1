package cn.cdw.demo.mapper;

import cn.cdw.demo.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author DW-CHEN
 * MyBatis动态sql
 * 根据不同条件进行查询
 */
public class TestUserMapper1 {
    public static void main(String[] args) throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("MyBatisConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);//获取动态代理对象

        User u1 = mapper.findByCondition(new User(2, null, null));
        User u2 = mapper.findByCondition(new User(null, "小小", 12));
        User u3 = mapper.findByCondition(new User(null, null, 23));

        System.out.println(u1);
        System.out.println(u2);
        System.out.println(u3);

        sqlSession.close();
        resourceAsStream.close();
    }
}
