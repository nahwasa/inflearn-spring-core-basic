# 싱글톤 관련 내용

## 싱글톤 패턴
* TPS(Transaction Per Second)가 5만이고, AppConfig을 스프링 컨테이너 없이 그냥 쓴다면 초당 5만개의 객체가 생성될 것임. -> 비효율적
* 그렇다고 직접 싱글톤을 적용한다면?
  * 구현하는 코드 자체가 많이 들어감
  * 싱글톤에서 instance 얻으려면 구체클래스에 의존해야 하므로 DIP 위반이고 OCP도 위반 가능성 높음
  * 테스트 어려움
  * 내부 속성을 변경하거나 초기화 하기 어려움
  * private 생성자를 사용하므로 자식 클래스 생성 불가능 -> 확장성 떨어짐

## 스프링 컨테이너(싱글톤 컨테이너)
* 기본적으로 객체 인스턴스를 싱글톤으로 관리함
* 싱글톤 레지스트리 : 싱글톤 객체를 생성하고 관리하는 기능
* 싱글턴 패턴의 모든단점을 해결하면서 객체를 싱글톤으로 유지 가능
  * 싱글톤 패턴을 위한 추가 코드가 안들어가도 됨
  * DIP, OCP, 테스트, private 생성자로부터 자유롭게 싱글톤으로 사용 가능.
* 요청할 때 마다 새로운 객체를 생성해서 반환하는 기능도 제공함.

## 싱글톤 주의점
* stateless 여야함
  * 필요하다면 필드 대신에 자바에서 공유되지 않는 지역변수, 파라미터, ThreadLocal 등을 사용해야함

## @Configuration과 바이트코드
* 스프링 컨테이너는 싱글톤 레지스트리
* AppConfig 처럼 new ~ 이런식으로 작성되어 있는 자바 코드라도 싱글톤으로 등록될 수 있어야 함.
  * 예를들어 memberService()와 orderService()에서 각각 new MemoryMemberRepository() 를 호출하지만, MemoryMemberRepository는 하나만 생성되어야 함.
* AppConfig 처럼 @Configuration을 붙일 경우 스프링이 CGLIB라는 바이트코드 조작 라이브러리를 써서 AppConfig 클래스를 상속받은 임의의 다른 클래스를 만들고, 그 다른 클래스를 스프링 빈으로 등록한 것임.
  * ConfigurationSingletonTest 테스트 출력 : "bean.getClass() = class com.nahwasa.study.inflearnspringcorebasic.AppConfig$$SpringCGLIB$$0"
  * 이런식으로 싱글톤이 보장되도록 처리됨.
  * 또, AppConfig@CGLIB는 AppConfig의 자식이므로 ConfigurationSingletonTest에서 부모를 조회 시 자식은 전부 끌려나오므로 조회 가능.
  * @Configuration 없이 @Bean만 있다면, 혹은 @Component -> 싱글톤으로 동작 안함!
* 스프링 설정정보엔 항상 @Configuration을 넣어주자.
