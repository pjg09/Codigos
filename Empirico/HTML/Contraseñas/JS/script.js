const cajaContraseña = document.getElementById("contraseña");
const length = 12;
const mayusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
const minusculas = "abcdefghijklmnopqrstuvwxyz";
const numeros = "0123456789";
const simbolos = "@#$%^()_+~|{}[]></-=¿?!¡";
const todosLosCaracteres = mayusculas + minusculas + numeros + simbolos;

function crearContraseña(){
    let contraseña = "";
    contraseña += mayusculas[Math.floor(Math.random() * mayusculas.length)];
    contraseña += minusculas[Math.floor(Math.random() * minusculas.length)];
    contraseña += numeros[Math.floor(Math.random() * numeros.length)];
    contraseña += simbolos[Math.floor(Math.random() * simbolos.length)];

    while (length > contraseña.length){
        contraseña += todosLosCaracteres[Math.floor(Math.random() * todosLosCaracteres.length)];
    }
    cajaContraseña.value = contraseña;
}

function copiarContraseña(){
    cajaContraseña.select();
    navigator.clipboard.writeText(cajaContraseña.value);
}