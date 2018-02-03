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
	
	
	
	//Admin dataTable
//jquery dataTable
	
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
						str += '<a href="${contextRoot}/admin/' + data + '/product" class="btn btn-warning">';
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
								bootbox.alert({
									size: "medium",
									title: "Information",
									message: "You changed the status of product " + value
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
	
});