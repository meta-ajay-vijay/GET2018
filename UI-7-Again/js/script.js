function stateChange(stateName){
    var formElement = document.getElementById("form-input-elements");
    
    var isZipExistFlag = formElement.contains(document.getElementById("zipcode"));
    var isWebDomainExistFlag = formElement.contains(document.getElementById("web-domain"));
    var isRadioExistFlag = formElement.contains(document.getElementById("radio"));
    var isProjectExistFlag = formElement.contains(document.getElementById("text-area"));

    
    switch(stateName){
        case "Rajasthan":
            if(!isZipExistFlag){
                formElement.insertBefore(getZipCode() ,formElement.lastElementChild);
            }
            if(!isWebDomainExistFlag){
                formElement.insertBefore(getWebDomain() ,formElement.lastElementChild);
            }
            if(isRadioExistFlag){
                formElement.removeChild(document.getElementById("radio"));
            }
            if(isProjectExistFlag){
                formElement.removeChild(document.getElementById("text-area"));
            }
            break;
            
        case "Hariyana":
            if(!isZipExistFlag){
                formElement.insertBefore(getZipCode() ,formElement.lastElementChild);
            }
            if(isWebDomainExistFlag){
                formElement.removeChild(document.getElementById("web-domain"));
            }
            if(!isRadioExistFlag){+6
                formElement.insertBefore(getRadio() ,formElement.lastElementChild);
            }
            if(isProjectExistFlag){
                formElement.removeChild(document.getElementById("text-area"));
            }
            break;
        case "Maharashtra":

            if(!isZipExistFlag){
                formElement.insertBefore(getZipCode() ,formElement.lastElementChild);
            }
            if(isWebDomainExistFlag){
                formElement.removeChild(document.getElementById("web-domain"));
            }
            if(isRadioExistFlag){
                formElement.removeChild(document.getElementById("radio"));
            }
            if(!isProjectExistFlag){
                formElement.insertBefore(getProject() ,formElement.lastElementChild);
            }
            break;

    }

}

function getZipCode(){
    var zipcode = document.createElement('div');
    zipcode.className = "input-container";
    zipcode.id = "zipcode";
    zipcode.innerHTML = "<div class='label'><label>Zip Code</label></div><i class='fa fa-home icon'></i><input class='input-field'  type='text' placeholder='Zip Code' name='zipcode' id = 'zipcode-input'>";
    return zipcode;
}

function getWebDomain(){
    var webDomain = document.createElement('div');
    webDomain.id = "web-domain";
    webDomain.className = "input-container";
    webDomain.innerHTML = "<div class='label'><label>Website or domain name</label></div><i class='fa fa-globe icon'></i><input class='input-field' type='text' placeholder='Website or domain name' name='domain' id = 'web-domain-input'>";
    return webDomain;
}

function getRadio(){
    var radio = document.createElement('div');
    radio.id = "radio";
    radio.className = "input-container";
    radio.innerHTML = "<div class='label'><label>Do you have hosting</label></div><div class='radio'><input type='radio' name='question' value='true'>Yes<input type='radio' name='question' value='false'> No</div>";
    return radio;
}

function getProject(){
    var project = document.createElement('div');
    project.id = "text-area";
    project.className = "input-container";
    project.innerHTML = "<div class='label'><label>Project Description</label></div><i class='fa fa-user icon'></i><textarea class='input-field' type='text-area' placeholder='Project Description' name='project_description' rows='5' cols='3' id = 'project-input'></textarea>" 
    return project;
}