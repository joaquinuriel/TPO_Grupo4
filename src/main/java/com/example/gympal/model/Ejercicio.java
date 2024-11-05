@Entity
public class Ejercicio {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "entrenamiento_id")
  private Entrenamiento entrenamiento;

  private String nombre;
  private GrupoMuscular grupoMuscular;
  private int series;
  private int repeticiones;
  private int pesoAsignado;
  private int nivelAerobico;
  private int nivelExigenciaMuscular;
  private boolean realizado = false;

  public Ejercicio(
    String nombre,
    GrupoMuscular grupoMuscular,
    int series,
    int repeticiones,
    int pesoAsignado,
    int nivelAerobico,
    int nivelExigenciaMuscular
  ) {
    this.nombre = nombre;
    this.grupoMuscular = grupoMuscular;
    this.series = series;
    this.repeticiones = repeticiones;
    this.pesoAsignado = pesoAsignado;
    this.nivelAerobico = nivelAerobico;
    this.nivelExigenciaMuscular = nivelExigenciaMuscular;
  }

  public void finalizarEjercicio() {
    this.realizado = true;
  }
  

  // getter y setters

  public boolean getRealizado() {
    return realizado;
  }
}