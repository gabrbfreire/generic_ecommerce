//CATEGORIES AND PRODUCTS
//Gets products and creates cards
function getProductsByCategory(category = 1) {
  $.ajax({
    type: "GET",
    url: "getProductsByCategoryId",
    data: {
      categoryId: category
    },
    success: (data) => makeProductsHTML(data)
  })
}


//Gets categories and creates categories list
function getCategories() {
  $.ajax({
    type: "GET",
    url: "getCategories",
    success: (data) => makeCategoriesHTML(data)
  })
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