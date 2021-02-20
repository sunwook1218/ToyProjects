<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kr">
	<head>
	<meta charset="UTF-8">
	<title>http://www.blueb.co.kr</title>
<style>

html,
body,
canvas {
  width: 100%;
  height: 100%;
  overflow: hidden;
  background: none;
}
html {
  background: center center no-repeat black;
  -webkit-animation: lightning infinite linear 11s;
          animation: lightning infinite linear 11s;
  -webkit-animation-direction: alternate;
          animation-direction: alternate;
}
body {
  background: black;
  background-image: -webkit-radial-gradient(40% 150% 200vmin, #2f2940 10%, rgba(8, 7, 13, 0) 100%);
  background-image: radial-gradient(200vmin at 40% 150%, #2f2940 10%, rgba(8, 7, 13, 0) 100%);
  background-image: -webkit-radial-gradient(40% 150% 200vmin, #660099 10%, rgba(25, 0, 77, 0) 90%);
  background-image: radial-gradient(200vmin at 40% 150%, #660099 10%, rgba(25, 0, 77, 0) 90%);
}
@-webkit-keyframes lightning {
  0%,
  99%,
  100% {
    background: black;
  }
  99.25% {
    background: white;
  }
}
@keyframes lightning {
  0%,
  99%,
  100% {
    background: black;
  }
  99.25% {
    background: white;
  }
}

</style>
</head>
<body>


<canvas id="sky"></canvas>


<script type="text/javascript">
// Setup ///////////////////////////////////////////////////////////
var canvas = document.getElementById('sky');
var sky = canvas.getContext('2d');

var window_width = window.innerWidth * 1.5;
var window_height = window.innerHeight * 1.5;

var fall_speed = 0.7;
var wind_speed = 5;

var rain_weight = 0.11;
var rain_color = '255,255,255';

var drop_count;
var drops = [];

// Helpers /////////////////////////////////////////////////////////
window.requestAnimFrame = (function(){
  return  window.requestAnimationFrame       ||
          window.webkitRequestAnimationFrame ||
          window.mozRequestAnimationFrame    ||
          window.msRequestAnimationFrame     ||
          window.oRequestAnimationFrame      ||
          function( callback ){
            window.setTimeout(callback, 1000 / 60);
          };
})();

function randomFrom(min, max) {
  return (Math.random() * (max - min) + min);
}

function resizer() {
  window_width = window.innerWidth * 1.5;
  window_height = window.innerHeight * 1.5;
  drop_count = window_width * rain_weight;
  
  canvas.setAttribute('width', window_width);
  canvas.setAttribute('height', window_height);
}

window.addEventListener('resize', resizer, false);

// Drawing /////////////////////////////////////////////////////////
function paintSky() {
  for (var i = 0; i < drop_count; i++) {
    drops[i] = new drop();
    drops[i].reset();
  }
  
  rain();
}

function rain() {
  sky.clearRect(0, 0, window_width, window_height);

  var drops_length = drops.length;

  for (var i = 0; i < drops_length; i++) {
    var drop = drops[i];
    drop.fall();
    drop.draw();
  }

  window.requestAnimFrame(rain);
}

function drop() {
  this.reset = function() {
    this.r = randomFrom(0.8, 1.6);
    this.l = (this.r * 250);
    this.x = randomFrom((window_width * -0.25), (window_width * 1.125));
    this.y = randomFrom((window_height * -0.25), (window_height * -1));
    this.dx = randomFrom((wind_speed - 3), (wind_speed + 3));
    this.dy = (this.r * (100 * fall_speed));
    this.offset = (this.l * (this.dx / this.dy));
    this.opacity = (this.r * randomFrom(0.2, 0.6));
    this.drip = this.render();
  };
  
  this.render = function() {
    var canv = document.createElement('canvas');
    var ctx = canv.getContext('2d');
    canv.setAttribute('width', Math.abs(this.offset) + this.r);
    canv.setAttribute('height', this.l);
    
    ctx.beginPath();
    
    var drip = ctx.createLinearGradient(0, 0, 0, this.l);
    drip.addColorStop(0, 'rgba(' + rain_color + ', 0)');
    drip.addColorStop(1, 'rgba(' + rain_color + ', ' + this.opacity + ')');
    ctx.fillStyle = drip;
        
    //sky.rect(this.x, this.y, this.r, this.l);
    var startX = (this.offset >= 0) ? 0 : Math.abs(this.offset);
    ctx.moveTo(startX, 0);
    ctx.lineTo(startX + this.r, 0);
    ctx.lineTo(startX + this.r + this.offset, this.l);
    ctx.lineTo(startX + this.offset, this.l);

    ctx.closePath();
    ctx.fill();
    
    return canv;
  };
  
  this.draw = function() {
    sky.drawImage(this.drip, this.x, this.y);
  };
  
  this.fall = function() {
    this.x += this.dx;
    this.y += this.dy;
    
    if (this.y > (window_height * 1.25)) {
      this.reset();
    }
  };
}

resizer();
paintSky();
</script>
</body>
</html>s