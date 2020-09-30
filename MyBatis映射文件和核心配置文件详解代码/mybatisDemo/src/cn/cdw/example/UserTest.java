package cn.cdw.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * @author DW-CHEN
 * 测试
 */
public class UserTest {
    public static void main(String[] args) throws Exception {
        findAll();//查询全部数据
        //findById();
        //add();
        //update();
        //delete();
    }

    //获取SqlSession对象通用方法
    public static SqlSession getSqlSession() throws Exception {
        InputStream resourceAsStream = Resources.getResourceAsStream("MyBatisConfig.xml");//读取核心配置文件MyBatisConfig.xml
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);//获取SqlSessionFactory工厂
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//通过SqlSessionFactory工厂获取SqlSession对象

        resourceAsStream.close();
        return sqlSession;
    }

    //查询全部
    public static void findAll() throws Exception {
        SqlSession sqlSession = getSqlSession();
        List<User> user = sqlSession.selectList("UserMapper.findAll");

        for (User user1 : user) {
            System.out.println(user1.getId() + " " + user1.getName() + " "+ user1.getAge());
        }
        sqlSession.close();
    }

    //根据id查询
    public static void findById() throws Exception {
        SqlSession sqlSession = getSqlSession();
        User user = sqlSession.selectOne("UserMapper.findById", 2);
        System.out.println(user);
        sqlSession.close();
    }

    //添加
    public static void add() throws Exception{
        SqlSession sqlSession = getSqlSession();
        sqlSession.insert("UserMapper.add",new User(null,"小李利",12));
        sqlSession.close();
    }

    //修改
    public static void update() throws Exception{
        SqlSession sqlSession = getSqlSession();
        sqlSession.update("UserMapper.update",new User(11,"修改小溪",32));
        sqlSession.close();
    }

    //根据id删除
    public static void delete() throws Exception{
        SqlSession sqlSession = getSqlSession();
        sqlSession.delete("UserMapper.delete",1);
        sqlSession.close();
    }
}
