/*
-----------------------------------------------------------------------------------
| PART II                                                                         |
-----------------------------------------------------------------------------------

/*
1. USA
Define function getUSA()
Find the html element that contains "USA".
Print that element's contents.
*/
function getUSA() {
    return $("span").filter(function () {
        return $(this).text() == 'USA'
    }).text()

}

/*
2. Sales
Define function getPeopleInSales()
Print the names of all the people in the sales department.
*/
function getPeopleInSales() {
    $('.empName').each(function () {
        console.log($(this).text())
    }
    )
}

/*
3. Click Here
Define function getAnchorChildren()
Find all anchor elements with a <span> child.
Print the contents of <span>
*/
function getAnchorChildren() {
    var anchors = $('a');
    for (anchor of anchors) {
        anchor.childNodes.forEach(
            function (node) {
                if (node.nodeName == 'SPAN') {
                    console.log(node.innerText);
                }
            }
        )
    }
}

/*
4. Hobbies
Define function getHobbies()
Find all checked options in the 'skills' select element.
Print the value and the contents.
*/
function getHobbies() {
    let skills = $("[name='skills']");
    console.log(skills.val());
}

/*
5. Custom Attribute
Define function getCustomAttribute()
Find all elements with "data-customAttr" attribute
Print the value of the attribute.
Print the element that has the attribute.
*/
function getCustomAttribute() {
    $('[data-customAttr]').each(function (i, e) { console.log(e) })
}

/*
10. Current Time
Regarding this element:
	<h5 id="currentTime"></h5>
Show the current time in this element in this format: 9:05:23 AM
The time should be accurate to the second without having to reload the page.
*/
let time = $('#currentTime');
window.onload = setInterval(function () {
    time.html(`${new Date().toLocaleTimeString()}`);
}, 1000);


/* 
11. Delay
Regarding this element:
	<p id="helloWorld">Hello, World!</p>
Three seconds after a user clicks on this element, change the text to a random color.
*/
$('#helloWorld').on('click',
    function () {
        $(this).css('color', randomColor())
    });

function randomColor() {
    let color = '#';
    for (let i = 0; i < 6; i++) {
        let rgbComponent = Math.floor(Math.random() * 16);
        let hexVal = rgbComponent.toString(16);
        color += hexVal;
    }
    return color;
}