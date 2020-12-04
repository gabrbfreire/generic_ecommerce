/* $.ajax({
  type: "POST",
  url: "boards",
  data: {boardName: boardName},
  success:function() {
      getBoards();
      $('#board-name').val('');
  }
}); */

let categoriesHTML = "";
let productsHTML = "";



//Gets products and creates cards
function getProductsByCategory() {
  $(document).ready(function () {
    $.ajax({
      type: "GET",
      url: "getProductsByCategoryId",
      data: {
        categoryId: 1
      },
      success: (data) => makeProductsHTML(data)
    })
  });
}

function makeProductsHTML(data) {
  data.forEach(element => {
    console.log(element);
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
  data.forEach(element => {
    categoriesHTML += '<li class="categories-item list-group-item p-2" id="categoryId=' + element.categories_id + '">' + element.categories_title + '</li>';
  });
  $('#categories-list').append(categoriesHTML);
}

getCategories();
getProductsByCategory();


