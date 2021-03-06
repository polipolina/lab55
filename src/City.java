import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class City {
    public String getName() {
        return name;
    }
    public Coordinates getCoordinates() {
        return coordinates;
    }
    public LocalDate getCreationDate() {
        return creationDate;
    }
    public Long getId() {
        return id;
    }
    public Long getArea() {
        return area;
    }
    public Date getEstablishmentDate() {
        return establishmentDate;
    }
    public Integer getPopulation() {
        return population;
    }
    public Human getGovernor() {
        return governor;
    }
    public long getAgglomeration() {
        return agglomeration;
    }
    public Long getMetersAboveSeaLevel() {
        return metersAboveSeaLevel;
    }
    public StandardOfLiving getStandardOfLiving() {
        return standardOfLiving;
    }
    public void setArea(Long area) {
        this.area = area;
    }
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAgglomeration(long agglomeration) {
        this.agglomeration = agglomeration;
    }
    public void setEstablishmentDate(Date establishmentDate) {
        this.establishmentDate = establishmentDate;
    }
    public void setGovernor(Human governor) {
        this.governor = governor;
    }
    public void setMetersAboveSeaLevel(Long metersAboveSeaLevel) {
        this.metersAboveSeaLevel = metersAboveSeaLevel;
    }
    public void setPopulation(Integer population) {
        this.population = population;
    }
    public void setStandardOfLivin(StandardOfLiving standardOfLiving) {
        this.standardOfLiving = standardOfLiving;
    }

    private Long id; //Поле не может быть null, Значение поля должно быть больше 0,
    // Значение этого поля должно быть уникальным, Значение этого поля должно
    // генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
        private Coordinates coordinates; //Поле не может быть null
        private java.time.LocalDate creationDate; //Поле не может быть null,
     // Значение этого поля должно генерироваться автоматически
        private Long area; //Значение поля должно быть больше 0, Поле не может быть null
        private Integer population; //Значение поля должно быть больше 0, Поле не может быть null
        private Long metersAboveSeaLevel;
        private java.util.Date establishmentDate;
        private long agglomeration;
        private StandardOfLiving standardOfLiving; //Поле не может быть null
        private Human governor; //Поле не может быть null

    public Double getValueCity() {
        return getArea()*0.5*getPopulation();
    }

    //private Double valueCity = area*0.5*population;


     City(Long id, String name, Coordinates coordinates, java.time.LocalDate creationDate,
          Long area, Integer population,
          Long metersAboveSeaLevel, Date establishmentDate, long agglomeration,
          StandardOfLiving standardOfLiving, Human governor) {
         setId(id);
         setAgglomeration(agglomeration);
         setArea(area);
         setCoordinates(coordinates);
         setCreationDate(creationDate);
         setEstablishmentDate(establishmentDate);
         setPopulation(population);
         setName(name);
         setGovernor(governor);
         setStandardOfLivin(standardOfLiving);
         setMetersAboveSeaLevel(metersAboveSeaLevel);

     }
    @Override
    public String toString() {
        return getName()+":"+getId();/*"City{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", coordinates=" + getCoordinates() +
                ", creationDate=" + getCreationDate() +
                ", area=" + getArea() +
                ", population=" + getPopulation() +
                ", metersAboveSeaLevel=" + getMetersAboveSeaLevel() +
                ", establishmentDate=" + getEstablishmentDate() +
                ", agglomeration=" + getAgglomeration() +
                ", standardOfLiving=" + getStandardOfLiving() +
                ", governor=" + getGovernor() +
                '}';*/
    }
    public String toString2() {
        return "City{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", coordinates=" + getCoordinates() +
                ", creationDate=" + getCreationDate() +
                ", area=" + getArea() +
                ", population=" + getPopulation() +
                ", metersAboveSeaLevel=" + getMetersAboveSeaLevel() +
                ", establishmentDate=" + getEstablishmentDate() +
                ", agglomeration=" + getAgglomeration() +
                ", standardOfLiving=" + getStandardOfLiving() +
                ", governor=" + getGovernor() +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(name, city.name) &&
                Objects.equals(coordinates, city.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, coordinates);
    }
}

