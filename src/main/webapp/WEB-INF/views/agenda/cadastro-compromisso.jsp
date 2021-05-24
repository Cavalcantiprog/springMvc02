<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    
    <!-- Cache Control -->
    <%
    	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
    	response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
    	response.setDateHeader("Expires", 0); // Proxies.
    %>
    
    <title>Agenda</title>

    <!-- Custom fonts for this template-->
    <link href="resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="resources/css/sb-admin-2.min.css" rel="stylesheet">
    
    <style>
    	.error { width : 100%; }
    	label.error { font-size: 1rem;!important; color: #d9534f; }
    	input.error, select.error, textarea.error { font-size: 1rem;!important; border: 1px solid #d9534f; }
    </style>

</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="/springMvc02/home">
                <div class="sidebar-brand-icon">
                    <i class="fas fa-calendar"></i>
                </div>
                <div class="sidebar-brand-text mx-3">Agenda</div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - Dashboard -->
            <li class="nav-item">
                <a class="nav-link" href="/springMvc02/home">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Painel Principal</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                Gerenciar Compromissos
            </div>

            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
                    aria-expanded="true" aria-controls="collapseTwo">
                    <i class="fas fa-fw fa-cog"></i>
                    <span>Compromissos</span>
                </a>
                <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <a class="collapse-item" href="/springMvc02/cadastro-compromisso">Cadastrar Compromissos</a>
                        <a class="collapse-item" href="/springMvc02/consulta-compromisso">Consultar Compromissos</a>
                    </div>
                </div>
            </li>

        </ul>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                    <!-- Sidebar Toggle (Topbar) -->
                    <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                        <i class="fa fa-bars"></i>
                    </button>

                    <!-- Topbar Navbar -->
                    <ul class="navbar-nav ml-auto">

                        <div class="topbar-divider d-none d-sm-block"></div>

                        <!-- Nav Item - User Information -->
                        <li class="nav-item dropdown no-arrow">
                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small">
									<strong>${usuario_autenticado.nome}</strong>
								</span>                                
                            </a>
                            <!-- Dropdown - User Information -->
                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="userDropdown">
                                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#usuarioModal">
                                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Minha Conta
                                </a>                               
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Sair do Sistema
                                </a>
                            </div>
                        </li>

                    </ul>

                </nav>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">
                
                	<c:if test="${not empty mensagem_sucesso}">
                		<div class="alert alert-success alert-dismissible fade show" role="alert">
  							<strong>${mensagem_sucesso}</strong>
						</div>
                	</c:if>
                	
                	<c:if test="${not empty mensagem_erro}">
                		<div class="alert alert-danger alert-dismissible fade show" role="alert">
  							<strong>${mensagem_erro}</strong>
						</div>
                	</c:if>

                    <!-- Page Heading -->
                    <h1 class="h4 mb-4 text-gray-800">Cadastro de Compromissos</h1>
                    
                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Formulário de cadastro</h6>
                        </div>
                        <div class="card-body">
                          
                          <form id="formCadastro" method="post" action="cadastrarCompromisso" autocapitalize="off">
                          
                          	<div class="row">
                          		<div class="col-md-6">                          			
                          			<label>Nome do Compromisso:</label>
                          			<form:input path="dto.nome" type="text" id="nome" name="nome" class="form-control"/>                          			
                          		</div>
                          		<div class="col-md-3">                          			
                          			<label>Data:</label>
                          			<form:input path="dto.data" type="date" id="data" name="data" class="form-control"/>                          			
                          		</div>
                          		<div class="col-md-3">                          			
                          			<label>Hora:</label>
                          			<form:input path="dto.hora" type="text" id="hora" name="hora" class="form-control"/>                          			
                          		</div>
                          	</div>
                          	
                          	<div class="row mt-2">
                          		<div class="col-md-3">                          			
                          			<label>Tipo do Compromisso:</label>
                          			<form:select path="dto.tipo" id="tipo" name="tipo" class="form-control">
                          				<option value="">Escolha uma opção</option>
                          				<form:options items="${tipos}"/>
                          			</form:select>                          			
                          		</div>
                          		<div class="col-md-3">                          			
                          			<label>Prioridade do Compromisso:</label>
                          			<form:select path="dto.prioridade" id="prioridade" name="prioridade" class="form-control">
                          				<option value="">Escolha uma opção</option>
                          				<form:options items="${prioridades}"/>
                          			</form:select>                          			
                          		</div>
                          	</div>
                          	
                          	<div class="row mt-2">
                          		<div class="col-md-12">                          			
                          			<label>Descrição do Compromisso:</label>
                          			<form:textarea path="dto.descricao" id="descricao" name="descricao" class="form-control"></form:textarea>                      			
                          		</div>
                          	</div>
                          	
                          	<div class="row mt-2">
                          		<div class="col-md-12">                          			
                          			<input type="submit" value="Cadastrar Compromisso" class="btn btn-success"/>                     			
                          		</div>
                          	</div>
                          
                          </form>
                          
                        </div>
                    </div>
                    

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; COTI Informática 2021</span>
                    </div>
                </div>
            </footer>
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Deseja Sair do sistema?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Confirme se deseja realmente encerrar sua sessão</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancelar</button>
                    <a class="btn btn-primary" href="/springMvc02/logout">Sair do Sistema</a>
                </div>
            </div>
        </div>
    </div>
    
    <!-- Usuario Modal-->
    <div class="modal fade" id="usuarioModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Minha Conta</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">
                
                	<div class="row">
                		<div class="col-md-6 text-right">
                			Nome do Usuário:
                		</div>
                		<div class="col-md-6">
                			<strong>${usuario_autenticado.nome}</strong>
                		</div>
                	</div>
                	
                	<div class="row">
                		<div class="col-md-6 text-right">
                			Email de Acesso:
                		</div>
                		<div class="col-md-6">
                			<strong>${usuario_autenticado.email}</strong>
                		</div>
                	</div>
                	
                	<div class="row">
                		<div class="col-md-6 text-right">
                			Criado em:
                		</div>
                		<div class="col-md-6">
                			<strong>
                				<fmt:formatDate 
                					value="${usuario_autenticado.dataCriacao}"
                					pattern="dd/MM/yyyy"
                				/>
                			</strong>
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
    
    <!-- JQuery validate -->
    <script src="resources/vendor/jquery-validate/jquery.validate.min.js"></script>
    <script src="resources/vendor/jquery-validate/messages_pt_BR.min.js"></script>
    
    <script>
		$(document).ready(function(){
			
			$("#formCadastro").validate(
				{
					rules : {
						nome : {
							required : true,
							minlength : 6,
							maxlength : 150
						},
						data : {
							required : true
						},
						hora : {
							required : true
						},
						tipo : {
							required : true
						},
						prioridade : {
							required : true
						},
						descricao : {
							required : true,
							minlength : 6,
							maxlength : 1000
						}
					}		
				}
			);
			
		})	
	</script>

</body>

</html>