<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-2.1.0.js" type="text/javascript" charset="utf-8"></script>
<script src="js/ajaxfileupload.js"></script>
</head>
<body>
	<input type="file" name="file" id="file"  /><br />
	<img id="img" style="width: 500px;height: auto;display: none;" /><br />
	<button id="btn">图片上传</button><br />
	<button id="btn1">图片上传base64</button><br />
	<script type="text/javascript">
	
	$("#file").change(function(){
		//判断上传的是否是图片
		var fp = $("#file").val();
		//为了避免转义反斜杠出问题，这里将对其进行转换
		//  为了避免转义反斜杠出问题这里将对其进行转换
		var re = /(\\+)/g;
		var fn = fp.replace(re, "#");
		//对路径字符串进行剪切截取
		var one = fn.split("#");
		//获取数组中最后一个，即文件名
		var two = one[one.length - 1];
		//再对文件名进行截取，以取得后缀名
		var three = two.split(".");
		//获取截取的最后一个字符串，即为后缀名
		var last = three[three.length - 1];
		last = last.toLowerCase();

		if (last != 'png' && last != 'jpg' && last != 'gif'
				&& last != 'PNG' && last != 'JPG' && last != 'GIF') {
			alert("请上传png、jpg或者gif文件！");
			return;
		}
				
		$("#img").attr("src",URL.createObjectURL($("#file")[0].files[0]));
		$("#img").show();
		
		
		
	});
	
	
	function image2Base64(img) {
	    var canvas = document.createElement("canvas");
	    canvas.width = img.width;
	    canvas.height = img.height;
	    var ctx = canvas.getContext("2d");
	    ctx.drawImage(img, 0, 0, img.width, img.height);
	    var dataURL = canvas.toDataURL("image/png");
	    return dataURL;
	}
	
	$("#btn").click(function(){
		
		$.ajaxFileUpload({
			url:"fileup",
			secureuri:false,
			fileElementId:"file",
			dataType:"text",
			success:function(data){
				if(data == "success"){
					alert("图片上传成功");
				}
				
			}
		})
		
	});
	
	$("#btn1").click(function(){
		var imgurl = $("#img").attr("src");  //获取的图片路径
		var img = new Image();
		img.src=imgurl;
		
		var imgpojo={imgStr:image2Base64(img)};
		//alert(imgpojo);
		$.ajax({
			url:"imgup",
			type:"post",
			data:imgpojo,
			dataType:"text",
			success:function(data){
				
					alert(data);
				
					
			}
		//console.log(imgStr);
		});
	});
		
	</script>

	 <!-- <script type="text/javascript">
		$.ajax({
			type:"post",
			url:"getAllUser",
			dataType:"json",
			success:function(data){
				alert(data);
			}
		});
	</script> -->


</body>
</html>