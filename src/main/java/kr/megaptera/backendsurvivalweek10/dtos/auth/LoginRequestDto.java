package kr.megaptera.backendsurvivalweek10.dtos.auth;

public record LoginRequestDto( //레코드는 데이터의 불변성을 보장하고, 간단한 데이터 구조를 나타내기 위해 사용.
        String username,
        String password
) {
}
