import java.util.ArrayList;
import java.util.List;

public class SistemaAtencionMedico {
    private List<Paciente> pacientes;
    private List<Medico> medicos;
    private List<ServicioMedico> serviciosMedicos;

    public static final int mayorEdad = 65; 
    public static final double descMayorEdad = 0.25; 
    

    public SistemaAtencionMedico() {
        this.pacientes = new ArrayList<>();
        this.medicos = new ArrayList<>();
        this.serviciosMedicos = new ArrayList<>();
    }

    public void agregarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public void agregarMedico(Medico medico) {
        medicos.add(medico);
    }

    public void agregarServicioMedico(ServicioMedico servicioMedico) {
        serviciosMedicos.add(servicioMedico);
    }

    public void agendarConsulta(Paciente paciente, Consulta consulta){
        double costoConsulta = consulta.getServicioMedico().getCosto();
        costoConsulta = calcularValorFinalConsulta(costoConsulta, paciente);
        System.out.println("Se han cobrado "+ costoConsulta+ " dolares de su tarjeta de credito");
        paciente.getHistorialMedico().getConsultas().add(consulta); //Hacer esto es incorrecto
    }

    public double calcularValorFinalConsulta(double costoConsulta, Paciente paciente){
        double valorARestar = 0;
        if(paciente.getEdad()>=mayorEdad){
            valorARestar = costoConsulta*descMayorEdad; //0.25 es el descuento para adultos mayores
        }
        return costoConsulta-valorARestar;
    }

    public <T> T obtenerElementoPorNombre(List<T> lista, String nombre) {
        for (T elemento : lista) {
            if (elemento.toString().equals(nombre)) {
                return elemento;
            }
        }
        return null;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public List<ServicioMedico> getServiciosMedicos() {
        return serviciosMedicos;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }

    public void setServiciosMedicos(List<ServicioMedico> serviciosMedicos) {
        this.serviciosMedicos = serviciosMedicos;
    }
    
}
