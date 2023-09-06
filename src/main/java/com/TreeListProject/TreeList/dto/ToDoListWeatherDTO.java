package com.TreeListProject.TreeList.dto;

public class ToDoListWeatherDTO {
    private Long id;
    private String region; // 지역
    private Double temp; // 온도
    private Double rainAmount; // 강수량
    private Double humid; // 습도
    private String lastUpdateTime; // 마지막 갱신 시각 (시간 단위)
}
