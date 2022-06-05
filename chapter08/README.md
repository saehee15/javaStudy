# Chapter 08 예외처리
 <blockquote>
- 실 공부일자: 2022.06.04(토) ~ 
</blockquote>   
<br /><br />

## 프로그램 오류
- 컴파일 에러 : 컴파일 할때 발생하는 에러
javac.exe
- 런타임 에러 : 실행할 때 발생하는 에러, 프로그램 종료
- 놀리적 에러 : 작성 의도와 다르게 동작, 프로그램 종료 X

<br/>


## java의 런타입 에러
```
에러(error) : 프로그램 코드에 의해서 수습될 수 없는 심각한 오류 ex) out of memory error   
예외(exception) : 프로그램 코드에 의해서 수습될 수 있는 다소 미약한 오류                         

에러(error)는 어쩔 수 없지만, 예외(exception)은 처리하자!
-> 프로그램 실행시 발생할 수 있는 예외의 발생에 대비한 코드를 작성 
-> 왜 해? 비정상 종료를 막고, 정상적인 실행상태 유지!!
```

<br />

## Exception과 RuntimeException

```
Exception 클래스들 : 사용자의 실수와 같은 외적인 요인에 의해 발생하는 예외

IOException : Input, Output 입출력 예외
ClassNotFoundException : 클래스 파일이 외부디스크에  존재 X 



RuntimeException 클래스들 : 프로그래머의 실수로 발생하는 예외

ArithmeticException : 산술계산 예외 
ClassCastException : 형변환
NullPointerException : String str = null; 이런데 str.length 이러면 nullpointer 오류
IndexOutBoundsException : 배열 범위 벗어나는 오류
```
```java
try {
    예외가 발생할 가능성이 있는 문장들을 넣는다.
} catch ( Exception e ) {
    Exception이 발생했을 경우, 이를 처리하기 위한 문장 적는다.
}
```
- if문과 달리, try블럭이나 catch블럭 내에 포함된 문장이 하나뿐이더라도 괄호 {}를 생략 할 수 없다.    
- catch문 (Exception e) 이렇게 쓰면 모든 예외 처리 가능, Exception e가 모든 예외의 최고조상이기 때문, 제일 마지막에 와야함

<br/>



## printStackTrace(), getMessage()
```
printStackTrace() : 예외발생 당시의 호출스택(Call Stack)에 있었던 메서드의 정보와 예외 메시지를 화면에 출력한다.
getMessage() : 발생한 예외클래스의 인스턴스에 저장된 메시지를 얻을 수 있다.
```


## 멀티 catch 블록    
: 내용이 같은 catch블럭을 하나로 합친 것(JDK1.7 부터)
```java
try{
    ...
} catch ( ExceptionA e ){
    e.printStackTrace();
} catch ( ExceptionB e2 ){
    e2.printStackTrace();
}
```
위 코드처럼 내용이 동일하면 밑처럼 하나로 합칠 수 있음
```java
try{
    ...
} catch ( ExceptionA | ExceptionB e ){
    e.printStackTrace();
}
```
BUT 주위사항
- catch 괄호 안에 예외가 부모 자식 관계 X - 부모만 써도 됨
- 예외 2개 중 한개에만 있는 메서드 호출 불가, 형변환 하면 가능( ExceptionA에 선언된 methodA는 호출불가)
e.methodA();  

<br /><br />


## 예외 발생시키기
1. 연산자 new를 이용해서 발생시키려는 예외 클래스의 객체를 만든 다음  
Exception e = new Exception("에러메세지")

2. 키워드 throw를 이용해서 예외를 발생시킨다.   
throw e;

<br /><br />



## checked 예외, unchecked 예외
- checked 예외: 컴파일러가 예외 처리를 여부를 체크(예외 처리 필수)
Exception와 그 자손
- unchecked 예외: 컴파일러가 예외처리 여부를 체크 안함(예외 처리 선택)
RuntimeException와 자손

<br /><br />


 
## 메서드에 에외 선언하기

예외를 처리하는 방법
1. try-catch문 (내가 직접 처리)
2. 예외 선언하기 (예외 떠넘기기 알리기)
3. 은폐 (덮기) - 빈 catch문

```java
void method() throws Exception1, Exception2, ....{

}
``` 
<br /><br />

## finally블록     
: 에외 발생여부와 관계없이 수행되어야 하는 코드를 넣는다.

<br /><br /><br />


## 느낀점
아쉽게 스터디모임이 파토났다. 그래도 일주일에 한 챕터씩 공부해서 기록은 남길려고 한다.    
6월 첫째주는 chapter8 예외처리에 대해 공부했다.      
try catch문은 학원에서 이번주에 내내 했던거라 낯설지는 않다.   
이번 주 학원에서 게시판, 회원가입 화면을 만들면서 dao파일을 만들고, 그 안에 try catch문을 썼기 때문이지     
그때는 그냥 따라쳤지만, 이제는 구조가 좀 보임   
학원에서 했던 코드 
```java
try {
			Class.forName(CommonUtil.driver_class);
			conn = DriverManager.getConnection(CommonUtil.db_url,
					CommonUtil.username,
					CommonUtil.password);
			
			String sql= "insert into tb_member(userid, pwd, username"
							+ ", phone, email, wdate, activeyn) values( "
							+ " ?,  ? ,  ?,  ?,  ?, now(), 'Y' )";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getUserid());
			pstmt.setString(2, dto.getPwd());
			pstmt.setString(3, dto.getUsername());
			pstmt.setString(4, dto.getPhone());
			pstmt.setString(5, dto.getEmail());
			
			pstmt.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
```
그리고 printStackTrace도 보이고, ClassNotFoundException, SQLException예 대해서도 알겠음
