package entities;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;



@XmlType(name = "reservation")
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "reservation")
public class Reservation implements Serializable {

    @XmlAttribute(name = "numer")
    private Integer numer;

    @XmlAttribute(name = "data")
    private String data;

    @XmlAttribute(name = "godzina")
    private String godzina;

    public Reservation() {
    }

    public Reservation(Integer numer, String data, String godzina) {
        this.numer = numer;
        this.data = data;
        this.godzina = godzina;
    }

    public Reservation(String data, String godzina) {
        this.data = data;
        this.godzina = godzina;
    }

    public Integer getNumer() {
        return numer;
    }

    public void setNumer(Integer numer) {
        this.numer = numer;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getGodzina() {
        return godzina;
    }

    public void setGodzina(String godzina) {
        this.godzina = godzina;
    }

}
