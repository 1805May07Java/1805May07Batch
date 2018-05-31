
let requireLogin = function() {

	$.ajax({
		method: "get",
		url: "getUser",
		
		success: function(resp, status, xhr) {
			if (!resp) {
				window.location.href = "/ers/login.html";
			} else {
				user = resp;
			}
		},
	
		error: function(e) {
			window.location.href = "/ers/login.html";
		}
	});
}

requireLogin();
