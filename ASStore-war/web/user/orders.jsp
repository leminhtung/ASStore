<%-- 
    Document   : orders
    Created on : May 4, 2018, 9:05:24 PM
    Author     : zerox
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>



<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:layout>
  <div class="container">
    <div class="row">
      <div class="col-12 m-l-r-auto m-t-20">
        <h1 class="m-b-20">Your orders</h1>
        <table border="1" style="width: 100%; border-color: #e6e6e6; border: 1px solid #e6e6e6">
          <thead>
            <tr style="text-align: center">
              <th class="text-center p-t-10 p-l-20 p-r-20 p-b-10">ID</th>
              <th class="text-center p-t-10 p-l-20 p-r-20 p-b-10">Date</th>
              <th class="text-center p-t-10 p-l-20 p-r-20 p-b-10">Passcode</th>
              <th class="text-center p-t-10 p-l-20 p-r-20 p-b-10">Status</th>
              <th class="text-center p-t-10 p-l-20 p-r-20 p-b-10">Actions</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${orders}" var="order">
              <c:if test="${order.enabled}">
                <tr>
                  <td class="text-center p-t-10 p-l-20 p-r-20 p-b-10">${order.id}</td>
                  <td class="text-center p-t-10 p-l-20 p-r-20 p-b-10">${order.createAt}</td>
                  <td class="text-center p-t-10 p-l-20 p-r-20 p-b-10">${order.passCode}</td>
                  <td class="text-center p-t-10 p-l-20 p-r-20 p-b-10">
                    <c:choose>
                      <c:when test="${order.delivering == true && order.status == true}">
                        delivered
                      </c:when>
                      <c:when test="${order.delivering == true && order.status == false}">
                        delivering
                      </c:when>
                      <c:when test="${order.delivering == false && order.status == false}">
                        pending
                      </c:when>
                    </c:choose>
                  </td>
                  <td class="text-center p-t-10 p-l-20 p-r-20 p-b-10">
                    <a href="<c:url value="/orders/details?order=${order.id}" />" style="color: #007bff">Details</a>
                    <c:if test="${order.delivering == false || (order.delivering == true && order.status == true)}">
                    || <a href="<c:url value="/orders/delete?order=${order.id}" />" style="color: #c82333">Delete</a>
                    </c:if>
                  </td>
                </tr>
              </c:if>
            </c:forEach>

          </tbody>
        </table>
      </div>
    </div>
  </div>
</t:layout>
