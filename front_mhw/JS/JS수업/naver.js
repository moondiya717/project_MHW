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




//기본 메뉴
var oriMenu = ['사전', '뉴스', '증권', '부동산', '지도', 'VIBE', '책', '웹툰'];
//저장으로 최종 확정된 선택된 메뉴
var selMenu = [];
//메뉴설정에서 선택한 메뉴
var arr1=[];

//링크 저장할 배열들
var oriHref = ['https://dict.naver.com/',''];
var selHref = [];
var arr1Href = [];

$(function(){
$('.box3 .btn_more').click(function(){
 $('.box3-btn-more').show();
 $('btn-more-settingbox').show();
 $('.btn-more-settingbox').show();
 $('.box3 .btn_more').hide();
 $('.box3 .btn_hide').show();
})
$('.box3 .btn_hide').click(function(){
$('.box3-btn-more').hide();
$('btn-more-settingbox').hide();
$('.btn-more-settingbox').hide();
$('.box3 .btn_hide').hide();
$('.box3 .btn_more').show();
$('.contents-btn-more').show();
$('.contents-btn-more2').addClass('display-none');
$('.setting-btn-box').hide();
$('.weather_rolling').show();
setMenuBox(selMenu, oriMenu, selHref, oriHref);
arr1=[];
arr1Href=[];
initCheckbox(selMenu)

})
$('.btn-setting').click(function(){
$('.weather_rolling').hide();
$('.btn-more-settingbox').hide();
$('.setting-btn-box').show();
$('.contents-btn-more').hide();
$('.contents-btn-more2').removeClass('display-none');
initMenuBox(selMenu);
arr1=selMenu.slice(0);
arr1Href=selMenu.slice(0);

})
$('input[type=checkbox]').click(function(){
var value = $(this).val();
var index = arr1.indexOf(value);
  if(index >=0){
    arr1.splice(index,1);
    $(this).prop('checked',false);
  }else{                //이 구간부터 쌤이랑 달라서 밑에를 가져오기가 좀 그러네
    if(arr1.length<4){
      arr1.push(value);
      arr1Href.push(href);
    }else if(arr1.length>=4){ 
        $(this).prop('checked',false);
        alert('최대 4개까지 설정할 수 있습니다.');
        return;
    } 
  }
  initMenuBox(arr1)
})

$('.setting-btn-save').click(function(){
  if(arr1.length!=0){
    selMenu=arr1;
    selHref=href; //이거 맞나? 쌤이랑 달라서 
    $('.box3 .btn_hide').click();
  }else{
    if($('input[type=checkbox]:checked').length==0){ //checkbox갯수세는것
      alert('선택된 메뉴가 없습니다. 초기설정으로 돌아갑니다.')
      $('input[type=checkbox]').prop('checked',false);
      arr1.splice(0);
      arr1Href.splice(0);
      selMenu.splice(0);
      selHref.splice(0);
      setMenuBox(selMenu, oriMenu)
      $('.box3 .btn_hide').click();
    }
  }
})

$('.setting-btn-reset').click(function(){
  alert('초기설정으로 돌아갑니다.')
  $('input[type=checkbox]').prop('checked',false);
  arr1.splice(0);
  selMenu.splice(0);
  setMenuBox(selMenu, oriMenu, selHref, oriHref)
  $('.box3 .btn_hide').click();
})    
})

function initMenuBox(arr){
  $('.basic_setting a').each(function(index){
    $(this).removeClass('input-box selected display-none')

    //5번째 검은색 메뉴를 안보이게 함
    if(index >= 4){
      $(this).addClass('display-none');
    }
    //선택된 메뉴를 화면에 미리 출력
    else if(arr.length > index){
      $(this).text(arr[index]);
    }
    //남은 부분을 검은 색 빈 박스로 변경
    else{
      $(this).text('');
      $(this).addClass('input-box');
      if(index == arr.length){
        $(this).addClass('selected');
      }
    }
  })
}


function setMenuBox(selArr, oriArr, selHref, oriHref){
  //선택된 메뉴가 있으면 선택된 메뉴를 화면에 출력하고, 선택된 메뉴가 없으면 미리 지정된 메뉴를 출력
  //하기 위해 arr를 상황에 따라 선정
  var arr = selArr.length == 0 ? oriArr: selArr;
  var href = selHref.length == 0? oriHref : selHref;
  $('.basic_setting a').each(function(index){
    $(this).removeClass('display-none');
    //메뉴를 보여줘야 하기 때문에 메뉴 선택할 때 사용된 박스를 제거
    $(this).removeClass('selected input-box');
    if(index < arr.length){
      $(this).text(arr[index]);
      $(this).attr('href',hrefArr[index]);
    }else{
      $(this).addClass('display-none');
    }
  })	
}

function initCheckbox(arr){
  $('input[type=checkbox]').each(function(){
    var value = $(this).val();
    //선택된 메뉴에 값이 있으면
    if(arr.indexOf(value)>=0){
      $(this).prop('checked',true);
    }else{
      $(this).prop('checked',false);
    }
  })
}