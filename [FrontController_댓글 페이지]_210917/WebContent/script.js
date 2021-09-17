$.ajax({
	type : "GET",
	url : "ad.json",
	dataType : "json",
	success : function(data){
		var str = "";
		$.each(data, function(index, obj){
			str += "<li>";
			str += "<a href='" + obj.link + "'>";
			str += "<img alt='"+ obj.alt +"' ";
			str += "src='img/" + obj.img + "'>";
			str += "</a></li>";
			
			
		});
		$("#adAdd").append(str);
	},
	error : function(){
		alert('에러발생');
	}
});