apiclient=(function(){
	return {
		getCinemaByName:function(name,callback){
			console.log(name);
			$.ajax({
			    type: "GET",  
			    url: "weather/" + name ,
			    success: callback,
			    error: function(XMLHttpRequest, textStatus, errorThrown) { 
			        alert("Status: " + textStatus); alert("Error: " + errorThrown); 
			    }       
			});
		}
	}
})();