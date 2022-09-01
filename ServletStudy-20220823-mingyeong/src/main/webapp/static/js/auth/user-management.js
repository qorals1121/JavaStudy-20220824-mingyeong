/**
 * 
 */
 
 load();
 
 function load() {
	
	$.ajax({
		async: false,
		type: "get",
		url: "/api/v1/auth/management/users",
		dataType: "json",
		success: (response) => {
			console.log(response);
			getUserList(response);
		},
		error: (error) => {
			console.log(error);
		}
	});
	
	
}

function getUserList(userList) {
	const tbody = document.querySelector("tbody");
	
	tbody.innerHTML = "";
	
	for(let user of userList) {
		tbody.innerHTML += `
			<tr>
				<td>${user.user_code}</td>
				<td>${user.user_id}</td>
				<td>${user.user_password}</td>
				<td>${user.user_name}</td>
				<td>${user.user_email}</td>
				<td>${user.user_phone}</td>
				<td>${user.user_address}</td>
				<td><button type="button" class="delete-button">삭제</button></td>
			</tr>
		`
	}
}