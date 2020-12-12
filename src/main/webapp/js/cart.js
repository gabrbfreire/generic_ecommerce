function makeProductsHTML(data) {
  let productsHTML = "";
  let cartTotalPrice = 0;
  $('#products-cards').empty();
  data.forEach(element => {
    productsHTML += '<div class="col-12 mb-4" id="productId=' + element.cart + '"><div class="card h-100"><div class="row"><a href="product?productId=' + element.product_id + '" class="col-12 col-sm-5 mh-50"><img class="card-img-top h-100 w-100" src="http://placehold.it/300x100" alt=""></a ><div class="card-body col-12 col-sm-5"><h4 class="card-title"><a href="product?productId=' + element.product_id + '">' + element.product_name + '</a></h4><h5>$' + element.product_price + '</h5></div><div class="col-2"><button type="button" class="btn btn-danger align-middle">Remove</button></div></div ></div ></div>';
    cartTotalPrice += element.product_price;
  });
  //add product description and photo
  $('#cart-total').html('Total: $' + cartTotalPrice);
  $('#products-cards').append(productsHTML);
}

//Search bar submit
window.onload = () => {
  $.ajax({
    type: "GET",
    url: "getProductSession",
    success: (data) => {
      $.ajax({
        type: "POST",
        url: "addItemUserCart",
        data: {
          productId: data,
        },
        success: () => {
          $.ajax({
            type: "GET",
            url: "getProductsUserCart",
            success: (data) => {
              makeProductsHTML(data)
            }
          })
        }
      })
    },
    error: () => {
      $.ajax({
        type: "GET",
        url: "getProductsUserCart",
        success: (data) => {
          makeProductsHTML(data)
        }
      })
    }
  })
};