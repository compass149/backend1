package com.pgm.backend1.controller;

import com.pgm.backend1.domain.Comment;
import com.pgm.backend1.dto.CommentDTO;
import com.pgm.backend1.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/{boardId}")
    public ResponseEntity<Long> addComment(@PathVariable("boardId") Long boardId,
                                        @RequestBody CommentDTO commentDTO) {
        Comment comment=commentService.saveComment(boardId, commentDTO);
        return ResponseEntity.ok(comment.getId());
    }
    @GetMapping("/{boardId}")
    public ResponseEntity<List<Comment>> getComments(@PathVariable("boardId") Long boardId) {
        return ResponseEntity.ok(commentService.getComments(boardId));
    }
    @GetMapping("/one/{id}")
    public ResponseEntity<Comment> getComment(@PathVariable("id") Long id) {
        return ResponseEntity.ok(commentService.getComment(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteComment(@PathVariable("id") Long id) {
        commentService.deleteComment(id);
        return ResponseEntity.ok(id);
    }

}