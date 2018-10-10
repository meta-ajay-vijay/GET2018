var errorMap = new Map();

function checkValidity(){
     checkFirstName(document.getElementById("first_name"));
     checkLastName(document.getElementById("last_name"));
     checkEmail(document.getElementById("email"))
     checkContact(document.getElementById("contact"));
     checkState(document.getElementById("state"));
     if(document.getElementById("form-input-elements").contains(document.getElementById("zipcode"))){
     checkZipCode(document.getElementById("zipcode-input"));}
     showMessage();
	 
if(errorMap.size!=0) 
{return false;}

     if(errorMap.size===0){
        var formElements = document.getElementById("contact-us");
        if(localStorage){
			debugger;
            localStorage.clear();
        for (var i = 0; i < formElements.elements.length; i++) {
                localStorage.setItem(formElements.elements[i].name,formElements.elements[i].value);   
        }
        }else{
        console.log("browser dosent support localStorage");
        }
    }  

return true;	
}

function deleteEntry(key){
	if(errorMap.has(key)) {
		errorMap.delete(key);
	}
}

function showMessage(){
    var message = "";
    if(errorMap.size > 0){
        var allkeys = errorMap.keys();
		for(var key of allkeys) {
			message +=  key + " - " + errorMap.get(key) + "\n";
		}
		alert(message);
	}
}

function checkFirstName(firstName){
	if(firstName.value == ""){
		errorMap.set("FirstName", "First Name is required");
		firstName.style.borderColor = "red";
	}else if (!(/^[a-zA-Z]{2,}$/.test(firstName.value))) {
		errorMap.set("FirstName", "First Name is invalid");
		firstName.style.borderColor = "red";
	} else{
		deleteEntry("FirstName");
		firstName.style.borderColor = "green";
    }
}

function checkLastName(lastName){
	if(lastName.value == ""){
		errorMap.set("LastName", "Last Name is required");
		lastName.style.borderColor = "red";
	}else if (!(/^[a-zA-Z]{2,}$/.test(lastName.value))) {
		errorMap.set("lastName", "Last Name is invalid");
		lastName.style.borderColor = "red";
	} else{
		deleteEntry("LastName");
		lastName.style.borderColor = "green";
    }
}

function checkEmail(email){
	if(email.value == ""){
		errorMap.set("Email", "Email is required");
		email.style.borderColor = "red";
	}else if(!(/^\w+([\.-]?\w+)*@[a-zA-Z]+(\.[a-zA-Z]{2,3})+$/.test(email.value))){
		errorMap.set("Email", "Email is invalid");
		email.style.borderColor = "red";
	}else{
		deleteEntry("Email");
		email.style.borderColor = "green";
	}
}
function checkContact(contact){
	if(contact.value == ""){
		errorMap.set("contact", "contact is required");
		contact.style.borderColor = "red";
	}else if(!(/^[\d]{10}$/.test(contact.value))){
		errorMap.set("contact", "contact is invalid");
		contact.style.borderColor = "red";
	}else{
		deleteEntry("contact");
		contact.style.borderColor = "green";
	}
}
function checkState(state){
    if(state.value == ""){
		errorMap.set("state", "state is required");
		state.style.borderColor = "red";
	}else{
		deleteEntry("state");
		state.style.borderColor = "green";
	}
}

function checkZipCode(zipcode){
    if(zipcode.value == ""){
		errorMap.set("zipcode", "zipcode is required");
		zipcode.style.borderColor = "red";
	}else if(!(/^[\d]{6}$/.test(zipcode.value))){
		errorMap.set("zipcode", "zipcode is invalid");
		zipcode.style.borderColor = "red";
	}else{
		deleteEntry("zipcode");
		zipcode.style.borderColor = "green";
	}
}