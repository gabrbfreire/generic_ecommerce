$('#product-search-input').on('input', () => {
  let searchValue = $('#product-search-input').val()
  if (searchValue.length > 3) {
    $.ajax({
      type: "GET",
      url: "getProductsByNameAjax",
      data: {
        name: searchValue,
      },
      success: (data) => showProductsFound(data)
    })
  }
});

function showProductsFound(data) {
  $('#search-results-list').empty();
  let productsFoundHTML = "";
  data.forEach(element => {
    productsFoundHTML += '<a type="button" href="product?productId=' + element.product_id + '" class="list-group-item list-group-item-action col-8" id="found-product-' + element.product_id + '">' + element.product_name + '</a>';
  });
  $('#search-results-list').append(productsFoundHTML);
}