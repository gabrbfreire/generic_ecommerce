

$('#login-form').on('submit', function (e) {
  e.preventDefault();

  let email = $('#user-email').val();
  let password = $('#user-password').val();

  login(email, password);
});

function login(email, password) {
  $.ajax({
    type: "GET",
    async: "false",
    url: "logout",
    success: (data) => makeProductsHTML(data)
  });

  $.ajax({
    type: "POST",
    url: "login",
    data: { email: email, password: password },
    success: function () {
      window.location.href = 'cart'
    },
    error: function () {
      $('#result').text('Incorrect email or password');
    }
  });
}