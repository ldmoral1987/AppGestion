
function confirmarBorrado()
{
	var respuesta = window.confirm("¿Quieres borrar el registro seleccionado")
    if (respuesta) 
    {
        return true;
    } 
    else 
    {
        return false;
    }
}