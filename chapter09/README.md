# Chapter 09 java.lang 패키지와 유용한 클래스
 <blockquote>
- 실 공부일자: 2022.06.06(월)~<br/>
</blockquote>
<br /><br />

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
|boolean equals(Object obj)<br/>매개변수로 받은 문자열(obj)과 String인스턴스의 문자열을 비교한다. obj가 String이 아니거나 문자열이 다르면 false를 반환한다.|String s = "Hello"; <br/> boolean b = s.equals("Hello"); <br/> boolean b2 = s.equals("hello");| b = true <br /> b2 = false
|boolean equalsIgnoreCase(String str)<br/>문자열과 String 인스턴스의 문자열을 대소문자 구분없이 비교한다.|String s = "Hello";<br/>boolean b = s.equalsIgnoreCase("HELLO");<br/>boolean b2 = s.equalsIgnoreCase("heLLo");| b = true <br/> b2 = true
|int indexOf(int ch)<br/>주여진 문자(ch)가 문자열에 존재하는지 확인하여 위치(index)를 알려준다. 못 찾으면 -1을 반환한다(index는 0부터 시작)|String s = "Hello"; <br/>int idx1 = s.indexOf('o');<br/> int idx2 = s.indexOf('k')|idx1 = 4 <br/>idx2 = -1
|int indexOf(int ch, int pos)<br/>주어진 문자(ch)가 문자열에 존재하는지 지정된 위치(pos)로부터 확인하여 위치(index)를 알려준다. 못 찾으면 -1을 반환한다. (index는 0부터 시작)|String s = "Hello"; <br/>int idx1 = s.indexOf('e',0);<br/>int idx2 = s.indexOf('e',2);| idx1 = 1 <br/> idx2 = -1
|int indexOf(String str)<br/>주어진 문자열이 존재하는지 확인하여 그 위치(index)를 알려준다. 없으면 -1을 반환한다.(index는 0부터 시작)|String s = "ABCDEFG"; <br/> int idx = s.indexOf("CD");|idx = 2
|int lastIndexOf(int ch)<br/>지정된 문자 또는 문자코드를 문자열의 오른쪽에서부터 찾아서 위치(index)를 알려준다. 못 찾으면 -1을 반환한다.|String s = "java.lang.Object";<br/>int idx1 = s.lastIndexOf('.');<br/>int idx2 = s.indexOf('.');|idx1 = 9<br/>idx2 = 4
|int lastIndexOf(String str)<br/>지정된 문자열을 인스턴스의 문자열 끝에서 부터 찾아서 위치(index)를 알려준다. 못 찾으면 -1을 반환한다.|String s = "java.lang.java";<br/>int idx1 = s.lastIndexOf("java");<br/>int idx2 = s.indexOf("java");|idx = 10<br/>idx = 0
|int length()<br/>문자열의 길이를 알려준다.|String s = "Hello";<br/> int length = s.length();|length = 5
|String[] split(String regex)<br/>문자열을 지정된 분리자(regex)로 나누어 문자열 배열에 담아 반환한다.|String animals = "dog,cat,bear";<br/>String[] arr = animals.split(",");|arr[0] = "dog" <br/> arr[1] = "cat" <br/>arr[2] = "bear"
|String[] split(String regex, int limit)<br/>문자열을 지정된 분리자(regex)로 나누어 문자열배열에 담아 반환한다. 단, 문자열 전체를 지정된 수(limit)로 자른다.|String animals = "dog, cat, bear";<br/>String[]arr = animals.split(",",2);|arr[0] = "dog"<br/>arr[1]="cat, bear"
|boolean startsWith(String prefix)<br/>주어진 문자열(prefix)로 시작하는지 검사한다.|String s = "java.lang.Object"; <br/> boolean b = s.startsWith("java");<br/>boolean b2 = s.startsWith("lang");|b = true<br/>b2 = false
|String substring(int begin)<br/>String substring(int begin, int end)<br/>주어진 시작위치(begin)로부터 끝 위치(end)범위에 포함된 문자열을 얻는다. 이 때 시작위치의 문자는 범위에 포함되지만, 끝 위치의 문자는 포함되지 않는다(begin <= x < end)|String s = "java.lang.Object";<br/> String c = s.substring(10); <br/>String p = s.substring(5,9);| c = "Object" <br/> p = "lang"
|String toLowerCase()<br/>String인스턴스에 저장되어있는 모든 문자열을 소문자로 변환하여 반환한다.|String s = "Hello"; <br/> String s1 = s.toLowerCase();| s1 = "hello"
|String toUpperCase()<br/>String인스턴스에 저장되어있는 모든 문자열을 대문자로 변환하여 반환한다.|String s = "Hello"; <br/> String s1 = s.toUpperCase();| s1 = "HELLO"
|String trim()<br/>문자열의 왼쪽 끝과 오른쪽 끝에 있는 공백을 없앤 결과를 반환한다. 이 때 문자열 중간에 있는 공백은 제거되지 않는다.|String s = "   Hello World ";<br/>String s1 = s.trim();|s1="Hello World" <br/> 문자열은 내용 바꿀수 없으니 새로운 문자열이 만들어진거임
|static String valueOf(boolean b)<br/>static String valueOf(char c)<br/> static String valueOf(int i)<br/> static String valueOf(long l)<br/> static String valueOf(float f)<br/> static String valueOf(double d)<br/> static String valueOf(Object o)<br/> 지정된 값을 문자열로 변환하여 반환한다. 참조변수의 경우, toString()을 호출한 결과를 반환한다.|String b = String.valueOf(true);<br/>String c = String.valueOf('a');<br/>String i = String.valueOf(100)<br/>String l = String.valueOf(100L);<br/>String f = String.valueOf(10f);<br/>String d = String.valueOf(10.0);<br/>java.util.Data dd = new java.util.Date(); <br/> String date = String.valueOf(dd);|b = "true"<br/>c = 'a'<br/>i = "100"<br/>l = "100"<br/>f = "10.0"<br/>d = "10.0"<br/>data = "Wed Jan 27 21:26:29 KST 2016"

