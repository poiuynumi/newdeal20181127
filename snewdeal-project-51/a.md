
BoardaddCommend의 execute를 사용하려면 BoardDao의 인스턴스가 있어야함
- BoradaddCommand는 scanner와 BoardDao에 의존한다 -> Scanner, BoardDao : 의존객체
App의 작업을 Handler로 분산 -> Handler의 작업을 Dao에게 맡김 (객체 생성을 통한 작업 수행)
Handler의 작업을 분류 (add, delete, update ...)

Engine(해석 + 실행) / Parser(뭔가를 해석하는 일을 한다) / Container (생성, 소멸 관리) : 넓은 의미에서 같은 의미
Bean = instance = object . Bean Container : 인스턴스 생성 , 삭제 등 관리

Inversion Of Control 
-event listener
-DI (Dependence Injection)

DI(=IoC)사용의 장점
-의존객체의 대체가 쉽다 -> 유지보수 용이
-단위테스트가 쉽다
-가비지생성 최소화


## 51 : Spring IoC Container 도입

-객체 생성과 소멸을 Spring IoC Container에게 맡겨라