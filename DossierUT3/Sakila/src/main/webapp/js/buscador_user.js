$(document).ready(
		function() {
			$("#search").keyup(
					function() {
						_this = this;
						// Show only matching TR, hide rest of them
						$.each($("#myDiv .object "), function() {
							if ($(this).text().toLowerCase().indexOf(
									$(_this).val().toLowerCase()) === -1)
								$(this).hide();
							else
								$(this).show();
						});
					});
		});