
define("test", function() {
	var init = function() {
		alert("test test");
	}	
	return {
		init : init
	}

});

$(function(){
	$("#exitbtn").click(function(){
		
		require([ "test" ], function(index) {
			
			index.init();
		})
	});
	
})
