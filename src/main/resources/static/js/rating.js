// adds checked class to star rating
function addChecked (rating) {
    let one = '';
    let two = '';
    let three = '';
    let four = '';
    let five = '';
    if (rating === '1') {
        one += 'checked';
    } else if (rating === '2') {
        one += 'checked';
        two += 'checked';
    } else if (rating === '3') {
        one += 'checked';
        two += 'checked';
        three += 'checked';
    } else if (rating === '4') {
        one += 'checked';
        two += 'checked';
        three += 'checked';
        four += 'checked';
    } else if (rating === '5') {
        one += 'checked';
        two += 'checked';
        three += 'checked';
        four += 'checked';
        five += 'checked';
    }
}

    let starRating = (rating) => {
        if (rating === "1") {
            return addChecked(rating);
        } else if (rating === "2") {
            return addChecked(rating);
        } else if (rating === "3") {
            return addChecked(rating);
        } else if (rating === "4") {
            return addChecked(rating);
        } else if (rating === "5") {
            return addChecked(rating);
        }
    };


