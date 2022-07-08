package kimshop.domain.item;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // final이 붙거나 @NotNull 이 붙은 필드의 생성자를 자동 생성해주는 롬복 어노테이션
@Getter
public enum ItemSellStatus {
    // 자바 자료형
    // 1. 클래스 Class
    // 2. 인터페이스
    // 3. 열거형 enum [ 서로 연관된 필드들의 집합 구성 ]


    // 열거형 = MEMBER[0], SELLER[1], ADMIN[2]
    SELL("SELL", "판매 중"),
    SOLD_OUT("SOLD_OUT", "판매 완료");



    private final String key;
    // final은 상수 : 데이터 고정
    private final String title;
}
