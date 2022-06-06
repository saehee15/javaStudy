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
