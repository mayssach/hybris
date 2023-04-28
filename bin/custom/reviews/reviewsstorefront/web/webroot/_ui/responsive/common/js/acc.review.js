ACC.productReview = {

    _autoload: [
        "bindProductReview"
    ],

    bindProductReview: function () {
        $(document).on("click",".js-store-details",function(e){
            var maValeur = document.getElementById("storeName").innerHTML;
            window.location.href=ACC.config.encodedContextPath + '/store/' +maValeur ;
        })
        $(document).on("click", ".js-show-more", function (e) {
            var comment = $(this).data("comment");
            var customer = $(this).data("customer");
            var title = $(this).data("title");
            ACC.colorbox.open(ACC.common.encodeHtml(title), {
                inline: true,
                href: "#show_more",
                maxWidth: "100%",
                width: "600px",
                overlayClose: false,
                initialWidth: "600px",
                onComplete: function () {
                    $("#comment_content").html(comment);
                    $("#customer_content").html(customer);
                    $(this).colorbox.resize();
                },
                onCleanup: function () {
                    $("#comment_content").html("");
                    $("#customer_content").html("");
                }

            });

        });
        $(document).on("click", ".js-add-review", function (e) {
            e.preventDefault();
            var title = $(this).data("title");
            ACC.colorbox.open(ACC.common.encodeHtml(title), {
                inline: true,
                href: "#popup_add_review",
                maxWidth: "100%",
                width: "600px",
                overlayClose: false,
                initialWidth: "600px",
                onComplete: function () {
                    $(this).colorbox.resize();
                }

            });

        });

        $(document).on("click", ".js-close-popup-review", function (e) {

            e.preventDefault();

            // Vérifier si tous les champs obligatoires sont remplis
            var allFieldsFilled = true;
            $("#reviewForm .js-required").each(function () {
                if ($(this).val() === "" && !$(this).parent().hasClass('has-error')) {
                    allFieldsFilled = false;
                    $(this).parent().addClass('has-error');
                    $(this).after('<span class="help-block">This field is required.</span>');
                }else if($(this).val() === "" && $(this).parent().hasClass('has-error')) {
                    allFieldsFilled = false;
                    $(this).parent().addClass('has-error');
                }
                else {
                    $(this).parent().removeClass('has-error');
                    $(this).siblings('.help-block').remove();
                }
            });

            if (allFieldsFilled) {
                // Si tous les champs obligatoires sont remplis, soumettre le formulaire
                $("#reviewForm").submit();
            } else {
                // Sinon, afficher un message d'erreur à l'utilisateur
               // alert("Veuillez remplir tous les champs obligatoires.");
            }
        });

    }
}
