//Variables generales que pueden ser utilizadas por todas las funciones
let ataqueJugador
let ataqueEnemigo
let resultado
let vidasJugador = 3
let vidasEnemigo = 3

//Funcion que escucha los clicks de los botones
function iniciarJuego() {
    let sectionSeleccionarAtaque = document.getElementById('seleccionar-ataque')
    let sectionReiniciar = document.getElementById('reiniciar')

    sectionSeleccionarAtaque.style.display = 'none'
    sectionReiniciar.style.display = 'none'

    let botonMascotaJugador = document.getElementById('boton-mascota')
    let botonFuego = document.getElementById('boton-fuego')
    let botonAgua = document.getElementById('boton-agua')
    let botonTierra = document.getElementById('boton-tierra')
    let botonReiniciar = document.getElementById('boton-reiniciar')

    botonMascotaJugador.addEventListener('click', seleccionarMascotaJugador)
    botonFuego.addEventListener('click', ataqueFuego)
    botonAgua.addEventListener('click', ataqueAgua)
    botonTierra.addEventListener('click', ataqueTierra)
    botonReiniciar.addEventListener('click', reiniciarJuego)
}

//Funcion que selecciona la mascota y modifica el texto de manera personalizada con la eleccion del usuario
function seleccionarMascotaJugador() {
    let sectionSeleccionarMascota = document.getElementById('seleccionar-mascota')
    let sectionSeleccionarAtaque = document.getElementById('seleccionar-ataque')

    sectionSeleccionarMascota.style.display = 'none'
    sectionSeleccionarAtaque.style.display = 'block'

    let inputHipodoge = document.getElementById('hipodoge')
    let inputCapipepo = document.getElementById('capipepo')
    let inputRatigueya = document.getElementById('ratigueya')
    let spanMascotaJugador = document.getElementById('mascota-jugador')

    if (inputHipodoge.checked) {
        spanMascotaJugador.innerHTML = 'Hipodoge'
    } else if (inputCapipepo.checked) {
        spanMascotaJugador.innerHTML = 'Capipepo'
    } else if (inputRatigueya.checked) {
        spanMascotaJugador.innerHTML = 'Ratigueya'
    } else {
        alert('Debes seleccionar una mascota')
    }

    seleccionarMascotaEnemigo()
}

//Funcion que le asigna a la maquina una mascota de manera aleatoria y lo plasma en el texto de manera personalizada
function seleccionarMascotaEnemigo() {
    let mascotaAleatoria = aleatorio(1, 3)
    let spanMascotaEnemigo = document.getElementById('mascota-enemigo')

    if (mascotaAleatoria == 1) {
        //1 Hipodoge
        spanMascotaEnemigo.innerHTML = 'Hipodoge'
    } else if (mascotaAleatoria == 2) {
        //2 Capipepo
        spanMascotaEnemigo.innerHTML = 'Capipepo'
    } else {
        //3 Ratigueya
        spanMascotaEnemigo.innerHTML = 'Ratigueya'
    }
}

//Funcion que registra el ataque de fuego y se lo asgina a la variable general del ataque del jugador
function ataqueFuego() {
    ataqueJugador = 'FUEGO'
    ataqueAleatorioEnemigo()
}

//Funcion que registra el ataque de agua y se lo asigna a la variable general del ataque del jugador
function ataqueAgua() {
    ataqueJugador = 'AGUA'
    ataqueAleatorioEnemigo()
}

//Funcion que registra el ataque de tierra y se lo asigna a la variable general del ataque del jugador
function ataqueTierra() {
    ataqueJugador = 'TIERRA'
    ataqueAleatorioEnemigo()
}

//Funcion que elige de manera aleatoria el ataque de la maquina
function ataqueAleatorioEnemigo() {
    let ataqueAleatorio = aleatorio(1, 3)

    if (ataqueAleatorio == 1) {
        //1 Fuego
        ataqueEnemigo = 'FUEGO'
    } else if (ataqueAleatorio == 2){
        //2 Agua
        ataqueEnemigo = 'AGUA'
    } else {
        //3 Tierra
        ataqueEnemigo = 'TIERRA'
    }

    combate()
}

//Funcion que enfrenta la eleccion del usuario contra la eleccion de la maquina para determinar un resultado, tambien se encarga de restarle las vidas al jugador y a la maquina
function combate() {
    let spanVidasJugador = document.getElementById('vidas-jugador')
    let spanVidasEnemigo = document.getElementById('vidas-enemigo')

    if (ataqueEnemigo == ataqueJugador) {
        crearMensaje('EMPATASTE')
    } else if (ataqueJugador == 'FUEGO' && ataqueEnemigo == 'TIERRA') {
        crearMensaje('GANASTE')
        vidasEnemigo--
        spanVidasEnemigo.innerHTML = vidasEnemigo
    } else if (ataqueJugador == 'AGUA' && ataqueEnemigo == 'FUEGO') {
        crearMensaje('GANASTE')
        vidasEnemigo--
        spanVidasEnemigo.innerHTML = vidasEnemigo
    } else if (ataqueJugador == 'TIERRA' && ataqueEnemigo == 'AGUA') {
        crearMensaje('GANASTE')
        vidasEnemigo--
        spanVidasEnemigo.innerHTML = vidasEnemigo
    } else {
        crearMensaje('PERDISTE')
        //Si ponemos vidas jugador y dos operadores de resta estamos quitandole una unidad a esa variable
        vidasJugador--
        spanVidasJugador.innerHTML = vidasJugador
    }

    revisarVidas()
}

//Funcion que revisa las vidas del jugador y la maquina
function revisarVidas() {
    if (vidasEnemigo == 0) {
        crearMensajeFinal('GANASTE LA PARTIDA')
        crearMensajeFinal('Puedes darle al botón reiniciar para jugar de nuevo')
    } else if (vidasJugador == 0) {
        crearMensajeFinal('PERDISTE LA PARTIDA')
        crearMensajeFinal('Puedes darle al botón reiniciar para jugar de nuevo')
    }
}

//Funcion que crea los mensajes de los resultados tras el enfrentamiento del usuario contra la maquina
function crearMensaje(resultado) {
    let sectionMensajes = document.getElementById('mensajes')
    let parrafo = document.createElement('p')

    parrafo.innerHTML = 'Tu mascota atacó con ' + ataqueJugador + ', la mascota del enemigo atacó con ' + ataqueEnemigo + ' por lo que ' + resultado + ' el combate'

    sectionMensajes.appendChild(parrafo)
}

//Funcion que genera el mensaje final de derrota o victoria, ademas deshabilita los botones una vez el usuario pierda o gane la partida
function crearMensajeFinal(resultadoFinal) {
    let sectionReiniciar = document.getElementById('reiniciar')
    sectionReiniciar.style.display = 'block'

    let sectionMensajes = document.getElementById('mensajes')
    let parrafo = document.createElement('p')
    let botonFuego = document.getElementById('boton-fuego')
    let botonAgua = document.getElementById('boton-agua')
    let botonTierra = document.getElementById('boton-tierra')

    parrafo.innerHTML = resultadoFinal

    sectionMensajes.appendChild(parrafo)

    botonFuego.disabled = true
    botonAgua.disabled = true
    botonTierra.disabled = true
}

//Funcion que se encarga de reiniciar el juego
function reiniciarJuego() {
    location.reload()
}

//Funcion para generar un numero aleatorio
function aleatorio(min, max) {
    return Math.floor(Math.random() * (max - min + 1) + min)
}

//Escuchador de cuando el documento cargue para inciar el script
window.addEventListener('load', iniciarJuego)