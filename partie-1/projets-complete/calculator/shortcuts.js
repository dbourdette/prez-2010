
function keyCodeToButton(keyCode) {
	var mapping = {48 : '0',
			49 : '1',
			50 : '2',
			51 : '3',
			52 : '4',
			53 : '5',
			54 : '6',
			55 : '7',
			56 : '8',
			57 : '9',
			43 : '+',
			45 : '-',
			13 : '=',
			61 : '=',
			96 : '0',
			97 : '1',
			98 : '2',
			99 : '3',
			100 : '4',
			101 : '5',
			102 : '6',
			103 : '7',
			104 : '8',
			105 : '9',
			107 : '+',
			109 : '-',
			27 : 'C'};
	
	return mapping[keyCode];
}

function onKeyPress(keyCode) {
	var button = keyCodeToButton(keyCode);
	
	if (button) {
		$("#calculator .digits span:contains(" + button + ")").click();
	}
}

$(document).keydown(function(event) {onKeyPress(event.keyCode);});