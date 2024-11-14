package com.pgm.backend1.dto;

import lombok.Data;

@Data
public class CommentDTO {
    private String content; //parentId도 이렇게 적어야 함 entity는 parentID를 못 받아서 DTO 사용
    private String writer;
    private Long parentId;
}
