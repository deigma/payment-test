package dev.katanoesis.paymenttest.payment.kakao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.katanoesis.paymenttest.DtoToMultiValueMapConverter;
import dev.katanoesis.paymenttest.payment.kakao.dto.KakaoPayReadyRequestDto;
import dev.katanoesis.paymenttest.payment.kakao.dto.KakaoPayReadyResponseDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
@RequiredArgsConstructor
@Getter // 테스트용
public class KakaoPayService {

    private final ObjectMapper objectMapper;

    @Value("${kakaoKey}")
    private String kakaoKey;

    public KakaoPayReadyResponseDto ready(final KakaoPayReadyRequestDto requestDto) {
        MultiValueMap<String, String> convertedRequestDto = DtoToMultiValueMapConverter.convert(objectMapper, requestDto);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(convertedRequestDto, getHeaders());

        RestTemplate restTemplate = new RestTemplate();

        String url = "https://kapi.kakao.com/v1/payment/ready";

        Map<String, String> map = restTemplate.postForObject(url, request, Map.class);

        KakaoPayReadyResponseDto responseDto = KakaoPayReadyResponseDto.builder()
                .tid(map.get("tid"))
                .next_redirect_pc_url(map.get("next_redirect_pc_url"))
                .build();

        return responseDto;
    }


    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();

        headers.add("Authorization", "KakaoAK " + kakaoKey);
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        return headers;
    }

}
