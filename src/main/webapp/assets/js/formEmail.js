$ = jQuery;
var i = 1;
$(".formEmail").click(function () {
    $(".jQueryEmail").append("<input type=\"text\" class=\"form-control mt-2\" id=\"inputAddress" + [i] + "\" placeholder=\"Rentrez un email\">");
    i++
});