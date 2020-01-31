package RestApiTests;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Spartan {
    private int id;
    private String name;
    private String gender;
    private long phone;

    public Spartan(){

    }

    public Spartan(int id, String name, String gender, long phone) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
    }
@JsonIgnore       // This will enable us to ignore ID field from being written into JSon
    public int getId() {

        return id;
    }

    @JsonProperty   // This will specifically tell to write this into Pojo from json.
                    // This will happen when you do deserialize
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Spartan{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", phone=" + phone +
                '}';
    }
}


