function deal() {
	var xhr = new XMLHttpRequest();
	xhr.open("post", "/niceserv", true);
	xhr.onreadystatechange = thecall;
}

function thecall() {

}


// $("#test").on('click', (e) => {
// 	var inputs = document.getElementsByClassName("login").value;
// 	for(let i=0; i<inputs.length; i++) {
// 		console.log(inputs[i])
// 	}
// 	$.ajax({
// 		url: niceserv,
// 		dataType: "json",
// 		type: "post",
// 		data: {
// 			action: "post",
// 			username: inputs[0],
// 			password: inputs[1]
// 		},
// 		success: (nice) => {
// 			console.log(nice);
// 			document.getElementById("stuff").innerHTML = nice;
// 		}
// 	})
// })