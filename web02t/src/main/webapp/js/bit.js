function bit(id) {
	return document.getElementById(id);
}

bit.ajax = function(url, method, success, error) {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				var jsonResult = JSON.parse(xhr.responseText).jsonResult;
				if (jsonResult.resultStatus == 1) {
					if (error) {
						error(jsonResult.error);
					}
				} else {
					if (success) {
						success(jsonResult.data);
					}
				}
			} else {
				if (error) {
					error("요청 실패!");
				}
			}
		}
		
	};
	xhr.open(method, url, true);
	xhr.send();
};


var $ = bit;