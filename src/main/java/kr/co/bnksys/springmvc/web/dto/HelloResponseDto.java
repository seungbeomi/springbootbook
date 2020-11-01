package kr.co.bnksys.springmvc.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
public class HelloResponseDto {

    private String name;
    private int amount;

}
