# Chapter 11 컬렉션 프레임웍

```
컬렉션(collection)
- 여러 객체(데이터)를 모아 놓은 것을 의미

프레임웍(framework)
- 표준화, 정형화된 체계적인 프로그래밍 방식

컬렉션 프레임웍(collection framework)
- 컬렉션(다수의 객체)을 다루기 위한 표준화된 프로그래밍 방식
- 컬렉션을 쉽고 편리하게 다룰 수 있는 다양한 클래스를 제공
- java.util패키지에 포함, JDK1.2부터 제공

컬렉션 클래스(collection class)
- 다수의 데이터를 저장할 수 있는 클래스 ex) ArrayList, HashSet
```

|인터페이스|설명|
|-----------------|------|
|List|순서가 있는 데이터의 집합, 중복 허용, 구현클래스: ArrayList, LinkdedList 등
|Set|순서를 유지하지 않는 데이터의 집합, 중복 허용 X, 구현클래스: HashSet, TreeSet 등
|Map|키와 값의 쌍으로 이어어진 데이터 집합, 순서 유지하지 않고, 키는 중복 허용 X, 값은 중복 허용 ex) HashMap, TreeMap 등

<br /><br />

## Collection 인터페이스의 메서드
<br />
 
|메서드|설명|
|-----------------|-----------------------|
|boolean add(Object o)<br/>boolean addAll(Collection c)|지정된 객체(o) 또는 Collection(c)의 객체들을 Collection에 추가한다.
|void clear()|Collection의 모든 객체를 삭제한다.
|boolean contains(Object o)<br/>boolean containsAll(Collection c)|지정된 객체(o) 또는 Collection(c)의 객체들을 Collection에 포함되어 있는지 확인한다.
|boolean equals(Object o)|동일한 Collection인지 비교한다.
|int hashCode()|Collection의 hash code를 반환한다.
|boolean isEmpty()|Collection이 비어있는지 확인한다.
|lterator iterator()|Collection의 lteraior를 얻어서 반환한다.
|boolean remove(Object o)|지정된 객체를 삭제한다.
|boolean removeAll(Collection c)|지정된 Collection에 포함된 객체들을 삭제한다.
|boolean retainAll(Collection c)|지정된 Collection에 포함된 객체만을 남기고 다른 객체들은 Collection에서 삭제한다. 이 작업으로 인해 Collection에 변화가 있으면 true를 그렇지 않으면 false를 반환한다.
|int size()|Collection에 저장된 객체의 개수를 반환한다.
|Object[] toArray() |Collection에 저장된 객체를 객체배열(Object[])로 반환한다.
|Object[] toArray()(Object[] a) |지정된 배열에 Collection의 객체를 저장해서 반환한다.

<br /><br />

## List인터페이스 - 순서O, 중복O
<img src="../img/list.png" width="400px">

<br/>

|메서드|설명|
|-----------------|-----------------------|
|void add(int index, Object element)<br/>boolean addAll(int index, Collection c)|지정된 위치(index)에 객체(element) 또는 컬렉션에 포함된 객체들을 추가한다.
|Object get(int index)|지정된 위치(index)에 있는 객체를 반환한다.
|int indexOf(Object o)|지정된 객체의 위치(index)를 반환한다.(List의 첫번째 요소로부터 순방향으로 찾는다.)
|int lastIndexOf(Object o)|지정된 객체의 위치(index)를 반환한다.(List의 마지막 요소로부터 역방향으로 찾는다.)
|Listlterator listlterator()<br/>Listlterator listlterator(int index)|List의 객체에 접근할 수 있는 Listlterator를 반환한다.
|Object remove(int index)|지정된 위치(index)에 있는 객체를 삭제하고, 삭제된 객체를 반환한다.
|Object set(int index, Object element)|지정된 위치(index)에 있는 객체(element)를 저장한다.
|void sort(Comparator c)|지정된 비교자(comparator)로 List를 정렬한다.
|List subList(int fromIndex, int toIndex)|지정된 범위(fromIndex부터 toIndex)에 있는 객체를 반환한다.

<br /><br />

## Set인터페이스 - 순서X, 중복X
<img src="../img/set.png" width="300px">

<br/>

### Set인터페이스의 메서드 - Collection인터페이스와 동일 <br />
### 집합과 관련된 메서드(Collection 변화가 있으면 true, 아니면 false를 반환)

<br />

