function checkUrl(url) {
	var request = false;
	if (window.XMLHttpRequest) {
		request = new XMLHttpRequest;
	} else if (window.ActiveXObject) {
		request = new ActiveXObject("Microsoft.XMLHttp");
	}
	if (request) {
		request.open("GET", url);
		if (request.status == 200) {
			return true;
		}
	}
	return false;
}

/*
 * jQuery(document).ready(function($) { $('.level-bar-inner').css('width', '0');
 * $(window).on('load', function() { $('.level-bar-inner').each(function() { var
 * itemWidth = $(this).data('level'); $(this).animate({ width: itemWidth },
 * 800); }); }); });
 */
