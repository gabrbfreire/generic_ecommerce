//CATEGORIES AND PRODUCTS
//Gets products and creates cards
function getProductsByCategory(category = 1) {
  $(document).ready(function () {
    $.ajax({
      type: "GET",
      url: "getProductsByCategoryId",
      data: {
        categoryId: category
      },
      success: (data) => makeProductsHTML(data)
    })
  });
}

function makeProductsHTML(data) {
  let productsHTML = "";
  $('#products-cards').empty();
  data.forEach(element => {
    productsHTML += '<div class="col-lg-4 col-md-6 mb-4" id="productId=' + element.product_id + '"><div class="card h-100"><a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a><div class="card-body"><h4 class="card-title"><a href="#">' + element.product_name + '</a></h4><h5>$' + element.product_price + '</h5><p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur!</p></div><div class="card-footer"><small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small></div></div></div>';
  });
  //add product description and photo
  $('#products-cards').append(productsHTML);
}


//Gets categories and creates categories list
function getCategories() {
  $(document).ready(function () {
    $.ajax({
      type: "GET",
      url: "getCategories",
      success: (data) => makeCategoriesHTML(data)
    })
  });
};

function makeCategoriesHTML(data) {
  let categoriesHTML = "";
  data.forEach(element => {
    categoriesHTML += '<li class="categories-item list-group-item p-2" id="categoryId' + element.categories_id + '">' + element.categories_title + '</li>';
  });
  $('#categories-list').append(categoriesHTML);
  data.forEach(element => {
    let itemId = "#categoryId" + element.categories_id;
    $(itemId).click(() => {
      getProductsByCategory(element.categories_id);
      $('.categories-item').css('background-color', '#ffffff');
      $('.categories-item').css('color', 'black');
      $(itemId).css('background-color', '#6c757d');
      $(itemId).css('color', 'white');
    })
  });
  $('#categoryId1').css('background-color', '#6c757d');
  $('#categoryId1').css('color', 'white');
}

getCategories();
getProductsByCategory();


//SEARCH BAR
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
  console.log(data);
  data.forEach(element => {
    productsFoundHTML += '<button type="button" class="list-group-item list-group-item-action col-8" id="found-product-' + element.product_id + '">' + element.product_name + '</button>';
  });
  $('#search-results-list').append(productsFoundHTML);
}

//Search bar submit
$('#search-input').submit((e) => {
  e.preventDefault();
  $('.categories-item').css('background-color', '#ffffff');
  $('.categories-item').css('color', 'black');

  let searchValue = $('#product-search-input').val()
  $.ajax({
    type: "GET",
    url: "getProductsList",
    data: {
      name: searchValue,
    },
    success: (data) => makeProductsHTML(data)
  })
});