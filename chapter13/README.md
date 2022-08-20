# Chapter 13 쓰레드

## 프로세스와 쓰레드(process $ thrdad)
-프로세스 : 실행 중인 프로그램, 자원(resources)과 쓰레드로 구성
-쓰레드 : 프로세스 내에서 실제 작업을 수행, 모든 프로세스는 최소한 하나의 쓰레드를 가지고 있다.
```
프로세스 : 쓰레드 = 공장 : 일꾼
```
-싱글 쓰레드 프로세스 = 자원 + 쓰레드
-멀티 쓰레드 프로세스 = 자원 + 쓰레드 + 쓰레드...
```
하나의 새로운 프로세스를 생성하는 것보다
하나의 새로운 쓰레드를 생성하는 것이 더 적은 비용이 든다
```

<br/>

### 멀티쓰레드의 장단점
|||
|-----------------|------|
|장점|시스템 자원을 보다 효율적으로 사용할 수 있다 <br/>사용자에 대한 응답성이 향상된다 <br/>작업이 분리되어 코드가 간결해진다
|단점|동기화에 주의해야한다 <br/> 교착상태가 발생하지 않도록 주의해야 한다 <br/> 각 쓰레드가 효율적으로 고르게 실행될 수 있게 해야한다

<br/><br/>

### 쓰레드의 구현과 실행
1) Thread클래스를 상속
2) Runnable인터페이스를 구현 (많이 사용)

### 쓰레드의 실행 - start()
-쓰레드를 생성한 후에 start()를 호출해야 쓰레드가 작업을 시작
```java
ThreadEx1_1 t1 = new ThreadEx1_1(); // 쓰레드 t1을 생성한다.
ThreadEx1_1 tx = new ThreadEx1_1(); // 쓰레드 t2를 생성한다.

t1.start(); // 쓰레드 t1을 실행시킨다.
t2.start(); // 쓰레드 t2를 실행시킨다.
```
-t1을 먼저 start했다고 t1이 먼저 실행되는건 아님
-확률이 높을뿐, 반드시 그런건 아님 언제 실행될지는 OS스케줄러가 실행순서 결정

<br/>

### main쓰레드
-main매서드의 코드를 수행하는 쓰레드
-쓰레드 '사용자 쓰레드'와 '데몬 쓰레드' 두 종류가 있다.
-데몬 쓰레드  : 보조 쓰레드
-실행중인 사용자 쓰레드가 하나도 없을때 프로그램은 종료된다.


### 쓰레드의 I/O블락킹(blocking) - Input/Output
-I/O블락킹 : 입력출력시 작업중단
-사용자의 입력을 기달린다는가 할때 싱글쓰레드는 아무일도 할수 없는데, 멀티쓰레드는 좀 더 작업을 빨리 마칠수 있음


<br/><br/>
### 쓰레드 우선순위(priority of thread)
-작업의 중요도에 따라 쓰레드의 우선순위를 다르게 하여 특정 쓰레드가 더 많은 작업시간을 갖게 할 수 있따
-우선순위 지정해주지 않으면 5

```java
void setPriority(int newPriority) 쓰레드의 우선순위를 지정한 값으로 변경한다.
int getPriority() 쓰레드의 우선순위를 반환한다.

public static final int MAX_PRIORITY = 10 // 최대우선순위
public static final int MIN_PRIORITY = 1 // 최소우선순위
public static final int NORM_PRIORITY = 5 // 보통우선순위
```

### 쓰레드 그룹
-서로 관련된 쓰레드를 그룹으로 묶어서 다루기 위한 것
-모든 쓰레드는 반드시 하나의 쓰레드 그룹에 포함되어 있어야 한다.
-쓰레드 그룹을 지정하지 않고, 생성한 쓰레드는 'main쓰레드 그룹'에 속한다.
-자신이 생성한 쓰레드(부모 쓰레드)의 그룹과 우선순위를 상속받는다.

<br/>

### 데몬 쓰레드(deamon thread)
-일반 쓰레드(non-deamon thread)의 작업을 돋는 보조적인 역할을 수행
-일반 쓰레드가 모두 종료되면 자동적으로 종료된다.
-가비지 컬렉터, 자동저장, 화면 자동갱신 등에 사용된다.
-무한루프와 조건문을 이용해서 실행 후 대기하다가 특정조건이 만족되면 작업을 수행하고 다시 대기하도록 작성한다.
```java
public void run(){
    while(true) // 무한루프, 일반쓰레드가 종료되면 자동 종료되니
        try{
            // 무한루프라 계속 실행되면 안되니까 쉬는시간 줌 
            Thread.sleep(3*1000); // 3초마다 쉬는거임
        } catch (InterruptedException e) {}

        // autoSave의 값이 true이면 autoSave()를 호출한다.
        if(autoSave){
            autoSave();
        }
}
```
```java
boolean isDaemon() - 쓰레드가 데몬쓰레드인지 확인한다. 데몬 쓰레드이면 true를 반환
void setDaemon(boolean on) - 쓰레드를 데몬 쓰레드로 또는 사용자 쓰레드로 변경, 매개변수 on을 true로 지정하면 데몬쓰레드가 된다.
```
-setDaemon(boolean on)은 반드시 start()를 호출하기 전에 실행되어야 한다.
그렇지 않으면 IllegalThreadStateException이 발생한다.

<br />

