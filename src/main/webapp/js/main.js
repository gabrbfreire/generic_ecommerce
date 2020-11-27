/* $.ajax({
  type: "POST",
  url: "boards",
  data: {boardName: boardName},
  success:function() {
      getBoards();
      $('#board-name').val('');
  }
}); */

function getProductByCategory() {
  $(document).ready(function () {
    $.ajax({
      type: "GET",
      url: "logout",
      success: window.location.href = 'login'
    })
  });
}


function getCategories() {
  $(document).ready(function () {
    $.ajax({
      type: "GET",
      url: "getProductsByCategoryId",
      success: () => console.log(data)
    })
  });
}

getCategories();