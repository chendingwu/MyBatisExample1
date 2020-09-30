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
 * 测试MyBatis接口代理方式实现dao层，不需要实现类了
 */
public class TestUserMapper {
    public static void main(String[] args) throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("MyBatisConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);//获取动态代理对象
        User user = mapper.findById(2);

        System.out.println(user);
        sqlSession.close();
        resourceAsStream.close();

    }
}
