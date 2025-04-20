

const si = document.getElementById("si");
const no = document.getElementById("no");
const rect = si.getBoundingClientRect();
let contador = 0;

console.log('x', rect.left);
console.log('y', rect.top);

no.addEventListener("click", function() {

    function aleatorio(min, max) {
        return Math.random() * (max - min) + min;
    }

    let x = aleatorio(0.39, 0.78);
    let y = aleatorio(0.5575, 1.115);

    console.log(x);
    console.log(y);

    console.log("Contador de click");
    contador++;

    if (contador == 1) {
        alert("¿Segura que no me amas?");
    }

    if (contador >= 3) {
        si.disabled = false;
    }

    const nuevox = x * 477;
    const nuevoy = y * 268;

    no.style.left = nuevox + 'px';
    no.style.top = nuevoy + 'px';
});

si.addEventListener("click", function () {
    window.location.href = '../Paginas/ultima.html'
})