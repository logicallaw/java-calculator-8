# java-calculator-precourse: 문자열 덧셈 계산기

구분자와 양수로 이루어진 문자열을 입력 받아서 덧셈 결과를 출력하는 프로그램이다.

## 기능 구현

MVC 패턴, Factory Method 패턴, 전략 패턴을 적용하여 객체지향적 설계를 목표로 한다.

- [x] InputView: 사용자 입력 처리
- [x] OutputView: 화면(console) 출력 처리
- [x] StringAddStrategy
    - [x] 기본 구분자 정규표현식 정의 (",|:")
    - [x] 커스텀 구분자 인덱스 정의 (2)
    - [x] 커스텀 구분자 접두어 제거용 substring 시작 인덱스 정의 (5)
    - [x] 입력 유효성 검사
        - [x] 음수 입력 시 "IllegalArgumentException" 발생
        - [x] 커스텀 구분자가 숫자일 경우 "IllegalArgumentException" 발생
    - [x] 문자열 배열을 순회하며 양수 합 계산
    - [x] 입력 문자열을 구분자로 split하여 문자열 배열 반환
    - [x] **기본 구분자로 구성된 입력 문자열의 덧셈 결과 반환**
    - [x] **커스텀 구분자로 구성된 입력 문자열의 덧셈 결과 반환**
- [x] BaseCalculator (추상 클래스)
    - [x] 커스텀 구분자 식별 상수 정의 ("//")
    - [x] 빈 문자열일 때 반환할 상수 정의 (0)
    - [x] 추상 메서드 execute() 정의
- [x] StringCalculator (BaseCalculator의 자식 클래스)
    - [x] 잘못된 문자열 입력 시 "IllegalArgumentException" 발생
    - [x] 빈 문자열, 기본 구분자, 커스텀 구분자 여부를 판단하는 불리언 함수
    - [x] execute() 오버라이딩
- [x] Factory
    - [x] StringCalculator 객체 생성 함수 정의 (create())
- [x] CalculatorController (계산기의 실행 흐름 제어)
- [x] Application
    - [x] 객체 생성 및 CalculatorController 실행
- [x] ApplicationTest
    - [x] 올바른 기본 구분자는 통과 ("3,5:9,")
    - [x] 기본 구분자가 아닌 구분자가 포함된 경우는 "IllegalArgumentException" 발생 ("1,2;3[4,5")
    - [x] 구분자만 있는 경우 "IllegalArgumentException" 발생 (",,;[]")
    - [x] 커스텀 구분자가 숫자이면 구분 기준이 모호해지므로 "IllegalArgumentException" 발생 ("//9\n29893")
    - [x] 커스텀 구분자가 잘못된 형식이면 "IllegalArgumentException" 발생 ("//:2:3:4:5")
- [x] 전략패턴 수정
    - [x] 계산기의 동작을 확장 가능하도록 기능을 정의하는 Calculation 인터페이스를 생성
    - [x] 이를 상속 받아서 문자열 덧셈 기능을 수행하는 자식 클래스 StringCalculation 생성
    - [x] BaseCalculator에 setCalculation 함수를 정의하여 내부 구현은 숨기되 사용하기 용이하도록 API 정의