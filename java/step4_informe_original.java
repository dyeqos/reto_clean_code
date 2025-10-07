/**
 * Clase de ejemplo que viola el Principio de Responsabilidad Única (SRP) al
 * mezclar la generación, notificación y persistencia de un informe en una
 * sola clase.  Utiliza este archivo como base para refactorizar en el
 * ejercicio del paso 4.
 */

interface GeneradorPDF {
    void generarPDF(InformeData data);
}

public class InformePDF implements GeneradorPDF {
    @Override
    public void generarPDF(InformeData data) {
        // Generar un documento PDF
    }
}

interface NotificadorEmail {
    void enviarEmail(InformeData data);
}
public class EmailNotificador implements NotificadorEmail {
    @Override
    public void enviarEmail(InformeData data) {
        // Enviar el informe por correo electrónico
    }
}

interface RepositorioDB {
    void guardarEnBaseDatos(InformeData data);
}

class InformeRepositorio implements RepositorioDB {
    @Override
    public void guardarEnBaseDatos(InformeData data) {
        // Guardar el informe en la base de datos
    }
}

class InformeService {
    private GeneradorPDF generador;
    private NotificadorEmail notificador;
    private RepositorioDB repositorio;

    public InformeService(GeneradorPDF generador, NotificadorEmail notificador, RepositorioDB repositorio) {
        this.generador = generador;
        this.notificador = notificador;
        this.repositorio = repositorio;
    }

    public void procesar(InformeData data) {
        generador.generarPDF(data);
        notificador.enviarEmail(data);
        repositorio.guardarEnBaseDatos(data);
    }
}

class InformeData {
    // Campos del informe (placeholder)
}