<br/><br/>

## join()과 StringJoiner
: join()은 여러 문자열 사이에 구분자를 넣어서 결합한다.
```java
String animals = "dog,cat,bear";
String[] arr = animals.split(","); // 문자열을 ','를 구분자로 나눠서 배열에 저장
String str = String.join("-", arr); // 배열의 문자열을 '-'로 구분해서 결합
System.out.println(str); // dog-cat-bear

```

<br/><br/>

## 문자열과 기본형 간의 변환
숫자를 문자열로 바꾸는 방법
```java
int i = 100;
String str1 = i + ""; // 100을 "100"으로 변환하는 방법1, ""(빈문자열) 더하기
String str2 = String.valueOf(i); // 100을 "100"으로 변환하는 방법2
```
문자열을 숫자로 바꾸는 방법
```java
int i = Integer.parseInt("100"); // "100"을 100으로 변환하는 방법1
int i2 = Integer.valueOf("100"); // "100"을 100으로 변환하는 방법2
Integer i2 = Integer.valueOf("100"); // 원래는 반환 타입이 Integer
```

<br/><br/>
## StringBuffer클래스
: String처럼 문자형 배열(char[])을 내부적으로 가지고 있다.
: 그러나 String과 달리 내용을 변경할 수 있다.(mutable 가변)
: StringBuffer는 equals()가 오버라이딩 되어있지 않다. (즉 주소비교함)
-> 그래서 StringBuffer를 String으로 변환 후에 equals()로 비교해야 함

```java
StringBuffer sb = new StringBuffer("abc");
StringBuffer sb2 = new StringBuffer("abc");

System.out.println(sb == sb2);  // false
System.out.println(sb.equals(sb2)); // false
```
