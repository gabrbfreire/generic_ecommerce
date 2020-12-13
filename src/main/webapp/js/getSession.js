//Check session
let userData;
$.ajax({
  type: "GET",
  url: "getSession",
  success: (data) => {
    $('#navbar').empty();
    $('#navbar').append('<li class="nav-item"><a class="nav-link" href="#">' + data + '</a></li><li class="nav-item"><a class="nav-link" href="logout">Logout</a></li>');
    userData = data;
    $.ajax({
      type: "GET",
      url: "getProductsUserCart",
      success: (data) => {
        if (data.length > 1) {
          $('#navbar').append('<li class="nav-item"><a class="nav-link" href="cart">Cart: ' + data.length + ' Items</a></li>');
        } else {
          $('#navbar').append('<li class="nav-item"><a class="nav-link" href="cart">Cart: ' + data.length + ' Item</a></li>');
        }
      },
    })
  },
});