window.onload = function() {
	console.log("okok");
	
	var xhr = new XMLHttpRequest();
	xhr.open(
			'GET', 			// 요청 방식: GET, POST 
			'ajax/list.do', 	// 요청 URL
			false); 			// 비동기 여부
	xhr.send(); // 동기 방식은 서버에서 결과를 받을 때까지 멈춤
	
	//responseText 속성에 서버의 응답 데이터가 들어 있다.
	var members = eval(xhr.responseText);
	var m = null;
	var tr = null;
	var html = null;
	var table = document.getElementById("listTable");
	for (var i = 0; i < members.length; i++) {
		m = members[i];
		tr = document.createElement('tr');
		html = '';
		html += '<td>' + m.no + '</td>'; 
		html += '<td>' + m.name + '</td>';	
		html += '<td>' + m.email + '</td>';	
		html += '<td>' + m.tel + '</td>';	
	  tr.innerHTML = html;
	  table.appendChild(tr);
	}
};














