package com.korit.korit_gov_spring_boot_study.dto.response;

import com.korit.korit_gov_spring_boot_study.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetPostByPostIdRespDto {
    private String status;
    private String message;
    private Post data;
}
