$('#profile').on('click', function(){
    console.log("작동했습니다.1")
    if($('.hoverMenu').css('display') === 'none'){
        $('.hoverMenu').show();
    }else{
        $('.hoverMenu').hide();
    }
    console.log("작동했습니다.2")
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