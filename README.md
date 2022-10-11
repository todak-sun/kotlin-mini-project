# KOTLIN MINI PROJECT

---

## 사다리 게임 (Ladder Game)

### 요구사항

1. 용어의 정리
   1. 사다리의 다리는 "Leg"로 칭한다.
   2. 사다리의 단계(열)은 "Rung" 으로 칭한다.
   3. 사다리의 목적지는 "Destination"이라 칭한다.
   4. 사다리 게임의 참여자는 "Participant"이라 칭한다.

2. Participant를 입력할 수 있다.
   1. 인원은 최소 2명, 최대 100명이다.
   2. Participant의 수 만큼 Leg가 생성된다.
   3. 입력의 순서가 곧 Leg의 순서다.

3. Rung
   1. 3 이상 20 이하로 사용자가 설정할 수 있다.
   2. 사용자가 단계수를 지정하지 않는다면, 랜덤한 개수의 단계가 설정된다.
   3. 연속된 Leg는 동일한 Rung을 가질 수 없다.

4. Destination
   1. 최대 입력 가능한 Destination의 수는 Participant와 같아야 한다.
   2. Destination의 수는 Participant보다 많을 수 없다.
   3. Destination의 수가 Participant보다 작다면, 그 차이만큼 "NONE" 이란 상태값을 가진 Destination이 자동으로 추가된다.

5. 게임의 등록
   1. 사다리 게임을 등록할 때는 Participant의 목록, Destination의 목록이 필수로 필요하며, Rung의 개수는 옵션이다.
   2. 사다리 게임이 성공적으로 등록된다면, 사다리 게임의 결과를 조회할 수 있는 ID를 리턴한다.
   3. 사다리 게임이 등록되지 않는다면, 예외가 발생하며, 예외 안에는 사용자가 정상적인 입력을 할 수 있도록 돕는 안내 메시지가 포함되어야 한다.

6. 게임 결과의 확인
   1. 등록된 사다리 게임의 ID를 가지고 조회시, 결과를 확인할 수 있다.
   2. 결과에는 다음이 포함되어야 한다
      - Participant의 이동 경로
      - Participant의 Destination
   3. 같은 ID로 조회시 조회 결과는 항상 같아야만 한다.

---
