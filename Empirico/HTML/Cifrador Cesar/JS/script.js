const alfabeto = ["A","B","C","D","E","F","G","H","I","J","K","L","M","N","Ñ","O","P","Q","R","S","T","U","V","W","X","Y","Z"];
const inputOriginal = document.getElementById('input-original');
const cifrador = document.getElementById('cifrador');
const resultado = document.getElementById('resultado');
const rango = document.getElementById('rango');

const mensaje = () => {
    const formacion = [...inputOriginal.value.toUpperCase()];
    imprimir(0, formacion);
}

const imprimir = (caracteres, formacion) => {
    if(formacion.length === caracteres) return;
    inputOriginal.value = inputOriginal.value.substring(1)
    const spanCaracteres = document.createElement("span");
    resultado.appendChild(spanCaracteres);
    animacionCaracteres(spanCaracteres)
        .then( () => {
            const caracterSinCodificar = formacion[caracteres];
            spanCaracteres.innerHTML = alfabeto.includes(caracterSinCodificar) ? 
                alfabeto[(alfabeto.indexOf(caracterSinCodificar) + parseInt(rango.value)) % alfabeto.length] : 
                caracterSinCodificar
            imprimir(caracteres + 1, formacion);
        });
}

const animacionCaracteres = spanCaracteres => {
    let cambiosDeLetra = 0;
    return new Promise(resolver => {
        const intervalo = setInterval(() => {
            spanCaracteres.innerHTML = alfabeto[Math.floor(Math.random() * alfabeto.length)];
            cambiosDeLetra++;
            if(cambiosDeLetra === 3) {
                clearInterval(intervalo);
                resolver();
            }
        }, 50);
    });
}

const reinicio = e => {
    e.preventDefault();
    resultado.innerHTML = '';
    mensaje()
}

cifrador.onsubmit = reinicio;