# BeanDefinition

* 스프링은 다양한 방식으로 빈을 등록할 수 있다.(xml로도 되고)
* 이걸 지원해주는게 BeanDefinition이라는 추상화
  * XML을 읽어서 BeanDefinition 생성
  * 팩토리 메소드 방식으로 작성한거(AppConfig)에서 BeanDefinition 생성
  * 어노테이션으로 설정해둔거 (@Component)로  BeanDefinition 생성
* 따라서 스프링 컨테이너는 BeanDefinition만 알면 되므로 자바 코드인지 XML인지 아무튼 생성 방식은 몰라도 됨.
* (추가로 BeanDefinition을 직접 생성해서 컨테이너에 등록할 수도 있긴함)

### 즉, 스프링이 다양한 형태의 설정 정보를 BeanDefinition으로 추상화해서 사용한다.