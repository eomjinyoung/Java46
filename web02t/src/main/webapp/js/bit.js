function bit(id) {
	return document.getElementById(id);
}

bit.ajax = function(url, settings) {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				var jsonResult = JSON.parse(xhr.responseText).jsonResult;
				if (jsonResult.resultStatus == 1) {
					if (settings.error) {
						settings.error(jsonResult.error);
					}
				} else {
					if (settings.success) {
						settings.success(jsonResult.data);
					}
				}
			} else {
				if (settings.error) {
					settings.error("요청 실패!");
				}
			}
		}
		
	};
	xhr.open(settings.method, url, true);
	xhr.send();
};


var $ = bit;








