function accionSi() {
    alert("Gracias, yo también quiero pasar toda la vida a tu lado ❤️")
}

function moverBoton() {
    const ancho = window.innerWidth;
    const alto = window.innerHeight;
    const nuevoAncho = Math.random() * ancho;
    const nuevoAlto = Math.random() * alto;
    const buttonNo = document.getElementById("botonNo");

    buttonNo.style.position = "absolute";
    buttonNo.style.left = nuevoAncho + "px";
    buttonNo.style.top = nuevoAlto + "px";
}

function accionSi() {
    const respuesta = confirm("¿Estás segura de que quieres estar conmigo toda la vida?");
    if (respuesta) {
        window.location.href = "si.html";
    } else {
        alert("Piensalo bien mami 😏");
    }
}

function moverBoton() {
    const ancho = window.innerWidth;
    const alto = window.innerHeight;
    const nuevoAncho = Math.random() * ancho;
    const nuevoAlto = Math.random() * alto;
    const buttonNo = document.getElementById("botonNo");

    buttonNo.style.position = "absolute";
    buttonNo.style.left = nuevoAncho + "px";
    buttonNo.style.top = nuevoAlto + "px";
}