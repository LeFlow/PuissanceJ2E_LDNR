$(function(){
	
//	setInterval(function(){
//		console.log("Pret");
//		$('#text').load('loading');
//	}, 1000)
//	

	setTimeout(function(){
		
//		function refresh() {
//			$.ajax({
//			    url: "loading", // Ton fichier ou se trouve ton chat
//			    success:
//			        function(retour){
//			        $('#text').html(retour); // rafraichi toute ta DIV "bien sur il lui faut un id "
//			    }
//			});
//			 
//			}
//	 
//		setInterval(refresh(), 1000) // Répète la fonction toutes les 1 sec
		
		
		function refresh(){ 
			$("#text").load("loading #text");
			setTimeout("refresh()", 1000);
		}
		
		
		
		
		
	}, 1000);
	
	

	
	
	
	
	
})