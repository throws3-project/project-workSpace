//  var idHoverMenu = document.getElementById('idHoverMenu');
//     //마우스오버
//     idHoverMenu.addEventListener('mouseover',function(){
//         idHoverMenu.setAttribute('class','hover');
//     });
// 	//마우스 아웃

// 	box.addEventListener('mouseout',function(){

// 		box.removeAttribute('class');

// 	});

// $(".idHoverMenu").css('display', 'block');

// $(".ugname").mouseover(function(){

//     $(this).next().css('display', 'block');

 
// });
    
// $(".ugname").mouseout(function(){

//     $(this).next().css('display', 'none');
 
// });
    
// $(".ugname").on('mouseover', function(){
//     $(this).next().css('display','block');
// }).on('mouseover foucus', function{
//     $(this).css('background-color','pink');
// });

$(".ugname").mouseover(function(){
    $(this).next().css('display','block');
}).on('mouseover foucus', function{
    $(this).css('background-color','pink');
});