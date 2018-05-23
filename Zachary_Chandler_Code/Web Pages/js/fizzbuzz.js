

fizzBuzz = function() {

    let n = $('#fizzBuzzValue').val();

    let list = $('#fizzbuzzList');

    list.empty();

    for (let i = 1; i <= n; i++) {
        let value = '';

        if (i % 3 == 0) {
            value += 'fizz ';
        }

        if (i % 5 == 0) {
            value += 'buzz';
        }

        list.append(`<li>${value}</li>`)
    }

}