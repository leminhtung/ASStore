<%-- 
    Document   : productItem
    Created on : Apr 26, 2018, 10:16:55 PM
    Author     : zerox
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col-sm-12 col-md-6 col-lg-4 p-b-50">
  <!-- Block2 -->
  <div class="block2">
    <div class="block2-img wrap-pic-w of-hidden pos-relative">
      <img src="assets/img/products/${param.image}" alt="IMG-PRODUCT">

      <div class="block2-overlay trans-0-4">
        <div class="block2-btn-addcart w-size1 trans-0-4">
          <!-- Button -->
          <button class="flex-c-m size1 bg4 bo-rad-23 hov1 s-text1 trans-0-4">
            Add to Cart
          </button>
        </div>
      </div>
    </div>

    <div class="block2-txt p-t-20">
      <a href="product-detail.html" class="block2-name dis-block s-text3 p-b-5">
        ${param.name}
      </a>

      <span class="block2-price m-text6 p-r-5">
        $${param.price}
      </span>
    </div>
  </div>
</div>
