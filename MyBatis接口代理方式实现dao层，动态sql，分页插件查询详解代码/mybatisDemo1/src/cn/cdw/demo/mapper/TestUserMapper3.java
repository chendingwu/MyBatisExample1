package cn.cdw.demo.mapper;

import cn.cdw.demo.pojo.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author DW-CHEN
 * PageHelper分页助手
 */
public class TestUserMapper3 {
    public static void main(String[] args) throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("MyBatisConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);//获取动态代理对象

        // PageHelper.startPage(1, 2);//从第一页开始，每页显示2条数据
       PageHelper.startPage(2, 2);//从第二页开始，每页显示2条数据

        List<User> all = mapper.findAllByPage();
        for (User user : all) {
            System.out.println(user);
        }

        PageInfo<User> pageInfo = new PageInfo<>(all);
        System.out.println("总数据：" + pageInfo.getTotal());
        System.out.println("总页数：" + pageInfo.getPages());
        System.out.println("当前页：" + pageInfo.getPageNum());
        System.out.println("每页显示的数据：" + pageInfo.getPageSize());
        System.out.println("上一页：" + pageInfo.getPrePage());
        System.out.println("下一页：" + pageInfo.getNextPage());
        System.out.println("是否时第一页：" + pageInfo.isIsFirstPage());
        System.out.println("是否是最后一页：" + pageInfo.isIsLastPage());

        sqlSession.close();
        resourceAsStream.close();
    }
}
