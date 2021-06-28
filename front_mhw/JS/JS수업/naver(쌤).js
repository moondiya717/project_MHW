  var id;
  $(function(){
    id=rollingLeft('.right2 .view-box .contents-box', 'li', 800, 1000);
    $('.right2').hover(function(){
      clearInterval(id);
    },function(){
      id=rollingLeft('.right2 .view-box .contents-box', 'li', 800, 1000);
    })

    $('.right2 .btn-box .next-btn').click(function(){
      if(!$('.right2 .contents-box li').first().is(':animated')){
        var width = $('.right2 .contents-box li').first().width();
        $('.right2 .contents-box li').first().animate({'margin-left':-width+'px'},800,function(){
          $(this).detach().appendTo('.right2 .contents-box').removeAttr('style');
        })
       }
    })

      $('.right2 .btn-box .prev-btn').click(function(){
        if(!$('.right2 .contents-box li').first().is(':animated')){
          var width=$('.right2 .contents-box li').first().width();
          $('.right2 .contents-box li').last().detach().prependTo('.right2 .contents-box')
            .css('margin-left',-width+'px').animate({'margin-left':0},800);
        }
      })
  })
