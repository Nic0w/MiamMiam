$(document).ready(function(){

// Security new user's form
	$("#envoieFormUser").click(function(){
		valid =0;
		vmail=0;
		vpwd=0;
		vcpwd =0;
		// verif mail
		if(($("#mail").val() == "") /*|| ($("#mail").match(/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i))*/){
			$("#mail").css("border-color","#ff0000");
			$("#labMail").css("color", "#ff0000");
			vmail ++;
		}
		else
		{
			$("#mail").css("border-color","#000");
			$("#labMail").css("color", "#000");
			vmail=0;
		}
		// verif pwd
		if($("#pwd").val().length < 5){
			$("#labelPwd").css("color", "#ff0000");
			$("#pwd").css("border-color", "#ff0000");
			vpwd ++;
		}
		else
		{
			$("#labelPwd").css("color", "#000");
			$("#pwd").css("border-color", "#000");
			vpwd = 0;
		}
		// verif confirm pwd
		if($("#cpwd").val()!= $("#pwd").val()){
			$("#labelCpwd").css("color", "#ff0000");
			$("#cpwd").css("border-color", "#ff0000");
			vcpwd ++;
		}
		else
		{
			$("#labelCpwd").css("color", "#000");
			$("#cpwd").css("border-color", "#000");
			vcpwd = 0;
		}
		// autorisation
		valid= vmail + vpwd + vcpwd;
		//alert(valid);
		if (valid == 0)
			return true;
		else
			return false;
	});
// Security research's user
	valid = true;
	$("#envoieRecherche").click(function(){
		if($("#farine").is(':checked')||$("#sucre").is(':checked')||$("#huile").is(':checked')||$("#lait").is(':checked')||$("#beurre").is(':checked')||$("#oeuf").is(':checked')||$("#fruit").is(':checked')||$("#sucreV").is(':checked')||$("#levure").is(':checked')||$("#coco").is(':checked')||$("#vanille").is(':checked')){
			$("#validIngredient").css("visibility","hidden");
			valid=true
		}
		else{
			$("#validIngredient").css("visibility","visible");
			valid = false;
		}
		return valid;
			
	
	});





});