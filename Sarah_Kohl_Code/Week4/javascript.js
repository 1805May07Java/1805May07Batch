// 1. USA
// Define function getUSA()
// Find the html element that contains "USA".
// Print that element's contents.
function getUSA(){
    walkTheDOM(document.body, function(node){
        if(node.innerText==="USA")
        {
            console.log(node.innerText);
        }
    }
    );
}

// 2. Sales
// Define function getPeopleInSales()
// Print the names of all the people in the sales department.
//TODO
function getPeopleInSales(){
walkTheDOM(document.body, function(node){
    if(node.text==="Sales")
    {
        for (var e=0;e<parentNode.childNodes.length;e++)
        {
            console.log(node.parentNode.childNodes[e].innerText);
        }
    }
}
);
}
  
// 3. Click Here
// Define function getAnchorChildren()
// Find all anchor elements with a <span> child.
// Print the contents of <span>
function getAnchorChildren(){
        document.querySelectorAll("a span").forEach(
        element => {console.log(element.innerHTML)}
    );
}

// 4. Hobbies
// Define function getHobbies()
// Find all checked options in the 'skills' select element.
// Print the value and the contents.
function getHobbies(){
        document.querySelectorAll("[name='hobbies'] [selected='selected']").forEach(
        element => {console.log(element.innerHTML)}
    );
}

// 5. Custom Attribute
// Define function getCustomAttribute()
// Find all elements with "data-customAttr" attribute
// Print the value of the attribute.
// Print the element that has the attribute.
function getCustomAttribute(){
        document.querySelectorAll("[data-customAttr]").forEach(
            element => {console.log(`${element.tagName}: ${element.getAttribute("data-customAttr")}`);}
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
         document.getElementById("num1").addEventListener("input", changeNumbers);
         document.getElementById("num2").addEventListener("input", changeNumbers); 

function changeNumbers(){
    var num1 = parseInt(document.getElementById("num1").value);
        var num2 = parseInt(document.getElementById("num2").value);
        if(isNaN(num1) || isNaN(num2))
        {
            //$("#sum").text("Cannot add");
            document.getElementById("sum").innerText = "Cannot Add";
        }
        else
        {
            document.getElementById("sum").innerText = num1 + num2;
        }
    
}

// 7. Skills Event
// NOTE: Write unobtrusive Javascript
// When user selects a skill, create an alert with a message similar to:
// 	"Are you sure CSS is one of your skills?"
// NOTE: no alert should appear when user deselects a skill.
document.querySelectorAll("[name='skills']")[0].addEventListener("change", changeSkill);
function changeSkill(){
    var e = document.querySelectorAll("[name='skills']")[0];
    alert(`Are you sure ${e.options[e.selectedIndex].text} is one of your skills?`);
}

// 8. Favorite Color Event
// NOTE: Write unobtrusive Javascript
// NOTE: This is regarding the favoriteColor radio buttons.
// When a user selects a color, create an alert with a message similar to:
// 	"So you like green more than blue now?"
// In this example, green is the new value and blue is the old value.
// Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor
//TODO
var prevColor;
document.querySelectorAll("[name='favoriteColor']").forEach(
    function(e){e.addEventListener("onchange", changeColor);}
);
function changeColor(){
    var prevColorVal = document.querySelector('input[name = "favoriteColor"]:checked').value;
    console.log("function call");
    if(prevColor)
    {
        console.log("if block");
        document.getElementById("firstForm").setAttribute("style", `background-color: ${prevColorVal}`);;
    }
    prevColor = document.querySelector('input[name = "favoriteColor"]:checked');
}

// });

// 9. Show/Hide Event
// NOTE: Write unobtrusive Javascript
// When user hovers over an employees name:
// 	Hide the name if shown.
// 	Show the name if hidden.
//TODO
document.querySelectorAll(".empName").forEach(
element => {
    element.addEventListener("mouseover",element => {element.setAttribute("style", "opacity: 0;");});
    element.addEventListener("mouseout", element => {element.setAttribute("style", "opacity: 1;");});
}
);

// 10. Current Time
// Regarding this element:
// 	<h5 id="currentTime"></h5>
// Show the current time in this element in this format: 9:05:23 AM
// The time should be accurate to the second without having to reload the page.
setInterval(
    () => {
        var time = new Date().toLocaleTimeString();
        document.getElementById("currentTime").innerText = time;
    }
    ,1000);

// 11. Delay
// Regarding this element:
// 	<p id="helloWorld">Hello, World!</p>
// Three seconds after a user clicks on this element, change the text to a random color.
document.getElementById("helloWorld").addEventListener("click", 
() => {setTimeout(
    ()=>{document.getElementById("helloWorld").setAttribute("style", `color: rgb(${Math.random()*255}, ${Math.random()*255}, ${Math.random()*255})`);}
    ,3000);}
);

// 12. Walk the DOM
// Define function walkTheDOM(node, func)
// This function should traverse every node in the DOM. Use recursion.
// On each node, call func(node).
function walkTheDOM(node, func){
func(node);
    if(node.children.length > 0)
    {       
        for(var e=0; e<node.children.length;e++)
        {
            walkTheDOM(node.children[e], func);
        }
    }
}

function testWalkDom(){
    var ivisited = function(node){console.log(`Visited ${node.tagName}`)};
    walkTheDOM(document, ivisited);
}

