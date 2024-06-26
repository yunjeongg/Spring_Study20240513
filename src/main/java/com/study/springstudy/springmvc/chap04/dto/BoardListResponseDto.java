package com.study.springstudy.springmvc.chap04.dto;

import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// 서버에서 조회한 데이터 중 화면에 필요한 데이터만 모아놓은 클래스
@Getter
public class BoardListResponseDto {

    /*
        {
            shortTitle: "",

        }
     */

    private int bno; // 원본 게시물 번호
    private String shortTitle; // 5글자 이상 줄임 처리된 제목
    private String shortContent; // 30자 이상 줄임 처리된 글 내용
    private String date; // 포맷팅된 날짜문자열
    private int view; // 조회 수
    private boolean hit; // HIT 게시물(조회수5 이상)인가? 여부
    private boolean newArticle; // 새 게시물(1시간 이내)인가?
    private int replyCount; //
    private String account; // 게시물의 글쓴이 계정


    // 엔터티를 DTO로 변환하는 생성자
    public BoardListResponseDto(BoardFindAllDto b) {
        this.bno = (int)b.getBoardNo();
        this.shortTitle = makeShortTitle(b.getTitle());
        this.shortContent = makeShortContent(b.getContent());
        this.date = dateFormatting(b.getRegDateTime());
        this.view = b.getViewCount();
        this.hit = this.view > 5;
        this.newArticle = LocalDateTime.now().isBefore(b.getRegDateTime().plusHours(5));
        // 현재시간이 게시물등록 후 5분보다 이전인가?
        this.replyCount = b.getReplyCount();
        this.account = b.getAccount();
    }

    private String dateFormatting(LocalDateTime regDateTime) {
        DateTimeFormatter pattern
                = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return pattern.format(regDateTime);
    }

    private String makeShortContent(String content) {
        return (content.length() > 30)
                ? content.substring(0, 30) + "..."
                : content;
    }

    private String makeShortTitle(String title) {
        return (title.length() > 5)
                ? title.substring(0, 5) + "..."
                : title;
    }

}
