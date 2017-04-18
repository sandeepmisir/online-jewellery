<div class="mainHeader">


	<div>
		<div class="col-md-12">

			<div class="rowspan-2 col-md-3">
				<h2>
					<font color="black">E-JEWELLERY</font><span
						class="glyphicon glyphicon-shopping-cart"></span>
				</h2>
				<p>IT Online Jewellery Store</p>
			</div>

			<div><a href=""><h4>SOCIAL MEDIA ICONS</h4></a></div>
			<form class="navbar-form myForm">
				<input type="text" class="form-control col-md-8 searchBox"
					placeholder=" Search This" id="searchInput" style="width: 65%;">
				<span class="input-group-addon searchBtn">Search</span>
				<!-- <button type="submit" class="btn btn-default searchBtn">
					<span class="glyphicon glyphicon-search"></span>
				</button> -->
			</form>


		</div>

		<nav class="navbar" role="navigation">
			<div class="container">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
				</div>
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li><a class="navbar-brand navText navText"
							href="${contextRoot}/home">ejewellery</a></li>
						<li id="about"><a class="navText" href="${contextRoot}/about">About</a></li>
						<li id="contact"><a class="navText"
							href="${contextRoot}/contact">Contact</a></li>
						<li id="listProducts"><a class="navText"
							href="${contextRoot}/show/all/products">View Products</a></li>
						<%-- <li id="category">
                        <a href="${contextRoot}/show/all/category">Categories</a>
                    	</li> --%>
						<li class="dropdown"><a class="dropdown-toggle navText"
							data-toggle="dropdown" href="#">Admin panel<span
								class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="${contextRoot}/addcategory">Add Category</a></li>
								<li><a href="${contextRoot}/addsupplier">Add Supplier</a></li>
								<li><a href="${contextRoot}/addProducts">Add Product</a></li>
								<li><a href="${contextRoot}/viewcategory">View
										Category</a></li>
								<li><a href="${contextRoot}/viewsupplier"}>View
										Supplier</a></li>
								<li><a href="${contextRoot}/viewproduct"}>View Product</a></li>
							</ul></li>

						<!-- end of form -->

						<li id="login"><a class="navText" href="${contextRoot}/login">Login</a></li>

						<li id="register"><a class="navText"
							href="${contextRoot}/register">Register</a></li>


					</ul>



					<!-- <ul class="nav navbar-nav pull-right">
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown"><apan class="glyphicon glyphicon-user"></span>MyAccount</a>

								<ul class="dropdown-menu">
									<li>
										<a href="#"><span class="gliphicon gliphicon-wrench"></span>Setting</a>
									</li>
									<li>
										<a href="#"><span class="gliphicon gliphicon-refresh"></span>Update-Profile</a>
									</li>
									<li>
										<a href="#"><span class="gliphicon gliphicon-briefcase"></span>Billing</a>
									</li>
									<li class="divider"></li>
									<li>
										<a href="#"><span class="gliphicon gliphicon-off"></span>Sign Out</a>
									</li>
								</ul>
							</li>
					</ul>end pull right -->
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container -->
		</nav>

	</div>



</div>