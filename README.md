# 자바 스터디 TIL


1. [Chapter 02 변수 variable](#chapter-02-변수-variable)
2. [Chapter 04 조건문과 반복문](#chapter-04-조건문과-반복문)
3. [Chapter 05 배열 arrary](#chapter-05-배열-arrary)



<br/>

# Chapter 02 변수 variable
 <blockquote>
- 스터디 일자: 2022.04.24(일) <br/>
- 실 공부일자: 2022.04.24(일)
 </blockquote>

<br/>

# Chapter 04 조건문과 반복문
 <blockquote>
- 스터디 일자: 2022.05.01(일) <br/>
- 실 공부일자: 2022.04.30(토) ~ 05.01(일) <br/>
- chapter 03 연산자는 각자 하고 넘어가기로 함
 </blockquote>

<br/>

### 2. 스터디에서 깨달은점

 * 자바 디버깅시 System.out 만 알고 있었는데, System.err 도 있었음! <br /> : System.err.println() 결과값이 빨간색으로 찍힘 <br/><br/>
 * 용어들! tomcat, war파일
 <br /> - tomcat : 동적인 데이터를 처리하는 웹서버, 동적인 처리를 담당하는 서버를 WAS(Web Application Server)라 하며, 대표적인 WAS가 톰캣
<br /> - war파일: WAR란 WebApplication Archive의 약자로 말그대로 웹 어플리케이션 저장소이며 웹 어플리케이션을 압축해 저장해 놓은 파일
<br /><br /> 사실 읽어봐도 뭔말인지 모르겠어... 우선은 이런게 있다는것만 알고, 넘어가자 <br/><br/>

* 연습문제에서 회문수 구하기 

```java
public class test15 {

	public static void main(String[] args) {
		// 회문수 구하기
		
		int number = 23432;
		int tmp = number;
		
		int result = 0;

		while(tmp !=0) {
			result = result*10 + tmp % 10;
			tmp /=10;
		}
		if(number == result) {
			System.out.println(number + "는 회문수입니다.");
		} else 
			System.out.println(number + "는 회문수가 아닙니다.");
	}

}
```
교재에 나와있는 답은 위의 코드인데,<br />
스터디 멤버 중에 한분은 int number를 string으로 바꾸고, 첫번째와 다섯번째, 두번째와 네번째를 비교하는 방식으로 해서 회문수인지 판별하도록 코드를 짜심! 오호 이 방식이 확실히 이해가 더 쉬움! <br/>
그분은... Character.getNumericValue() 메소드를 사용하였으나, 코드를 분명 봤는데 정확히 기억은 안나고, 나는 아래와 같이 다시 짜봄
```java
public class test15 {

	public static void main(String[] args) {
		// 회문수 구하기 
			
		int number = 23432;
		
		String str = String.valueOf(number);
		
		char ch0 = str.charAt(0);
		char ch1 = str.charAt(1);
		char ch2 = str.charAt(2);
		char ch3 = str.charAt(3);
		char ch4 = str.charAt(4);
		
		if(ch0 == ch4 && ch1 == ch3) {
			System.out.println(number +"는 회문수입니다.");
		} else
		System.out.println(number +"는 회문수가 아닙니다.");
	}
}
```
### Character.getNumericValue()


<br/>

# Chapter 05 배열 arrary
 <blockquote>
- 스터디 일자: 2022.05.08(일) <br/>
- 실 공부일자: 2022.05.05(목) ~ 08(일)
 </blockquote>
 
 <br/>

### 1. 공부내용 & 느낌점



### 2. 스터디에서 깨달은점
