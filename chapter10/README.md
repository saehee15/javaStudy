# Chapter 10 날짜와 시간 & 형식화

## Calendar 클래스 
- 추상 클래스 이므로 getInstance()를 통해 구현된 객체를 얻어야 한다.   
- get()으로 날짜와 시간 필드 가져오기
```java
Calender cal = new Calendar(); // 에러!!! 추상클래스는 인스턴스 생성 불가
Calender cal = Calendar.getInstance(); // OK, getInstance()메서드는 Calendar클래스를 구현한 클래스의 인스턴스를 반환한다
```
- set()으로 날짜와 시간 지정하기
- clear()는 Calendar객체의 모든 필드를 초기화
- add()는 특정 필드의 값을 증가 또는 감소(다른 필드에 영향O)
- roll()은 특정필드의 값을 증가 또는 감소(다른 필드에 영향X)
```java
Calendar date = Calendar.getInstance();
date.clear();  // 모든 필드를 초기화
date.set(2020, 7, 31); // 2020년 8월 31일로 설정

date.add(Calendar.DATE, 1); // 날짜(DATE)에 1을 더한다 , 2020년 9월 1일
date.add(Calendar.MONTH, -8); //월(MONTH)에서 12을 뺀다, 2020년 1월 1일
```

## 형식화 클래스
### DecimalFormat
### SimpleDateFormat