function makeProductsHTML(data) {
  let productsHTML = "";
  $('#products-cards').empty();
  console.log(data)
  data.forEach(element => {
    productsHTML += '<div class="col-lg-4 col-md-6 mb-4" id="productId=' + element.product_id + '"><div class="card h-100"><a href="product?productId=' + element.product_id + '" class="d-flex justify-content-center"><img class="card-img-top" src="' + element.product_image_link + '" alt=""></a><div class="card-body"><h4 class="card-title"><a href="product?productId=' + element.product_id + '">' + element.product_name + '</a></h4><h5>$' + element.product_price + '</h5><p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur!</p></div><div class="card-footer"><small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small></div></div></div>';
  });
  //add product description and photo
  $('#products-cards').append(productsHTML);
}