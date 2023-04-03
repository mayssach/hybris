ACC.productReview = {

    _autoload: [
        "bindProductReview"
    ],

    bindProductReview: function () {

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
                if ($(this).val() === "") {
                    allFieldsFilled = false;
                    $(this).parent().addClass('has-error');
                    $(this).after('<span class="help-block">This field is required.</span>');
                } else {
                    $(this).parent().removeClass('has-error');
                    $(this).siblings('.help-block').remove();
                }
            });

            if (allFieldsFilled) {
                // Si tous les champs obligatoires sont remplis, soumettre le formulaire
                $("#reviewForm").submit();
            } else {
                // Sinon, afficher un message d'erreur à l'utilisateur
                alert("Veuillez remplir tous les champs obligatoires.");
            }


            /* e.preventDefault();
            var form = $("#reviewForm");
            var url = form.data("action");
            var formData = form.serialize();

            $.ajax({
                type: "POST",
                url: url,
                data: formData,
                success: function (response) {
                    if (response.success) {
                        ACC.colorbox.close();
                    } else {
                        form.find(".js-required").each(function () {
                            var $field = $(this);
                            var fieldName = $field.attr("name");
                            if (response.errors.hasOwnProperty(fieldName)) {
                                var errorMsg = response.errors[fieldName][0].defaultMessage;
                                $field.closest(".form-group").addClass("has-error");
                                $field.after("<span class='help-block'>" + errorMsg + "</span>");
                            } else {
                                $field.closest(".form-group").removeClass("has-error");
                                $field.next(".help-block").remove();
                            }
                        });

                    }
                },
                error: function (xhr, status, error) {
                    console.log("Une erreur s'est produite lors de la soumission du formulaire", error);

                }
            });*/
        });
    }
}