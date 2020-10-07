package domain;

public class Score {
    private String sno;
    private Float average;

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public Float getAverage() {
        return average;
    }

    public void setAverage(Float average) {
        this.average = average;
    }

    @Override
    public String toString() {
        return "Score{" +
                "sno='" + sno + '\'' +
                ", average=" + average +
                '}';
    }
}
