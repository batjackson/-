let swiper = document.getElementsByClassName("swiper")[0];
// var swiper_left = parseInt(swiper[0].style.left);
let prebtn = document.getElementsByClassName("pre")[0];
let nextbtn = document.getElementsByClassName("next")[0];
let cirindex = document.getElementsByClassName("swiper-index")[0].children[0];


let cirstart;
let swiper_left;
let pic_located = 0;
let nextpic=1228.8;
let last_pic = -(nextpic*4);

function nextpict() {
  swiper_left = parseFloat(swiper.style.left);
  // if(swiper_left>last_pic){
  //   // pic_located++;
  //   swiper.style.left = swiper_left - nextpic+'px';
  //   // swiper.style.left =  -(pic_located*nextpic)+'px';
  // }
  if(pic_located<4){
    pic_located++;
    // swiper.style.left = swiper_left - nextpic+'px';
    swiper.style.left =  -(pic_located*nextpic)+'px';
    swiperIndex(pic_located);
  }
  else{
    pic_located=0;
    swiper.style.left = 0+'px'; 
    swiperIndex(pic_located);
  }
}

function backpict() {
  swiper_left = parseFloat(swiper.style.left);
  // if(swiper_left==0){
  //   swiper.style.left = -(nextpic*4)+'px';
  // }
  // else
  //   swiper.style.left = swiper_left + nextpic+'px';
  if(pic_located==0){
    pic_located=4
    swiper.style.left = -(nextpic*4)+'px';
    swiperIndex(pic_located);
  }
  else
  {
    pic_located--;
    swiper.style.left = -(pic_located*nextpic)+'px';
    swiperIndex(pic_located);
  }
}

function swiIselected() {
  for (let i = 0; i<cirindex.children.length;i++) {
    cirindex.children[i].onclick = function () {
      swiperIndex(i);
    }
    
  }
}

function swiperIndex(num) {
  let t=0;
  pic_located = num;
  // console.log("--------------", cirindex.children[i]);
  cirindex.children[num].style.backgroundColor = "rgba(255, 255, 255, 0.7)";
  swiper.style.left = -(num*nextpic)+'px';
  while (t<cirindex.children.length) {
    if(t!=num){
      cirindex.children[t].style.backgroundColor="rgba(255,255,255,0.1)";
    }
    t++;
  }
}

let speed =122.88;
function cirmove() {
  swiper_left = parseFloat(swiper.style.left);
  if(swiper_left<=(-5*nextpic)){
    swiper.style.left = '0px';
    swiper_left=0;
  }
  // console.log((swiper_left-speed)+(nextpic*(pic_located+1)));
  if((swiper_left-speed)+(nextpic*(pic_located+1))<0.00001){
    if(pic_located==4){
      swiperIndex(0);
      pic_located=0;
    }
    else{
      
      // console.log(pic_located);
      swiperIndex(++pic_located);

    }
  }
  swiper.style.left = swiper_left - speed + 'px';
}

let bigcir = setInterval(() => {
  cirstart = setInterval(() => {
    cirmove();
  }, 100);
  
  cirstop = setTimeout(() => {
    clearInterval(cirstart);
  }, 1000);

}, 2000);


swiper.onmouseover = function () { 
  // console.log("=========");
  clearInterval(bigcir);
}

swiper.onmouseout = function () { 
  bigcir = setInterval(() => {
    cirstart = setInterval(() => {
      cirmove();
    }, 100);
    
    cirstop = setTimeout(() => {
      clearInterval(cirstart);
    }, 1000);
  
  }, 2000);
  
}

nextbtn.onclick = function(){
  nextpict();
}

prebtn.onclick = function () { 
  backpict();
}

swiIselected();
