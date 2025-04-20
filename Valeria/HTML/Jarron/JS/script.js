var img1 = document.getElementById('imagen1');
var img2 = document.getElementById('imagen2');
var img3 = document.getElementById('imagen3');
var img4 = document.getElementById('imagen4');
var img5 = document.getElementById('imagen5');
var img6 = document.getElementById('imagen6');

var contador1 = 0;
var contador2 = 0;
var contador3 = 0;
var contador4 = 0;
var contador5 = 0;
var contador6 = 0;

var contenedorMano1 = document.getElementById('mano1');
var contenedorMano2 = document.getElementById('mano2');
var contenedorMano3 = document.getElementById('mano3');
var contenedorPiernas1 = document.getElementById('piernas1');
var contenedorPie1 = document.getElementById('pie1');
var contenedorPie2 = document.getElementById('pie2');

img1.style.height = '30%';
img2.style.height = '30%';
img3.style.height = '30%';
img4.style.height = '30%';
img5.style.height = '30%';
img6.style.height = '30%';

window.onload = function() {
    var aleatorias = document.querySelectorAll('#imagen1, #imagen2, #imagen3, #imagen4, #imagen5, #imagen6')

    aleatorias.forEach(function(aleatoria) {
        const anchoVentana = window.innerWidth;
        const altoVentana = window.innerHeight / 1.35;
        var posicionX = Math.random() * (anchoVentana - aleatoria.width);
        var posicionY = Math.random() * (altoVentana - aleatoria.height);
        var angulo = Math.random() * 360;

        aleatoria.style.transform = `rotate(${angulo}deg)`;
        aleatoria.style.left = posicionX + 'px'
        aleatoria.style.top = posicionY + 'px'
    });
}

function ingreso() {
    contenedorMano1.addEventListener('dragenter', function(event) {
        event.preventDefault();
        contenedorMano1.style.backgroundColor = 'lime';
    });

    contenedorMano2.addEventListener('dragenter', function(event) {
        event.preventDefault();
        contenedorMano2.style.backgroundColor = 'lime';
    });

    contenedorMano3.addEventListener('dragenter', function(event) {
        event.preventDefault();
        contenedorMano3.style.backgroundColor = 'lime';
    });

    contenedorPiernas1.addEventListener('dragenter', function(event) {
        event.preventDefault();
        contenedorPiernas1.style.backgroundColor = 'lime';
    });

    contenedorPie1.addEventListener('dragenter', function(event) {
        event.preventDefault();
        contenedorPie1.style.backgroundColor = 'lime';
    });

    contenedorPie2.addEventListener('dragenter', function(event) {
        event.preventDefault();
        contenedorPie2.style.backgroundColor = 'lime';
    });
} 

function salir() {
    contenedorMano1.addEventListener('dragleave', function(event) {
        contenedorMano1.style.backgroundColor = '';
    });

    contenedorMano2.addEventListener('dragleave', function(event) {
        contenedorMano2.style.backgroundColor = '';
    });

    contenedorMano3.addEventListener('dragleave', function(event) {
        contenedorMano3.style.backgroundColor = '';
    });

    contenedorPiernas1.addEventListener('dragleave', function(event) {
        contenedorPiernas1.style.backgroundColor = '';
    });

    contenedorPie1.addEventListener('dragleave', function(event) {
        contenedorPie1.style.backgroundColor = '';
    });

    contenedorPie2.addEventListener('dragleave', function(event) {
        contenedorPie2.style.backgroundColor = '';
    });
}

function over() {
    contenedorMano1.addEventListener('dragover', function(event) {
        event.preventDefault();
    });

    contenedorMano2.addEventListener('dragover', function(event) {
        event.preventDefault();
    });

    contenedorMano3.addEventListener('dragover', function(event) {
        event.preventDefault();
    });

    contenedorPiernas1.addEventListener('dragover', function(event) {
        event.preventDefault();
    });

    contenedorPie1.addEventListener('dragover', function(event) {
        event.preventDefault();
    });

    contenedorPie2.addEventListener('dragover', function(event) {
        event.preventDefault();
    });
}

function drop() {
    contenedorMano1.addEventListener('drop', function(event) {
        event.preventDefault();
        contenedorMano1.style.backgroundColor = '';
        img1.style.transform = `rotate(${0}deg)`;
        img1.style.left = '';
        img1.style.top = '';
        img1.style.height = '100%';
        contenedorMano1.appendChild(imagen1);
        contador1++;
    });

    contenedorMano2.addEventListener('drop', function(event) {
        event.preventDefault();
        contenedorMano2.style.backgroundColor = '';
        img2.style.transform = `rotate(${0}deg)`;
        img2.style.left = '';
        img2.style.top = '';
        img2.style.height = '100%';
        contenedorMano2.appendChild(imagen2);
        contador2++;
    });

    contenedorMano3.addEventListener('drop', function(event) {
        event.preventDefault();
        contenedorMano3.style.backgroundColor = '';
        img3.style.transform = `rotate(${0}deg)`;
        img3.style.left = '';
        img3.style.top = '';
        img3.style.height = '100%';
        contenedorMano3.appendChild(imagen3);
        contador3++;
    });

    contenedorPiernas1.addEventListener('drop', function(event) {
        event.preventDefault();
        contenedorPiernas1.style.backgroundColor = '';
        img4.style.transform = `rotate(${0}deg)`;
        img4.style.left = '';
        img4.style.top = '';
        img4.style.height = '100%';
        contenedorPiernas1.appendChild(imagen4);
        contador4++;
    });

    contenedorPie1.addEventListener('drop', function(event) {
        event.preventDefault();
        contenedorPie1.style.backgroundColor = '';
        img5.style.transform = `rotate(${0}deg)`;
        img5.style.left = '';
        img5.style.top = '',
        img5.style.height = '100%';
        contenedorPie1.appendChild(imagen5);
        contador5++;
    });

    contenedorPie2.addEventListener('drop', function(event) {
        event.preventDefault();
        contenedorPie2.style.backgroundColor = '';
        img6.style.transform = `rotate(${0}deg)`;
        img6.style.left = '';
        img6.style.top = '';
        img6.style.height = '100%';
        contenedorPie2.appendChild(imagen6);
        contador6++;
    });
}

function verificacion() {
    if (contador1 > 0 && contador2 > 0 && contador3 > 0 && contador4 > 0 && contador5 > 0 && contador6 > 0) {
        console.log("Puzzle completo");
        window.location.href = 'https://valebm14.hotglue.me/?rostro';
    } else {
        console.log("Puzzle incompleto");
    }
}

ingreso();
salir();
over();
drop();
setInterval(verificacion, 1000);