
/* From: http://www.jquerybyexample.net/2012/06/get-url-parameters-using-jquery.html */
let GetURLParamater = function(sParam) {
	var sPageURL = window.location.search.substring(1);
    var sURLVariables = sPageURL.split('&');
    
    for (var i = 0; i < sURLVariables.length; i++) {
        var sParameterName = sURLVariables[i].split('=');
        if (sParameterName[0] == sParam) {
            return sParameterName[1];
        }
    }
}

let moneyFormat = function(n) {
	return `$${Math.floor(n/100)}.${n%100}`
}

window.onload = function() {
	$('#approve').click(approve);
	$('#deny').click(deny);
	
	$.ajax({
		method: "get",
		url: `getTicket?id=${GetURLParamater('id')}`,
		
		success: function(resp, status, xhr) {
			console.log(resp);
			if (resp) {
				$('#amount').val(moneyFormat(resp.ammount));
				$('#name').val(`${resp.author.firstName} ${resp.author.lastName}`);
				$('#submitted').val(resp.submitted);
				$('#type').val(resp.type);
				$('#status').val(resp.status);
				$('#description').val(resp.description ? resp.description : "-");
				$('#resolved').val(resp.resolved ? resp.resolved : "");
				$('#resolver').val(resp.resolver ? `${resp.resolver.firstName} ${resp.resolver.lastName}` : "");
				
				$('#ticket')[0].classList.remove("d-none");
				
				if (resp.status == "Pending" && user.role == "FinanceManager") {
					$('#action')[0].classList.remove("d-none");
				}
			} else {
				$('#ticket').replaceWith('<h2>Error 404</h2><p>Page not found.</p>')
			}
		},
		
		error: function(e) {
			console.log(`error ${e}`);
		}
	})
}

let approve = function() {
	action("approve");
}

let deny = function() {
	action("deny");
}

let action = function(a) {
	$.ajax({
		method: "get",
		url: `resolveTicket?id=${GetURLParamater('id')}&${a}`,
		
		success: function(resp, status, xhr) {
			window.location.href = "/ers/home.html";
		},
		
		error: function(e) {
			console.log(`error ${e}`);
		}
	});
}