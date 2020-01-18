package com.ledao.mapper;

import com.ledao.entity.Log;

import java.util.List;
import java.util.Map;

/**
 * 系统日志mapper接口
 *
 * @author LeDao
 * @company
 * @create 2020-01-18 12:08
 */
public interface LogMapper {

    /**
     * 添加系统日志
     *
     * @param log
     * @return
     */
    Integer add(Log log);

    /**
     * 根据条件分页查询日志信息
     *
     * @param map
     * @return
     */
    List<Log> list(Map<String, Object> map);

    /**
     * 获取记录数
     *
     * @param map
     * @return
     */
    Long getCount(Map<String, Object> map);
}
