package com.lji.local.spring.dce.dao.extend;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SelfExtendMapper {

    /**自定义计算数量.
     * @param sql sql
     * @return int
     * @create: 2016年3月16日 下午3:31:22 linyy
     * @history:
     */
    @Select("${sql}")
    public int count(@Param("sql") String sql);

    /**查询某列.
     * @param sql
     * @return
     * @create: 2016年3月16日 下午4:23:21 linyy
     * @history:
     */
    @Select("${sql}")
    public List<Object> column(@Param("sql") String sql);

    /**返回计算后的数值.
     * @param sql
     * @return
     * @create: 2016年3月16日 下午4:24:04 linyy
     * @history:
     */
    @Select("${sql}")
    public BigDecimal bigDecimal(@Param("sql") String sql);

    /**查询所有列表.
     * @param sql
     * @return
     * @create: 2016年3月17日 上午10:31:55 linyy
     * @history:
     */
    @Select("${sql}")
    public List<Map<String, Object>> list(@Param("sql") String sql);

}
