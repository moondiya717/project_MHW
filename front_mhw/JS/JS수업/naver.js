var id;
$(function(){
  // 오른쪽 두번째 컨텐츠 롤링기능
id=rollingLeft('.right2-list','li',800,1000);
$('.right2').hover(function(){
  clearInterval(id);
}, function(){
  id=rollingLeft('.right2-list','li',800,1000);
});
 // 오른쪽 두번쨰 컨텐츠 다음 버튼 
$('.next-btn').click(function(){
  var width = $('.right2-list li').first().innerWidth();
  $('.right2-list li').first().animate({'margin-left':-width+'px'},800,function(){
      $(this).detach().appendTo('.right2-list').removeAttr('style');
    })
})
 // 오른쪽 두번쨰 컨텐츠 이전 버튼 
$('.prev-btn').click(function(){
  var width=$('.right2-list li').first().innerWidth();
  $('.right2-list li').last().detach().prependTo('.right2-list')
    .css('margin-left',-width+'px').animate({'margin-left':0},800);
})

})
