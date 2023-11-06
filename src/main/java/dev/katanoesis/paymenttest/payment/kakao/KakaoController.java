package dev.katanoesis.paymenttest.payment.kakao;

import dev.katanoesis.paymenttest.payment.kakao.dto.KakaoPayReadyRequestDto;
import dev.katanoesis.paymenttest.payment.kakao.dto.KakaoPayReadyResponseDto;
import dev.katanoesis.paymenttest.payment.kakao.dto.KakaoPayRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/kakao")
public class KakaoController {

    private final KakaoPayService service;

    @GetMapping("/ready")
    public KakaoPayReadyResponseDto ready(KakaoPayRequestDto dto) {
        String cid = "TC0ONETIME";
        String partnerOrderId = "1";
        String partnerUserId = "Test123";
        String itemName = dto.getItem_name();
        Integer quantity = 1; // 고정 (기프티콘 하나씩 거래)
        Integer totalAmount = dto.getTotal_amount();

        String approvalUrl = "https://localhost";
        String cancelUrl = "https://localhost";
        String failUrl = "https://localhost";

        String paymentMethodType = "MONEY";
        Integer installMonth = 1;

        Integer taxFreeAmount = 0;


        KakaoPayReadyRequestDto requestDto = KakaoPayReadyRequestDto.builder()
                .cid(cid)
                .partner_order_id(partnerOrderId)
                .partner_user_id(partnerUserId)
                .item_name(itemName)
                .quantity(quantity)
                .total_amount(totalAmount)
                .tax_free_amount(taxFreeAmount)
                .approval_url(approvalUrl)
                .cancel_url(cancelUrl)
                .fail_url(failUrl)
                .payment_method_type(paymentMethodType)
                .install_month(installMonth)
                .build();

        return service.ready(requestDto);
    }

}
