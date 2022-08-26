const signinButton = document.querySelector(".signin-button");
const signupButton = document.querySelector(".signup-button");

singinButton.onclick = () => {
	send();
}

singupButton.onclick = () => {
	location.href = "/auth/signup";
}


 
 function send() {
	const userId = document.querySelector(".user-id").value;
	const userPassword = document.querySelector(".user-password").value;
	
	const userJson = Json.stringify({
		"userId" : userId,
		"userPassword" : userPassword
	});
	
	$ajax({
		async: false,
		type: "post",
		url: "/api/v1/auth/signin",
		data: {
			user : userJson
		},
		dataType: "json",
		success: (response) => {
			if(response.status) {
				alert("로그인 성공");
			}else {
				alert("사용자의 정보를 확인해 주세요.");
			}
		},
		error: (error) => {
			console.log(error);
		}
		
		});
}