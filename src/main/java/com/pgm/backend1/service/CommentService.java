package com.pgm.backend1.service;



import com.pgm.backend1.domain.Comment;
import com.pgm.backend1.dto.CommentDTO;

import java.util.List;

public interface CommentService {
    Comment saveComment(Long boardId, CommentDTO commentDTO);

    List<Comment> getComments(Long boardId);
    public void deleteComment(Long id);
    Comment getComment(Long id);
}
