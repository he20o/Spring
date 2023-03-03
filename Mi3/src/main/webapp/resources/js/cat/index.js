
    $(function(){       //익명 함수
        var myDiv = $('#cat');
        myDiv.on('click',function(){
            myDiv.animate({     //1.애니메이션 대상 속성값 변경
                'width':'300px',
                'height':'200px',
            }, 1000, 'linear');

            myDiv.animate({     //2.opacity 변경
                'opacity':0.5
            }, 1000,'swing');

            myDiv.animate({     //3.left,top 위치 변경
                'left':'+=100px',
                'top':'+=100px'
            },1000, 'swing');

            myDiv.animate({     //4. font-size 변경
                'font-size':'24px'
            }, 1000, 'swing');

            myDiv.animate({
                'opacity':1
            }, 1000, 'swing');

            myDiv.animate({
                'width':'100px',
                'height':'100px',
            },1000, 'linear');

            myDiv.animate({
                'font-size':'18px'
            }, 1000,'swing');
        });
    });
