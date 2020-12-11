let userName = "";

window.onload = () => {
  let searchValue = (window.location.href).slice((window.location.href).indexOf("=") + 1)
  $.ajax({
    type: "GET",
    url: "getProductsById",
    data: {
      productId: searchValue,
    },
    success: (data) => makeProductHTML(data)
  });

  $.ajax({
    type: "GET",
    url: "getSession",
    success: (data) => { userName = data; console.log(userName) }
  });
};

function makeProductHTML(data) {
  let productHTML = "";
  productHTML += '<div class="card h-100"><a href="#"><img class="card-img-top" src="http://placehold.it/700x200" alt=""></a><div class="card-body"><h4 class="card-title"><a href="#">' + data.product_name + '</a></h4><h5>$ ' + data.product_price + '</h5><p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur!</p ></div ><div class="card-footer"><small class="text-muted">★ ★ ★ ★ ☆</small><button type="button" class="btn btn-primary float-right" id="add-to-cart-button">Add to cart</button></div></div >';
  $('#product-card').append(productHTML);

  console.log(userName.length)
  if (userName.length > 0) {
    $('#add-to-cart-button').click(() => {
      $.ajax({
        type: "POST",
        url: "addItemUserCart",
        data: {
          productId: data.product_id
        },
        success: window.location.href = "cart"
      })
    })
  } else {
    $('#add-to-cart-button').click(() => {
      $.ajax({
        type: "POST",
        async: "false",
        url: "addClickedProduct",
        data: {
          productId: data.product_id
        },
        success: window.location.href = "cart"
      })
    })
  }
}

