# Stockid
Stock + Kid, 주린이들을 위한 주식 정보 공유 사이트

### 개발 환경
Spring Boot, Gradle, Java 11  
MySQL, JPA

### 프론트엔드
Javascript, JQuery, Vue.js

### 테스트
JUnit5, Swagger

[로그인 구현 정보](https://github.com/ynjch97/Stockid/wiki/Login-%EA%B8%B0%EB%8A%A5-%EA%B5%AC%ED%98%84-%EC%A0%95%EB%B3%B4)

### 21년 5월 
- url 패턴 재정의 -> [그룹url]/main.do [그룹url]/list.do [그룹url]/write.do  
- SiteMesh 설정  
- css 수정 : favicon 및 logo 작업, header 디자인, css 파일 용도별 세분화  
- 화면 추가 : 로그인, 그룹 선택, 회원가입, 개인정보 수정, 평단 계산기, 그룹별 메인, 그룹별 포스트 목록, 등록
- resultVO, common.js 등 공통화 작업  
- Const.java 공통 상수 관리  
- 로그인 및 세션 정보 전달 구현  
- 로그인 시 JavaScript - Controller 전달 시 Base64 인코딩 
- 로그인 암호화 RSAUtil 적용(삭제) > 로그인 암호화 SHA256Util 적용  
- 그룹 선택 화면 관련 쿼리 작성  

### 21년 6월 
- 화면 추가 : 카테고리별 포스트 목록
- log 파일 설정
- LoginInterceptor 설정 (세션 체크 제외 페이지 설정)

### 21년 7월
- LoginInterceptor 수정 (yml 파일 이용)

### 21년 9월
- LoginInterceptor 수정 (yml 파일 이용해 세션 체크 제외 페이지 세팅)

### 21년 10월
- LoginInterceptor 수정 (세션 체크 제외되는 페이지 패턴 검사 적용)
- mapper VO alias 적용
- 화면 수정 : 로그인, 개인정보 수정 화면에 Vue.js 적용
- Git 협업을 위한 Fork, Upstream Merge, Pull Request 테스트 

### 21년 11월
- Java 11 버전 업그레이드
- css 수정 : input box 와 span 사이 거리 조정, textarea 디자인, usr-grp 폼 항목명 영역 추가, 라디오 버튼
- 화면 추가 : 그룹 생성
- 화면 수정 : 그룹 선택 화면에 Vue.js 적용
- LoginInterceptor 수정 (redirectPage 관련 부분 오류 수정)

### 22년 1월
- 화면 수정 : 그룹 선택 화면에 Vue.js 적용
- JPA Hibernate 적용

### 22년 2월
- Swagger 추가
- JUnit5 추가
- JIRA 연결

### 22년 3월
- 포스트 목록 화면 JPA로 변경
