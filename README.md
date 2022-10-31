# spring event

### Branch

- 이벤트 발행을 `ApplicationEventPublisher` 와 `AbstractAggregateRoot` 두 가지로 진행하고자 브랜치를 나누어 진행.

- main
  - 이벤트 적용 전 공통 사항 구현
- event/publisher
  - `ApplicationEventPublisher` 를 이용한 이벤트 구현
- event/domain
  - `AbstractAggregateRoot` 를 이용한 이벤트 구현
