let cartId = 0;

function makeProductsHTML(data) {
  let productsHTML = "";
  let cartTotalPrice = 0;
  $('#products-cards').empty();

  data.forEach(element => {
    productsHTML += '<div class="col-12 mb-4"><div class="card h-100"><div class="row"><a href="product?productId=' + element.product_id + '" class="col-12 col-sm-3 mh-50"><img class="card-img-top h-100 w-100" src="' + element.product_image_link + '" alt=""></a ><div class="card-body col-12 col-sm-7"><h4 class="card-title"><a href="product?productId=' + element.product_id + '">' + element.product_name + '</a></h4><h5>$' + element.product_price + '</h5></div><div class="col-2"><button type="button" class="btn btn-danger align-middle" id=removeId' + element.product_id + '>Remove</button></div></div ></div ></div>';
    cartTotalPrice += element.product_price;
  });

  //add product description and photo
  $('#cart-total').html('Total: $' + cartTotalPrice.toFixed(2));
  $('#products-cards').append(productsHTML);

  data.forEach(element => {
    let deleteId = '#removeId' + element.product_id;
    $(deleteId).click(() => {
      itemId = $(deleteId).attr('id').substr(8);
      $.ajax({
        type: "DELETE",
        url: "removeItemUserCart",
        data: {
          cartId: cartId,
          productId: itemId,
        },
        success: () => {
          loadProducts()
        }
      })
    });
  });
}

//Search bar submit
window.onload = () => {
  $.ajax({
    type: "GET",
    url: "getUserCart",
    success: (data) => {
      cartId = data.cart_id;
    }
  })


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
      loadProducts();
    }
  })
};

function loadProducts() {
  $.ajax({
    type: "GET",
    url: "getProductsUserCart",
    success: (data) => {
      makeProductsHTML(data)
    }
  })
}