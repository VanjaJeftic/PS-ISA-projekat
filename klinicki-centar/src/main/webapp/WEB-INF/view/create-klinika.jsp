<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>Nova dijagnoza</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
  
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<div role="navigation">
		<div class="navbar navbar-inverse">
			<div class="navbar-collapse collapse">
			<h2>ADMINISTRATOR</h2>
				<ul class="nav navbar-nav">
				<li><a href="/sviIzBaze">Pregled svih</a></li>
					<li><a href="/zahteviRegistrovanje">Registrovanje korisnika</a></li>
					<li><a href="/klinike">Klinike</a></li>
					<li><a href="/pregledSvihAdmina">Administratori KC</a></li>
					<li><a href="/pregledSvihAdminaKlinike">Administratori klinika</a></li>
					<li><a href="/lekovi">Lekovi</a></li>
					<li><a href="/dijagnoze">Dijagnoze</a></li>
					<li><a href="/logout">Odjavi se</a></li>
				</ul>
			
			</div>
		</div>
	</div>
<section class="h-100">
    <div class="container h-100">
        <div class="row justify-content-md-center h-100">
            <div class="card-wrapper">
                <div class="card fat">
                    <div class="card-body">
                        <h4 class="card-title">Dodaj novu dijagnozu</h4>
                        <c:if test="${not empty param.error}">
                            <label id="error" class="alert alert-danger">${param.error}</label>
                        </c:if>
                        <form action="/novaKlinika" method="POST">


                            <div class="form-group">
                                <label for="naziv">Naziv</label>
                                <input id="naziv" type="text" class="form-control" name="naziv" required>
                            </div>

                            <div class="form-group">
                                <label for="grad">Grad</label>
                                <input id="grad" type="grad" class="form-control" name="grad" required>
                            </div>
                            
                            <div class="form-group">
                                <label for="drzava">Drzava</label>
                                <input id="drzava" type="drzava" class="form-control" name="drzava" required>
                            </div>
                            
                            <div class="form-group">
                                <label for="adresa">Adresa</label>
                                <input id="adresa" type="adresa" class="form-control" name="adresa" required>
                            </div>

                            <div class="form-group no-margin">
                                <button type="submit" class="btn btn-primary btn-block">
                                    NOVA KLINIKA
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="footer">
    Copyright &copy; tim21
			</div>
            </div>
        </div>
    </div>
</section>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="static/js/bootstrap.min.js"></script>
<script src="static/js/app.js"></script>
</body>
</html>