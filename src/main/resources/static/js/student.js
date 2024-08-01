
$('document').ready(function() {
	
	$('.table #editButton').on('click',function(event){		
		event.preventDefault();		
		var href = this.getAttribute('href');
		var modified_href = href.replace('?', '');
			$.get(modified_href, function(student){
				$('#idEdit').val(student.id);
				$('#lastnameEdit').val(student.lastname);
				$('#firstnameEdit').val(student.firstname);
				$('#klassEdit').val(student.klass);
				$('#mobileEdit').val(student.mobile);
				$('#emailEdit').val(student.email);
				$('#addressEdit').val(student.address);
				$('#dateOfBirthEdit').val(student.dateOfBirth.substr(0,10));
		});			
		$('#editModal').modal();		
	});
	
	$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href = this.getAttribute('href');
		var modified_href = href.replace('?', '');
		$.get(modified_href, function(student){
			$('#idDetails').val(student.id);
			$('#lastnameDetails').val(student.lastname);
			$('#firstnameDetails').val(student.firstname);
			$('#klassDetails').val(student.klass);
			$('#mobileDetails').val(student.mobile);
			$('#emailDetails').val(student.email);
			$('#addressDetails').val(student.address);
			$('#dateOfBirthDetails').val(student.dateOfBirth.substr(0,10));
			$('#lastModifiedByDetails').val(student.lastModifiedBy);
			$('#lastModifiedDateDetails').val(student.lastModifiedDate.substr(0,19).replace("T", " "));
		});			
		$('#detailsModal').modal();		
	});	
	
	$('.table #deleteButton').on('click',function(event) {
		event.preventDefault();
		var href = this.getAttribute('href');
		var modified_href = href.replace('?', '');
		$('#confirmDelete').attr('href', modified_href);
		$('#deleteModal').modal();		
	});	
});