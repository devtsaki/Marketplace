$(function() {
	//actime menu navbar
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
		default:
			if (menu == "Home") {
				break;
			}
			$("#listProducts").addClass("active");
			$("#a_" + menu).addClass("active");
		break;
	}
	
	//jquery dataTable
	
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
						
						if (row.quantity < 1) {
							str += "<a href='javascript:void(0)' class='btn btn-success disabled'><span class='glyphicon glyphicon-shopping-cart'></span></a>"; 
						} else {
							str += "<a href='"+ window.contextRoot +"/cart/add/"+ data +"/product' class='btn btn-success'><span class='glyphicon glyphicon-shopping-cart'></span></a>";
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
	
	$(".switch input[type='checkbox']").on("change", function() {
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
					bootbox.alert({
						size: "medium",
						title: "Information",
						message: "You are going to change the status of product " + value
					});
				}
				else {
					checkbox.prop("checked", !checked);
				}
			}
			
		});	
	});
	
});