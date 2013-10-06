$(document).ready(function(){

// Security new user's form
	$("#envoieFormUser").click(function(){
		var valid =0;
		var vmail=0;
		var vpwd=0;
		var vcpwd =0;

		var inputVal = $("#mail").val();
		var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;

		// verif mail
		if(   ($("#mail").val() == "") || (!emailReg.test(inputVal))  ){
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

// Security Recipe
	$("#envoieRecette").click(function(){
		var vPhoto =0;
		var vPersonne =0;
		var vPrep =0;
		var vCuisson =0;
		var vNom =0;
		var vEtape =0;

		var numericReg = /^\d*[0-9](|.\d*[0-9]|,\d*[0-9])?$/;
		/* Verif photo choisie */
		// picture validation
		if ($('#Rphoto').val() == '')
		{
			$('#labelRphoto').css("color","#f00");
			vPhoto ++;
		}
		else
		{
			$('#labelRphoto').css("color","#000");
			vPhoto =0;
		}
		/* Verif string*/
		// verif nom
		if($("#Rnom").val().length < 5){
			$("#labelRnom").css("color", "#ff0000");
			vNom ++;
		}
		else
		{
			$("#labelRnom").css("color", "#000");
			vNom = 0;
		}
		// verif etape
		if($("#Retape").val().length < 15){
			$("#labelRetape").css("color", "#ff0000");
			vEtape ++;
		}
		else
		{
			$("#labelRetape").css("color", "#000");
			vEtape = 0;
		}
		/* Verif numérique */
		// verif nb personne
		if(!numericReg.test($("#Rpersonne").val())) {
        	$('#labelRpersonne').css("color","#f00");
			vPersonne ++;
		}
		else
		{
			$('#labelRpersonne').css("color","#000");
			vPersonne =0;
		}
		// verif preparation time
		if(!numericReg.test($("#Rprep").val())) {
        	$('#labelRprep').css("color","#f00");
			vPrep ++;
		}
		else
		{
			$('#labelRprep').css("color","#000");
			vPrep =0;
		}
		// verif cuisson time
		if(!numericReg.test($("#Rcuisson").val())) {
        	$('#labelRcuisson').css("color","#f00");
			vCuisson ++;
		}
		else
		{
			$('#labelRcuisson').css("color","#000");
			vCuisson =0;
		}				
		// autorisation
		valide = vPhoto + vPersonne + vPrep + vCuisson + vNom + vEtape;
		alert(valide);
		if (valide == 0)
			return true;
		else
			return false;
	});





});