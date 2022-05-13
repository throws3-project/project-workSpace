$('#profile').on('click', function(){
    if($('.hoverMenu').css('display') === 'none'){
        $('.hoverMenu').show();
    }else{
        $('.hoverMenu').hide();
    }
});

$('.joinAndLogin').each(function(i, btn){
    $(btn).on("click", function(){
        $($(".modalWindow").get(i)).show();
    });
});

$('.logOut').on("click", function(){
    $($(".modalWindow").get(2)).show();
});

$('.modal_close_btn').each(function(i, btn){
    $(btn).on("click", function(){
        $($(".modalWindow").get(i)).hide();
    });
});

$('.complete').on("click", function(){
    $($(".modalWindow").get(2)).hide();
});