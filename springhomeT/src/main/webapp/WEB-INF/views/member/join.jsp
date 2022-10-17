<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp">
	<jsp:param value="회원 가입" name="title"/>
</jsp:include>

<style>
.progressbar {
    height:10px;
    width:100%;
    overflow: hidden;/* 넘어갈 경우에 대한 처리*/
    position:relative;
}
.progressbar > .inner {
    position: absolute;
    top:0;
    left:0;
    bottom:0;
    width:0%;
    background: rgb(131,58,180);
    background: linear-gradient(90deg, rgba(131,58,180,1) 0%, rgba(253,29,29,1) 50%, rgba(252,176,69,1) 100%);
    transition: width 0.2s linear;
}

/* 메세지는 숨김처리 */
.success-message,
.fail-message { 
    display: none;
}

.success-message {
    color:green;
}
.fail-message {
    color:red;
}

/* 입력창의 상태에 따라 특정 메세지를 표시 */
.input.success {
    border-color: green;
}
.input.success ~ .success-message {
    display: block;
}
.input.fail {
    border-color: red;
}
.input.fail ~ .fail-message {
    display: block;
}

.fa-asterisk {
	color:red;
}
</style>

<script src="/js/member-join.js"></script>

<form class="join-form" action="join" method="post" enctype="multipart/form-data" autocomplete="off">

<div class="container-600">
	<div class="row">
		<h1>회원 가입</h1>
	</div>
	
	<div class="row">
		<div class="progressbar"><div class="inner"></div></div>
	</div>
	
	<div class="page">
		<div class="row">
			<h2>1단계 : 아이디 입력</h2>
		</div>
		
		<div class="row left">
			<label>
				<i class="fa-solid fa-asterisk"></i>
				ID
			</label>
			<input class="input w-100" name="memberId" type="text">
			<span class="success-message">멋진 아이디입니다!</span>
			<span class="fail-message">영문 소문자로 시작하며 숫자 포함 8~20자로 작성하세요</span>
		</div>	
		
		<div class="row right">
			<button type="button" class="btn btn-positive btn-next">다음 단계</button>
		</div>
	</div>
	
	<div class="page">
		<div class="row">
			<h2>2단계 : 비밀번호 입력</h2>
		</div>
		
		<div class="row left">
			<label>
				<i class="fa-solid fa-asterisk"></i>
				Password
			</label>
			<input class="input w-100" name="memberPw" type="password">
			<span class="success-message">올바른 비밀번호 형식입니다</span>
			<span class="fail-message">영문 대소문자, 숫자, 특수문자를 포함하여 8~16자로 작성하세요</span>
		</div>
		
		<div class="row left">
			<label>
				<i class="fa-solid fa-asterisk"></i>
				Password confirm
			</label>
			<input class="input w-100" id="password-check" type="password">
			<span class="success-message">비밀번호가 일치합니다</span>
			<span class="fail-message">비밀번호가 일치하지 않습니다</span>
		</div>
		
		<div class="row right">
			<button type="button" class="btn btn-neutral btn-prev">이전 단계</button>
			<button type="button" class="btn btn-positive btn-next">다음 단계</button>
		</div>
	</div>
	
	<div class="page">
		<div class="row">
			<h2>3단계 : 닉네임 입력</h2>
		</div>
		
		<div class="row left">
			<label>
				<i class="fa-solid fa-asterisk"></i>
				Nickname
			</label>
			<input class="input w-100" name="memberNick" type="text">
			<span class="success-message">멋진 닉네임이네요!</span>
			<span class="fail-message">한글 또는 숫자 2~10글자로 작성하세요</span>
		</div>
		
		<div class="row right">
			<button type="button" class="btn btn-neutral btn-prev">이전 단계</button>
			<button type="button" class="btn btn-positive btn-next">다음 단계</button>
		</div>
	</div>
	
	<div class="page">
		<div class="row">
			<h2>4단계 : 개인 정보 입력</h2>
		</div>
		
		<div class="row left">
			<label>
				<i class="fa-solid fa-asterisk"></i>
				Birth
			</label>
			<input class="input w-100" name="memberBirth" type="text">
			<span class="success-message">올바른 날짜 형식입니다</span>
			<span class="fail-message">잘못된 날짜 형식입니다</span>
		</div>
		
		<div class="row left">
			<label>Phone No.</label>
			<input class="input w-100" name="memberTel" type="tel">
		</div>
		
		<div class="row left">
			<label>E-mail</label>	
			<input class="input w-100" name="memberEmail" type="email">
		</div>
		
		<div class="row right">
			<button type="button" class="btn btn-neutral btn-prev">이전 단계</button>
			<button type="button" class="btn btn-positive btn-next">다음 단계</button>
		</div>
	</div>
	
	<div class="page">
		<div class="row">
			<h2>5단계 : 주소 입력</h2>
		</div>
		
		<div class="row left">
			<label>Address</label>
			<br>
			<input class="input" name="memberPost" type="text" maxlength="6" size="6" placeholder="우편번호">
			<button class="btn btn-neutral">검색</button>
		</div>
		
		<div class="row left">
			<input class="input w-100" placeholder="기본주소" name="memberBaseAddress" type="text">
		</div>
		<div class="row left">
			<input class="input w-100" placeholder="상세주소" name="memberDetailAddress" type="text">
		</div>
		
		<div class="row right">
			<button type="button" class="btn btn-neutral btn-prev">이전 단계</button>
			<button type="button" class="btn btn-positive btn-next">다음 단계</button>
		</div>
	</div>
	
	<div class="page">
		<div class="row">
			<h2>6단계 : 프로필 이미지 설정</h2>
		</div>
		
		<div class="row left">
			<label>Profile image</label>
			<input class="input w-100" type="file" name="memberProfile" accept=".png, .jpg">
		</div>
		
		<div class="row right">
			<button type="button" class="btn btn-neutral btn-next">이전 단계</button>
			<button type="submit" class="btn btn-positive">회원 가입</button>
		</div>
	</div>
	
</div>

</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>








