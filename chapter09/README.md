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

 <br /> <br /><br />
## equals (Object obj)
: 객체 자신(this)와 주어진 객체(obj)를 비교한다. 같으면 true, 다르면 false
: Object클래스의 equals() 객체의 주소를 비교(참조변수 값 비교)
: 주로 인스턴스 변수(iv)의 값을 비교하도록 equals()를 오버라이딩 해야 한다.

 <br /> <br />
## String 클래스
: 데이터(char[]) + 메서드(문자열 관련)
: 내용을 변경할 수 없는 불변클래스

|메서드/설명|예제|결과
|------------|-------------|---------------|
|String(String s)<br/> 주어진 문자열(s)을 갖는 String인스턴스를 생성한다.|String s = new String("Hello");| s = "Hello"
|String(char[] value)<br/>주어진 문자열(value)를 갖는 String인스턴스를 생성한다.|char[] c = {'H','e','l','l','o'};<br/>String s = new String(c);| s = "Hello"
|String(StringBuffer buf)<br/>StringBuffer인스턴스가 갖고 있는 문자열과 같은 내용의 String인스턴스를 생성한다.|StringBuffer sb = new StringBuffer("Hello");<br/>String s = new String(sb);| s = "Hello"
|char charAt(int index)<br/> 지정된 위치(index)에 있는 문자를 알려준다.(index는 0부터 시작)|String s = "Hello";<br/>String n = "0123456";<br/>char c = s.charAt(1); <br/> char c2 = n.charAt(1);| c = 'e'<br/> c2 = '1'
|int compartTo(String str)<br/>문자열(str)과 사전순서로 비교한다. 같으면 0을, 사전순으로 이전이면 음수를, 이루면 양수를 반환한다.| int i = "aaa".compareTo("aaa");<br/> int i2 = "aaa.compareTo("bbb");<br/> int i3 = "bbb".compareTo("aaa");| i = 0 <br/> i2 = -1 <br/>i3 = 1
|String concat(String str)<br/>문자열(str)을 뒤에 덧붙인다.|String s = "Hello"; <br/>String s2 = s.concat(" World");|s2="Hello World"
|boolean contains(CharSequence s)<br/>지정된 문자열(s)이 포함되었는지 검사한다.|String s = "abcefg"; <br/>boolean b = s.contains("bc");|b = true
|boolean endsWith(String suffix)<br/>지정된 문자열(suffix)로 끝나는지 검사한다.|String file = "Hello.txt"; <br/>boolean b = file.endsWith("txt");|b = true
|||