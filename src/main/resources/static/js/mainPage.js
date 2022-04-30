const btns = document.querySelectorAll("button.btn");
const banner = document.querySelector("div.banner");

btns.forEach(function(value, index, ar){
    ar[index].addEventListener("click", function(){
        banner.style.transform = "translate(-" + index * 90 + "vw)";
    })
});
