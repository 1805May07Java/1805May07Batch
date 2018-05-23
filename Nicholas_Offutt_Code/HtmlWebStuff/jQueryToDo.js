

$("#toBuy > li").on("click", moveItem)


$("#add").on("click", function(){
    var text = $("#newItem").val();
    var item = document.createElement("li");
    if(text != "")
    {
    item.innerHTML = text;
    $(item).on("click", moveItem)
    $("#toBuy").append(item);
    $("#newItem").val("");
    }
});


function moveItem()
{
    $('#bought').append(this);
}
    
