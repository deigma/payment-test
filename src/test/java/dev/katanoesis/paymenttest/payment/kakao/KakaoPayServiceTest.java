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

}