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
: String처럼 문자형 배열(char[])을 내부적으로 가지고 있다.<br/>
: StringBuffer 클래스는 내부적으로 버퍼(buffer)라고 하는 독립적인 공간을 가진다.
버퍼 크기의 기본값은 16개의 문자를 저장할 수 있는 크기이며, 생성자를 통해 그 크기를 별도로 설정할 수도 있다.
하지만 인스턴스 생성 시 사용자가 설정한 크기보다 언제나 16개의 문자를 더 저장할 수 있도록 여유 있는 크기로 생성된다. <br/>
: String과 달리 내용을 변경할 수 있다.(mutable 가변) <br/>
: StringBuffer는 equals()가 오버라이딩 되어있지 않다. (즉 주소비교함) <br/>
-> 그래서 StringBuffer를 String으로 변환 후에 equals()로 비교해야 함 <br/>

```java
StringBuffer sb = new StringBuffer("abc");
StringBuffer sb2 = new StringBuffer("abc");

System.out.println(sb == sb2);  // false
System.out.println(sb.equals(sb2)); // false
```

## StringBuffer의 생성자와 메서드
|메서드/설명|예제|결과
|------------|-------------|---------------|
|StringBuffer()<br/>16문자를 담을 수 있는 버퍼를 가진 StringBuffer 인스턴스를 생성한다.|StringBuffer sb = new StringBuffer();|sb = ""
|StringBuffer(int length)<br/>지정된 개수의 문자를 담을 수 있는 버퍼를 가진 StringBuffer인스턴스를 생성한다.|StringBuffer sb = new StringBuffer(10);|sb = ""
|StringBuffer(String str)<br/>지정된 문자열 값(str)을 갖는 StringBuffer 인스턴스를 생성한다.|StringBuffer sb = "new StringBuffer("Hi");|sb = "Hi"
|StringBuffer append(boolean b)<br/>StringBuffer append(char c)<br/>StringBuffer append(char[] str)<br/>StringBuffer append(double d)<br/>StringBuffer append(float f)<br/>StringBuffer append(int i)<br/>StringBuffer append(long l)<br/>StringBuffer append(Object obj)<br/>StringBuffer append(String str)<br/>매개변수로 입력된 값을 문자열로 변환하여 StringBuffer인스턴스가 저장하고 있는 문자열의 뒤에 덧붙인다.|StringBuffer sb = new StringBuffer("abc");<br/>StringBuffer sb2 = sb.append(true);<br/>sb.append('d').append(10.0f);<br/><br/>StringBuffer sb3 = sb.append("ABC").append(123);|sb = "abctrued10.0ABC123" <br/> sb2 = "abctrued10.0ABC123" <br/> sb3 = "abctrued10.0ABC123" 
|int capacity()<br/>StringBuffer인스턴스의 버퍼크기를 알려준다. length()는 버퍼에 담긴 문자열의 길이를 알려준다.|StringBuffer sb = new StringBuffer(100);<br/>sb.append("abcd");<br/>int bufferSize = sb.capacity();<br/>int stringSize = sb.length();|bufferSize = 100 <br/> stringSize = 4 (sb에 담긴 문자열이 "abcd이므로")
|char charAt(int index)<br/>지정된 위치(index)에 있는 문자를 반환한다.|StringBuffer sb = new StringBuffer("abc"); <br/> char c = sb.charAt(2);| c = 'c'
|StringBuffer delete(int start, int end)<br/>시작위치(start)부터 끝 위치(end) 사이에 있는 문자를 제거한다. 단, 끝 위치의 문자는 제외|StringBuffer sb = new StringBuffer("0123456"); <br/> StringBuffer sb2 = sb.delete(3,6)|sb = "0126" <br/> sb2 = "0126" 
|StringBuffer deleteCharAt(int index)<br/>지정된 위치(index)의 문자를 제거한다.|StringBuffer sb = new StringBuffer("0123456"); <br/>sb.deleteCharAt(3);|sb = "012456"
|StringBuffer insert(int pos, boolean b)<br/>StringBuffer insert(int pos, char c)<br/>StringBuffer insert(int pos, char[] str)<br/>StringBuffer insert(int pos, double d)<br/>StringBuffer insert(int pos, float f)<br/>StringBuffer insert(int pos, int i)<br/>StringBuffer insert(int pos, long l)<br/>StringBuffer insert(int pos, Object obj)<br/>StringBuffer insert(int pos, String str)<br/>두 번째 매개변수로 받은 값을 문자열로 반환하여 지정된(pos)에 추가한다. pos는 0부터 시작<br/>|StringBuffer sb = newStringBuffer("0123456");<br/>sb.insert(4,'.');|sb = "0123.456"
|int length()<br/>StringBuffer인스턴스에 저장되어 있는 문자열의 길이를 반환한다.|StringBuffer sb = newStringBuffer("0123456");<br/>int length = sb.length();|length = 7
|StringBuffer replace(int start, int end, String str)<br/>지정된 범위(start~end)의 문자들을 주어진 문자열로 바꾼다. end위치의 문자는 범위에 포함되지 않음(start <= x < end)|StringBuffer sb = newStringBuffer("0123456");<br/>sb.replace(3,6,"AB");|sb = "012AB6" "345"가 "AB"로 바뀌었다.
|StringBuffer reverse()<br/>StringBuffer인스턴스에 저장되어 있는 문자열의 순서를 거꾸로 나열한다.|StringBuffer sb = new StringBuffer("0123456");<br/>sb.reverse();|sb = "6543210"
|void setCharAt(int index, char ch)<br/>지정된 위치의 문자를 주어진 문자(ch)로 바꾼다.|StringBuffer sb = new StringBuffer("0123456");<br/>sb.setCharAt(5,'o');|sb = "01234o6"
|void setLength(int newLength)<br/>지정된 길이로 문자열의 길이를 변경한다. 길이를 늘리는 경우에 나머지 빈 공간을 널문자 '\u0000'로 채운다.|StringBuffer sb = newStringBuffer("0123456"); <br/>sb.setLength(5);<br/><br/>StringBuffer sb2 = new StringBuffer("0123456");<br/>sb2.setLength(10);<br/>String str = sb2.toString().trim();|sb = "01234" <br/> sb2 = "0123456   " <br/>str = "0123456"
|String toString()<br/>StringBuffer인스턴스의 문자열을 String으로 반환|StirngBuffer sb = new StringBuffer("0123456");<br/>Stirng str = sb.toString();|str = "0123456"
|String substring(int start)<br/> String substring(int start, int end)<br/>지정된 범위 내의 문자열을 String으로 뽑아서 반환한다. 시작위치(start)만 지정하면 시작위치부터 문자열 끝까지 뽑아서 반환한다.|StringBuffer sb = new StringBuffer("0123456");<br/>String str = sb.substring(3);<br/>String str2 = sb.substring(3,5);|str = "3456"<br/>str2 = "34"

