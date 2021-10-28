$(document).ready(function() {
  var index = "";
  var totalPaid = 0;
  var change = 0;

  $.ajax({
    type: "GET",
    url: "http://tsg-vending.herokuapp.com/items",
    success: function(data) {
$.each(data, function(index, item) {
        var itemid = item.id;
        var itemname = item.name;
        var itemprice = item.price;
        var itemquantity = item.quantity;
        var row =
          '<button type ="button"class="itembutton"value="' +
          itemid +
          '"<div class="col-md-3" id="index-0"style="width:200px;height:200px;margin:1%;padding:5px;border:2px solid white;background-color:Black;">';
        row += "<h4>";
        row += '<h4 id="item-id-"> ' + itemid + "</h4>";
        row += "<h4 >" + itemname + "</h4>";
        row += '<h4 id="item-price-">$' + itemprice + "</h4>";
        row += "<h4 >Quantity left:" + itemquantity + "</h4>";

        row += "</h4>";
        row += "</div>";
        $("#vend").append(row);
      });
      $(".itembutton").click(function() {
        $("#item-selected").val($(this).val());
      });
    },

    error: function() {
   $("#messages").val("Out of Order.  Please call service.");
   }
  });
  $("[id^=index]").click(function(event) {
  $("#messages").val("");
    if ($("#change").val()) {
     $("#messages").val('Please click on "Change Return"');
      return false;
    }
    var indexSelected = $(this).attr("id");
    index = indexSelected.slice(-1);
    $("#item-selected").val($("#item-id-" + index).text());
  });

  $("#add-dollar-button").click(function(event) {
    $("#messages").val("");
    if ($("#change").val()) {
      $("#messages").val('Please click on "Change Return"');
      return false;
    }
   totalPaid = totalPaid + 1;
    $("#total-money-in").val(totalPaid.toFixed(2));
  });

  $("#add-quarter-button").click(function(event) {
    $("#messages").val("");
    if ($("#change").val()) {
      $("#messages").val('Please click on "Change Return"');
      return false;
    }
    totalPaid = totalPaid + 0.25;
    $("#total-money-in").val(totalPaid.toFixed(2));
  });

  $("#add-dime-button").click(function(event) {
    $("#messages").val("");
    if ($("#change").val()) {
      $("#messages").val('Please click on "Change Return"');
      return false;
    }
    totalPaid = totalPaid + 0.1;
    $("#total-money-in").val(totalPaid.toFixed(2));
 });

  $("#add-nickel-button").click(function(event) {
   $("#messages").val("");
   if ($("#change").val()) {
     $("#messages").val('Please click on "Change Return"');
     return false;
    }
    totalPaid = totalPaid + 0.05;
    $("#total-money-in").val(totalPaid.toFixed(3));
  });

  $("#make-purchase-button").click(function(event) {
    $("#messages").val("");
   if ($("#change").val()) {
      $("#messages").val('Please click on "Change Return"');
      return false;
   }
    if (!$("#item-id-" + index).text()) {
      $("#messages").val("Please select an item.");
      return false;
    } else {
     $("#item-id-").val("Pl")
    
    }
    if(!$("#total-money-in").val()) {
    $("#messages").val(
       "Please Enter Money " //+ $("#item-price-" + index).text()
      );
     return false;
   }
    $.ajax({
      type: "POST",
      url:
        "http://tsg-vending.herokuapp.com/money/" +
        $("#total-money-in").val() +
        "/item/" +
        $("#item-selected").val(),
      success: function(data, item) {
        $("#messages").val("Thank You!!!");
        var quarters = data.quarters;
        var dimes = data.dimes;
        var nickels = data.nickels;
        var pennies = data.pennies;
        returnChange(quarters, dimes, nickels, pennies);
        reduceInventory(index);
        $("#item-selected").val("");
        index = "";
        totalPaid = 0;
      },
      error: function(request, status,error) {
        $('#messages').val(request.responseJSON.message);
        var data = xhr.responseText;
        console.log(xhr);
       var jsonResponse = JSON.parse(data);
      $("#messages").val(jsonResponse["message"]);
       if (jsonResponse["message"] == "SOLD OUT!!!") {
          returnTotalPaid(totalPaid);
       $("#item-selected").val("");
         index = "";
         totalPaid = 0;
         return false;
       }
        if (jsonResponse["message"].slice(0, 14) == "Please deposit") {
       return false;
      }
       $("#messages").val("Out of Order.  Please call service.");
      }
    });
  });

  $("#change-return-button").click(function(event) {
    if (totalPaid == 0) {
      $("#change").val("");
      $("#messages").val("");
    } else {
      returnTotalPaid(totalPaid);
      $("#item-selected").val("");
      $("#messages").val("");
      index = "";
      totalPaid = 0;
      change = 0;
    }
 });
});


function returnTotalPaid(moneyDeposited) {
  var quarters = Math.floor((moneyDeposited * 100) / 25);
  var dimes = Math.floor(((moneyDeposited * 100) % 25) / 10);
  var nickels = Math.floor(
    (moneyDeposited * 100 - 25 * quarters - 10 * dimes) / 5
  );
  var pennies = 0;
  returnChange(quarters, dimes, nickels, pennies);
}

function returnChange(quarters, dimes, nickels, pennies) {
  var changeToReturn = "";
  var change = 0;
  if (quarters != 0) {
    changeToReturn = changeToReturn + "  " + quarters.toFixed(0) + " Quarter"; 
    change = quarters * 25 ;
  }
  if (dimes != 0) {
    changeToReturn = changeToReturn + "  " + dimes.toFixed(0) + " Dime";
  }
  if (nickels != 0) {
    changeToReturn = changeToReturn + "  " + nickels.toFixed(0) + " Nickel";
  }
  if (pennies != 0) {
    changeToReturn = changeToReturn + "  " + pennies.toFixed(0) + " Pennies";
  }
  $("#change").val(changeToReturn);
  $("#total-money-in").val("");
}