document.getElementById('select').addEventListener('change', function() {
    let selectedObj = this.options[this.selectedIndex].value;
    // Aquí puedes hacer lo que necesites con el objeto seleccionado, como llamar a un servicio Spring Boot.

    function calcularTotalPagar() {
        let Cantidad = document.getElementById('Cantidad').value;
        let precio = document.getElementById('precio').value;
        let valorPagar = Cantidad * precio;
        document.getElementById('ValorPagar').value = valorPagar;
    }
    
    document.getElementById('Cantidad').addEventListener('input', calcularTotalPagar);
    document.getElementById('precio').addEventListener('input', calcularTotalPagar);
    
});