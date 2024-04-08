package kr.megaptera.backendsurvivalweek10.models;

import jakarta.persistence.Embeddable;

@Embeddable //해당 클래스가 다른 엔티티 클래스에 내장될 수 있다. 이 클래스는 별도의 엔티티가 아니다.
public class UserId extends EntityId {
    private UserId() {
        super();
    }

    public UserId(String value) {
        super(value);
    }

    public static UserId of(String value) {
        return new UserId(value);
    }
}
