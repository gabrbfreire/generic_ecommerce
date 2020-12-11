$('#register-form').on('submit', function (e) {
  e.preventDefault();

  let name = $('#user-name').val();
  let email = $('#user-email').val();
  let password = $('#user-password').val();
  let passwordRepeat = $('#user-repeat-password').val();

  if (password == passwordRepeat) {
    register(name, email, password);
  } else {
    document.getElementById('result').innerHTML = "Passwords do not match";
  }
});

function register(name, email, password) {
  $.ajax({
    type: "GET",
    async: "false",
    url: "logout",
    success: (data) => makeProductsHTML(data)
  });

  $.ajax({
    type: "POST",
    url: "signup",
    data: { name: name, email: email, password: password },
    success: function () {
      window.location.href = 'cart'
    },
    error: function () {
      $('#result').text('User already exists');
    }
  })
}