### 쓰레드의 상태
|상태|설명|
|-----------------|------|
|NEW|쓰레드가 생성되고 아직 start()가 호출되지 않은 상태
|RUNNABLE|실행 중 또는 실행 가능한 상태
|BLOCKED|동기화블럭에 의해서 일시정지된 상태(lock이 풀릴때까지 기달리는 상태)
|WAITING, TIMED_WAITNG|쓰레드의 작업이 종료되지는 않았지만 실행가능하지 않은(unrunnable) 일시정지상태. TIMED_WAITING은 일시정지시간이 지정된 경우를 의미
|TERMINATED|쓰레드의 작입이 종료된 상태

<br/><br/>

## 쓰레드의 실행제어
-쓰레드의 실행을 제어할 수 있는 메서드가 제공된다.
이 들을 활용해서 보다 효울적인 프로그램의 작성할 수있다.
-static 이 붙은 메서드들은 자기 자신한테만 적용됨
|메서드|설명|
|-----------------|------|
|static void sleep(long millis)static void sleep(long millis,int nanos)<br/>|지정된 시간(천분의 일초 단위)동안 쓰레드를 일시정지시킨다. 지정한 시간이 지나고 나면, 자동적으로 다시 실행대기상태가 된다.
|void join()<br/>void join(long millis)<br/>void join(long millis, int nanos)|지정된 시간동안 쓰레드가 실행되도록 한다. 지정된 시간이 지나거나 작업이 종료되면 join()을 호출한 쓰레드로 다시 돌아와 실행을 계속한다.
|void interrupt()|sleep()이나 join()에 의해 일시정지상태인 쓰레드를 꺠워서 실행대기상태로 만든다. 해당 쓰레드에서는 Interrupted Exception이 발생함으로써 일시정지 상태를 벗어나게 된다
|void stop()|쓰레드를 즉시 종료시킨다
|void suspend()|쓰레드를 일시정지시킨다. resume()을 호출하면 다시 실행대기상태가 된다.
|void resume()|suspend()에 의해 일시정지상태에 있는 쓰레드를 실행대기상태로 만든다.
|static void yield()|실행 중에 자신에게 주어진 실행시간을 다른 쓰레드에게 양보(yield)하고 자신은 실행대기상태가 된다
 <br/>

 ### sleep()
 -현재 쓰레드를 지정된 시간동안 멈추게 한다.
 -예외처리를 해야한다(INterruptedException이 발생하면 깨어남)
 -특정 쓰레드를 지정해서 멈추가 하는것을 불가능하다.

 <br/>

 ### interrupt()
 -대기상태(WAITING)인 쓰레드를 실행대기 상태(RUNNABLE)로 만든다
 ```java
 void interrupt() - 쓰레드와 interrupted상태를 false에서 true로 변경
 boolean isInterrupted() - 쓰레드의 interrupted상태를 반환
 static boolean interrupted() - 현재 쓰레드의 interrupted상태를 알려주고, false로 초기화
 ```

 <br/>

### suspend(), resume(), stop()
-쓰레드의 실행을 일시정시, 재개, 완전정지 시킨다
-deprecated 됨, 사용 권장하지 않음!! why? 교착상태 야기
```java
void suspend() - 쓰레드를 일시정지 시킨다
void resume() - suspend()에 의해 일시 정지된 쓰레드를 실행대기상태로 만든다.
void stop() - 쓰레드를 즉시 종료시킨다
```

<br/>

### join()
-지정된 시간동안 특정 쓰레드가 작업하는것을 기달린다
```java
void join() // 작업이 모두 끝날 때까지
void join(long millis) // 천분의 일초동안
void join(long millis, int nanos) // 천분의 일초 + 나노초 동안
```

<br/>

### yield()
-남은 시간을 다음 쓰레드에게 양보하고, 자신(현재 쓰레드)은 실행대기한다.
-yield()와 interrupt()를 적절히 사용하면, 응답성과 효울을 높일 수 있다
-OS스케줄러에 통보

<br/><br/>

## 쓰레드의 동기화(synchronization)
-멀티 쓰레드 프로세스에서는 다른 쓰레드의 작업에 영향을 미칠수 있다.
-진행중인 작업이 다른 쓰레드에게 간섭되지 않게 하려면 '동기화'가 필요
```
쓰레드의 동기화 - 한 쓰레드가 진행중인 작업을 다른 쓰레드가 간섭하지 못하게 하는것
```
-동기화하려면 간섭받지 않아야 하는 문장들을 '임계 영역'으로 설정
-임계영역은 락(lock)을 얻은 단 하나의 쓰레드만 출입가능(객체 1개에 락 1개)

## synchronized를 이용한 동기화
-synchronized로 임계영역(lock이 걸리는 영역)을 설정하는 방법 2가지
1. 메서드 전체를 임계 영역으로 지정
2. 특정한 영역을 임계 영역으로 지정

<br/>
-private으로 해야 동기화 의미가 있음

<br/>

## wait()과 notify()
-동기화 효율을 높이기 위해 wait(), notify()를 사용
-Object클래스에 정의되어 있으며, 동기화 블록 내에서만 사용할 수 있다.
```java
wait() - 객체의 lock을 풀고 쓰레드를 해당 객체의 waiting pool에 넣는다
notify() - waiting pool에서 대기중인 쓰레드 중의 하나를 꺠운다
notifyAll() - waiting pool에서 대기중인 모든 쓰레드를 깨둔다
```