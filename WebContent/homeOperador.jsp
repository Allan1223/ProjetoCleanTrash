<!DOCTYPE html>
<html lang="en" class="no-js">
	<head>
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
		<title>Clean Trash</title>
		<meta name="description" content="Dynamic Grid with CSS Transitions inspired by the Google Trends Grid Visualization" />
		<meta name="keywords" content="google trends, dynamic grid, css transitions, javascript, responsive, fluid, layout" />
		<meta name="author" content="Codrops" />
		<link rel="shortcut icon" href="../favicon.ico"> 
		<link rel="stylesheet" type="text/css" href="css/default2.css" />
		<link rel="stylesheet" type="text/css" href="css/default.css" />
		<link rel="stylesheet" type="text/css" href="css/component.css" />
		
		<link rel="stylesheet" type="text/css" href="css/component2.css" />
		<script src="js/modernizr.custom.js"></script>
		<script src="js/modernizr2.custom.js"></script>
		
				
	</head>
	<body>
	
		<div class="md-modal md-effect-19" id="modal-19">
			<div class="md-content">
				<h3>Clean Trash</h3>
				<div>
					<!--<p>This is a modal window. You can do the following things with it:</p>-->
					<ul>
						<li><strong>Versão:</strong> 1.0 </li>
						<li><strong>Desenvolvimento:</strong> RefSoft 2015</li>
						<!--<li><strong>Close:</strong> click on the button below to close the modal.</li>-->
					</ul>
					<button class="md-close">Fechar</button>
				</div>
			</div>
		</div>
				
		<div class="container demo-3">
			<div id="gt-grid-selector" class="gt-grid-control">
				<span class="gt-grid-icon"></span>
				<div class="gt-grid-select">
					<div></div> <div></div> <div></div> <div></div> <div></div> 
					<div></div> <!--<div></div> <div></div><div></div> <div></div> 
					<div></div><div></div><div></div><div></div><div></div>
					<div></div><div></div><div></div><div></div><div></div>
					<div></div><div></div><div></div><div></div><div></div> -->
				</div>
			</div>
			<div id="gt-grid" class="gt-grid">
				<div>
					<h1>Clean Trash</h1>
					
					<!--<img src="images\home-icon.png" style="opacity:0.6">-->
					<div class="codrops-top">
						<a class="codrops-icon codrops-icon-prev" href="index.jsp"><span>Sair</span></a>
					</div>	
				</div>
				<!--<div>
					
						<a class="codrops-icon codrops-icon-prev" href="#"><span>Reportar Problemas</span></a>
						<span class="right"><a class="codrops-icon codrops-icon-drop" href="http://tympanus.net/codrops/?p=15468"><span>Codrops Article</span></a></span>
					</div>
				</div>-->
				
				<!--<div><h3>Status dos Problemas</h3></div>
				<div><h3>Manutenção</h3></div>
				<div><h3>About</h3></div>-->
				<div class="special"><h3><a href="problemas.html"> Reportes </a></h3></div>
				<div class="special"><!-- <h3><a href="reportar.html">Reportar Problemas</a></h3>--></div>
				<div class="special"><h3><a href="controladorUsuario?acao=listar">Manuten&ccedil&atildeo Usu&aacute;rio</a></h3></div>
				<div class="special"><h3><a href="ajudaOperador.html">Ajuda</a></h3></div>
				<div class="special">
				
				<div class="main clearfix">
				
					<div class="column">
						<button class="md-trigger md-setperspective" data-modal="modal-19">Sobre</button>
						<!--<h3><a href="sobre.html">Sobre</a></h3>-->
					</div>
					</div>
				</div>
				
				
				
				
				
				<!--<div><h3>celery</h3></div>
				<div><h3>greens lotus</h3></div>
				<div><h3>arugula beet</h3></div>
				<div><h3>desert raisin</h3></div>
				<div><h3>mustard burdock</h3></div>
				<div><h3>potato bush</h3></div>
				<div><h3>catsear</h3></div>
				<div><h3>water chestnut</h3></div>
				<div><h3>bok choy</h3></div>
				<div><h3>pea sprouts</h3></div>
				<div><h3>gumbo parsley</h3></div>
				<div><h3>bitterleaf</h3></div>
				<div><h3>spinach rock</h3></div>
				<div><h3>tigernut garlic</h3></div>
				<div><h3>caulie</h3></div>
				<div><h3>seakale</h3></div>-->
			</div>

		</div><!-- /container -->
		<!-- classie.js by @desandro: https://github.com/desandro/classie -->
		<script src="js/classie.js"></script>
		<script src="js/gridSelector.js"></script>
		<script src="js/grid.js"></script>
		<script>
			Grid.init( {
				transition : true,
				speed : 450,
				delay: 20
			} );
		</script>
		
		<div class="md-overlay"></div><!-- the overlay element -->

		<!-- classie.js by @desandro: https://github.com/desandro/classie -->
		<script src="js/classieM.js"></script>
		<script src="js/modalEffects.js"></script>

		<!-- for the blur effect -->
		<!-- by @derSchepp https://github.com/Schepp/CSS-Filters-Polyfill -->
		<script>
			// this is important for IEs
			var polyfilter_scriptpath = '/js/';
		</script>
		<script src="js/cssParser.js"></script>
		<script src="js/css-filters-polyfill.js"></script>
	</body>
</html>