# Chapter 12 지네릭스, 열거형, 애너테이션

## 지네릭스(Generics)란?
-컴파일시 타입을 체크해주는 기능(compile-time type check)-JDK1.5
```java
ArrayList<Object> list = new ArrayList<Object>();
```
* Object 대신 String을 쓰면, String만 들어올수 있음 

<br/>

-객체의 타입 안정성을 높이고, 형변환의 번거로움을 줄여줌

## 타입변수
-클래스를 작성할때, Object타입 대신 타입 변수(E)를 선언해서 사용
-객체를 생성시, 타입 변수(E) 대신 실제 타입(Tv)을 지정(대입)
```java
// 타입 변수 E 대신에 실제 타입 Tv를 대입
ArrayList<TV> tvlist = new ArrayList<TV>();
```
-타입 변수 대신 실제 타입이 지정되면, 형변환 생략 가능

<br/><br/>

## 지네릭스 용어
```
Box<T> 지네릭 클래스, 'T의 Box' 또는 'T Box'라고 읽는다.
T 타입 변수 또는 타입 매개변수(T는 타입 문자)
Box 원시 타입(raq type)
대입된 타입
```


## 지네릭 타입과 다형성

-참조 변수와 생성자의 대입된 타입은 일치해야 한다.
```java
ArrayList<Tv>         list = new ArrayList<Tv>();  // OK, 일치
ArrayList<Product> list = new ArrayList<Tv>(); // 에러, 불일치
```

<br/>
-지네릭 클래스간의 다형성은 성립(여전히 대입된 타입은 일치해야)

```java
List<Tv> list = new ArrayList<Tv>();  // OK. 다향성. ArrayList가 List를 구현
List<Tv> list = new LinkedList<Tv>(); // OK. 다향성. LinkedList가 List를 구현
```
 
<br/>

-매개변수의 다형성도 성립
```java
ArrayList<Product> list = new ArrayList<Product>(); 
list.add(new Product());
list.add(new Tv());  // OK. Product의 자손도 OK
list.add(new Audio());  // OK. Product의 자손도 OK
```

*But 꺼낼때는 형변환 해줘야함
```java
Product p = list.get(0);
Tv t = (Tv)list.get(1);
```
 

<br/><br/>

 
## Iterator<E>
-클래스를 작성할때, Object타입 대신 T와 같은 타입 변수를 사용

<br/>
 
## HashMap<K,V>
-여러 개의 타입 변수가 필요한 경우, 콤마(,)를 구분자로 선언
-key, value가 타입이 다를수 있으니 타입 2개

<br/>

## 제한된 지네릭 클래스, 지네릭스의 제약
-extends로 대입할 수 있는 타입을 제한

```java
class FruitBox<T extends Fruit>{   //Fruit의 자손만 타입으로 지정가능
       ArrayList<T> list = new ArrayList<T>();
}

FruitBox<Apple> appleBox = new FruitBox<Apple>(); // OK.
FruitBox<Toy>     toyBox = new FruitBox<Toy>(); // 에러. Toy는 Fruit의 자손이 아님

```

-인터페이스인 경우에도 extends를 사용(implements를 사용할것 같지만 아니고)
```java
interface Eatable{}
class FruitBox<T extends Eatable>{...}
```
 

## 지네릭스의 제약
- 타입 변수에 대입은 인스턴스 별로 다르게 가능<br/>
따라서, static멤버(모든 인스턴스에 공통)에 타입 변수 사용 가늘
- 객체,배열 생성할때 타입 변수 사용부락, 타입 변수로 배열 선언은 가능
new연산자 다음 바로 T 불가 

<br/><br/>

## 와일드 카드 <?>
-하나의 참조 변수로 대입된 타입이 다른 객체를 참조 가능
```
<? extends T> 와일드 카드의 상한 제한. T와 그 자손들만 가능
<? super T> 와일드 카드의 하한 제한. T와 그 조상들만 가능
<?> 제한 없음. 모든 타입이 가능 <? extends Object>와 동일
```

-메서드의 매개변수에 와일드 카드를 사용

<br/>

## 지네릭 메서드
-지네릭 타입이 선언된 메서드(타입 변수는 메서드 내에서만 유효)
-클래스의 타입 매개변수<T>와 메서드의 타입 매개변수<T>는 별개
-메서드를 호출할때마다 타입을 대입해야(대부분 생략 가능)
-메서드를 호출할때 타입을 생략하지 않을때는 클래스 이름 생략 불가

-와일드 카드는 하나의 참조변수로 서로 다른 타입이 대입된 여러 지네릭 객체를 다루기 위한 것
-지네릭 메서드는 메서드를 호출할때마다 다른 지네릭 타입을 대입할 수 있게 한것

