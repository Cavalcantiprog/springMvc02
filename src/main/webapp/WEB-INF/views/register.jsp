<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Cadastre-se</title>

    <!-- Custom fonts for this template-->
    <link href="resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="resources/css/sb-admin-2.min.css" rel="stylesheet">
    
    <style>
    	.error { width : 100%; }
    	label.error { font-size: 9pt; color: #d9534f; }
    	input.error { border: 1px solid #d9534f; }
    </style>

</head>

<body class="bg-gradient-primary">

    <div class="container">

        <div class="row justify-content-center">

            <div class="col-xl-6 col-lg-6 col-md-6">

                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">                            
                            <div class="col-lg-12">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h3 text-gray-900 mb-4">Criar Conta de Usuário</h1>                                        
                                    </div>
                                    
                                    <h5 class="text-success"><strong>${mensagem_sucesso}</strong></h5>
                                    <h5 class="text-danger"><strong>${mensagem_erro}</strong></h5>
                                    
                                    <form id="formRegister" class="user" autocomplete="off"
                                    	method="post" action="registerUser">
                                    
                                    	<div class="form-group">
                                            <form:input type="text" path="usuario.nome"
                                            	class="form-control form-control-user"
                                                id="nome" name="nome" placeholder="Entre com o seu nome"/>
                                        </div>
                                    
                                        <div class="form-group">
                                            <form:input type="email" path="usuario.email"
                                            	class="form-control form-control-user"
                                                id="email" name="email" placeholder="Entre com o seu email"/>
                                        </div>
                                        
                                        <div class="form-group">
                                            <form:input type="password" path="usuario.senha"
                                            	class="form-control form-control-user"
                                                id="senha" name="senha" placeholder="Entre com a sua senha"/>
                                        </div>
                                        
                                        <div class="form-group">
                                            <input type="password" class="form-control form-control-user"
                                                id="senhaConfirm" name="senhaConfirm" placeholder="Confirme a sua senha"/>
                                        </div>
                                        
                                        <input type="submit" class="btn btn-success btn-user btn-block"
                                        	value="Realizar Cadastro"/>
                                        	
                                    </form>
                                    
                                    <hr>
                                    
                                    <div class="text-center">
                                        <a href="/springMvc02/">Voltar para a página de login.</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </div>

    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="resources/vendor/jquery/jquery.min.js"></script>
    <script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="resources/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="resources/js/sb-admin-2.min.js"></script>
    
    <script src="resources/vendor/jquery-validate/jquery.validate.min.js"></script>
    <script src="resources/vendor/jquery-validate/messages_pt_BR.min.js"></script>

	<script>
		$(document).ready(function(){
			
			$("#formRegister").validate(
				{
					rules : {
						nome : {
							required : true,
							minlength : 6,
							maxlength : 150
						},
						email : {
							required : true,
							email : true
						},
						senha : {
							required : true,
							minlength : 6,
							maxlength : 20
						},
						senhaConfirm : {
							required : true,
							equalTo : '#senha'
						}
					}		
				}
			);
			
		})	
	</script>

</body>

</html>









