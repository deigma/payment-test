package dev.katanoesis.paymenttest.payment.kakao.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * html로부터 요청을 받는 DTO
 */
@Getter
@AllArgsConstructor
@Builder
public class KakaoPayRequestDto {

    private String item_name;
    private Integer total_amount;

}
