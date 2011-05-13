
function bindButtons() {
	$("#calculator .digits span").each(function(i, e) {
		$(e).click(function() {
			var text = calc.compute($(e).text());

			$("#result").text(text);
		});
	});
}

$(document).ready(function() { bindButtons(); });