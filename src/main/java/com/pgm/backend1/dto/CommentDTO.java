package com.pgm.backend1.dto;

import lombok.Data;

@Data
public class CommentDTO {
    private String content;
    private String writer;
    private Long parentId;
}
