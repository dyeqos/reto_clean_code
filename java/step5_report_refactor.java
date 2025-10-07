import java.util.Date;
import java.util.List;

/**
 * Refactorización del reporte de empleados.  Se separan las responsabilidades
 * en clases distintas, reduciendo la longitud de métodos y favoreciendo la
 * reutilización.  Además, se aplican los principios KISS y DRY.
 */
public class ReporteEmpleadosRefactor {
    //inyección de dependencias
    private final FormateadorReporte formateador;
    private final NotificadorReporte notificador;
    private final PersistenciaReporte persistencia;
    private final Auditor auditor;

    //constructor clase ReporteEmpleadosRefactor
    public ReporteEmpleadosRefactor(FormateadorReporte formateador,
                                    NotificadorReporte notificador,
                                    PersistenciaReporte persistencia,
                                    Auditor auditor) {
        this.formateador = formateador;
        this.notificador = notificador;
        this.persistencia = persistencia;
        this.auditor = auditor;
    }

    //único método de la clase ReporteEmpleadosRefactor 
    public String generarReporte(List<Empleado> empleados) {
        String contenido = formateador.formatear(empleados);
        //notifica
        notificador.enviar(contenido);
        //guarda
        persistencia.guardar(contenido);
        //genera log del registro
        auditor.registrar("REPORTE", contenido.length(), new Date());
        return contenido;
    }
}

//generar interfaz
interface FormateadorReporte {
    String formatear(List<Empleado> empleados);
}

//clase para formatear la clase empleado en un archivo csv separado por ";"
class FormateadorCSV implements FormateadorReporte {
    @Override
    public String formatear(List<Empleado> empleados) {
        StringBuilder sb = new StringBuilder();
        for (Empleado e : empleados) {
            sb.append(e.getId()).append(";")
              .append(e.getNombre()).append(";")
              .append(e.getSalario()).append("\n");
        }
        return sb.toString();
    }
}

//generar interfaz
interface NotificadorReporte {
    void enviar(String contenido);
}

class EmailNotificadorReporte implements NotificadorReporte {
    @Override
    public void enviar(String contenido) { //envio de notificacion del archivo csv
        // Implementar envío de correo
    }
}

//generar interfaz
interface PersistenciaReporte {
    void guardar(String contenido);
}

class ArchivoPersistenciaReporte implements PersistenciaReporte {
    @Override
    public void guardar(String contenido) {//guarda el contenido
        // Implementar guardado en archivo o base de datos
    }
}

//generar interfaz
interface Auditor {
    void registrar(String tipo, int longitud, Date fecha);
}

class AuditorSimple implements Auditor {
    @Override
    public void registrar(String tipo, int longitud, Date fecha) { //registra el log del envio y guardado del csv
        // Implementar registro de auditoría
    }
}

//Clase empleado
class Empleado {
    private String id;
    private String nombre;
    private double salario;

    public Empleado(String id, String nombre, double salario) {
        this.id = id;
        this.nombre = nombre;
        this.salario = salario;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSalario() {
        return salario;
    }
}