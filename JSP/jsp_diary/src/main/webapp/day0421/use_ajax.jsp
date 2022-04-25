<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="AJAX로 요청하기"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 공통CSS -->
<link rel="stylesheet" type="text/css" href="http://211.63.89.135/jsp_prj/common/css/main_20220321.css"/>
<style type="text/css">
#result{ border : 1px solid #333; width:800px; height: 200px; margin-top: 20px;}
</style>
<!-- jQuery CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- bootstrap CDN -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
<script type="text/javascript">
$(function() {
	$("#text").click(function(){
		$.ajax({
			url:"ajax.txt",
			dataType:"text",
			error:function(xhr){
				alert("문제발생"+xhr.status+"," +xhr.statusText);
			},
			success:function(data){
				let output="<ul>";
				
				var arr = data.split(",");
				for(var i = 0; i < arr.length; i++){
					output+="<li>" + arr[i] + "</li>";
				}
				output +="</ul>";
				
				$("#result").html(output);
			}
		})
	})
	
	$("#html").click(function(){
		$.ajax({
			url: "ajax.html",
			async:true,
			dataType:"html",
			error:function(xhr){
				alert("에러" + xhr.status + ", " + xhr.statusText);
			},
			success:function(data){
				$("#result").html(data);
			}
		})
	}); // click
	
	$("#xml").click(function() {
		$.ajax({
			url: "ajax.xml",
			dataType:"xml",
			error:function(xhr){
				console.log(xhr.status + "/" + xhr.statusText);
			},
			success:function(data){
				$("#result").html($(data).find("name"));
			}
		})
	}) // click
	
	$("#json").click(function() {
		  $.ajax({
			  url:"ajax.json",
			  dataType:"json",
			  error:function( xhr ){
				  console.log(xhr.status + " / " + xhr.statusText);
			  },
			  success:function( data ){
			 	$("#result").html(data.name + " " + data.age);
			  }
			  
		  }) // json
	}) // click
	
}); // ready
</script>
</head>
<body>
<input type="button" value="HTML요청" id="html" class="btn btn-success"/>
<input type="button" value="Text요청" id="text" class="btn btn-info"/>
<input type="button" value="XML요청" id="xml" class="btn btn-danger"/>
<input type="button" value="JSON요청" id="json" class="btn btn-dark"/>
<div id="result"></</div>
</body>
</html>