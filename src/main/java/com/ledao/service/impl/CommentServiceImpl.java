package com.ledao.service.impl;

import com.ledao.entity.Comment;
import com.ledao.mapper.CommentMapper;
import com.ledao.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 客户商品评论Service实现类
 *
 * @author LeDao
 * @company
 * @create 2020-05-27 23:03
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentMapper commentMapper;

    @Override
    public List<Comment> list(Map<String, Object> map) {
        return commentMapper.list(map);
    }

    @Override
    public Long getCount(Map<String, Object> map) {
        return commentMapper.getCount(map);
    }

    @Override
    public Integer add(Comment comment) {
        return commentMapper.add(comment);
    }

    @Override
    public Integer delete(Integer id) {
        return commentMapper.delete(id);
    }

    @Override
    public Comment findById(Integer id) {
        return commentMapper.findById(id);
    }
}
