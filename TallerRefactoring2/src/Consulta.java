import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

public class Consulta {
    private LocalDateTime date;
    private Paciente paciente;
    private Medico medico;
    private ServicioMedico servicioMedico;
    private boolean realizada;
    private String diagnostico;
    private String tratamiento;
    private List<String> examenesMedicos;

    public Consulta(LocalDateTime dia, Paciente paciente, Medico medico, ServicioMedico servicioMedico, String diagnostico, String tratamiento, List<String> examenesMedicos) {
        this.date = dia;
        this.servicioMedico = servicioMedico;
        this.paciente = paciente;
        this.medico = medico;
        this.realizada = false;
    }


    public String getHora() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return date.format(formatter);
    }

    public void setHora(String hora) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        this.date = date.withHour(Integer.parseInt(hora.split(":")[0]))
                                  .withMinute(Integer.parseInt(hora.split(":")[1]));
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public boolean isRealizada() {
        return realizada;
    }

    public void setRealizada(boolean realizada) {
        this.realizada = realizada;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public void addBook(String examen) {
        examenesMedicos.add(examen);
    }

    public void removeBook(String examen) {
        examenesMedicos.remove(examen);
    }

    public List<String> getExamenesMedicos() {
        return Collections.unmodifiableList(examenesMedicos);
    }


    public ServicioMedico getServicioMedico() {
        return servicioMedico;
    }

    public void setServicioMedico(ServicioMedico servicioMedico) {
        this.servicioMedico = servicioMedico;
    }
}
