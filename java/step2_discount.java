/**
 * Clase utilitaria para calcular descuentos según el tipo de cliente.
 */
public class DiscountCalculator {
    //El TDD (Test-Driven Development) o Desarrollo Guiado por Pruebas es una metodología 
    //de programación donde escribes primero las pruebas (tests) antes del código funcional,
    // y es muy útil cuando quieres refactorizar código sin romper lo que ya funciona.

    //Listado de descuentos
    private static final Map<String, Double> descuentosMap = Map.of(
        "preferente", 0.9,
        "vip", 0.8
        //agregar mas descuentos
    );


    public static double calcularDescuento(double precio, String tipoCliente) {
        // Si el tipo no existe, se aplica 1.0 (sin descuento)
        double factor = descuentosMap.getOrDefault(tipoCliente, 1.0);
        return precio * factor;
    }
}