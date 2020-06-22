package com.kearmy.dao;import com.kearmy.domain.QueryVo;import com.kearmy.domain.User;import java.util.List;public interface IUserDao {    /**     * 查询所有用户     * @return     */    List<User> findAll();    /**     * 插入新的用户     * @param user     */    void saveUser(User user);    /**     * 更新用户     */    void updateUser(User user);    /**     * 删除用户     */    void deleteUser(Integer userId);    /**     * 根据用户id查询     * @param userId     * @return     */    User findById(Integer userId);    /**     * 根据用户名模糊查询所有用户     * @param username     * @return     */    List<User> findByUsername(String username);    /**     * 查询总记录数     * @return     */    Integer findTotal();    /**     * 通过QueryVO模糊查询查询     * @param queryVo     * @return     */    List<User> findByQueryVo(QueryVo queryVo);}