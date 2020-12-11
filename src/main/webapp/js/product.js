let userData = "";
$.ajax({
  type: "GET",
  url: "getSession",
  success: (data) => {
    $('#navbar').empty();
    $('#navbar').append('<li class="nav-item"><a class="nav-link" href="signin">' + data + '</a></li><li class="nav-item"><a class="nav-link" href="logout">Logout</a></li><li class="nav-item"><a class="nav-link" href="cart">Cart: 1 Item</a></li>');
    userData = data;
  },
});


let searchValue = (window.location.href).slice((window.location.href).indexOf("=") + 1)
$.ajax({
  type: "GET",
  url: "getProductsById",
  data: {
    productId: searchValue,
  },
  success: (data) => makeProductHTML(data)
});


function makeProductHTML(data) {
  let productHTML = "";
  productHTML += '<div class="card h-100"><a href="#"><img class="card-img-top" src="http://placehold.it/700x200" alt=""></a><div class="card-body"><h4 class="card-title"><a href="#">' + data.product_name + '</a></h4><h5>$ ' + data.product_price + '</h5><p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur!</p ></div ><div class="card-footer"><small class="text-muted">★ ★ ★ ★ ☆</small><button type="button" class="btn btn-primary float-right" id="add-to-cart-button">Add to cart</button></div></div >';
  $('#product-card').append(productHTML);

  console.log(userData.length)


  $('#add-to-cart-button').click(() => {
    if (userData.length > 0) {
      $.ajax({
        type: "POST",
        url: "addItemUserCart",
        data: {
          productId: data.product_id
        },
        success: window.location.href = "cart"
      })
    } else {
      $.ajax({
        type: "POST",
        async: "false",
        url: "addClickedProduct",
        data: {
          productId: data.product_id
        },
        success: window.location.href = "cart"
      })
    }
  })
}