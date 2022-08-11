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

<br/><br/>

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
