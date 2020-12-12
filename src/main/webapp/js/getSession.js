//Check session
let userData;
$.ajax({
  type: "GET",
  url: "getSession",
  success: (data) => {
    $('#navbar').empty();
    $('#navbar').append('<li class="nav-item"><a class="nav-link" href="#">' + data + '</a></li><li class="nav-item"><a class="nav-link" href="logout">Logout</a></li><li class="nav-item"><a class="nav-link" href="cart">Cart: 1 Item</a></li>');
    userData = data;
  },
});