
$( document ).ready(function() {

    var form = $("#myform");
    form.on( "submit", function( event ) {

      event.preventDefault();
      $("#cardDeck").empty();

      $.ajax({
        type: form.attr("method"),
        url: form.attr("action"),
        data: form.serialize(),
        success: function (data) {

          var images = new Array(
            "https://loremflickr.com/320/240?random=1?lock=1",
            "https://loremflickr.com/320/240?random=2?lock=2",
            "https://loremflickr.com/320/240?random=3?lock=3",
            "https://loremflickr.com/320/240?random=4?lock=4",
            "https://loremflickr.com/320/240?random=5?lock=5",
            "https://loremflickr.com/320/240?random=6?lock=6",
            "https://loremflickr.com/320/240?random=7?lock=7",
            "https://loremflickr.com/320/240?random=8?lock=8",
            "https://loremflickr.com/320/240?random=9?lock=1",
            "https://loremflickr.com/320/240?random=10?lock=10",
            "https://loremflickr.com/320/240?random=11?lock=11",
            "https://loremflickr.com/320/240?random=12?lock=12",
            "https://loremflickr.com/320/240?random=13?lock=13",
            "https://loremflickr.com/320/240?random=14?lock=14",
            "https://loremflickr.com/320/240?random=15?lock=15",
            "https://loremflickr.com/320/240?random=16?lock=16",
            "https://loremflickr.com/320/240?random=17?lock=17",
            "https://loremflickr.com/320/240?random=18?lock=18",
            "https://loremflickr.com/320/240?random=19?lock=19",
            "https://loremflickr.com/320/240?random=20?lock=20",
            "https://loremflickr.com/320/240?random=21?lock=21",
            "https://loremflickr.com/320/240?random=22?lock=22",
            "https://loremflickr.com/320/240?random=23?lock=23",
            "https://loremflickr.com/320/240?random=24?lock=24",
            "https://loremflickr.com/320/240?random=25?lock=25",
            "https://loremflickr.com/320/240?random=26?lock=26",
            "https://loremflickr.com/320/240?random=27?lock=27",
            "https://loremflickr.com/320/240?random=28?lock=28",
            "https://loremflickr.com/320/240?random=29?lock=29",
            "https://loremflickr.com/320/240?random=30?lock=30"
          );

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
              + "<p class=\"card-text\"> </p>"
              + "<div class=\"d-flex justify-content-between align-items-center\">"
              + "</div>"
              + "</div>"
              + "</div>";

              /*
              var card = "<div class=\"col-md-4\">"
              + "<div class=\"card mb-4 shadow-sm\">"
              + "<svg class=\"bd-placeholder-img card-img-top\" width=\"100%\" height=\"225\" xmlns=\"http://www.w3.org/2000/svg\" preserveAspectRatio=\"xMidYMid slice\" focusable=\"false\" role=\"img\" aria-label=\"Placeholder: Thumbnail\"><title>"
              + img+"</title><rect width=\"100%\" height=\"100%\" fill=\"#55595c\"></rect><text x=\"50%\" y=\"50%\" fill=\"#eceeef\" dy=\".3em\">"
              + "</text></svg>"
              + "<div class=\"card-body\">"
              + "<p class=\"card-text\"> </p>"
              + "<div class=\"d-flex justify-content-between align-items-center\">"
              + "</div>"
              + "</div>"
              + "</div>" ;*/

              $("#cardDeck").append(card);

            }

        	} else {
            $("#cardDeck").append(spl[0]);
          }

        }

      });
    });

});
