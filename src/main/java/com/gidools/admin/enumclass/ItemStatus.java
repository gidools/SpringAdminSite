package com.gidools.admin.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ItemStatus {

    REGISTERED(0, "등록", "사용자 등록 상태"),
    UNREGISTERED(1, "해지", "사용자 해지 상태"),
    WAITING(0, "대기중", "상품 대기 상태");

    private final Integer id;
    private final String title;
    private final String description;

}
