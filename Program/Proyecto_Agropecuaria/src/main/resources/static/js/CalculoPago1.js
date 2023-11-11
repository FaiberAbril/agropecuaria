
function calcularTotalPagar() {
    let Cantidad = document.getElementById('Cantidad').value;
    let precio = document.getElementById('precio').value;
    let valorPagar = Cantidad * precio;
    document.getElementById('ValorPagar').value = valorPagar;
}

document.getElementById('Cantidad').addEventListener('input', calcularTotalPagar);
document.getElementById('precio').addEventListener('input', calcularTotalPagar);




