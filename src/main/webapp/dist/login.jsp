<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>

	<title>softech</title>
	<!-- HTML5 Shim and Respond.js IE11 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 11]>
		<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
		<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
		<![endif]-->
	<!-- Meta -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="description" content="" />
	<meta name="keywords" content="">
	<meta name="author" content="Phoenixcoded" />
	<!-- Favicon icon -->
	<link rel="icon" href="dist/assets/images/favicon.ico" type="image/x-icon">

	<!-- vendor css -->
	<link rel="stylesheet" href="dist/assets/css/style.css">
	
	


</head>
<%session.invalidate();%>

<!-- [ auth-signin ] start -->
<div class="auth-wrapper">
	<div class="auth-content">
		<div class="card">
			<div class="row align-items-center text-center">
				<div class="col-md-12">
					<div class="card-body">
						<img src="assets/images/logo-dark.png" alt="" class="img-fluid mb-4">
						<h4 class="mb-3 f-w-400">Login</h4>
						  <c:if test="${mensaje != null}">
				            <div><p style="color:red">${mensaje}</p></div><br>
				        </c:if>
						<form action="login" method="post">
						<div class="form-group mb-3">
							<label for="Email" style="float:left">Usuario</label>
							<input type="text" class="form-control" value="${usuario.nombre_usuario}" name="usuario" id="Email" placeholder="">
						</div>
						<div class="form-group mb-4">
							<label for="Password" style="float:left">Contraseņa</label>
							<input type="password" class="form-control" value="${usuario.contrasena}" name="clave" id="Password" placeholder="">
						</div>
						<div class="custom-control custom-checkbox text-left mb-4 mt-2">
							<input type="checkbox" class="custom-control-input" id="customCheck1">
							<label class="custom-control-label" for="customCheck1">Guardar credenciales</label>
						</div>
						<button class="btn btn-block btn-primary mb-4" type="submit">Ingresar</button>
						<p class="mb-2 text-muted">Olvidaste tu contraseņa? <a href="auth-reset-password.html" class="f-w-400">Recuperar</a></p>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- [ auth-signin ] end -->

<!-- Required Js -->
<script src="dist/assets/js/vendor-all.min.js"></script>
<script src="dist/assets/js/plugins/bootstrap.min.js"></script>
<script src="dist/assets/js/ripple.js"></script>
<script src="dist/assets/js/pcoded.min.js"></script>



</body>

</html>
