
window.onload = function() {
    $('#ourList').on('click', 'li', function(){
        $('#boughtList').append(this);
    })
}

addItem = function() {
    let value = $("#toAddValue").val();

    if (value != "") {
        $("#ourList").append(`<li class='toBuy'> ${value}</li>`);
        $("#toAddValue").val("")
    }
    

}
