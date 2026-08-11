const API_URL = "https://curriculum-java-uoy0.onrender.com/";

// Función para el botón general "GET"
async function obtenerCurriculum() {
    try {
        const respuesta = await fetch(API_URL);
        const datos = await respuesta.json();
        
        // Asignar cada valor del JSON a su respectivo textarea por ID
        if (datos.telefono) document.getElementById('telefono').value = datos.telefono;
        if (datos.correo) document.getElementById('correo').value = datos.correo;
        if (datos.sitio) document.getElementById('sitio').value = datos.sitio;
        if (datos.habilidades) document.getElementById('habilidades').value = datos.habilidades;
        if (datos.idiomas) document.getElementById('idiomas').value = datos.idiomas;
        if (datos.educacion) document.getElementById('educacion').value = datos.educacion;
        if (datos.nombre) document.getElementById('nombre').value = datos.nombre;
        if (datos.puesto) document.getElementById('puesto').value = datos.puesto;
        if (datos.perfil) document.getElementById('perfil').value = datos.perfil;
        if (datos.periodo1) document.getElementById('periodo1').value = datos.periodo1;
        if (datos.empresa1) document.getElementById('empresa1').value = datos.empresa1;
        if (datos.descripcion1) document.getElementById('descripcion1').value = datos.descripcion1;

    } catch (error) {
        console.error("Error al obtener el currículum:", error);
    }
}

async function editarCampo() {

    // Juntamos el valor de todos los textarea en un solo objeto
    const datosModificados = {
        nombre: document.getElementById('nombre').value,
        puesto: document.getElementById('puesto').value,
        perfil: document.getElementById('perfil').value,
        telefono: document.getElementById('telefono').value,
        correo: document.getElementById('correo').value,
        sitio: document.getElementById('sitio').value,
        habilidades: document.getElementById('habilidades').value,
        idiomas: document.getElementById('idiomas').value,
        educacion: document.getElementById('educacion').value,
        periodo1: document.getElementById('periodo1').value,
        empresa1: document.getElementById('empresa1').value,
        descripcion1: document.getElementById('descripcion1').value
    };

    try {
        // Enviamos el objeto completo al servidor
        // fetch -> peticiones http al servidor, espera a que el servidor responda con la peticion
        const respuesta = await fetch(API_URL, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(datosModificados)
        });

        // Recibimos la respuesta (el mensaje de éxito)
        const resultado = await respuesta.json();
        
        // Mostramos la alerta en el navegador
        alert("Cambios realizados exitosamente");

    } catch (error) {
        console.error("Error al actualizar:", error);
        alert("Hubo un error al guardar los cambios.");
    }
}

async function crearCampo(){
    try{
        // RECOLECTAR LOS DATOS DEL HTML 
        const datosModificados = {
            nombre: document.getElementById("nombre").value,
            puesto: document.getElementById("puesto").value,
            perfil: document.getElementById("perfil").value,
            telefono: document.getElementById("telefono").value,
            correo: document.getElementById("correo").value,
            sitio: document.getElementById("sitio").value,
            habilidades: document.getElementById("habilidades").value,
            idiomas: document.getElementById("idiomas").value,
            educacion: document.getElementById("educacion").value,
            periodo1: document.getElementById("periodo1").value,
            empresa1: document.getElementById("empresa1").value,
            descripcion1: document.getElementById("descripcion1").value
        };

        const respuesta = await fetch(API_URL, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(datosModificados)
        });

        // Leemos la respuesta de Spring Boot como TEXTO PLANO
        const mensajeServidor = await respuesta.text();

        // Evaluamos qué nos respondio el servidor
        if (mensajeServidor.includes("Los siguientes campos están vacíos")) {
            // Si faltaron campos, mostramos la lista que nos mandó Java
            alert(mensajeServidor);
        } else {
            
            alert("¡Cambios realizados exitosamente!");
        }

    } catch (error) {
        console.error("Error al actualizar:", error);
        alert("Hubo un error al guardar los cambios.");
    }
}

async function eliminarCampo(){

    if (!confirm("¿Estás seguro de que deseas eliminar el currículum?")) {
        return; 
    }

    try{
        const datosModificados = {
            nombre: document.getElementById("nombre").value,
            puesto: document.getElementById("puesto").value,
            perfil: document.getElementById("perfil").value,
            telefono: document.getElementById("telefono").value,
            correo: document.getElementById("correo").value,
            sitio: document.getElementById("sitio").value,
            habilidades: document.getElementById("habilidades").value,
            idiomas: document.getElementById("idiomas").value,
            educacion: document.getElementById("educacion").value,
            periodo1: document.getElementById("periodo1").value,
            empresa1: document.getElementById("empresa1").value,
            descripcion1: document.getElementById("descripcion1").value
        };

        const respuesta = await fetch(API_URL, {
            method: 'DELETE',
        });

        const mensaje = await respuesta.text();
        alert(mensaje);

        document.querySelectorAll("textarea").forEach(textarea => textarea.value = "");

    } catch (error) {
        console.error("Error al actualizar:", error);
        alert("Hubo un error al guardar los cambios.");
    }
}


