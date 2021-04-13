<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.haeyo.biz.user.UserVO"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>해요 - 결제완료</title>
    <link href="resources/image/icon.ico" rel="shortcut icon" type="image/x-icon">
    <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link href="resources/css/header.css" rel="stylesheet">
    <link href="resources/css/profession/complete.css" rel="stylesheet">
</head>
<script type="text/javascript">
window.onload = function() {
	wsOpen();
}
var ws;

function wsOpen(){
	ws = new WebSocket("ws://" + location.host + "/project/chating");
	wsEvt();
}

	//소켓이 연결되었을 떄 실행
	function wsEvt() {
		ws.onopen = function(data){
			//소켓이 열리면 동작
			send();
		}
		
		ws.onmessage = function(data) {
			//메시지를 받으면 동작
			var msg = data.data;
			console.log(msg);
			if(msg != null && msg.trim() != ''){
				var message = JSON.parse(msg);
				console.log(message);
				if(message.type == "alarm" && message.pEmail == "${user.uEmail}"){
					var si = message.sessionId != null ? message.sessionId : "";
					$("#sessionId").val(si);
					$("#alarmTxt").append("<div>" + message.msg + "</div>");	
				}else if( message.type == "alarm" && vmessage.uEmail == "${user.uEmail}"){
					$("#alarmTxt").append("<div>" + "결제가 완료되었습니다." + "</div>");
				}
			}else{
				console.warn("unknown type!");
			}
		}
	
	}
	
	//소켓에 메세지 보내기
	function send() {
		//메시지 보낼때 json형태로 보낸다
		//type은 메세지, type이 message인 경우에 채팅이 발생한 경우
		//sessioId 값은 상대방과 자신을 구분할 수 있는 session값
		var option = {
				type: "alarm",
				sessionId : $("#sessionId").val(),
				pNo : "60001",
				pName : "황순근",
				uNo : "10001",
				uEmail : "soomin@bit.com",
				uNick : "${user.uNick}",
				pEmail : "wendy@bit.com",
				msg : "${user.uNick}" + "님이 회원님을 예약하셨습니다."
			}
		ajaxSend(option);
		let sendMsg = JSON.stringify(option);
		console.log();
		ws.send(sendMsg);
	}
	//결제 인서트 ajax
	function ajaxSend(data) {
		$.ajax({
			url:"insertAlram.do",
			type: "GET",
			data: data,
			contentType : "application/json; charset=UTF-8",
			dataType: "json",
			success: function(result){
				$("#alarmTxt").append("<div>" + result.msg + "</div>");
			}
		});
	}
</script>
<body>
<wrap>
	<header id="header">
		<nav id="nav">
			<logo id="logo"> <a href="index"><img
				src="resources/image/logo2.png" alt="로고"></a> </logo>
			<ul>
				<li><a href="#">같이해요</a></li>
				<li><a href="#">혼자해요</a></li>
				<li><a href="#">전문가 신청</a></li>
				<li class="btn-group">
					<ul class="dropdown-toggle bell" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false">
						<i class="fas fa-bell"></i>
					</ul>
					<div class="dropdown-menu dropdown-menu-right alarm1">
						<p>알림</p>
						<div id="alarmTxt"></div>
					<!--<span>23분전</span> -->
					</div>
				</li>
				<li class="btn-group">
					<div class="dropdown-toggle" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false">${user.uNick}님</div>
					<div class="dropdown-menu dropdown-menu-right" id="profile">
						<div id="profiteTxt">
							<span>반갑습니다! </span>${user.uNick}님</div>
						<ul class="profileMenu">
							<li><i class="fas fa-user menuico"></i>마이페이지</li>
							<li><i class="fas fa-sign-out-alt menuico"></i>로그아웃</li>
							<li><i class="fas fa-exchange-alt menuico"></i>전문가로 전환</li>
						</ul>
					</div>
				</li>
			</ul>
		</nav>
	</header> <!---------------------headerEnd--------------------->

    <main>
    	<input type="hidden" id="sessionId" value="">
        <div id="txtWrap">
            <div id="txt">
                <h1>결제가 완료되었습니다.</h1>
                <h1><span>${user.uNick}님 감사합니다.</span></h1>
            </div>
            <form action="chat.do" method="get" target="_blank">
            	<input type="hidden" id="uNick" name="uNick" value="${user.uNick}"/>
            	<!-- <input type="hidden" id="pNo" name="pNo" value=""> -->
            <button id="mybtn" type="submit">전문가 채팅 연결하기</button>
            </form>
        </div>
    </main>

    <!------- footerStart ------->
    <footer id="footer">
        <section id="bottom" class="clearfix">
            <div class="phone">
                <p><span>1599-2121</span></p>
                <p>평일 10:00 - 18:00</p>
                <p>(점심시간 13:00 - 14:00 제외·주말/공휴일 제외)</p>
                <ul class="sns">
                    <li><i class="fab fa-facebook"></i></li>
                    <li><i class="fab fa-instagram"></i></li>
                    <li><i class="fab fa-youtube"></i></li>
                </ul>
            </div>
            <div class="service">
                <ul>
                    <li class="sevName">해요소개</li>
                    <li>회사소개</li>
                    <li>채용안내</li>
                </ul>
                <ul>
                    <li class="sevName">고객안내</li>
                    <li>이용안내</li>
                    <li>안전정책</li>
                    <li>예상금액</li>
                    <li>전문가소개</li>
                </ul>
                <ul>
                    <li class="sevName">전문가안내</li>
                    <li>이용안내</li>
                    <li>전문가가이트</li>
                    <li>전문가가입</li>
                </ul>
                <ul>
                    <li class="sevName">고객센터</li>
                    <li>공지사항</li>
                    <li>자주묻는질문</li>
                </ul>
            </div>
        </section>
        <section id="bottomtxt">
            <p>(주)해요모바일은 통신판매중개자로서 통신판매의 당사자가 아니며 개별 판매자가 제공하는 서비스에 대한 이행, 계약사항 등과 관련한 의무와 책임은 거래당사자에게 있습니다.</p>
            <p>상호명:(주)해요모바일 · 대표이사:1조 · 개인정보책임관리자:1조 · 주소:서울특별시 마포구 거구장, 지하 1층(커틀 타워)</p>
            <p>사업자등록번호:111-22-34323 · 통신판매업신고증:제 2015-서울강남-00567 호 · 직업정보제공사업 신고번호:서울청 제 2019-21호</p>
            <p>고객센터:1599-2121 · 이메일:heayo@heayo.com</p>
            <p class="copy">Copyright heayo Web Inc. All Rights Reserved.</p>
        </section>
    </footer>
    <!------- footerEND ------->
</wrap>
</body>

</html>