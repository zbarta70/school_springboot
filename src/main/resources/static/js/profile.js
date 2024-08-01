
/*$('document').ready(function() {
		
	//Code to Load up the Profile Data
	
	$('.edit-profile .btn-primary').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');	
			$.get(href, function(user, status){
			$('#firstnameEdit').val(user.firstname);
			$('#txtAddressEdit').val(client.address);
			$('#txtCityEdit').val(client.city);
			$('#ddlCountryEdit').val(client.countryid);
			$('#txtDetailsEdit').val(client.details);
		});			
		$('#edit-profile').modal();		
	});
	
	$('.table #deleteButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteModal #delRef').attr('href', href);
		$('#deleteModal').modal();		
	});	
});*/