

document.getElementById('FzBz').addEventListener('click', run);


function run()
{
    var n = document.getElementById('fizzy').value;
    var arg = fizzBuzz(n);
    var text = "";
    for(let i = 1; i< arg.length; i++)
    {
        console.log(arg[i]);
        text = text + ' ' +arg[i];
    }
    document.getElementById('landing zone').innerHTML = text;
}


function fizzBuzz(input)
{
    
    var arr = [];

    for(let i = 1; i <=input; i++)
    {
		if (i%15 === 0)
		{
			arr[i] = "FizzBuzz";
		}
		else if(i % 5 ===0 )
		{
			arr[i] = "Buzz";
		}
		else if(i % 3 ===0)
		{
			arr[i] = "Fizz";
		}
		else
		{
			arr[i] = i;
		}
    }
    
    return arr;

}


function validateInput(){

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