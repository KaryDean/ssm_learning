package com.kearmy.mybatis;import com.kearmy.dao.IUserDao;import com.kearmy.domain.User;import org.apache.ibatis.io.Resources;import org.apache.ibatis.session.SqlSession;import org.apache.ibatis.session.SqlSessionFactory;import org.apache.ibatis.session.SqlSessionFactoryBuilder;import org.junit.After;import org.junit.Before;import org.junit.Test;import java.io.IOException;import java.io.InputStream;import java.util.ArrayList;import java.util.List;public class TestUser {    private InputStream is;    private SqlSession sqlSession;    private IUserDao userDao;    /**     * 创建IUserDao实现类     * @throws IOException     */    @Before //在所有方法执行之前执行    public void init() throws IOException {        is = Resources.getResourceAsStream("SqlMapConfig.xml");        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);        sqlSession = sqlSessionFactory.openSession();        userDao = sqlSession.getMapper(IUserDao.class);    }    /**     * 关闭资源     * @throws IOException     */    @After //在所有方法执行之后执行    public void  close() throws IOException {        sqlSession.commit();//保存后必须提交，否则回滚        sqlSession.close();        is.close();    }    /**     * 测试查询所有操作     * @throws IOException     */    @org.junit.Test    public void testFindAll() throws IOException {        List<User> users = userDao.findAll();//        List<User> users = sqlSession.selectList("com.kearmy.dao.IUserDao.findAll");        for(User user : users){            System.out.println(user);            System.out.println(user.getAccounts());        }    }    /**     * 测试通过id关键词查询操作     * @throws IOException     */    @org.junit.Test    public void testFindById() throws IOException {        User user = userDao.findById(41);        System.out.println(user);    }}