
$( document ).ready(function() {

  // Load random, but cached, images into an Array for display.

  /*
  var images = [];
  var rand = 3;
  for(a = 1; a <= 16; a++) {
    images.push("https://loremflickr.com/320/240?random="+(a+rand)+"?lock="+a);
    rand += 3;
  }*/

  var form = $("#myform");
  form.on( "submit", function( event ) {

    event.preventDefault();

    $.ajax({
      type: form.attr("method"),
      url: form.attr("action"),
      data: form.serialize(),
      success: function (data) {

        console.log("data: "+data)

        var spl0 = data.split("\t");

        if(spl0.length > 1) {

          var datasets = []
          var spl1 = spl0[1].split("|");
          var backgroundCol = ["rgb(244, 66, 66, 0.5)","rgb(244, 238, 65, 0.5)","rgb(65, 244, 88, 0.5)","rgb(65, 67, 244, 0.5)"];
          var k = 0;

          for(b = 0; b < spl1.length; b++) {

            var dat = []
            var spl1A = spl1[b].split(",");
            var gate = 0;
            var label = "";

            for(c = 0; c < spl1A.length-2; c++) {

              var spl1B = spl1A[c].split(" ");

              if(gate == 0) {
                label = spl1B[spl1B.length-1];
                gate = 1;
              }
              dat.push(parseInt(spl1B[2]));
            }
            datasets.push({label: label, data: dat, backgroundColor: backgroundCol[k]});
            k++;
          }

          $("scatter").empty();

          var ctx = document.getElementById("scatter");

          new Chart(ctx, {
            type: 'radar',
            data: {
              labels: ["1", "2", "3", "4", "5", "6", "7", "8", "9","10","11","12"
              ,"13","14","15","16"],
              datasets: datasets
            },
            options: {
              title: {
                display: true,
                text: ''
              }
            }
          });

          /*
          {
            label: "1950",
            fill: true,
            backgroundColor: "rgba(179,181,198,0.2)",
            borderColor: "rgba(179,181,198,1)",
            pointBorderColor: "#fff",
            pointBackgroundColor: "rgba(179,181,198,1)",
            data: [8.77,55.61,21.69,6.62,6.82]
          }
          */

        }

      	var spl2 = spl0[0].split(",");

        $("#cardDeck").empty();

        for (e = 0; e < spl2.length-1; e++) {

          var spl2A = spl2[e].split(" ");
          var img = spl2A[0]-1;
          var rand = 3;

          var card = "<div class=\"col-md-4\">"
          + "<div class=\"card mb-4 shadow-sm\">"
          + "<img class=\"card-img-top\" src=\""
          + "https://loremflickr.com/320/240?random="+(spl2A[0]+rand)+"?lock="+spl2A[0] +"\" alt=\"Card image cap\">"
          + "<div class=\"card-body\">"
          + "<p class=\"card-text\">IMG# "+spl2A[0]+"</p>"
          + "<div class=\"d-flex justify-content-between align-items-center\">"
          + "</div>"
          + "</div>"
          + "</div>";

          $("#cardDeck").append(card);
          rand += 3;

        }

      }, error : function(jqXHR,textStatus,errorThrown) {
          alert("Error "+" "+jqXHR.status+" "+textStatus+" "+errorThrown)
      }

    });
  });
});
