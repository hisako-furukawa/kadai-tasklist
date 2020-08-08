<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="../layout/app.jsp">
    <c:param name="content">
    <c:choose>
    <c:when test="${tasklist != null}">
        <h2>id : ${tasklist.id} のタスク詳細ページ</h2>

        <table>
        <tboby>
        <tr>
        <th>タスク</th>
        <td><c:out value="${tasklist.content}" /></p></td>
        </tr>
        <tr>
        <th>作成日時</th>
        <td><fmt:formatDate value="${tasklist.created_at}" pattern="yyyy-MM-dd HH:mm:ss" /></p></td>
        </tr>
        <tr>
        <th>更新日時</th>
        <td><fmt:formatDate value="${tasklist.updated_at}" pattern="yyyy-MM-dd HH:mm:ss" /></p></td>
        </tr>
        </tboby>
        </table>

        <p><a href="${pageContext.request.contextPath}/index">一覧に戻る</a></p>
        <p><a href="${pageContext.request.contextPath}/edit?id=${tasklist.id}">このタスクを編集する</a></p>
        </c:when>
        <c:otherwise>
        <h2>お探しのデータは見つかりませんでした。</h2>
        </c:otherwise>
        </c:choose>
    </c:param>
</c:import>