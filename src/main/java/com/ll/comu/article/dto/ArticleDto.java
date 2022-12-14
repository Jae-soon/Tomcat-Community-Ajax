package com.ll.comu.article.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto {
    private long id;
    private String title;
    private String content;
}
