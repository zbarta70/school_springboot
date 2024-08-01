
$('document').ready(function() {
	
	$('.table #editButton').on('click',function(event){		
		event.preventDefault();		
		var href = this.getAttribute('href');
		var modified_href = href.replace('?', '');
			$.get(modified_href, function(teacher){
				$('#idEdit').val(teacher.id);
				$('#lastnameEdit').val(teacher.lastname);
				$('#firstnameEdit').val(teacher.firstname);
				$('#klassEdit').val(teacher.klass);
				$('#mobileEdit').val(teacher.mobile);
				$('#emailEdit').val(teacher.email);
				$('#addressEdit').val(teacher.address);
				$('#subjectsEdit').val(teacher.subjects);
		});			
		$('#editModal').modal();		
	});
	
	$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href = this.getAttribute('href');
		var modified_href = href.replace('?', '');
		$.get(modified_href, function(teacher){
			$('#idDetails').val(teacher.id);
			$('#lastnameDetails').val(teacher.lastname);
			$('#firstnameDetails').val(teacher.firstname);
			$('#klassDetails').val(teacher.klass);
			$('#mobileDetails').val(teacher.mobile);
			$('#emailDetails').val(teacher.email);
			$('#addressDetails').val(teacher.address);
			$('#subjectsDetails').val(teacher.subjects);
			$('#lastModifiedByDetails').val(teacher.lastModifiedBy);
			$('#lastModifiedDateDetails').val(teacher.lastModifiedDate.substr(0,19).replace("T", " "));
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