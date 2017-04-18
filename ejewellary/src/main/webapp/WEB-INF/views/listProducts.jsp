<div class="container">

	<div class="row">

		<!-- Would be to display sidebar -->
		<div class="col-md-3">


			<%@include file="./shared/sidebar.jsp"%>



		</div>

		<!-- Would be to display products -->
		<div class="col-md-9">

			<!-- added breadcrumb component -->
			<div class="row">

				<div class="col-lg-12">

					<c:if test="${userClickAllProducts == true}">
					
						<script>
							window.categoryID = '';
						</script>
					
						<ol class="breadcrumb">

							<li><a href="${contextRoot}/home">HOME</a></li>
							<li class="active">All Products</li>

						</ol>
					</c:if>

					<c:if test="${userClickCategoryProducts == true}">
					
						<script>
							window.categoryID = '${category.id}';
						</script>
					
						<ol class="breadcrumb">

							<li><a href="${contextRoot}/home">HOME</a></li>
							<li class="active">Category</li>
							<li class="active">${category.name}</li>

						</ol>
					</c:if>

				</div>

			</div>

			<div class="row">
				
				<div class="col-xs-12">
				
					<table id="productListTable" class="table table-striped table-bordered">
					
						<thead>
						
							<th></th>
							<th>Name</th>
							<th>Brand</th>
							<th>Price</th>
							<th>Qty-Available</th>
							<th></th>
							
						</thead>
						<tfoot>
						
							<th></th>
							<th>Name</th>
							<th>Brand</th>
							<th>Price</th>
							<th>Qty-Available</th>
							<th></th>
						</tfoot>
					
					</table>
				
				</div>
			
			</div>

		</div>


	</div>

</div>