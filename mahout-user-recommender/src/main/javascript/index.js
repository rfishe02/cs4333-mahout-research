
$( document ).ready(function() {

    var form = $("#myform");
    form.on( "submit", function( event ) {

      event.preventDefault();
      //$("#result").empty();
      $("#cardDeck").empty();

      $.ajax({
        type: form.attr("method"),
        url: form.attr("action"),
        data: form.serialize(),
        success: function (data) {

        	var spl = data.split(",");

        	if(spl.length > 2) {

            for (i = 0; i < spl.length; i++) {
              var spl2 = spl[i].split(" ");

              var card = "<div class=\"col-md-4\">"
              + "<div class=\"card mb-4 shadow-sm\">"
              + "<svg class=\"bd-placeholder-img card-img-top\" width=\"100%\" height=\"225\" xmlns=\"http://www.w3.org/2000/svg\" preserveAspectRatio=\"xMidYMid slice\" focusable=\"false\" role=\"img\" aria-label=\"Placeholder: "
              + spl2[0]+"\"><title>"
              + spl2[0]+"</title><rect width=\"100%\" height=\"100%\" fill=\"#55595c\"></rect><text x=\"50%\" y=\"50%\" fill=\"#eceeef\" dy=\".3em\">Thumbnail</text></svg>"
              + "<div class=\"card-body\">"
              + "<p class=\"card-text\"> </p>"
              + "<div class=\"d-flex justify-content-between align-items-center\">"
              //+ "<div class=\"btn-group\">"
              //+ "<button type=\"button\" class=\"btn btn-sm btn-outline-secondary\">View</button>"
              //+ "<button type=\"button\" class=\"btn btn-sm btn-outline-secondary\">Edit</button>"
              //+ "</div>"
              //+ "<small class=\"text-muted\">9 mins</small>"
              + "</div>"
              + "</div>"
              + "</div>" ;

              $("#cardDeck").append(card);

            }

        	} else {
            //$("#result").append(spl[0]);
          }

        }

      });
    });

});
