// 1. USA
// Define function getUSA()
// Find the html element that contains "USA".
// Print that element's contents.
function getUSA(){
    console.log($("span:contains(USA)").html());
}
  
// 2. Sales
// Define function getPeopleInSales()
// Print the names of all the people in the sales department.
function getPeopleInSales(){
    $("td:contains(Sales)").siblings().each( function() {
        console.log($( this ).text() );
      });
}
  
// 3. Click Here
// Define function getAnchorChildren()
// Find all anchor elements with a <span> child.
// Print the contents of <span>
function getAnchorChildren(){
    $("a span").each(
        function(){
            console.log($(this).text());
        }
    );
}

// 4. Hobbies
// Define function getHobbies()
// Find all checked options in the 'skills' select element.
// Print the value and the contents.
function getHobbies(){
    $("[name='hobbies'] [selected='selected']").each(
        function(){
            console.log($(this).text());
        }
    );
}

// 5. Custom Attribute
// Define function getCustomAttribute()
// Find all elements with "data-customAttr" attribute
// Print the value of the attribute.
// Print the element that has the attribute.
function getCustomAttribute(){
    $("[data-customAttr]").each(
        function(){
            console.log(`${$(this).prop("tagName")}: ${$(this).attr("data-customAttr")}`);
        }
    );
}

// 6. Sum Event
// NOTE: Write unobtrusive Javascript
// Regarding these elements:
// 	<input id="num1" class="nums" type="text"/>
// 	<input id="num2" class="nums" type="text"/>
// 	<h3>Sum: <span id="sum"></span></h3>
// Define onchange event handler.
// Add <input> element values.
// Put the sum in the <span> element.
// If values cannot be added, put "Cannot add" in the <span> element
$(function(){

$("#num1, #num2").change(
    function(){
        var num1 = parseInt($("#num1").val());
        var num2 = parseInt($("#num2").val());

        if(isNaN(num1) || isNaN(num2))
        {
            $("#sum").text("Cannot add");
        }
        else
        {
            $("#sum").text(num1+num2);
        }
    }
);

});

// 7. Skills Event
// NOTE: Write unobtrusive Javascript
// When user selects a skill, create an alert with a message similar to:
// 	"Are you sure CSS is one of your skills?"
// NOTE: no alert should appear when user deselects a skill.
$(function(){
    $("[name='skills']").change(
        function(){
        alert(`are you sure ${$("[name='skills'] :selected").text()} is one of your skills?`);
    }
    );
});

// 8. Favorite Color Event
// NOTE: Write unobtrusive Javascript
// NOTE: This is regarding the favoriteColor radio buttons.
// When a user selects a color, create an alert with a message similar to:
// 	"So you like green more than blue now?"
// In this example, green is the new value and blue is the old value.
// Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor
$(function(){

    var prevColor;

    $("[name='favoriteColor']").change(
            function(){
                //var previousColor = $("[name='favoriteColor']").prop("checked", true).val()
                
                if(prevColor){
                    alert(`So you like ${$(this).val()} more than ${prevColor} now?`);
                    $("#firstForm").css("background-color", `${$(this).val()}`);
                }

                prevColor = $(this).val();
            }
    );


});

// 9. Show/Hide Event
// NOTE: Write unobtrusive Javascript
// When user hovers over an employees name:
// 	Hide the name if shown.
// 	Show the name if hidden.
$(function(){
    $(".empName").hover(
        //on enter
        function(){
            $(this).fadeTo(1,0);
        }
        ,
        //on exit
        function(){
            $(this).fadeTo(1,1);
        }
    );

});

// 10. Current Time
// Regarding this element:
// 	<h5 id="currentTime"></h5>
// Show the current time in this element in this format: 9:05:23 AM
// The time should be accurate to the second without having to reload the page.
$(function(){
    setInterval(
        function()
        {
            var time = new Date().toLocaleTimeString();
            $("#currentTime").text(time);
        }
        ,1000);
});

// 11. Delay
// Regarding this element:
// 	<p id="helloWorld">Hello, World!</p>
// Three seconds after a user clicks on this element, change the text to a random color.
$(function(){

    $("#helloWorld").click(
        function(){
            setTimeout(
                
                function(){
                    $("#helloWorld").css("color", `rgb(${Math.random()*255}, ${Math.random()*255}, ${Math.random()*255})`);
                }
                
                ,3000);
        }
    );

});

// 12. Walk the DOM
// Define function walkTheDOM(node, func)
// This function should traverse every node in the DOM. Use recursion.
// On each node, call func(node).
function walkTheDOM(node, func)
{
    func(node);
    if(node.children().length > 0)
    {
    node.children().each(
        function(){
        walkTheDOM($(this), func);
    }
    );
}
}

function testWalkDom(){
    var ivisited = function(node){console.log(`Visited ${node.prop("tagName")}`)};
    walkTheDOM($("html"), ivisited);
}

