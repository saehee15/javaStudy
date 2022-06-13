# Chapter 10 날짜와 시간 & 형식화

## Calendar 클래스 
: 추상 클래스 이므로 getInstance()를 통해 구현된 객체를 얻어야 한다.   
: get()으로 날짜와 시간 필드 가져오기
```java
Calender cal = new Calendar(); // 에러!!! 추상클래스는 인스턴스 생성 불가
Calender cal = Calendar.getInstance(); // OK, getInstance()메서드는 Calendar클래스를 구현한 클래스의 인스턴스를 반환한다
```
