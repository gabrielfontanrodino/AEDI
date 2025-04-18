package es.uvigo.esei.aed1.activity7.hospital;

import es.uvigo.esei.aed1.tads.queue.LinkedQueue;
import es.uvigo.esei.aed1.tads.queue.Queue;

/**
 * Representa un/a médico/a, que se identifica por un número y
 * tiene asociado una cola de pacientes
 */
public class Doctor {

    private int number;
    private Queue<Patient> patients;

    public Doctor(int number) {
        this.number = number;
        this.patients = new LinkedQueue<>();
    }

    public int getNumero() {
        return this.number;
    }

    public Queue<Patient> getPatients() {
        return this.patients;
    }

    public void addPatient(Patient patient) {
        this.patients.add(patient);
    }

}
