<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <header>
        <div class="navbar">
            <div class="logo">
                <!-- 로고 이미지 추가 -->
                <img src="path/logo.png" alt="R&R" class="logo-img">
            </div>
            <nav>
                <ul>
                    <li><a href="#">베스트셀러</a></li>
                    <li><a href="#">도구</a></li>
                    <li><a href="#">내 프로필</a></li>
                </ul>
            </nav>
            <div class="profile">
                <!-- 세션에서 사용자 이름 가져오기 -->
                <span><%= session.getAttribute("username") != null ? session.getAttribute("username") : "Guest" %></span>
            </div>
        </div>
    </header>

    <main>
        <div class="search-container">
            <input type="text" placeholder="검색..." class="search-input">
            <button class="search-button">🔍</button>
        </div>
    </main>
</body>
</html>
