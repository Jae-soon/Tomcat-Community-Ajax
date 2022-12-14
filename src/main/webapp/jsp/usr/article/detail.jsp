<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.ll.comu.article.dto.ArticleDto" %>

<%
    ArticleDto article = (ArticleDto)request.getAttribute("article");
%>

<%@ include file="../common/head.jsp"%>

<section>
    <div class="container px-3 mx-auto">
        <h1 class="font-bold text-lg">게시물 상세페이지</h1>
        <div>
            <% if ( article != null ) { %>
            <div>
                ID : ${article.id}
            </div>
            <div>
                TITLE : ${article.title}
            </div>
            <div>
                CONTENT : ${article.content}
            </div>
            <% } %>
        </div>
    </div>
</section>

<%@ include file="../common/foot.jsp"%>