package com.project.myapp.VO;

import lombok.Data;

@Data
public class PageInfoVO {
   
    private int page; // 현재 페이지
    private int maxPage; // 총 페이지
    private int startPage; // 시작 페이지
    private int endPage; // 마지막 페이지
    private int listCount; // 게시글수
}
 