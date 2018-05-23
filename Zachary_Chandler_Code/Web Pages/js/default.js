
loadDummyData = function() {
    let arr = [{
		Amount: 35.32,
		Type:  "Travel",
		Description: "Gas money",
		Submitted: "5/21/2018 at 3:10pm",
		Resolved: "-",
		Status: "Pending"
    },{ 
        Amount: 20.91,
		Type:  "Food",
		Description: "Food money",
		Submitted: "5/18/2018 at 8:36pm",
		Resolved: "5/21/2018 at 9:47am",
		Status: "Approved"
    },{ 
        Amount: 15.26,
		Type:  "Food",
		Description: "Food money",
		Submitted: "5/18/2018 at 8:30pm",
		Resolved: "5/21/2018 at 9:45am",
		Status: "Approved"
    },{ 
        Amount: 109.52,
		Type:  "Lodging",
		Description: "Hotel money",
		Submitted: "5/18/2018 at 8:21pm",
		Resolved: "5/21/2018 at 9:44am",
		Status: "Approved"
    },{ 
        Amount: 109.52,
		Type:  "Other",
		Description: "Misc money",
		Submitted: "5/18/2018 at 8:15pm",
		Resolved: "5/21/2018 at 9:40am",
		Status: "Rejected"
    }]

    for (let i = 0; i < arr.length; i++) {
        $('#reimbursment-display').append(`<tr><td>$${arr[i].Amount
        }</td><td>${arr[i].Type
        }</td><td>${arr[i].Description
        }</td><td>${arr[i].Submitted
        }</td><td>${arr[i].Resolved
        }</td><td>${arr[i].Status
        }</td></tr>`)
    }
}



window.onload = loadDummyData