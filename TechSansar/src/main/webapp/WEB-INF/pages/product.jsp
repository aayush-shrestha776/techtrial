<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="jakarta.servlet.http.HttpSession"%>
<%@ page import="jakarta.servlet.http.HttpServletRequest"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>TechSansar</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/product.css" />
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css"/>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/footer.css"/>
</head>
<body>
  <c:set var="contextPath" value="${pageContext.request.contextPath}" />
  <jsp:include page="header.jsp" />

  <div class="products">
    <!-- Skeleton View -->
    <c:if test="${showSkeleton}">
      
        <div class="product-card">
          <div class="skeleton skeleton-image"></div>
          <div class="skeleton skeleton-name"></div>
          <div class="skeleton skeleton-price"></div>
          <div class="skeleton skeleton-description"></div>
          <div class="skeleton skeleton-button"></div>
        </div>
     
    </c:if>

    <!-- Real Products -->
    <c:if test="${!showSkeleton}">
      <c:forEach var="product" items="${product}">
        <div class="product-card">
        <!-- Image -->
          <img src="${contextPath}/resources/images/system/${product.imageUrl}" alt="${product.name}" />
          <!-- Name -->
          <div class="product-title">${product.name}</div>
          <!-- price -->
          <div>
          <span class="price">Rs. ${product.price}</span>
          </div>
          <!-- description -->
          <div class="description">${product.description}</div>
          <!-- add to cart -->
          <button class="add-to-cart">ADD TO CART</button>
        </div>
      </c:forEach>
    </c:if>
  </div>

  <jsp:include page="footer.jsp" />
</body>
</html>

