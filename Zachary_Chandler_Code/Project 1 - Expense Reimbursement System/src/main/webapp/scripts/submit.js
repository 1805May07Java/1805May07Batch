window.onload = function() {
	$('#submitForm').submit(submit);
};

let submit = function() {
	
	let amount=$('#ticketAmount').val() * 100;
	let type=$('#ticketType').find(':selected')[0].innerText;
	let desc=$('#ticketDescription').val();
	
	$.ajax({
		method: "post",
		url: "submitTicket",
		data: `amount:${amount}\ntype:${type}\ndescription:${desc}`,
		
		success: function(resp, status, xhr) {
			if (resp === "submitted") {
				window.location.href = "/ers/home.html";
			} else {
				console.log(resp)
			}
		},
	
		error: function(e) {
			console.log(`error ${e}`);
		}
	});
	
	return false;
};

