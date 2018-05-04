<%-- 
    Document   : products-details
    Created on : May 1, 2018, 9:10:32 PM
    Author     : Tien Phat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:adminLayout>
    <div class="container">
        <a href="javascript:history.back()" class="s-text2">&lt; Back</a>
    <div>
        <p style="font-weight: bold">Seller phone number</p>
        <p>${product.usersId.phoneNumber}</p>
    </div>
    <div>
        <p style="font-weight: bold">Product Id</p>
        <p>${product.id}</p>
    </div>
    <div>
        <p style="font-weight: bold">Product Name</p>
        <p>${product.name}</p>
    </div>
    <div>
        <p style="font-weight: bold">Category</p>
        <p>${product.categoryId.name}</p>
    </div>
    <div>
        <p style="font-weight: bold">Anime</p>
        <p>${product.animeId.name}</p>
    </div>
    <div>
        <p style="font-weight: bold">Image</p>
        <div>
          <c:forEach items="${images}" var="image">
                <img src="<c:url value="/assets/img/products/${image}"/>" height="150px" width="150px"/>
           </c:forEach>
        </div>
    </div>
    <div>
        <p style="font-weight: bold">Price</p>
        <p>${product.price}</p>
    </div>
    <div>
        <p style="font-weight: bold">Quantity</p>
        <p>${product.quantity}</p>
    </div>
    <div>
        <p style="font-weight: bold">Description</p>
        <textarea style="width: 200px; height: 100px">${product.description}</textarea>
    </div>
</div>    
</t:adminLayout>

