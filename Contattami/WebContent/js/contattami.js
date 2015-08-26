$(function(){
	$("#contattamiForm").validate({
		rules:{
			contattamiNome:{
				required: true
			},
			contattamiMailAddress:{
				required: true,
				email:true
			},
			contattamiBirthDate:{
				required: true
			},
			contattamiNationality:{
				required: true
			},
			contattamiWhereHeardUs:{
				required: true
			},
			contattamiInterestedTrips:{
				required: true
			}
		}
	});	
	autosize($('textarea'));
	 $( "#sendMailResultDialog" ).dialog({
	      modal: true,
	      autoOpen: false,
	      open: function(event, ui) {
	    	    setTimeout(function(){
	    	        $('#sendMailResultDialog').dialog('close');                
	    	    }, 5000);
	      },
	      close: function(event, ui) {
	    	  $("#contattamiMessageResult").text('');
	      }
	    });	
	$( "#contattamiBirthDate" ).datepicker({
	      changeMonth: true,
	      changeYear: true
	    });
	$("#contattamiInviaMail").button().click( function(e){
		e.preventDefault();

        var url =  $("#contattamiSendMailUrl").val();
        var sendObj = new Object();
        sendObj.nameSurname=$("#contattamiNome").val();
        sendObj.mailAddress=$("#contattamiMailAddres").val();
        sendObj.birthDate=$("#contattamiBirthDate").datepicker( 'getDate' ).getTime();
        sendObj.nationality=$("#contattamiNationality").val();
        sendObj.whereHeardUs=$("#contattamiWhereHeardUs").val();
        sendObj.occupation=$("#contattamiOccupation").val();
        sendObj.interestedTrips=$("#contattamiInterestedTrips").val();
        sendObj.independentExperiences=$("#contattamiIndependentExp").val();
        sendObj.questions=$("#contattamiQuestions").val();
        //console.log(sendObj);
        $.ajax({
            url        : url,
            dataType   : 'json',
            contentType: 'application/json; charset=UTF-8',
            data       : JSON.stringify(sendObj),
            type       : 'POST',
            beforeSend : function (){
                $.blockUI({
                    fadeIn : 0,
                    fadeOut : 0,
                    showOverlay : false,
                    message: $("#contattamiSendingMailMessage").val()
                });
            },
            complete : function (){
                $.unblockUI();
            },
            success: function (data) {
            	if( data.operationStatusCode == 200 )
            	{
            		$("#contattamiMessageResult").text($("#contattamiSuccesso").val());
            		$("#contattamiInviaMail").prop("disabled",true);
            	}
            	else
            	{
            		$("#contattamiMessageResult").text($("#contattamiErrore").val());
            	}
            	$("#sendMailResultDialog").dialog("open");
            },
            error: function(data){
            	console.log("Errori nella chiamata ajax");
            }
        });
	} );
	$("#contattamiReset").button();
});