|메서드|설명|
|-----------------|-----------------------|
|boolean addAll(Collection c|지정된 Collection(c)의 객체들을 Collection에 추가한다(합집합)
|boolean containsAll(Collection c|지정된 Collection의 객체들이 Collection에 포함되어 있는지 확인한다(부분집합)
|boolean removeAll(Collection c|지정된 Collection에 포함된 객체들을 삭제한다.(차집합)
|boolean retainAll(Collection c|지정된 Collection에 포함된 객체만을 남기고 나머지는 Collection에서 삭제한다.(교집합)

<br/><br/>

## Map인터페이스 - 순서X, 중복(키X,값O)
<img src="../img/map.png" width="400px">

<br />

|메서드|설명|
|-----------------|-----------------------|
|void clear()|Map의 모든 객체를 삭제한다.
|boolean containsKey(Object key)|지정된 Key객체와 일치하는 Map의 key객체가 있는지 확인한다.
|boolean containsValue(Object value)|지정된 value객체와 일치하는 Map의 value객체가 있는지 확인한다.
|Set entrySet()|Map에 저장되어 있는 key-value쌍을 Map.Entry타입의 객체로 저장한 Set으로 반환한다.
|boolean equals(Object o)|동일한 Map인지 비교한다.
|Object get(Object key)|지정한 key객체에 대응하는 value객체를 찾아서 반환한다.
|int hashCode()|해시코드를 반환한다.
|boolean isEmpty()|Map이 비어있는지 확인한다.
|Set keySet()|Map에 저장된 모든 key객체를 반환한다.
|Object put(Object key, Object value)|Map에 value객체를 key객체에 연결(mapping)하여 저장한다.
|void putAll(Map t)|지정된 Map의 모든 key-value쌍을 추가한다.
|Object remove(Object key)|지정된 key객체와 일치하는 key-value객체를 삭제한다.
|int size()|Map에 저장한 key-value쌍의 개수를 반환한다.
Collection values()|Map에 저장된 모든 value객체를 반환한다.

<br /><br/>

## ArrayList
- ArrayList는 기존의 Vector를 개선한 것으로 구현원리와 기능적으로 동일
- ArrayList와 달리 Vector는 자체적으로 동기화처리가 되어있다.
- 데이터 저장공간으로 배열을 사용한다.
- List인터페이스를 구현하므로, 저장순서 유지, 중복 허용
- 객체를 중간 삭제하거나 추가시, 뒤에 있는 데이터들을 다 앞으로 땡겨오거나, 뒤로 미룸!

<br/>

### ArrayList에 저장된 객체의 삭제과정
#### 1. ArrayList에 저장된 첫 번째 객체부터 삭제하는 경우(배열 복사 발생)
```java
for(int i=0; i <list.size(); i++;){
    list.remove(i);
}
```
<img src="../img/1.png" width="400px">

→ for문 다 돌았는데도, 값 남아있을 수 있음! why? 삭제할때마다 값이 올라가기 때문(앞으로 땡겨져서) 그래서 마지막 객체부터 삭제하면 됨

<br/>

#### 2. ArrayList에 저장된 마지작 객체부터 삭제하는 경우(배열 복사 발생안함)
```java
for(int i=list.size()-1; i >=0; i--;){
    list.remove(i);
}
```
<img src="../img/2.png" width="400px">

## LinkedList
- 배열의 장점: 구조가 간단하고, 데이터를 읽는데 걸리는 시간(접근시간, access time)이 짧다.
- 단점: 크기를 변경할 수 없다.
크기를 변경해야 하는 경우 새로운 배열을 생성 후 데이터를 복사해야함, 그리고 참조변경, 크기 변경을 피하기 위해 충분히 큰 배열을 생성하면, 메모리가 낭비됨
- 단점: 비순차적인 데이터의 추가, 삭제에 시간이 많이 걸린다.
(데이터를 추가하거나 삭제하기 위해, 다른 데이터를 옮겨야 함
but 순차적인 데이터 추가(끝에 추가)와 삭제(끝부터 삭제)는 빠르다.)

### 배열의 단점을 보완하기 위해 나온게 LinkedList
- 배열과 달리 불연속적으로 존재하는 데이터를 연결(link)
- 데이터 삭제 : 단 한번의 참조 변경만으로 가능
- 노드로 연결, 노드에는 데이터와 다음요소에 대한 정보를 담고있음
- 데이터 추가: 한번의 Node객체생성과 두번의 참조 변경만으로 가능

but LinkdedList에도 단점이 있음!
- 데이터 접근성이 나쁨
=> 보완하기 위해 doubly linked list(더블리 링크드 리스트)- 이중 연결리스트, 접근성 향상, 노드에 다음요소, 이전요소의 정보를 담고있음
=> doubly circular linked list(더블리 써쿨러 링크드 리스트)- 이중 원형 연결리스트 라는 것도 있음
맨 앞 노드가 맨뒤의 요소를, 맨 뒤의 노드가 맨 앞의 요소를 가지고 있음

## ArrayList(배열기반) vs LinkedList(연결기반) 성능비교
1. 순차적으로 데이터를 추가/삭제 - ArrayList가 빠름
2. 비순차적으로 데이터를 추가/삭제 - LinkedList가 빠름
3. 접근시간(access time) - ArrayList가 빠름


<br /><br /><br />

## 스택과 큐(Stack & Queue)
- 스택: LIFO(Last In First Out)구조, 마지막에 저장된 것을 제일 먼저 꺼내게 된, 밑이 막힌 상자, 스택은 배열로 구현하면 좋고
Stack st = new Stack();으로 사용 가능

- 큐: FIFO구조, 제일 먼저 저장한 것을 제일 먼저 꺼내게 된다, 양끝이 뚫린 상자  ex) 줄서기, 링크드리스트 적합
Queue는 자바에서 인터페이스로 정의되어있기때문에 Queue q = new Queue(); 이렇게 할수 없음
인터페이스는 객체 생성 불가
그래서 어떻게?
1. Queue를 직접 구현
2. Queue를 구현한 클래스를 사용

Java API에서 찾아보면 2번의 목록이 있음
2번의 하나로 LinkedList가 있음

Queue g = new LinkedList(); 이렇게

<img src="../img/stack&queue.png" width="400px">