<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="loginId" value="${sessionScope.id }"/>
<c:set var="nickname" value="${sessionScope.nickname }"/>
<c:set var="loginOutLink" value="${sessionScope.id==null ? '/login/login' : '/login/logout'}"/>
<c:set var="loginOut" value="${sessionScope.id==null ? '로그인' : '로그아웃'}"/>
<c:set var="registerYorN" value="${sessionScope.id != null ? sessionScope.nickname : '회원가입' }"/>
<c:set var="registerOrMypage" value="${sessionScope.id != null ? '/mypage/login' : '/register/add' }"/>
<c:set var="mypageLogin" value="${sessionScope.id != null ? '/mypage/login' : '/login/login' }"/>
	<!-- css -->
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/style.css'/>">
	<!-- 폰트 -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700&display=swap" rel="stylesheet">
  	<!-- slick -->
    <link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
	
	<!-- ajax jquery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    
</head>
<body>
    <div class="wrap">
        <header class="header">
            <div class="headerIn">
                <h1 class="logo">
                    <a href="<c:url value='/'/>">
                        <p>또쿡 로고</p>
                    </a>
                </h1>
                <nav class="nav">
                    <ul class="main_nav">
                        <li><a href="<c:url value='/'/>">HOME</a></li>
                        <li><a href="<c:url value='/recipe/list'/>">레시피 보기</a></li>
                        <li><a href="<c:url value='/recipe/make'/>">레시피 만들기</a></li>
                        <li><a>커뮤니티</a></li>
                    </ul>
                    <div class="commu_nav">   
                        <ul class="commu_navUl">
                            <li><a href="<c:url value='/board/cook'/>">요리게시판</a></li>
                            <li><a href="<c:url value='/board/free'/>">자유게시판</a></li>
                        </ul>
                    </div>
                </nav>
                <form action="" class="scBar">
                    <table class="scTable">
                        <tr class="scTr">
                            <td>
                                <label for="sc" class="scP">검색</label>
                                <input type="text" id="sc">
                            </td>
                            <td>
                                <button type="submit" class="scBtn">
                                    <p>검색 아이콘</p>
                                </button>
                            </td>
                        </tr>
                    </table>
                </form>
                <div class="util">
                    <ul>
                    	<li><a href="<c:url value='${registerOrMypage }'/>" >${registerYorN }</a></li>
                        <li><a href="<c:url value='${loginOutLink }'/>">${loginOut }</a></li>
                        <li><a href="<c:url value='${mypageLogin }'/>">마이페이지</a></li>
                    </ul>
                </div>
                <div>
                    <ul>
                        <li></li>
                    </ul>
                </div>   
            </div>
        </header>