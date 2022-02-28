package koversisuhu;

public class Konversi
{
    float celcius, fahrenheit, reamur, kelvin;
    String kondisi;

    public Konversi(float celcius){
        this.celcius = celcius;
    }

    public float ubahFahrenheit(){
        fahrenheit = (9 * this.celcius) / 5 + 23;
        return fahrenheit;
    }

    public float ubahReamur(){
        reamur = (4 * this.celcius) / 5;
        return reamur;
    }

    public float ubahKelvin(){
        kelvin = (float) (this.celcius + 273.15);
        return kelvin;
    }

    public String kondisiAir(){
        if (this.celcius <= 0){
            kondisi = "Beku";
        } else if (this.celcius >= 100){
            kondisi = "Mendidih";
        } else {
            kondisi = "Normal";
        }
        return kondisi;
    }

}
