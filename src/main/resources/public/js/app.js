app=(function(){
	
	return{
		getWeatherCity:function(){
			var city = $('#input').val();
			console.log(city)
			return apiclient.getCinemaByName(city, function(cinema){
				console.log(cinema);
				var x = JSON.parse(cinema);
				var table = $("#tableInfo");
				$("#tableInfo > tr").remove();
				table.append('<tr>' +
						"<td>"+ "Longitud  " + x.coord.lon +  " Latitup " + x.coord.lat    +"</td>" +
						"<td>"+ x.main.pressure +"</td>" +
						"<td>"+ x.main.humidity +"</td>"+
						"<td>"+ x.main.temp_min +"</td>"+
						"<td>"+ x.main.temp_max +"</td>"+
                        //'<tdstyle="display: none; >"'+cine.functions[i].seats+
                        //'</td>'+
                       "</tr>");
			})	
		}
	}
})();