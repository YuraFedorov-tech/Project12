$(function ($) {
    $('#btnDelete').click(function (e) {
        e.preventDefault();
        var result = $('.js-dataDelete').serializeArray();
        alert('delete');
        $.ajax({
            url: "/admin/delete",
            type: 'POST',
            data: result,
            context: document.getElementById('#ajax'),
            success: function (data) {
                succsess2(data);
                alert('succsess');
            }
        });
        $('#myModalDelete').modal('hide');
    });
});

function succsess2(result) {
    $('.js-tableUsers tr td:first-child  span').each(function () {
        var ans = $(this).text();
        if (ans == result.id) {
            $(this).parent().parent().remove();
        }
    });
}

function returnListRoles( idDelete) {
    var ansRole = 'dsf';
  //  result.css({border: '2px solid blue'});
    $('.js-tableUsers tr td:first-child  span').each(function () {
        var ans = $(this);

        if (ans.text() == idDelete) {
            ansRole= ans.parent().parent().children().find('#js-spanRole').text();
        }
    });
    alert(ansRole);
    return ansRole;
}