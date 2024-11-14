package com.pgm.backend1.service;

import com.pgm.backend1.domain.Board;
import com.pgm.backend1.domain.Comment;
import com.pgm.backend1.dto.CommentDTO;
import com.pgm.backend1.repository.BoardRepository;
import com.pgm.backend1.repository.CommentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{
    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    @Override
    public Comment saveComment(Long boardId, CommentDTO commentDTO) {
        Board board = boardRepository.findById(boardId).orElseThrow();
        Comment comment = Comment.builder()
                .board(board)
                .content(commentDTO.getContent())
                .writer(commentDTO.getWriter())
                .build();
        if(commentDTO.getParentId() != null) {
            Comment parent = commentRepository.findById(commentDTO.getParentId()).orElseThrow();
            comment.setParent(parent);
        }
      //  board.setCommentCount(board.getCommentCount() + 1); postman 오류나서 이거 주석처리함. getCommentCount여기에 null 리턴
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> getComments(Long boardId) {
        Board board = boardRepository.findById(boardId).orElseThrow();
        return commentRepository.findByBoardAndParentIsNull(board);
    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public Comment getComment(Long id) {
        return commentRepository.findById(id).orElseThrow();
    }
}
