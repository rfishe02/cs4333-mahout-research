


$( document ).ready(function() {

  // Load random, but cached, images into an Array for display.

  var images = [];

  for(a = 1; a <=30; a++) {
    images.push("https://loremflickr.com/320/240?random="+a+"?lock="+a);
  }

  var form = $("#myform");
  form.on( "submit", function( event ) {

    event.preventDefault();
    $("#cardDeck").empty();

    $.ajax({
      type: form.attr("method"),
      url: form.attr("action"),
      data: form.serialize(),
      success: function (data) {

        console.log("data: "+data)

      	var spl = data.split(",");

      	if(spl.length > 2) {

          for (i = 0; i < spl.length-1; i++) {
            var spl2 = spl[i].split(" ");
            var img = spl2[0]-1;

            var card = "<div class=\"col-md-4\">"
            + "<div class=\"card mb-4 shadow-sm\">"
            + "<img class=\"card-img-top\" src=\""
            + images[img]+"\" alt=\"Card image cap\">"
            + "<div class=\"card-body\">"
            + "<p class=\"card-text\">IMG# "+spl2[0]+"</p>"
            + "<div class=\"d-flex justify-content-between align-items-center\">"
            + "</div>"
            + "</div>"
            + "</div>";

            $("#cardDeck").append(card);

          }

      	} else {
          $("#cardDeck").append(spl[0]);
        }

      }, error : function(jqXHR,textStatus,errorThrown) {
          alert("Error "+" "+jqXHR.status+" "+textStatus+" "+errorThrown)
      }

    });
  });
});
