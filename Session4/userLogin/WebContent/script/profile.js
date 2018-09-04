/**
 * 
 */
function toggleProfileDetailUpdateDIV() {
    var updateProfileDetailsDIV = document.getElementById("user_profile_edit_container");
    var profileDetailsDIV = document.getElementById("user_profile_container");
    if (updateProfileDetailsDIV.style.display === "none") {
    	updateProfileDetailsDIV.style.display = "block";
    	profileDetailsDIV.style.display= "none";
    } else {
    	updateProfileDetailsDIV.style.display = "none";
    	profileDetailsDIV.style.display= "block";
    }
}
