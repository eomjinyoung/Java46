window.onload = function() {
	listMember();
};

function listMember() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		/* xhr.readyState 속성
		 * 1 = open() 호출했음.
		 * 2 = 서버에 요청했음
		 * 3 = 데이터 수신중
		 * 4 = 서버로부터 데이터 수신 완료
		 */
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				//responseText 속성에 서버의 응답 데이터가 들어 있다.
				//문자열이 {} 일 경우 양쪽에 괄호 '()'를 붙여야 한다.
				//문자열이 [] 일 경우 그냥 둔다.
				//var members = eval("(" + xhr.responseText + ")").memberList;
				var jsonResult = JSON.parse(xhr.responseText).jsonResult;
				if (jsonResult.resultStatus == 1) {
					alert('시스템이 바쁩니다.\n나중에 다시 시도해 주세요!');
					console.log(jsonResult.error);
				} else {
					var members = jsonResult.data;
					var m = null;
					var tr = null;
					var html = null;
					var table = $('listTable');
					for (var i = 0; i < members.length; i++) {
						m = members[i];
						tr = document.createElement('tr');
						html = '';
						html += '<td>' + m.no + '</td>'; 
						html += '<td><a href="#" class="memberName" data-no="' + 
							m.no + '">' + 
							m.name + '</a></td>';	
						html += '<td>' + m.email + '</td>';	
						html += '<td>' + m.tel + '</td>';	
					  tr.innerHTML = html;
					  table.appendChild(tr);
					}
					
					var alist = document.querySelectorAll('.memberName');
					for (var i = 0; i < alist.length; i++) {
						alist[i].onclick = function() {
							loadMember(this.getAttribute("data-no"));
						};
					}
				}
			}
		}
	};
	xhr.open(
			'GET', 			// 요청 방식: GET, POST 
			'ajax/list.do', 	// 요청 URL
			true); 			// 비동기 여부
	xhr.send(); // 동기 방식은 서버에서 결과를 받을 때까지 멈춤	
}

function loadMember(no) {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				var jsonResult = JSON.parse(xhr.responseText).jsonResult;
				if (jsonResult.resultStatus == 1) {
					alert('시스템이 바쁩니다.\n나중에 다시 시도해 주세요!');
					console.log(jsonResult.error);
				} else {
					var member = jsonResult.data;
					console.log(member);
					$("mNo").value = member.no;
					$("mName").value = member.name;
					$("mTel").value = member.tel;
					$("mAge").value = member.age;
					$("mEmail").value = member.email;
					$("mPhoto").src = "../files/" + member.photo;
				}
			}
		}
	};
	xhr.open('GET', 
			'ajax/read.do?no=' + no,
			true);
	xhr.send();
}













