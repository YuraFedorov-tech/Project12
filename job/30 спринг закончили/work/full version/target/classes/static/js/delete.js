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
    $('.js-tableUsers tr td:first-child  span').each(function () {
        var ans = $(this);
        if (ans.text() == idDelete) {
            ansRole= ans.parent().parent().children().find('.js-spanRole').text();
        }
    });
    var ans2=getRoleWithSpace(ansRole);
    return ans2;
}
function getRoleWithSpace( ansRole) {
    var ansRoleWithSpac = '';
    ansRoleWithSpac=findAtOneRole(ansRole, 'GUEST');
    ansRoleWithSpac=ansRoleWithSpac+findAtOneRole(ansRole, 'USER');
    ansRoleWithSpac=ansRoleWithSpac+findAtOneRole(ansRole, 'ADMIN');
    ansRoleWithSpac=ansRoleWithSpac+findAtOneRole(ansRole, 'SUPERADMIN');
    return ansRoleWithSpac;
}

function findAtOneRole( ansRole ,pretendent) {
    console.log(ansRole);
    var ansRoleWithSpac = '';
    if(ansRole.indexOf(pretendent) !== -1){
        alert(pretendent);
        ansRoleWithSpac=pretendent+" ";
    }
    return ansRoleWithSpac;
}