<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="utf-8" />

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous" />

<style>
form {
	width: 40%;
}

main {
	display: flex;
	justify-content: center;
}

img {
	/* display: flex; */
	/* justify-content: flex-end; */
	border-radius: 50%;
}

body {
	background-color: rgb(192, 200, 248);
	/* background-color: rgb(214, 85, 121); */
}

#btnInscription {
	margin-top: 10px;
}

.errorForm{color:red;}
</style>
</head>
<div class="container">
	<body class="text-center">
		<main class="form-signin w-100 m-auto">
			<form action="home" method="post">
				<img class="mb-4" src="assets/img/logoParking2.gif" alt=""
					width="100" height="80" />
				<h1 class="h3 mb-3 fw-normal">Please sign in</h1>

				<div class="form-floating">
					<input name="login" type="text" class="form-control"
						id="floatingInput" placeholder="Login" /> <label
						for="floatingInput">Login </label>
				</div>
				<div class="form-floating">
					<input name="password" type="password" class="form-control"
						id="floatingPassword" placeholder="Password" /> <label
						for="floatingPassword">Password</label>
				</div>
				<div class="errorForm"> ${error}</div>
				<button class="w-100 btn btn-lg btn-primary" type="submit">
					Sign in</button>
				<br /> <a href="inscription.jsp"> <input id="btnInscription"
					class="w-50 btn btn-secondary btn-sm" type="button"
					value="inscription">
				</a>
				<p class="mt-5 mb-3 text-muted">&copy; 2017–2022</p>
			</form>
			

		</main>
		
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
			crossorigin="anonymous"></script>
	</body>
</div>
</html>
