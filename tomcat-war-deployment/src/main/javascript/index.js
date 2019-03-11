$( document ).ready(function() {

    var form = $("#goform");
    form.on( "submit", function( event ) {

      event.preventDefault();
      $("#result").empty();

      $.ajax({
        type: form.attr("method"),
        url: form.attr("action"),
        data: form.serialize(),
        success: function (data) {

        	var spl = data.split(",");

        	if(spl.length > 2) {

            for (i = 0; i < spl.length; i++) {
              var spl2 = spl[i].split(" ");
              $("#result").append("<h2>"+spl2[0]+"</h2>");
        			$("#result").append("<br>");

            }

        	}
        }
      });
    });

});
