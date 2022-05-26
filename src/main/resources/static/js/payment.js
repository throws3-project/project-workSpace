// 가격 선택 시 가격 나타내주기
$("input[type=radio]").change(function(){
    let value = $(this).val();

    if( value ==="10000"){
        $("#message").text("총 결제금액 : 11,000원 (부가세 10% 포함)")
    }else if( value ==="20000" ){
        $("#message").text("총 결제금액 : 22,000원 (부가세 10% 포함)")
    }else if( value ==="50000" ){
        $("#message").text("총 결제금액 : 55,000원 (부가세 10% 포함)")
    }else if( value ==="100000"){
        $("#message").text("총 결제금액 : 110,000원 (부가세 10% 포함)")
    }
});

$(function(){
    $('button.kakao').click(function(){
        $.ajax({
            url: '/kakaoPay' ,
            dataType: 'json' ,
            success: function(data){
                // alert(data.next_redirect_pc_url);
                var box =  data.next_redirect_pc_url;
                window.open(box);
            },
            error:function(error){
                alert(error);
            }
        })
    })
})