package _16_text_file.exercise._read_file_csv;

public class Country {
    int id;
    private String code, nameCountry;

    public Country (int id , String code , String nameCountry) {
        this.id = id;
        this.code = code;
        this.nameCountry = nameCountry;
    }

    public int getId () {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public String getCode () {
        return code;
    }

    public void setCode (String code) {
        this.code = code;
    }

    public String getNameCountry () {
        return nameCountry;
    }

    public void setNameCountry (String nameCountry) {
        this.nameCountry = nameCountry;
    }

    @Override
    public String toString () {
        return "Country{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", nameCountry='" + nameCountry + '\'' +
                '}';
    }
}
