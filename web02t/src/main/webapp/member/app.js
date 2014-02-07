window.onload = function() {
	listMember();
};

function listMember() {
	$.ajax('ajax/list.do', 'GET', function(members){
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
	}, function(){
		alert('시스템이 바쁩니다.\n나중에 다시 시도해 주세요!');
	});
}

function loadMember(no) {
	$.ajax('ajax/read.do?no=' + no, 'GET', function(member){
		$("mNo").value = member.no;
		$("mName").value = member.name;
		$("mTel").value = member.tel;
		$("mAge").value = member.age;
		$("mEmail").value = member.email;
		$("mPhoto").src = "../files/" + member.photo;
	});
}













