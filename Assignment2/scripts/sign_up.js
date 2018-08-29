function checkAll(){
		
		if(!isNameValid("first_name")){
			alert("Invalid Name");
		}
		
		if(!isNameValid("last_name")){
			alert("Invalid last name");
		}
		
		if(!isEmailValid()){
			alert("Invalid email");
		}
		if(!isContactValid()){
			alert("contact should be numeric and should be of 10 digits");
		}
		if(!isPasswordValid()){
			alert("password should be alphanumeric");
		}
		if(!isConfirmPasswordValid()){
			alert("confirm password should be same as password");
			alert("confirm password should be same as password");
		}
		
		if(isNameValid("first_name") && isNameValid("last_name") && isEmailValid() && isContactValid() && isPasswordValid() && isConfirmPasswordValid()){
			document.getElementById('signup').submit();	
		}


	}

	function isNameValid(id){
		var name  = document.getElementById(id).value;
		var pattern = new RegExp("^[A-Za-z]+$");
		var x = name.length >2 && pattern.test(name) ? 'green' : 'red';
		document.getElementById(id).style.border = '2px solid '+ x;
		var text = name.length >2 && pattern.test(name) ? '' : 'invalid name';
		document.getElementById(id+'_message').innerHTML = text;
		document.getElementById(id+'_message').style.color = 'blue';
		
		return pattern.test(name) && name.length>2?true:false;
	}
	
	function isEmailValid(){
		var email  = document.getElementById('email').value;
		var pattern = new RegExp("^[A-Za-z0-9]*[A-Za-z0-9._@#$%&!()]+@[A-Za-z0-9]+[.]+(([a-z0-9.]{3,4})){1,}$");
		var x = pattern.test(email) ? 'green':'red';
		var text = pattern.test(email) ? '':'invalid email ';
		document.getElementById('email').style.border = '2px solid '+ x;
		
		document.getElementById('email_message').innerHTML = text;
		document.getElementById('email_message').style.color = 'blue';
		return pattern.test(email);
	}
	

	function isContactValid(){
		var contact = document.getElementById('contact').value;
		var pattern = new RegExp("^[0-9]{10}$");
		var x = pattern.test(contact)?'green':'red';
		document.getElementById('contact').style.border = '2px solid '+ x;
		
		var text = pattern.test(contact)?'':'invalid contact'; 
		document.getElementById('contact_message').innerHTML = text;
		document.getElementById('contact_message').style.color = 'blue';
		return pattern.test(contact);	
	}
	
	function isPasswordValid(){
		var password = document.getElementById('password').value;
		var pattern = new RegExp("^(?=.*[A-Z].*[A-Z])(?=.*[!@#$&*])(?=.*[0-9].*[0-9])(?=.*[a-z].*[a-z].*[a-z]).{8,}$");
		var color = pattern.test(password)?'green':'red';
		var text = pattern.test(password)?'Strong':'password should be alphanumeric'; 
		document.getElementById('password').style.border = '2px solid '+ color;
		document.getElementById('password_message').innerHTML = text;
		document.getElementById('password_message').style.color = 'blue';
		return pattern.test(password);
		
	}
	
	function isConfirmPasswordValid(){
		var password = document.getElementById('password');
		var confirmPassword=document.getElementById('confirm_password');
		var x = (password.value==confirmPassword.value)?'green':'red';
		
		var text = (password.value==confirmPassword.value)?'':'confirm password should be same as password'; 
		document.getElementById('confirm_password').style.border = '2px solid '+ x;
		
		document.getElementById('confirm_password_message').innerHTML = text;
		document.getElementById('confirm_password_message').style.color = 'blue';

		return (password.value==confirmPassword.value);
	}
	
	function showPassword() {
		var x = document.getElementById("password");
		if (x.type === "password") {
			x.type = "text";
		} else {
			x.type = "password";
		}
	}