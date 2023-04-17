
package es.uvigo.esei.aed1.activity7.hospital;

import es.uvigo.esei.aed1.tads.list.List;
import es.uvigo.esei.aed1.tads.list.LinkedList;

/**
 * Representa el hospital el cual tiene un nombre y una lista de médicos
 */
public class Hospital {

  private final String name;
  private List<Doctor> doctors;

  public Hospital(String name) {
    this.name = name;
    this.doctors = new LinkedList<>();
  }

  public String getName() {
    return this.name;
  }

  public List<Doctor> getDoctors() {
    return this.doctors;
  }

  public void addDoctor(Doctor doctor) {
    this.doctors.addLast(doctor);
  }

}
