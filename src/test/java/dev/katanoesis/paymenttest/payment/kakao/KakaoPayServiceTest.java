package dev.katanoesis.paymenttest.payment.kakao;

import dev.katanoesis.paymenttest.payment.kakao.dto.KakaoPayReadyRequestDto;
import dev.katanoesis.paymenttest.payment.kakao.dto.KakaoPayReadyResponseDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class KakaoPayServiceTest {

    @Autowired
    KakaoPayService service;

    @Test
    void 서비스가_주입된다() {
        assertThat(service).isNotNull();
    }

    @Test
    void 카카오키값을_가져온다() {
        String kakaoKey = service.getKakaoKey();

        // 카카오키는 length가 32임
        assertThat(kakaoKey.length()).isEqualTo(32);
    }

    @Test
    void 카카오페이_준비요청을_보낸다() {
        KakaoPayReadyRequestDto requestDto = KakaoPayReadyRequestDto.builder()
                .cid("TC0ONETIME")
                .partner_order_id("1")
                .partner_user_id("userid")
                .item_name("아이템")
                .quantity(11)
                .total_amount(12000)
                .tax_free_amount(1000)
                .green_deposit(0)
                .payment_method_type("MONEY")
                .install_month(1)
                .approval_url("https://localhost")
                .cancel_url("https://localhost")
                .fail_url("https://localhost")
                .build();

        KakaoPayReadyResponseDto responseDto = service.ready(requestDto);

        assertThat(responseDto.getTid().length()).isEqualTo(20);
    }

}