<br/><br/>


## 열거형(enum)
-관련된 상수들을 같이 묶어놓은거, 자바는 타입에 안전한 열거형을 제공
-열거형을 정의하나느 방법
```java
enum 열거형이름 {상수명1, 상수명2, 상수명3, ...}
enum Kind {CLOVER, HEART, DIAMOND, SPADE}
```
-열거형 상수의 비교에 ==와 compartTo()사용가능
compareTo() 같으면 0, 왼쪽이 크면 양수, 오른쪽이 크면 음수

### 열겨형의 조상 - java.lang.Enum
-모든 열겨형은 Enum의 자손이며, 아래의 메서드를 상속받는다
|메서드|설명|
|-----------------|------|
|Class<E> getDeclaringClass()|열거형의 Class객체를 반환
|String name()|열거형 상수의 이름을 문자열로 반환
|int ordinal()|열겨형 상수가 정의된 순서를 반환(0부터 시작)
|T valueOf(Class<T> enumType, String name)|지정된 열거형에서 name과 일치하는 열겨형 상수를 반환

-values(), valueOf()는 컴파일러가 자동으로 추가

<br />

## 애너테이션
-주석처럼 프로그래밍 언어에 영향을 미치지 않으며, 유용한 정보를 제공

<br/>

### 표준 애너테이션
@Override
-오버라이딩을 올바르게 했는지, 컴파일러가 체크하게 한다.
-오버라이딩할때 메서드이름을 잘못적는 실수를 하는 경우가 많음
-오버라이딩 할때는 메서드 선언부 앞에 @Override를 붙이자

@Deprecated
-앞으로 사용하지 않을것을 권장하는 필드나 메서드에 붙인다
-Date클래스의 getDate()

@Functionallnterface
-함수형 인터페이스를 붙이면, 컴파일러가 올바르게 작성했는지 체크
-함수형 인터페이스는 하나의 추상메서드만 가져야 한다는 제약이 있음

@SuppressWarnings
-컴파일러의 경고메서지가 나타나지 않게 억제한다.
-괄홀()안에 억제하고자하는 경고의 종류를 문자열로 지정

<br/>

### 메타 애너테이션
-메타 애너테이션은 '애너테이션을 위한 애너테이션'
-메나 애너테이션은 java.lang.annotation패키지에 포함
@Target
-에너테이션을 정의할때, 적용대상 지정에 사용

@Retention
-애너테이션이 유지되는 기간을 지정하는데 사용
-컴파일러에 의해 사용되는 애너테이션의 유지 정책은 SOURCE이다
-실행시에 사용 능한 애너테이션의 정책은 RUNTIME이다

@Documented, @Inherited
-javadoc으로 작성한 문서에 포함시키려면 @Documented를 붙인다.
-애너테이션을 자손 클래스를 상속하고자 할 떄, @Inherited를 붙인다.

@Repeatable
-반복해서 붙일 수 있는 애너테이션을 정의할 때 사용
-@Repeatable이 붙은 애너테이션은 반복해서 붙일 수 있다.
-@Repeatable인 @ToDo를 하나로 묶을 컨테이너 애너테이션도 정의해야 함

<br/>

### 애너테이션 타입 정의하기
-애너테이션을 직접 만들어 쓸 수 있다
```java
@interface 애너테이션이름 {
       타입 요소이름(); // 애너테이션의 요소를 선언한다.
              ...
}
```
-애너테이션의 매서드는 추상 매서드이며, 애너테이션을 적용할때 지정(순서X)

<br/>

### 애너테이션의 요소
-적용시 값을 지정하지 않으면, 사용될 수 있는 기본값 지정 가능(null제외)
-요소가 하나이고 이름이 value일때는 요소의 이름 생략 가능
-요소의 타입이 배열인 경우, 괄호{}를 사용해야 한다.

<br/>

### 모든 애너테이션의 조상 - java.lang.annotation.Annotataion
-Annotation은 모든 애너테이션의 조상이지만 상속은 불가
-사실 Annotation은 인터페이스이다

<br/>

### 마커 애너테이션
-요소가 하나도 정의되지 않은 애너테이션
```java
public @interface Override {} // 마커 애너테이션. 정의된 요소가 하나도 없다
```

<br/>

### 애너테이션 요소의 규칙
-애너테이션의 요소를 선언할 때 아래의 규칙을 반드시 지켜야 한다.
* 요소의 타입은 기본형, String, enum, 애너테이션, Class만 허용됨
* 괄호()안에 매개변수를 선언할수 없다.
* 예외를 선언할 수 없다.
* 요소를 타입 매개변수로 정의할 수 없다.


<br/><br/><br/>