<br/><br/>
## StringBuilder 
: StringBuffer는 동기화 되어있다. 멀티 쓰레드에 안전,
: StringBuilder는 동기화 X
: 멀티 쓰레드 프로그램이 아닌 경우, 동기화는 불필요한 성능저하, 이럴 땐 StringBuffer 대신 StringBuilder를 사용하면 성능 향상

```java
StringBuffer ab;
ab = new StringBuffer();
ab.append("abc");

StringBuilder ab;
ab = new StringBuilder();
ab.append("abc");
```
<br/><br/>
## Math클래스 메서드
math클래스는 익숙하니까 몰랐던 것만 적을래
|메서드/설명|예제|결과
|------------|-------------|---------------|
|static double rint(double a)<br/>주어진 double값과 가장 가까운 정수값을 double형으로 반환한다. 단 두 정수의 정가운데 있는 값(1.5,2.5,3.5 등)은 짝수를 반환|double d = Math.rint(1.2);<br/>double d = Math.rint(2.6);<br/>double d = Math.rint(3.5);<br/>double d = Math.rint(4.5);<br/>| d = 1.0 <br /> d2 = 3.0 <br />d3 = 4.0 <br />d4 = 4.0 <br />

반올림에도 종류가 여러개!! rint라는 애도 있음

## 래퍼(wrapper) 클래스
: 기본형 값을 감싸는 클래스, 8개의 기본형을 객체로 다뤄야할 떄 사용하는 클래스

객체지향 언어에서는 모든것이 객체여야함 근디 자바는 기본형 존재, 그래서 자바는 90퍼쯤 객체지향언어, 완전히는 아님, 왜 모든것이 객체가 아니냐 하면 성능 때문에 그런데 


## Number 클래스
: 모든 숫자 래퍼 클래스의 조상
래퍼 객체 -> 기본형
```java
int i = new Integer(100).intValue();
```
문자열 -> 기본형
```java
int i = Integer.parseInt("100");
```
문자열 -> 래퍼클래스
```java
Integer i = Integer.valueOf("100");
```

## 오토박싱 & 언박싱
int -> integer 오토박싱
integer -> int 언박싱

-JDK1.5 이전에는 기본형과 참조형간의 연산이 불가능
```java
int i = 5;
Integer iObj = new Integer(7);

int sum = i + iObj; 
// JDK1.5 이전에는 에러, 기본형과 참조형 연산 불가능, JDK1.5이 후 가능

// 컴파일 전에는 
int i = 5;
Integer iObj = new Integer(7);

int sum = i + iObj; 

// 이랬던 코드가 컴파일 후에는
int i = 5;
Integer iObj = new Integer(7);

int sum = i + iObj.intValue();
// 이렇게 바뀌면서 연산 가능 
```
기본형의 값을 객체로 자동변환하는 것을 오토박싱, 그 반대는 언박싱





<br/><br/><br/>

## 느낀점
- concat은 js나 java에서나 원데이터는 변함이 없네 <br/>
- StringBuffer 의 delete는 원데이터도 변하네 <br/>
- 왜왜 String타입은 delete가 없는가, 
내가 String타입 특징을 이해못하는건가
밑에 String을 StringBuffer처럼 몇번째에서 몇번째까지 지우고 싶은데, 메소드를 못찾겠음 그나마 비슷한게 replace는 index가 아니고, "3" 대신 빈공간, 원데이터 변화없음, substring은 몇번째 부터 몇번째를 반환(index), replace나 substring은 String이나 StringBuffer 타입이나 다 있는데.. 음
```java
StringBuffer sb1 = new StringBuffer("0123456");
StringBuffer sb2 = sb1.delete(3,6);
System.out.println(sb1); // 0126
System.out.println(sb2); // 0126
	    
String sb3 = "0123456";
String sb4 = sb3.replace("3", "");
System.out.println(sb3); // 0123456
System.out.println(sb4); // 012456

String sb5 = "0123456";
String sb6 = sb5.substring(3,6);
System.out.println(sb5); //0123456
System.out.println(sb6); //345 
```
