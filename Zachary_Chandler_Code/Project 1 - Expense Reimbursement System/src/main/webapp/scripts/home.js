
let moneyFormat = function(n) {
	return `${Math.floor(n/100)}.${n%100}`
}


$.ajax({
	method : "get",
	url : "getTickets",

	success : function(resp, status, xhr) {
		console.log(resp);
		for (let i = 0; i < resp.length; i++) {
	        $('#reimbursement-body').append(`<tr id="${resp[i].id
	        }"><td>$${moneyFormat(resp[i].ammount)
	        }</td><td>${resp[i].author.firstName} ${resp[i].author.lastName
	        }</td><td>${resp[i].type
	        }</td><td>${resp[i].submitted
	        }</td><td>${resp[i].status
	        }</td></tr>`)
	    }
		
		$('#reimbursment-display').DataTable({
			paging: false,
			info: false,
			order: [[3, 'desc'], [1, 'asc'], [4, 'desc'], [2, 'asc'], [0, 'asc']]
		});
		
		let fil = $('#reimbursment-display_filter')[0];
		fil.classList.add("text-right");
		fil.children[0].children[0].classList.add("ml-2");
		
		$('tbody tr').on('click', function(e) {
			window.location.href=`/ers/resolveTicket.html?id=${e.currentTarget.id}`
		});
	},

	error : function(e) {
		console.log(`error ${e}`);
	}
});
