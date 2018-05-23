



function fizzBuzz(input)
{
    var fizz = 'Fizz';
    var buzz = 'Buzz';

    for(let i = 1; i <=input; i++)
    {

    }


}




function validateISBN(){

    var input = document.getElementById("fizzy").value;

    var numRegEx = /^[0-9]+$/;

    if(! (numRegEx.test(input) & input.length == 10)){

        document.getElementById("warn").hidden = false;

        document.getElementById("FzBz").setAttribute("disabled", true);

        document.getElementById("warn").innerHTML = "Not valid input. Please enter a number";

    }
    else
    {

        document.getElementById("warn").hidden = true;

        document.getElementById("FzBz").removeAttribute("disabled");

    }



}