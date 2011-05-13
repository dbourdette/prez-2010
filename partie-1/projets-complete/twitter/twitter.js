$(document).ready(function() {
	$.ajax({
	 url: 'http://api.twitter.com/statuses/user_timeline.json?screen_name=RTLFrance&callback=handleJson',
	 dataType: 'jsonp'
	});
});

function handleJson(twits) {
	$(twits).each(function(index, twitt) {
		if (index < 3) {
			$("<a>").attr("href", "http://twitter.com/RTLFrance").attr("target", "_blank").text(twitt.text).appendTo($("#twitter .messages"));
		}
	});
}