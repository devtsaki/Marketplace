$(function() {
	// actime menu navbar
	switch(menu) {
		case "About Us":
			$("#about").addClass("active");
			break;
		case "Contact":
			$("#contact").addClass("active");
			break;
		case "All Products":
			$("#listProducts").addClass("active");
			break;
		case "Manage Products":
			$("#manageProducts").addClass("active");
			break;
		case "Sell Products":
			$("#sellProducts").addClass("active");
			break;
		case "User Cart":
			$("#userCart").addClass("active");
			break;
		default:
			if (menu == "Home") {
				break;
			}
			$("#listProducts").addClass("active");
			$("#a_" + menu).addClass("active");
		break;
	}
	
	// CSRF Ajax
	var token = $("meta[name='_csrf']").attr('content');
	var header = $("meta[name='_csrf_header']").attr('content');
	
	if (token.length > 0 && header.length > 0) {
		$(document).ajaxSend(function(e, xhr, options) {
			xhr.setRequestHeader(header, token);
			
		});
	}
	
	// jquery dataTable
	
	var $table = $("#productListTable");
	if ($table.length) {
		var jsonUrl = '';
		if (window.categoryId == '') {
			jsonUrl = window.contextRoot + "/json/data/all/products";
		}
		else {
			jsonUrl = window.contextRoot + "/json/data/category/" + window.categoryId + "/products";
		}
		
		$table.DataTable({
			lengthMenu: [[5, 10, 25, -1],['5', '10', '25' , 'All']],
			pageLength: 5,
			order: [[1, 'asc']],
			ajax: {
				url: jsonUrl,
				dataSrc: ''
			},
			columns: [	
				{
					data: "code",
					bSortable: false,
					mRender: function(data, type, row) {
						return "<img src='" + window.contextRoot + "/resources/images/"+ data +".jpg' class='dataTableImg' />";
					}
				},
				{
					data: "name"
				},
				{
					data: "brand"
				},
				{
					data: "unitPrice",
					mRender: function(data, type, row) {
						return data + " &#8364";
					}
				},
				{
					data: "quantity",
					mRender: function(data, type, row) {
						if (data < 1) {
							return "<span style='color:red'>Out of Stock!</span>";
						}
						
						return data;
					}
				},
				{
					data: "id",
					bSortable: false,
					mRender: function(data, type, row) {
						var str = "";
						str += "<a href='"+ window.contextRoot +"/show/"+ data +"/product' class='btn btn-primary'><span class='glyphicon glyphicon-eye-open'></span></a> &#160";
						if (userRole == "ADMIN") {
							str += "<a href='"+ window.contextRoot +"/admin/"+ data +"/product' class='btn btn-warning'><span class='glyphicon glyphicon-pencil'></span></a>";
						} else {													
							if (row.quantity < 1) {
								str += "<a href='javascript:void(0)' class='btn btn-success disabled'><span class='glyphicon glyphicon-shopping-cart'></span></a>"; 
							} else {	
									str += "<a href='"+ window.contextRoot +"/cart/add/"+ data +"/product' class='btn btn-success'><span class='glyphicon glyphicon-shopping-cart'></span></a>";									
							}
						
						}
						return str;
					}
				}
			]
		});
	}
	
	var $alert = $(".alert");
	if ($alert.length) {
		setTimeout(function() {
			$alert.fadeOut("slow");
		} , 3000)
	}
	
	
	
	// Admin dataTable
// jquery dataTable
	
	var $adminProductsTable = $("#adminProductsTable");
	if ($adminProductsTable.length) {
		var jsonUrl = window.contextRoot + '/json/data/admin/all/products';
		
		$adminProductsTable.DataTable({
			lengthMenu: [[10, 25, 50, -1],['10', '25' , '50', 'All']],
			pageLength: 25,
			order: [[1, 'asc']],
			ajax: {
				url: jsonUrl,
				dataSrc: ''
			},
			columns: [
				{
					data: 'id'
				},
				{
					data: "code",
					bSortable: false,
					mRender: function(data, type, row) {
						return "<img src='" + window.contextRoot + "/resources/images/"+ data +".jpg' class='adminDataTableImg' />";
					}
				},
				{
					data: "name"
				},
				{
					data: "brand"
				},
				{
					data: "quantity",
					mRender: function(data, type, row) {
						if (data < 1) {
							return "<span style='color:red'>Out of Stock!</span>";
						}
						
						return data;
					}
				},
				{
					data: "unitPrice",
					mRender: function(data, type, row) {
						return data + " &#8364";
					}
				},
				{
					data: "active",
					bSortable: false,
					mRender: function(data, type, row) {
						var str= "";
						str = '<label class="switch">';
						if (data) {
							str += '<input type="checkbox" checked="checked" value="' + row.id + '" />';
						}
						else {
							str += '<input type="checkbox" value="' + row.id + '" />';
						}
						str += '<span class="slider round"></span></label>';
						return str;
					}
				},
				{
					data: "id",
					bSortable: false,
					mRender: function (data, type, row) {
						var str = "";
						str += '<a href="' + window.contextRoot + '/admin/' + data + '/product" class="btn btn-warning">';
						str += '<span class="glyphicon glyphicon-pencil"></span></a>';
						return str;
					}
				}
			],
			initComplete: function() {
				var api = this.api();
				api.$(".switch input[type='checkbox']").on("change", function() {
					var checkbox = $(this);
					var checked = checkbox.prop("checked");
					var dMsg = (checked) ? "Are you sure you want to activate the product?" : "Are you sure you want to deactivate the product?";
					var value = checkbox.prop("value");
					
					bootbox.confirm({
						size: "medium",
						title: "Product Activation/Deactivation",
						message: dMsg,
						callback: function(confirmed) {
							if (confirmed) {
								var activationUrl = window.contextRoot + "/admin/product/" + value + "/activation";
								
								$.post(activationUrl, function(data) {
									bootbox.alert({
										size: "medium",
										title: "Information",
										message: data
									});
								});
								
							}
							else {
								checkbox.prop("checked", !checked);
							}
						}
						
					});	
				});
			}
		});
	}
	
	// category validation
	
	var $categoryForm = $("#categoryForm");
	
	if ($categoryForm.length) {
		$categoryForm.validate({
			rules : {
				name : {
					required: true,
					minlength: 2
				},
				description : {
					required: true
				} 
			},
			messages : {
				name : {
					required: "Please enter category name!",
					minlength: "You should try more! Two letters is the minimum!"
				},
				description : {
					required: "Come on now! Enter a description!"
				}
			},
			errorElement : "em",
			errorPlacement: function(error, element) {
				error.addClass("help-block");
				error.insertAfter(element);
			}
		});
	}
	
	//STock 
var $stockForm = $("#stockForm");
	
	if ($stockForm.length) {
		$stockForm.validate({
			rules : {
				name : {
					required: true,
					minlength: 2
				},
				brand : {
					required: true,
					minlength: 2
				},
				description : {
					required: true
				},
				unitPrice : {
					required: true,
					min: 2
				},
				quantity : {
					required: true,
					min: 2
				}
			},
			messages : {
				name : {
					required: "Please enter product name!",
					minlength: "You should try more! Two letters is the minimum!"
				},
				brand : {
					required: "Please enter brand name!",
					minlength: "You should try more! Two letters is the minimum!"
				},
				description : {
					required: "Come on now! Enter a description!"
				},
				unitPrice : {
					required: "Please enter unit price!",
					min: "You should try more!"
				},
				quantity : {
					required: "Please enter quantity!",
					min: "You should try more!"
				}
			},
			errorElement : "em",
			errorPlacement: function(error, element) {
				error.addClass("help-block");
				error.insertAfter(element);
			}
		});
	}
	
	// login validation
	
	var $loginForm = $("#loginForm");
	
	if ($loginForm.length) {
		$loginForm.validate({
			rules : {
				username : {
					required: true,
					email: true
				},
				password : {
					required: true,
					minlength: 3
				} 
			},
			messages : {
				username : {
					required: "Please enter username!",
					email: "Please enter valid email!"
				},
				password : {
					required: "Dammit! Enter a password!",
					minlength: "You are very special! Three characters is the minimum!"
				}
			},
			errorElement : "em",
			errorPlacement: function(error, element) {
				error.addClass("help-block");
				error.insertAfter(element);
			}
		});
	}
	
	$("button[name='refreshCart']").click(function() {
		var cartLineId = $(this).attr("value");
		var countElement = $("count_" + cartLineId);
		var originalCount = countElement.attr("value");
		var currentCount = countElement.val();
		
		var cartLineId = $(this).attr('value');
		var countField = $('#count_' + cartLineId);
		var originalCount = countField.attr('value');
		// do the checking only the count has changed
		if(countField.val() !== originalCount) {	
			// check if the quantity is within the specified range
			if(countField.val() < 1 || countField.val() > 3) {
				// set the field back to the original field
				countField.val(originalCount);
				bootbox.alert({
					size: "medium",
			    	title: "Error",
			    	message: "Don't be greedy or irrational! One to four products please!"
				});
			}
			else {
				// use the window.location.href property to send the request to
				// the server
				var updateUrl = window.contextRoot + '/cart/' + cartLineId + '/update?count=' + countField.val();
				window.location.href = updateUrl;
			}
		}
	});
	
});