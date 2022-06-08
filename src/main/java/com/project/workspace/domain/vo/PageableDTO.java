package com.project.workspace.domain.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;

@Getter
@Setter
@NoArgsConstructor
@Slf4j
public class PageableDTO {

    private int startPage;
    private int endPage;
    private int realEnd;
    private int pageNumber;
    private int next,previous;
    private boolean hasPrev, hasNext;
    private int amount;
    private int total;
    private int pageCount;
    private Pageable pageable;


    public PageableDTO(Pageable pageable, int total) {
        this( pageable,total, 10,10);
    }

    public PageableDTO(Pageable pageable, int total, int pageCount,int amount){
        this.previous = pageable.previousOrFirst().getPageNumber();
        this.next  = pageable.next().getPageNumber();
        this.pageNumber = pageable.getPageNumber()+1;
        this.total = total;
        this.pageCount = pageCount;
        this.endPage =   (int)(Math.ceil(pageNumber / 10.0)) * pageCount;
        this.startPage = endPage - pageCount + 1;
        /* realEnd 구하기 */
        this.realEnd = (int)Math.ceil(total /(double) amount);
        /* endPage와 비교 */
        //        endPage = endPage > realEnd ? realEnd : endPage;

        if(this.endPage > realEnd){
            this.endPage = this.realEnd == 0 ? 1 :this.realEnd;
        }

        /* hasPrev, next 구하기 */

        this.hasPrev = this.startPage > 1;
        // 이전 버튼 생성 여부 = 시작 페이지 번호가 1과 같으면 false, 아니면 true
        this.hasNext = this.endPage < this.realEnd;
        // 다음 버튼 생성 여부 = 끝 페이지 번호 * 한 페이지당 보여줄 게시글의 개수가 총 게시글의 수보다
        // 크거나 같으면 false, 아니면 true
    }
}