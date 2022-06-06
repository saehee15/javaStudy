# Chapter 09 java.lang 패키지와 유용한 클래스
 <blockquote>
- 실 공부일자: 2022.06.06(월)<br/>
</blockquote>
<br /><br />

## hashCode(), toString()
## hashCode() 
: 객체의 해시코드를 반환하는 메서드   
해시코드: 정수값, 해싱 알고리즘, 11장 컬렉션 프레임웍에서 더 자세히
object클래스의 hashCode()는 객체의 주소를 int로 변환해서 반환, 객체의 지문이라고또 함   
: equals()를 오버라이딩하면, hashCode()도 오버라이딩해야 한다.
(equals를 iv를 같고 오버라이딩 했을경우)    
: equals() 결과가 true인 두 객체의 해시코드는 같아야 하기 때문⭐️⭐️ 밑에 예시 참고
```java
String str1 = new String("abc");
String str2 = new String("abc");

System.out.println(str1.equals(str2)); // true
System.out.println(str1.hashCode());   // 96354
System.out.println(str2.hashCode());   // 96354
``` 

## toString()
: 객체를 문자열(String)으로 변환하기 위한 메서드 

<br/>

### soure -> Generate hashCode() and equals() 하면 자동으로 오버라이딩, toString 도 있고

<br/><br/>

## object 클래스
: 모든 클래스의 최고 조상, 오직 11개의 메서드만 가지고 있다
|object 클래스의 메서드|설명|
|--------------|-------------|
|protected Object clone()|객체 자신의 본사본을 반환한다.|
|public boolean equals(Object obj)|객체 자신과 같은 obj가 같은 객체인지 알려준다.(같으면 true)
|protected void finalize()|객체가 소멸될 때 가비지 컬렉터에 의해 자동적으로 호출된다. 이때 수행되어야 하는 코드가 있을 때 오버라이딩한다.(거의 사용안함)
|public Class getClass()|객체 자신의 클래스 정보를 담고 있는 Class인스턴스를 반환한다.
|public int hashCode()|객체 자신의 해시코드를 반환한다.
|public String toString()|객체 자신의 정보를 문자열로 반환한다.
|public void notify|객체 자신을 사용하려고 기다리는 쓰레드를 하나만 깨운다.
|public void notifyAll()|객체 자신을 사용하려고 기다리는 모든 쓰레드를 깨운다.
|public void wait() <br /> public void wait(long timeout) <br />  public void wait(logn timeout, int nanos)| 다른 쓰레드가 notify()나 notifyAll()을 호출할 때까지 현재 쓰레드를 무한히 또는 지정된 시간(timeout, nanos)동안 기다리게 한다.

## equals (Object obj)
: 객체 자신(this)와 주어진 객체(obj)를 비교한다. 같으면 true, 다르면 false
: Object클래스의 equals() 객체의 주소를 비교(참조변수 값 비교)
: 주로 인스턴스 변수(iv)의 값을 비교하도록 equals()를 오버라이딩 해야 한다.

